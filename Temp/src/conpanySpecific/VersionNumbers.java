package conpanySpecific;

import java.util.Scanner;

/*Compare the two versions, version1, version2.
If version1 > version2 return 1
If version1 < version2 return -1
if version1 = version2 return 0

version strings are non-empty and contain only digits and the '.' character. The '.' character does not represent a decimal point and is used to separate number sequences.

Example of version ordering.
0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

Input :  version1 : 002.0005.12.3
         version2 : 2.5.12.3
Output : 0

Input : version1 : 451231654684151546847799885544662
        version2 : 1.256.24.5.5
Output : 1

Input : version1 : 1.21.20
        version2 : 1.21.25
Output : -1

Input : version1 : 1.2
        version2 : 1.2.0.0.0
Output : 0

Input : version1 : 1.2
        version2 : 1.0.1
Output : -1

Note : Here the numbers present inside the string can be huge so don’t try to convert these numbers
to unsigned long long. Eg. version1 = 1.234565434523423423523423423423434432.23.0*/




public class VersionNumbers {

		static String s1=new String();
		static String s2=new String();
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String v1="1.2";
		String v2="1.0.1";
		
		RemoveLeadingZeros(v1,v2);
		System.out.println(compareVersions(s1,s2));
	}


	private static void RemoveLeadingZeros(String v1, String v2)
	{
		String[] a=v1.split("\\.");
		String[] b=v2.split("\\.");
		int flag=0;
		for (int j2 = 0; j2 < a.length; j2++) 
		{
			int i=0;
			char[] a1=a[j2].toCharArray();
			
			while (i<a1.length)
			{
				if ((a1[i]=='0' && flag==0) ||a1.length==i+1)
				{
						s1=s1+a1[i];
				}
				else
				{
					flag=1;
					s1=s1+a1[i];
				}
				i++;
			}
			s1=s1+".";
		}
		for (int j2 = 0; j2 < b.length; j2++) {
			int j=0;
			char[] b1=b[j].toCharArray();
			flag=0;
			while (j<b1.length)
			{
				if ((b1[j]=='0' && flag==0) ||b1.length==j+1)
				{
					s2=s2+b1[j];
				}
				else
				{
					flag=1;
					s2=s2+b1[j];
				}
				j++;
			}
			s2=s2+".";
			
		}
	}


	private static int compareVersions(String v1, String v2) 
	{
		if (v1.length()>v2.length()) {
			return 1;
		}
		else if (v1.length()<v2.length()) {
			return -1;
		}
		else
		{
			String a1[]=v1.split("\\.");
			String a2[]=v2.split("\\.");
			
			for (int i = 0; i < a1.length; i++)
			{
					int j=0;
					int k=0;
					char[] a=a1[i].toCharArray();
					char[] b=a2[i].toCharArray();
					
					if (j<a.length && k<b.length) {
						
						if (a[j]>b[k]) 
						{
							return 1;
						}
						if (a[j]<b[k]) 
						{
							return -1;
						}
						j++;k++;
				}
			}
			return 0;
		}
	}

}
