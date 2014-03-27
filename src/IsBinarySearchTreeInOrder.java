import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class IsBinarySearchTreeInOrder {
	public void insert(int value)
	{
		Node node = new Node(value);
		root = insert(root, node);
	}
	
	public void insertMaybeWrong(int value)
	{
		Node node = new Node(value);
		root = insertMaybeWrong(root, node);
	}
	
	public boolean isBinarySearchTree()
	{
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public void dump() throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter("IsBinarySearchTreeInOrder.gv");
		writer.println("digraph tree {");
		dump(root, writer);
		writer.println("}");
		writer.close();
	}

	public class Node
	{
		public int value;
		public Node left = null;
		public Node right = null;
		
		public Node(int value)
		{
			this.value = value;
		}
	}
	
	private Node root = null;
	private Random random = new Random();
	
	private Node insert(Node root, Node node)
	{
		if (root == null) return node;
		if (node.value <= root.value)
		{
			root.left = insert(root.left, node);
		}
		else
		{
			root.right = insert(root.right, node);
		}
		return root;
	}
	
	private Node insertMaybeWrong(Node root, Node node)
	{
		if (root == null) return node;
		if (node.value <= root.value)
		{
			if (random.nextInt(10) == 0)
			{
				root.right = insert(root.right, node);
			}
			else
			{
				root.left = insert(root.left, node);
			}
		}
		else
		{
			if (random.nextInt(10) == 0)
			{
				root.left = insert(root.left, node);
			}
			else
			{
				root.right = insert(root.right, node);
			}			
		}
		return root;
	}
	
	private boolean isBinarySearchTree(Node root, int min, int max)
	{
		if (root == null) return true;
		if (min > root.value || root.value > max) return false;
		return isBinarySearchTree(root.left, min, root.value)
				&& isBinarySearchTree(root.right, root.value, max);
	}
	
	private void dump(Node root, PrintWriter writer)
	{
		if (root == null) return;
		writer.printf("%d [label=\"%d\"]\n", root.hashCode(), root.value);
		if (root.left != null)
		{
			writer.printf("%d -> %d [label=\"L\"]\n", root.hashCode(), root.left.hashCode());
			dump(root.left, writer);
		}
		if (root.right != null)
		{
			writer.printf("%d -> %d [label=\"R\"]\n", root.hashCode(), root.right.hashCode());
			dump(root.right, writer);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Random random = new Random();
		IsBinarySearchTreeInOrder tree = new IsBinarySearchTreeInOrder();
		for (int i = 0; i < 10; i++)
		{
			if (random.nextInt(10) == 0)
				tree.insertMaybeWrong(random.nextInt(10));
			else
				tree.insert(random.nextInt(10));
		}
		tree.dump();
		System.out.println(tree.isBinarySearchTree());
	}
	
}
