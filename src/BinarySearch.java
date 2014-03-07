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
			if (target < a[mid]) max = mid-1;
			if (a[mid] < target) min = mid+1;
		}
		return -1;
	}
	
	public static int searchRecursive(int a[], int target)
	{
		return searchRecursive(a, target, 0, a.length-1);
	}
	
	private static int searchRecursive(int a[], int target, int min, int max)
	{
		if (min > max) return -1;
		int mid = min + (max-min)/2;
		if (a[mid] == target) return mid;
		if (target < a[mid]) return searchRecursive(a, target, min, mid-1);
		return searchRecursive(a, target, mid+1, max);
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
		System.out.printf("%d %d %d\n", target, search(a, target), searchRecursive(a, target));
	}

}
