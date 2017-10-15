package stringManupulations;

public class Pangram {
	public static void main(String[] args) {
		String s = "We promptly judged antique ivory buckles for the prize";
		int i = 0;
		int alphabets[] = new int[26];
		s = s.toLowerCase();
		/*
		 * Scanner sc=new Scanner(System.in); s=sc.nextLine();
		 */
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == 32) {
				continue;
			}
			alphabets[s.charAt(j) - 96 - 1] = s.charAt(j);
		}
		for (int j = 0; j < alphabets.length; j++) {
			if (alphabets[j] == 0) {
				System.out.println("not pangram");
				i = 2;
				break;
			}
		}
		if (i == 0) {
			System.out.println("pangram");
		}
	}
}
