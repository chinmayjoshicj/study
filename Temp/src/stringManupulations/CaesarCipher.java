package stringManupulations;

/*Julius Caesar protected his confidential information by encrypting it in a cipher. 
Caesar's cipher rotated every letter in a string by a fixed number, , making it unreadable by his enemies.
Given a string, , and a number, , encrypt  and print the resulting string.*/

public class CaesarCipher {
	public static void main(String[] args) {
		String s = "middle-Outz";
		StringBuffer finalString = new StringBuffer(s);
		int k = 2;
		k=k%26;
		char temp = 0;
		for (int i = 0; i < s.length(); i++) {
			if (finalString.charAt(i) >= 65 && finalString.charAt(i) <= 90) {
				if ((finalString.charAt(i) + k) > 90) {
					temp = (char) ((finalString.charAt(i) + k) % 90 + 64);
				} else
					temp = (char) (finalString.charAt(i) + k);

				finalString = finalString.replace(i, i + 1, (temp) + "");
			} else if (finalString.charAt(i) >= 97 && finalString.charAt(i) <= 122) {
				if ((finalString.charAt(i) + k) > 122) {
					temp = (char) ((finalString.charAt(i) + k) % 122 + 96);
				} else {
					temp = (char) (finalString.charAt(i) + k);
				}
				finalString = finalString.replace(i, i + 1, (temp) + "");
			}
		}
		System.out.println(finalString);
	}

}
