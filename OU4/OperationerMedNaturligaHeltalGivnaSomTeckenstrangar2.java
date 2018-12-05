package OU4;

import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar2
{
	public static void main (String[] args)
	{
			out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
			 // mata in tv� naturliga heltal
			 Scanner in = new Scanner (System.in);
			 out.println ("tv� naturliga heltal:");
			 String tal1 = in.next ();
			 String tal2 = in.next ();
			 out.println ();
			 // addera heltalen och visa resultatet
			 String summa = addera (tal1, tal2);
			 visa (tal1, tal2, summa, '+');
			 // subtrahera heltalen och visa resultatet
			 try {
				 String differens = subtrahera (tal1, tal2);
				 visa (tal1, tal2, differens, '-');
			 }
			 catch(IllegalArgumentException e) {
				 
				 System.out.println(e.getMessage());
				 String differens = subtrahera (tal2, tal1);
				 visa (tal2, tal1, differens, '-');	 
			 }
			 
			 
	}
	 // addera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar deras
	 // summa som en teckenstr�ng.
	 public static String addera (String tal1, String tal2)
	 {
		 int 	sumint = 0;
		 int 	siffra = 0;
		 for(int i = tal1.length() - 1; i >=0; i--) {
			 siffra = (int) ((tal1.charAt(i) - 48) * Math.pow(10, tal1.length() - 1 - i));
			 sumint += siffra;
		 }
		 for(int i = tal2.length() - 1; i >=0; i--) {
			 siffra = (int) ((tal2.charAt(i) - 48) * Math.pow(10, tal2.length() - 1 - i));
			 sumint += siffra;
		 }
		 
		 String sum = String.valueOf(sumint);
		 
		 return sum;
	 }
	 
	 // subtrahera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar
	 // deras differens som en teckenstr�ng.
	 // Det f�rsta heltalet �r inte mindre �n det andra heltalet.
	 public static String subtrahera (String tal1, String tal2)
	 {
		 int 	tal1int = 0;
		 int	tal2int = 0;
		 int 	siffra = 0;
		 for(int i = tal1.length() - 1; i >=0; i--) {
			 siffra = (int) ((tal1.charAt(i) - 48) * Math.pow(10, tal1.length() - 1 - i));
			 tal1int += siffra;
		 }
		 for(int i = tal2.length() - 1; i >=0; i--) {
			 siffra = (int) ((tal2.charAt(i) - 48) * Math.pow(10, tal2.length() - 1 - i));
			 tal2int += siffra;
		 }
		 
		 if (tal1int < tal2int)
			 throw new IllegalArgumentException("Tal 1 m�ste vara st�rre �n tal 2!");
		 
		 String diff = String.valueOf(tal1int-tal2int);
		 
		 return diff;
	 }
	 // visa visar tv� givna naturliga heltal, och resultatet av en aritmetisk operation
	 // utf�rd i samband med hetalen
	public static void visa (String tal1, String tal2, String resultat, char operator)
	{
		 // s�tt en l�mplig l�ngd p� heltalen och resultatet
		 int len1 = tal1.length ();
		 int len2 = tal2.length ();
		 int len = resultat.length ();
		 int maxLen = Math.max (Math.max (len1, len2), len);
		 tal1 = sattLen (tal1, maxLen - len1);
		 tal2 = sattLen (tal2, maxLen - len2);
		 resultat = sattLen (resultat, maxLen - len);
		 // visa heltalen och resultatet
		 out.println (" " + tal1);
		 out.println (" " + operator + " " + tal2);
		 for (int i = 0; i < maxLen + 2; i++) 
			 out.print ("-");
		 out.println ();
		 out.println (" " + resultat + "\n");
		 
	}
	// sattLen l�gger till ett angivet antal mellanslag i b�rjan av en given str�ng
	public static String sattLen (String s, int antal)
	{
		 StringBuilder sb = new StringBuilder (s);
		 for (int i = 0; i < antal; i++)
		 sb.insert (0, " ");
		 return sb.toString ();
	}
}