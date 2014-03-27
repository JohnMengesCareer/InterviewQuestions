import java.util.LinkedList;
import java.util.Random;

public class StackWithQueues {
	public void push(int value)
	{
		queue.add(value);
	}
	
	public int pop()
	{
		LinkedList<Integer> queue2 = new LinkedList<Integer>();
		while (queue.size() > 1)
		{
			queue2.add(queue.remove());
		}
		int result = queue.remove();
		queue = queue2;
		return result;
	}
	
	public int size()
	{
		return queue.size();
	}
	
	public void dump()
	{
		for (int i = 0; i < queue.size(); i++)
		{
			System.out.printf("%d ",  queue.get(i));
		}
		System.out.println();
	}

	private LinkedList<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args)
	{
		Random random = new Random();
		StackWithQueues stack = new StackWithQueues();
		for (int i = 0; i < 10; i++)
		{
			stack.push(random.nextInt(10));
		}
		System.out.println("dump");
		stack.dump();
		System.out.println("pop");
		while (stack.size() > 0)
		{
			System.out.printf("%d ", stack.pop());
		}
		System.out.println();
	}
	

}
