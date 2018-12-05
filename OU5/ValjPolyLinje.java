package OU5;

import java.util.Random;

public class ValjPolyLinje {
	
	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 10;
	
	public static void main(String[] args) {
		
		// skapa ett antal slumpm�ssiga polylinjer
		PolyLinje[] polylinjer = new PolyLinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje ();
		
		// visa polylinjerna
		
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			System.out.println(polylinjer[i]);
		
		// best�m den kortaste av de polylinjer som �r gula
		boolean	flag = false;
		int	minPos = 0;
		for (int i = 0; i < ANTAL_POLYLINJER; i++) {
			if("gul".equals(polylinjer[i].getFarg())) {
				if(!flag) {
					flag = true;
					minPos = i;
				}
				if(polylinjer[minPos].langd() > polylinjer[i].langd())
					minPos = i;
			}
					
		}

		// visa den valda polylinjen
		
		if(!flag)
			System.out.println("Det finns inga gula polylinjer!");
		else
			System.out.print(polylinjer[minPos]);

	}
	// slumpPunkt returnerar en punkt med ett slumpm�ssigt namn, som �r en stor bokstav i
	// det engelska alfabetet, och slumpm�ssiga koordinater.
	public static Punkt slumpPunkt ()
	{
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Punkt (n, x, y);
	}
	// slumpPolylinje returnerar en slumpm�ssig polylinje, vars f�rg �r antingen bl�, eller r�d
	// eller gul. Namn p� polylinjens h�rn �r stora bokst�ver i det engelska alfabetet. Tv� h�rn
	// kan inte ha samma namn.
	public static PolyLinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och l�gg till h�rn till den
		PolyLinje polylinje = new PolyLinje ();
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		// ett och samma namn kan inte f�rekomma flera g�nger
		Punkt valdPunkt = null;
		char valtChar = 0;
		while (antalValdaHorn < antalHorn)
		{
			valdPunkt = slumpPunkt();
			valtChar = valdPunkt.getNamn().toCharArray()[0];
			if(!valdaNamn[valtChar - 65]) {
				valdaNamn[valtChar - 65] = true;
				antalValdaHorn++;
				polylinje.laggTill(valdPunkt);
			}
		}
		
		// s�tt f�rg
		
		String[]	farger = {"bl�", "r�d", "gul"};
		polylinje.setFarg(farger[rand.nextInt(3)]);
		
		return polylinje;
	}
}