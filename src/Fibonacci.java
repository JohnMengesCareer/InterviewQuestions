
public class Fibonacci {
	public static int fibonacci(int n)
	{
		int f1 = 0;
		int f2 = 1;
		if (n == 1) return f1;
		if (n == 2) return f2;
		for (int i = 3; i <= n; i++)
		{
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f2;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++)
		{
			System.out.printf("%d ", fibonacci(i));
		}
		System.out.println();
	}

}
