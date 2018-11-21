package awesome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveRepeatativeCharacters {

	public static void main(String[] args) {
		String a = "accn fvvtrren sccrrttrr";

		char[] charArray = a.toCharArray();
		List<Character> l = new ArrayList<>();

		for (int i = 0; i < charArray.length; i++) {
			l.add(charArray[i]);
		}

		Iterator<Character> itr = l.iterator();
		Character prev = null;
		if (itr.hasNext()) {
			prev = itr.next();
			while (itr.hasNext()) {
				Character curr = itr.next();
				if (curr == prev) {
					itr.remove();
					continue;
				}
				prev = curr;
			}
		}
		charArray = new char[l.size()];
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = l.get(i);
		}
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}
	}
}
