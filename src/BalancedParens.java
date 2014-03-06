
public class BalancedParens {
	public static boolean isBalanced(String s)
	{
		char[] c = s.toCharArray();
		int openCount = 0;
		for (int i = 0; i < c.length; i++)
		{
			if (c[i] == '(') openCount++;
			else if (c[i] == ')')
			{
				if (openCount == 0) return false;
				openCount--;
			}
		}
		return openCount == 0;
	}

	public static void main(String[] args) {
		String[] tests = new String[] {
				"",
				"()",
				"(",
				")",
				"()()",
				"(())",
				"())()("
		};
		for (String test: tests)
		{
			System.out.printf("%s %s\n", test, isBalanced(test));
		}
	}

}
