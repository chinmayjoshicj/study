package hackerRank;

import java.util.ArrayList;

public class TwoCharacters {
	static ArrayList<String> stringFormed = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "beabeefeab";
		s = "asvkugfiugsalddlasguifgukvsa";
		ArrayList<String> tuple = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					continue;
				}
				if (!(tuple.contains(new String(s.charAt(i) + "").concat(s.charAt(j) + ""))

						|| tuple.contains(new String(s.charAt(j) + "").concat(s.charAt(i) + "")))) {

					System.out.println("Adding " + (s.charAt(i) + "" + s.charAt(j)) + "");
					tuple.add(new String(s.charAt(i) + "").concat(s.charAt(j) + ""));
				}
			}
		}
		for (int i = 0; i < tuple.size(); i++) {
			System.out.print(tuple.get(i) + " ");
		}
		for (String string : tuple) {
			int i = 0;
			String formed = "";
			for (int j = 0; j < s.length(); j++) {
				if (string.contains(s.charAt(j) + "")) {
					formed = formed.concat(s.charAt(j) + "");
				}
			}
			checkedFormed(formed);
		}
		System.out.println();
		if (stringFormed.size() == 0) {
			System.out.println("No Strings are formed");
			return;
		}
		int length = stringFormed.get(0).length();
		String largestString = stringFormed.get(0);
		for (String sf : stringFormed) {
			if (sf.length() > length) {
				length = sf.length();
				largestString = sf;
			}
		}
		System.out.println("Largest String is " + largestString);
	}

	private static void checkedFormed(String formed) {
		boolean flag = true;
		for (int i = 1; i < formed.length(); i++) {
			if (formed.charAt(i - 1) != formed.charAt(i)) {
				continue;
			} else {
				flag = false;
				break;
			}
		}
		if (flag) {
			stringFormed.add(formed);
		}
	}

}
