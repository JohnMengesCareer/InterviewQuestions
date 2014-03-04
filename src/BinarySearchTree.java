import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class BinarySearchTree<T extends Comparable<T>> {
	public void insert(T value)
	{
		BinaryNode<T> node = new BinaryNode<>(value);
		root = insert(root, node);
	}
	
	public void dump() throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter("BST.gv");
		writer.println("digraph Tree {");
		dump(root, writer);
		writer.println("}");
		writer.close();
	}

	private BinaryNode<T> root = null;
	
	private void dump(BinaryNode<T> node, PrintWriter writer)
	{
		if (node == null) return;
		writer.printf("  %d [label=\"%s\"]\n",
				node.hashCode(), node.getValue().toString());
		if (node.getLeft() != null)
		{
			writer.printf("  %d -> %d [label=\"L\"]\n", node.hashCode(), node.getLeft().hashCode());
			dump(node.getLeft(), writer);
		}
		if (node.getRight() != null)
		{
			writer.printf("  %d -> %d [label=\"R\"]\n", node.hashCode(), node.getRight().hashCode());
			dump(node.getRight(), writer);
		}			
	}
	
	private BinaryNode<T> insert(BinaryNode<T> root, BinaryNode<T> node) {
		if (root == null) return node;
		if (node.getValue().compareTo(root.getValue()) <= 0)
			root.setLeft(insert(root.getLeft(), node));
		else
			root.setRight(insert(root.getRight(), node));
		return root;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		testInsert(10);
	}
	
	public static void testInsert(int n) throws FileNotFoundException
	{
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		Random random = new Random();
		for (int i = 0; i < n; i++)
		{
			bst.insert(random.nextInt(n));
		}
		bst.dump();
	}

}
