import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class LinkedList<T extends Comparable<T>> {
	public LinkedList() {
		super();
		this.name = new Integer(hashCode()).toString();
	}
	
	public LinkedList(String name) {
		super();
		this.name = name;
	}

	public void append(Link<T> node)
	{
		if (head == null)
			head = tail = node;
		else
		{
			tail.setNext(node);
			for (; node.getNext() != null; node = node.getNext());
			tail = node;
		}
	}
	
	public void dump() throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(name + ".gv");
		writer.printf("digraph %s {", name);
		for (Link<T> link = head; link != null; link = link.getNext())
		{
			writer.printf("%d [label=\"%s\"]\n", link.hashCode(), link.getValue());
			if (link.getNext() != null)
				writer.printf("%d -> %d\n", link.hashCode(), link.getNext().hashCode());
		}
		writer.printf("}");
		writer.close();
	}
	
	public Link<T> getHead() {
		return head;
	}
	public void setHead(Link<T> head) {
		this.head = head;
	}
	public Link<T> getTail() {
		return tail;
	}
	public void setTail(Link<T> tail) {
		this.tail = tail;
	}
	
	private final String name;
	private Link<T> head = null;
	private Link<T> tail = null;
}
