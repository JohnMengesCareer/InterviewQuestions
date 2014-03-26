import java.util.Random;


public class LinkedListInsertionSort {
	
	public static class Link
	{
		public int value;
		public Link next = null;
		
		public Link(int value)
		{
			this.value = value;
		}
	}
	
	public static void dump(Link head)
	{
		for (Link p = head; p != null; p = p.next)
		{
			System.out.printf("%d ", p.value);
		}
		System.out.println();
	}
	
	public static Link sort(Link head)
	{
		if (head == null) return head;
		Link lastSorted = head;
		while (lastSorted.next != null)
		{
			Link firstToSort = lastSorted.next;
			if (firstToSort.value >= lastSorted.value)
			{
				lastSorted = firstToSort;
			}
			else if (firstToSort.value < head.value)
			{
				lastSorted.next = firstToSort.next;
				firstToSort.next = head;
				head = firstToSort;
			}
			else
			{
				lastSorted.next = firstToSort.next;
				Link before = head;
				while (before.next.value < firstToSort.value) before = before.next;
				firstToSort.next = before.next;
				before.next = firstToSort;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Random random = new Random();
		Link list = null;
		for (int i = 0; i < 10; i++)
		{
			Link newLink = new Link(random.nextInt(10));
			newLink.next = list;
			list = newLink;
		}
		dump(list);
		list = sort(list);
		dump(list);
	}

}
