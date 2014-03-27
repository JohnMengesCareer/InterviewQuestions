import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class IsBinarySearchTreePreOrder {
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
	
	public void dump() throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter("IsBinarySearchTreePreOrder.gv");
		writer.println("digraph tree {");
		dump(root, writer);
		writer.println("}");
		writer.close();
	}
	
	public boolean isBinarySearchTree()
	{
		Values values = new Values();
		return isBinarySearchTree(root, values);
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
	
	public class Values
	{
		int lastValue = Integer.MIN_VALUE;
	}
	
	private Node root = null;
	private Random random = new Random();
	
	private Node insert(Node root, Node node)
	{
		if (root == null) return node;
		if (node.value <= root.value)
			root.left = insert(root.left, node);
		else
			root.right = insert(root.right, node);
		return root;
	}

	private Node insertMaybeWrong(Node root, Node node)
	{
		if (root == null) return node;
		if (node.value <= root.value)
			if (random.nextInt(5) == 0) root.right = insert(root.right, node);
			else root.left = insert(root.left, node);
		else
			if (random.nextInt(5) == 0) root.left = insert(root.left, node);
			else root.right = insert(root.right, node);
		return root;
	}
	
	private void dump(Node root, PrintWriter writer)
	{
		if (root == null) return;
		writer.printf("%d [label=\"%d\"]\n", root.hashCode(), root.value);
		if (root.left != null) {
			writer.printf("%d -> %d [label=\"L\"]\n", root.hashCode(), root.left.hashCode());
			dump(root.left, writer);
		}
		if (root.right != null) {
			writer.printf("%d -> %d [label=\"R\"]\n", root.hashCode(), root.right.hashCode());
			dump(root.right, writer);
		}
	}
	
	private boolean isBinarySearchTree(Node root, Values values)
	{
		if (root == null) return true;
		if (!isBinarySearchTree(root.left, values)) return false;
		if (root.value < values.lastValue) return false;
		values.lastValue = root.value;
		return (isBinarySearchTree(root.right, values));
	}

	public static void main(String[] args) throws FileNotFoundException {
		Random random = new Random();
		IsBinarySearchTreePreOrder tree = new IsBinarySearchTreePreOrder();
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
