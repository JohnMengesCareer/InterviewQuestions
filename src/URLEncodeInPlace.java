
public class URLEncodeInPlace {
	public static void URLEncode(char[] chars) throws Exception
	{
		if (chars == null)
			throw new Exception("Array chars cannot be null.");
		int spaces = 0;
		int i;
		for (i = 0; i < chars.length && chars[i] != '\0'; i++)
		{
			if (chars[i] == ' ') spaces++;
		}
		if (chars.length < i+spaces*2)
			throw new Exception("Insufficient room to URL encode chars.");
		i--;
		int j = i+spaces*2;
		while (i >= 0 && i < j)
		{
			if (chars[i] == ' ')
			{
				chars[j--] = '0';
				chars[j--] = '2';
				chars[j--] = '%';
			}
			else
			{
				chars[j--] = chars[i];
			}
			i--;
		}
	}

	public static void main(String[] args) throws Exception
	{
		String[] tests = {
				"Now is the time for all good men to come to the aid of their country.",
				" Space at start and end. ",
				"Multiple  spaces  between  words",
				"Nospaces",
				"     ",
				""			
		};
		for (String test : tests)
		{
			char[] chars = test.toCharArray();
			int spaces = 0;
			for (int i = 0; i < chars.length; i++)
			{
				if (chars[i] == ' ') spaces++;
			}
			char[] charsWithRoom = new char[chars.length+spaces*2];
			for (int i = 0; i < chars.length; i++)
			{
				charsWithRoom[i] = chars[i];
			}
			URLEncode(charsWithRoom);
			System.out.printf("'%s' '%s'\n", test, new String(charsWithRoom));
		}
		try
		{
			URLEncode(null);
		}
		catch (Exception e)
		{
			if (e.getMessage().equals("Array chars cannot be null."))
				System.out.println("Exception properly thrown for null.");
			else throw e;
		}
		try
		{
			URLEncode("Now is the time".toCharArray());
		}
		catch (Exception e)
		{
			if (e.getMessage().equals("Insufficient room to URL encode chars."))
				System.out.println("Exception properly thrown for insufficient space.");
			else throw e;
		}
	}
}
