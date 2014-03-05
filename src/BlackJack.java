import java.util.ArrayList;
import java.util.Random;


public class BlackJack {
	public void hit()
	{
		hand.add(random.nextInt(13)+1);
	}
	
	public int score()
	{
		int result = 0;
		int aces = 0;
		for (int i = 0; i < hand.size(); i++)
		{
			int cardNumber = hand.get(i);
			if (cardNumber == 1) aces++;
			else result += hand.get(i);
		}
		for (int i = aces; i > 0; i--)
		{
			if (result + 10 + (aces-1) <= 21) result += 10;
			else result++;
		}
		return result;
	}
	
	public void dump() throws Exception
	{
		for (int i = 0; i < hand.size(); i++)
		{
			System.out.printf("%s ", name(hand.get(i)));
		}
		System.out.printf("(%d)\n", score());
	}
	
	private ArrayList<Integer> hand = new ArrayList<Integer>();
	private Random random = new Random();
	
	private String name(int cardNumber) throws Exception
	{
		if (cardNumber >= 2 && cardNumber <= 10)
			return new Integer(cardNumber).toString();
		switch (cardNumber)
		{
		case 1: return "A";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		}
		throw new Exception("Illegal card number " + cardNumber);
	}

	public static void main(String[] args) throws Exception {
		BlackJack blackJack = new BlackJack();
		while (blackJack.score() < 21)
		{
			blackJack.hit();
			blackJack.dump();
		}
	}

}
