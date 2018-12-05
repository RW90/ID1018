package OU4;

import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public static void main (String[] args)
	{
			out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
			 // mata in två naturliga heltal
			 Scanner in = new Scanner (System.in);
			 out.println ("två naturliga heltal:");
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
	 // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
	 // summa som en teckensträng.
	 public static String addera (String tal1, String tal2)
	 {
		 int 	sumint = 0;
		 int 	siffra1 = 0;
		 int	siffra2 = 0;
		 int	rest = 0;
		 int	len = (tal1.length() > tal2.length()) ? tal1.length() : tal2.length();
		 StringBuilder	summaSb = new StringBuilder();
		 char	siffra = '0';
		 for(int i = 1; i <= len; i++) {
			 siffra1 = (tal1.length() - i >= 0) ? tal1.charAt(tal1.length() - i) - 48 : 0;
			 siffra2 = (tal2.length() - i >= 0) ? tal2.charAt(tal2.length() - i) - 48 : 0;
			 sumint = (siffra1 + siffra2 + rest) % 10;
			 rest = (siffra1 + siffra2 + rest > 9) ? 1 : 0;
			 siffra = (char) (sumint + 48);
			 summaSb.insert(0, siffra);
		 }
		 
		 if(rest > 0)
			 summaSb.insert(0, (char) (rest + 48));
		 
		 String sum = String.valueOf(summaSb);
		 
		 return sum;
	 }
	 
	 // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
	 // deras differens som en teckensträng.
	 // Det första heltalet är inte mindre än det andra heltalet.
	 public static String subtrahera (String tal1, String tal2)
	 {
		 int 	diffint = 0;
		 int 	siffra1 = 0;
		 int	siffra2 = 0;
		 int	borrow = 0;
		 int	len = (tal1.length() > tal2.length()) ? tal1.length() : tal2.length();
		 StringBuilder	diffSb = new StringBuilder();
		 char	siffra = '0';
		 for(int i = 1; i <= len; i++) {
			 siffra1 = (tal1.length() - i >= 0) ? tal1.charAt(tal1.length() - i) - 48 - (borrow / 10) : 0;
			 siffra2 = (tal2.length() - i >= 0) ? tal2.charAt(tal2.length() - i) - 48 : 0;
			 borrow = (siffra1 - siffra2 < 0) ? 10 : 0;
			 diffint = siffra1 - siffra2 + borrow;
			 siffra = (char) (diffint + 48);
			 diffSb.insert(0, siffra);
			 if(i == len && borrow > 0)
				 throw new IllegalArgumentException("Tal 1 måste vara större än tal 2!");
		 }
		 
		 String diff = String.valueOf(diffSb);
		 
		 return diff;
	 }
	 // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
	 // utförd i samband med hetalen
	public static void visa (String tal1, String tal2, String resultat, char operator)
	{
		 // sätt en lämplig längd på heltalen och resultatet
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
	// sattLen lägger till ett angivet antal mellanslag i början av en given sträng
	public static String sattLen (String s, int antal)
	{
		 StringBuilder sb = new StringBuilder (s);
		 for (int i = 0; i < antal; i++)
		 sb.insert (0, " ");
		 return sb.toString ();
	}
}