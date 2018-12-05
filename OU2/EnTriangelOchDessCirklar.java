package OU2;

public class EnTriangelOchDessCirklar {

	public static void main(String[] args) {
		// Setup och Inmatning
		java.util.Scanner	in = new java.util.Scanner(System.in);
		System.out.println("Skriv in triangelns 3 sidor:");
		double	sida1 = in.nextDouble();
		double	sida2 = in.nextDouble();
		double	sida3 = in.nextDouble();
		// Triangel	tri = new Triangel();

		// räkna ut cirklars radie
		double	inre = Triangel.inrecirkel(sida1, sida2, sida3);
		double	yttre = Triangel.yttrecirkel(sida1, sida2, sida3);
		System.out.println("Den inre cirkelns radie är " + inre + ".\nDen yttre cirkelns radie är " + yttre + ".");

	}

}
