import java.util.Random;


public class PopCount {
	
	public static int popCount(int value)
	{
		int result = 0;
		while (value != 0)
		{
			result++;
			value &= value-1;
		}
		return result;
	}

	public static void main(String[] args) {
		Random random = new Random();
		int value = random.nextInt();
		System.out.printf("%d %x %d\n", value, value, popCount(value));
	}

}
