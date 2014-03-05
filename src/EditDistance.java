
public class EditDistance {
	public static int editDistance(String from, String to, boolean dump)
	{
		char[] fromChars = from.toCharArray();
		char[] toChars = to.toCharArray();
		int[][] solutions = new int[fromChars.length+1][toChars.length+1];
		
		for (int i = 0; i <= fromChars.length; i++)
			solutions[i][0] = i;
		for (int i = 0; i <= toChars.length; i++)
			solutions[0][i] = i;
		for (int i = 1; i <= fromChars.length; i++)
			for (int j = 1; j <= toChars.length; j++)
				if (fromChars[i-1] == toChars[j-1])
					solutions[i][j] = solutions[i-1][j-1];
				else
					solutions[i][j] =
						min(solutions[i-1][j-1], solutions[i-1][j], solutions[i][j-1])+1;
		if (dump)
			for (int i = 0; i <= toChars.length; i++)
			{
				for (int j = 0; j <= fromChars.length; j++)
					System.out.printf("%d ", solutions[j][i]);
				System.out.println();
			}
		return solutions[fromChars.length-1][toChars.length-1];					
	}
	
	private static int min(int i, int j, int k)
	{
		int result = i;
		if (j < result) result = j;
		if (k < result) result = k;
		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(editDistance("Saturday", "Sunday", true));
	}
}
