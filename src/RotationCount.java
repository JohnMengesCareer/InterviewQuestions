import java.util.Arrays;
import java.util.Random;


public class RotationCount {
	public static void rotate(int a[], int n)
	{
		int t[] = new int[n];
		for (int i = 0; i < n; i++)
			t[i] = a[i];
		for (int i = n; i < a.length; i++)
			a[i-n] = a[i];
		for (int i = 0; i < n; i++)
			a[a.length-n+i] = t[i];
	}
	
	public static int detectRotation(int a[])
	{
		if (a.length < 2) return 0;
		int left = 0;
		int right = a.length-1;
		while (right-left > 1)
		{
			int mid = left + (right-left)/2;
			if (a[left] < a[mid] || a[left] == a[mid] && a[mid] > a[right])
				left = mid;
			else if (a[mid] < a[right] || a[mid] == a[right] && a[left] > a[mid])
				right = mid;
			else {
				int p = mid;
				while (p < right && a[p] == a[left]) p++;
				if (p < right) left = mid;
				else right = mid;
			}
			System.out.printf("%d %d\n", left, right);
		}
		if (a[left] <= a[right]) return 0;
		return a.length-left-1;
	}
	
	public static void dump(int a[])
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Random random = new Random();
		int a[] = new int[10];
		for (int i = 0; i < a.length; i++)
		{
			a[i] = random.nextInt(10);
		}
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.printf("%d ", i);
		System.out.println();
		dump(a);
		int rotation = random.nextInt(10);
		System.out.println(rotation);
		rotate(a, rotation);
		dump(a);
		System.out.println(detectRotation(a));
	}

}
