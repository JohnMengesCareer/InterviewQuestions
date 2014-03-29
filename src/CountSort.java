import java.util.Random;


public class CountSort {
	public static void sort(int[] a)
	{
		int count[] = new int[a.length];
		for (int i = 0; i < a.length; i++)
		{
			count[a[i]]++;
		}
		int k = 0;
		for (int i = 0; i < count.length; i++)
			for (int j = 0; j < count[i]; j++)
				a[k++] = i;
	}
	   
	public static void dump(int[] a)
	{
		for (int i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.println();
	}

	public static void main(String[] args) {
		Random random = new Random();
		int a[] = new int[10];
		for (int i = 0; i < a.length; i++)
		{
			a[i] = random.nextInt(10);
		}
		dump(a);
		sort(a);
		dump(a);
	}

}
