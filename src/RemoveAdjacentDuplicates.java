import java.util.Stack;


public class RemoveAdjacentDuplicates {
	public static String removeDups(String s)
	{
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		boolean stackTopIsDup = false;
		for (int i = 0; i < chars.length; i++)
		{
			if (stackTopIsDup && chars[i] != stack.lastElement().charValue())
			{
				stack.pop();
				stackTopIsDup = false;				
			}
			if (stack.isEmpty() || chars[i] != stack.lastElement().charValue())
			{
				stack.push(chars[i]);
			}
			else
			{
				stackTopIsDup = true;
			}
		}
		if (stackTopIsDup)
		{
			stack.pop();
			stackTopIsDup = false;				
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
		{
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String[] strings = new String[] {
				"abbc",
				"aacbb",
				"abcba",
				"",
				"a",
				"aa",
				"abbcccccbbz"
		};
		for (String s : strings)
		{
			System.out.printf("%s %s\n",  s, removeDups(s));
		}
	}

}
