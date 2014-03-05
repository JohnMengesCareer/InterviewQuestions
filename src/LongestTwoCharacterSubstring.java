
public class LongestTwoCharacterSubstring {
	public static String longestTwoCharacterSubstring(String s)
	{
		char[] chars = s.toCharArray();
		String result = "";
		int f = 0;
		int p = nextDifferent(chars, f);
		while (f < chars.length)
		{
			char firstChar = chars[f];
			if (p == chars.length)
			{
				if (p - f > result.length())
					result = s.substring(f, p);
				break;
			}
			char secondChar = chars[p];
			int q = nextDifferent(chars, p);
			while (q < chars.length && (chars[q] == firstChar || chars[q] == secondChar))
			{
				p = q;
				q = nextDifferent(chars, p);
			}
			if (q - f > result.length())
			{
				result = s.substring(f, q);
			}
			f = p;
			p = q;
		}
		return result;
	}
	
	private static int nextDifferent(char[] chars, int start)
	{
		if (start == chars.length) return start;
		int result;
		for (result = start+1; result < chars.length; result++)
			if (chars[start] != chars[result]) break;
		return result;
	}
	
	public static void main(String[] args) {
		String s = "LongestTwoCharacterSubstring";
		System.out.printf("%s %s\n", s, longestTwoCharacterSubstring(s));
		s = "bananas and apples";
		System.out.printf("%s %s\n", s, longestTwoCharacterSubstring(s));
		s = "sssssssss";
		System.out.printf("%s %s\n", s, longestTwoCharacterSubstring(s));
		s = "abracadabra";
		System.out.printf("%s %s\n", s, longestTwoCharacterSubstring(s));
	}

}
