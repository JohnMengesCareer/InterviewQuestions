import java.util.Arrays;
import java.util.Random;


public class BinarySearch {
	public static int search(int a[], int target)
	{
		int min = 0;
		int max = a.length-1;
		while (min <= max)
		{
			int mid = min+(max-min)/2;
			if (a[mid] == target) return mid;
			if (a[mid] > target) max = mid-1;
			if (a[mid] < target) min = mid+1;
		}
		return -1;
	}
	
	public static void dump(int a[])
	{
		for (int i = 0; i < a.length; i++)
			System.out.printf("%2d ",  i);
		System.out.println();
		for (int i = 0; i < a.length; i++)
			System.out.printf("%2d ", a[i]);
		System.out.println();
	}

	public static void main(String[] args) {
		int a[] = new int[20];
		Random random = new Random();
		for (int i = 0; i < a.length; i++)
			a[i] = random.nextInt(10);
		Arrays.sort(a);
		dump(a);
		int target = random.nextInt(10);
		int result = search(a, target);
		System.out.printf("%d %d\n",  target, result);
	}

}
