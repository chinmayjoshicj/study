package awesome;

public class LongestPolindrome {

	public static void main(String[] args) throws Exception {

		String message = "underqualified";
		message = "Traveller";
		char[] charArray = message.toCharArray();
		String[] result = traverse(charArray, charArray.length - 1, 0, new String[] {"", ""});
		System.out.println(result[0]+result[1]);
	}

	private static String[] traverse(char[] charArray, int last, int first, String[] result) {
		if (last < first)
			return result;
		if(charArray[first] == charArray[last]) {
			result[0] += charArray[first];
			if(first != last)
			result[1] = charArray[first] + result[1];
			return traverse(charArray, last - 1, first + 1, result.clone());
		}
		String[] result1, result2;
		result1 = traverse(charArray, last, first + 1, result.clone());
		result2 = traverse(charArray, last - 1, first, result.clone());
		result = result2[0].length() > result1[0].length() ? result2 : result1;
		return result;
	}

}
