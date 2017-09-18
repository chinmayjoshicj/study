package ConpanySpecific;

import java.util.Scanner;

public class SpellTheNumber {
	public static void main(String[] args) 
	{
		String number[];
		Scanner sc= new Scanner(System.in);
		int inputs=Integer.parseInt(sc.nextLine());
		number=new String[inputs];
		for (int i = 0; i < number.length; i++) {
			number[i]=sc.nextLine();
			
		}
			for (int i = 0; i < number.length; i++)
			{
				printNumber(number[i]);
				System.out.println();
			}
	}
	private static void printNumber(String number) 
	{
		int n = 0;
		while (number.charAt(n) == '0') {
			if (number.length() != 1) {
				number = number.substring(n + 1, number.length());
			} else {
				System.out.println("zero");
				break;
			}
		}
		/*if (number.length() == 6) {
			readLakhs(number);
		}*/
		if (number.length() == 5 || number.length() == 4) {
			readThousand(number);
		}
		if (number.length() == 3) 
		{
			readHundred(number);
		}
		if (number.length()==2)
		{
			readTy(number.charAt(0), number.charAt(1));
			if (number.charAt(1)!='0' && number.charAt(0)!='1')
			{
				readnumber(number.charAt(1));
			}
		}
		if (number.length()==1)
		{
			readnumber(number.charAt(0));
		}
	}
	private static void readThousand(String number) {
		if (number.length() == 4) {
			for (int i = 0; i < number.length(); i++) 
			{
				if (i == 0)
				{
					//readTy(number.charAt(i), number.charAt(i + 1));
					readnumber(number.charAt(i));
					if (number.charAt(i) != '0') {
						System.out.print("thousand ");
					}
					if (number.charAt(i + 1) != '0') 
					{
						readHundred(number.substring(i+1,number.length()));
						i++;
							break;
					}
					if (number.charAt(i+1)=='0')
					{
						i++;
					}
					continue;
				}
				if (i==1 && number.charAt(i)!='0')
				{
					readHundred(number.substring(i));
					break;
				}
				if (i == 2)
				{
					if (number.charAt(i)=='0')
					{
						break;
					}
					//System.out.print("hundred ");
					if (number.charAt(i+1)=='0')
					{
						System.out.print("hundred ");
					}
					else
					{
						System.out.print("hundred and ");
					}
					readTy(number.charAt(i), number.charAt(i + 1));
					if (number.charAt(i + 1) != '0') {
						readnumber(number.charAt(i + 1));
					}
					break;
				}
			}
		}
		if (number.length() == 5) {
			for (int i = 0; i < number.length(); i++) {
				if (i == 0) {
					readTy(number.charAt(i), number.charAt(i + 1));
					if (number.charAt(i + 1) != '0' && number.charAt(i) != '1') {
						readnumber(number.charAt(i + 1));
					}
					if (number.charAt(i) != '0') {
						System.out.print("thousand ");
					}
					i++;
					continue;
				}
				if (i == 2) {
					readHundred(number.substring(i, number.length()));
				}
			}
		}
	}

	private static void readHundred(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (i == 0) {
				readnumber(number.charAt(i));
				if (number.charAt(i) != '0') {
					if (number.charAt(i+1)=='0'&& number.charAt(i+2)=='0')
					{
						System.out.print("hundred ");
					}
					else
					{
						System.out.print("hundred and ");
					}
					continue;
				}
			}
			if (i == 1) {
				if (number.charAt(i) != '0') {
					readTy(number.charAt(i), number.charAt(i + 1));
					if (number.charAt(i + 1) != '0' || number.charAt(i + 1) != '1') {
						readnumber(number.charAt(i + 1));
						
					}
					i++;
					break;
				} else {
					readnumber(number.charAt(i + 1));
					i++;
					break;
				}
			}
		}
	}

	/*private static void readLakhs(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (i == 0) {
				if (number.charAt(i) != '0') {
					readnumber(number.charAt(i));
					System.out.print("lakhs ");
					continue;
				}
			}
			if (i == 1) {
				readTy(number.charAt(i), number.charAt(i + 1));
				if (number.charAt(i + 1) != '0') {
					readnumber(number.charAt(i + 1));
				}
				if (number.charAt(i) != '0') {
					System.out.print("thousand ");
				}
				i++;
				continue;
			}
			if (i == 3) {
				readnumber(number.charAt(i));
				if (number.charAt(i) != '0') {
					System.out.print("hundred ");
				}
				continue;
			}
			if (i == 4) {
				readTy(number.charAt(i), number.charAt(i + 1));
				readnumber(number.charAt(i + 1));
				continue;
			}
		}
	}*/

	private static void readTy(char a, char i) {
		if (a == '1') {
			if (i != '0') {
				readTeen(i);
			} else {
				System.out.print("ten ");
			}
		}
		if (a == '2') {
			System.out.print("twenty ");
			return;
		}
		if (a == '3') {
			System.out.print("thirty ");
			return;
		}
		if (a == '4') {
			System.out.print("forty ");
			return;
		}
		if (a == '5') {
			System.out.print("fifty ");
			return;
		}
		if (a == '6') {
			System.out.print("sixty ");
			return;
		}
		if (a == '7') {
			System.out.print("seventy ");
			return;
		}
		if (a == '8') {
			System.out.print("eighty ");
			return;
		}
		if (a == '9') {
			System.out.print("ninety ");
			return;
		}
	}

	private static void readTeen(char a) {
		if (a == '1') {
			System.out.print("eleven ");
			return;

		}
		if (a == '2') {
			System.out.print("twelve ");
			return;
		}
		if (a == '3') {
			System.out.print("thirteen ");
			return;
		}
		if (a == '4') {
			System.out.print("forteen ");
			return;
		}
		if (a == '5') {
			System.out.print("fifteen ");
			return;
		}
		if (a == '6') {
			System.out.print("sixteen ");
			return;
		}
		if (a == '7') {
			System.out.print("seventeen ");
			return;
		}
		if (a == '8') {
			System.out.print("eighteen ");
			return;
		}
		if (a == '9') {
			System.out.print("nineteen ");
			return;
		}
	}

	private static void readnumber(char a) {
		if (a == '1') {
			System.out.print("one ");
			return;

		}
		if (a == '2') {
			System.out.print("two ");
			return;
		}
		if (a == '3') {
			System.out.print("three ");
			return;
		}
		if (a == '4') {
			System.out.print("four ");
			return;
		}
		if (a == '5') {
			System.out.print("five ");
			return;
		}
		if (a == '6') {
			System.out.print("six ");
			return;

		}
		if (a == '7') {
			System.out.print("seven ");
			return;

		}
		if (a == '8') {
			System.out.print("eight ");
			return;

		}
		if (a == '9') {
			System.out.print("nine ");
			return;

		}
	}
}
