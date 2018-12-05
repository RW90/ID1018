package OU5;

import java.util.Random;

public class ValjPolyLinje {
	
	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 10;
	
	public static void main(String[] args) {
		
		// skapa ett antal slumpmässiga polylinjer
		PolyLinje[] polylinjer = new PolyLinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje ();
		
		// visa polylinjerna
		
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			System.out.println(polylinjer[i]);
		
		// bestäm den kortaste av de polylinjer som är gula
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
	// slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
	// det engelska alfabetet, och slumpmässiga koordinater.
	public static Punkt slumpPunkt ()
	{
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Punkt (n, x, y);
	}
	// slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
	// eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
	// kan inte ha samma namn.
	public static PolyLinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och lägg till hörn till den
		PolyLinje polylinje = new PolyLinje ();
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		// ett och samma namn kan inte förekomma flera gånger
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
		
		// sätt färg
		
		String[]	farger = {"blå", "röd", "gul"};
		polylinje.setFarg(farger[rand.nextInt(3)]);
		
		return polylinje;
	}
}