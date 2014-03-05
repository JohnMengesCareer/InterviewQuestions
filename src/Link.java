
public class Link<T extends Comparable<T>> {
	public Link(T value) {
		super();
		this.value = value;
	}
	
	public Link(T value, Link<T> next) {
		super();
		this.value = value;
		this.next = next;
	}

	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Link<T> getNext() {
		return next;
	}
	public void setNext(Link<T> next) {
		this.next = next;
	}
	
	private T value;
	private Link<T> next = null;
}
