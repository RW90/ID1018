package OU2;

public class Triangel {
		// Returnerar ett double värde på triangelns omkrets utifrån double värderna på triangelns 3 sidor
		static double omkrets(double sida1, double sida2, double sida3){
			double 	omkretsen = sida1 + sida2+ sida3;
			return omkretsen;
		}

		// Returnerar ett double värde på triangelns area utifrån double värderna på triangelns 3 sidor
		static double area(double sida1, double sida2, double sida3){
			double 	arean = hojd(sida1, sida2, sida3) * sida1 / 2;
			return arean;
		}
		// Returnerar ett double värde på en vinkel i en triangel. Argument är 2 doublevärden på vinklar
		static double vinkel(double vinkel1, double vinkel2){
			double 	vinkel3 = 180.0 - vinkel1 - vinkel2;
			return vinkel3;

		}
		// Returnerar ett double värde på höjden mot sida argument 1 i en triangel. Tar in tre double parametrar med sidlängder
		static double hojd(double sida1, double sida2, double sida3) {
			double 	h = omkrets(sida1, sida2, sida3) / 2;
			double 	hojden = (2 / sida1) * Math.sqrt(h * (h - sida1) * (h - sida2) * (h - sida3));
			return hojden;
		}
		// Returnerar bisektrisens längd i ett doublevärde när två sidor och vinkeln mellan dem ges i typ double.
		static double bisektris(double sida1, double sida2, double vinkel1) {
			double	p = 2 * sida1 * sida2 * Math.cos (vinkel1/2);
			double	bisektrisen = p / (sida1 + sida2);
			return bisektrisen;
		}
		// Returnerar medianens längd i ett doublevärde när tre sidor i en triangel ges i doubletyp. Median som skär sida 1.
		static double median(double sida1, double sida2, double sida3){
			double	a = sida1 * sida1;
			double	b = 2 * sida2 * sida2;
			double	c = 2 * sida3 * sida3;
			double 	d = b + c - a;
			double	rot = Math.sqrt (d);
			double	medianen = rot / 2;
			return medianen;
		}

		static double yttrecirkel(double sida1, double sida2, double sida3) {
			double	p = sida1 * sida2* sida3 / 2;
			double	area = area(sida1, sida2, sida3);
			double 	diameter = p / area;
			double	radie = diameter / 2;
			return radie;
		}

		static double inrecirkel(double sida1, double sida2, double sida3) {
			double	semi = omkrets(sida1, sida2, sida3) / 2;
			double	area = area(sida1, sida2, sida3);
			double	radie = area / semi;
			return radie;
		}
}
