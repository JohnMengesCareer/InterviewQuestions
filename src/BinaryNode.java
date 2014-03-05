public class BinaryNode<T extends Comparable<T>> {
	public BinaryNode(T value) {
		super();
		this.value = value;
	}
	
	public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public BinaryNode<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}
	public BinaryNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
	
	private T value;
	private BinaryNode<T> left = null;
	private BinaryNode<T> right = null;
}
