package freshPractice;

public class PermutationsOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="boat";
		permutation("",s);

	}

	private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm + word);

        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) 
                         	               + word.substring(i + 1, word.length()));
            }
        }
    }
}
