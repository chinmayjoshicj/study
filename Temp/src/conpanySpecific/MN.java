package conpanySpecific;

public class MN {

/*	2. Given a sequence of M and N with M representing increasing and N representing decreasing, output the smallest number that follows this pattern.
	Input : MMMM
	Output : 12345

	Input : NNNN
	Output : 54321

	Input : MMNM
	Output : 2314*/
	
	
	public static void main(String[] args) 
	{
		String cond="MMNM";
		
			int start=startingNumber(cond.length());
			
			int end=Integer.parseInt(Integer.toString(start)+"9");
			int count=0;
			for (int j = start;j<end; j++) {
				char a[]=Integer.toString(j).toCharArray();
				for (int i = 0; i < a.length-1; i++) {
					if (cond.charAt(i)=='M') {
						if (Integer.parseInt(a[i]+"")<Integer.parseInt(a[i+1]+""))
						{
							count++;
						}
					}
					if (cond.charAt(i)=='N') {
						if (Integer.parseInt(a[i]+"")>Integer.parseInt(a[i+1]+""))
						{
							count++;
						}
					}
				}
				if (count==cond.length()) {
					System.out.println(j);
					break;
				}
				count=0;
			}
	}

	private static int startingNumber(int length) {
	
		String num = new String();
		for (int i = 0; i < length; i++) {
			num+=9;
		}
		return Integer.parseInt(num)+1;
	}
	
}
