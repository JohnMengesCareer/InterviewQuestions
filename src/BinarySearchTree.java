import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class BinarySearchTree<T extends Comparable<T>> {
	public BinarySearchTree(String name) {
		super();
		this.name = name;
	}

	public void insert(T value)
	{
		BinaryNode<T> node = new BinaryNode<>(value);
		root = insert(root, node);
	}
	
	public void dump() throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(name + ".gv");
		writer.printf("digraph %s {", name);
		dump(root, writer);
		writer.println("}");
		writer.close();
	}
	
	public LinkedList<T> toLinkedList(String name)
	{
		LinkedList<T> result = new LinkedList<>(name);
		toLinkedList(root, result);
		return result;
	}

	private final String name;
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
	
	private void toLinkedList(BinaryNode<T> node, LinkedList<T> result) {
		if (node == null) return;
		toLinkedList(node.getLeft(), result);
		result.append(new Link<T>(node.getValue()));
		toLinkedList(node.getRight(), result);
	}

	public static void main(String[] args) throws FileNotFoundException {
//		testInsert("bst", 10);
		testToLinkedList("bst", "ll", 10);
	}
	
	public static void testInsert(String name, int n) throws FileNotFoundException
	{
		BinarySearchTree<Integer> bst = getBST(name, n);
		bst.dump();
	}
	
	public static void testToLinkedList(String bstName, String llName, int n) throws FileNotFoundException
	{
		BinarySearchTree<Integer> bst = getBST(bstName, n);
		bst.dump();
		LinkedList<Integer> ll = bst.toLinkedList(llName);
		ll.dump();
	}
	
	private static BinarySearchTree<Integer> getBST(String name, int n)
	{
		BinarySearchTree<Integer> bst = new BinarySearchTree<>(name);
		Random random = new Random();
		for (int i = 0; i < n; i++)
		{
			bst.insert(random.nextInt(n));
		}
		return bst;
	}
}
