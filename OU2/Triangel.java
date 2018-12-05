package OU2;

public class Triangel {
		// Returnerar ett double v�rde p� triangelns omkrets utifr�n double v�rderna p� triangelns 3 sidor
		static double omkrets(double sida1, double sida2, double sida3){
			double 	omkretsen = sida1 + sida2+ sida3;
			return omkretsen;
		}

		// Returnerar ett double v�rde p� triangelns area utifr�n double v�rderna p� triangelns 3 sidor
		static double area(double sida1, double sida2, double sida3){
			double 	arean = hojd(sida1, sida2, sida3) * sida1 / 2;
			return arean;
		}
		// Returnerar ett double v�rde p� en vinkel i en triangel. Argument �r 2 doublev�rden p� vinklar
		static double vinkel(double vinkel1, double vinkel2){
			double 	vinkel3 = 180.0 - vinkel1 - vinkel2;
			return vinkel3;

		}
		// Returnerar ett double v�rde p� h�jden mot sida argument 1 i en triangel. Tar in tre double parametrar med sidl�ngder
		static double hojd(double sida1, double sida2, double sida3) {
			double 	h = omkrets(sida1, sida2, sida3) / 2;
			double 	hojden = (2 / sida1) * Math.sqrt(h * (h - sida1) * (h - sida2) * (h - sida3));
			return hojden;
		}
		// Returnerar bisektrisens l�ngd i ett doublev�rde n�r tv� sidor och vinkeln mellan dem ges i typ double.
		static double bisektris(double sida1, double sida2, double vinkel1) {
			double	p = 2 * sida1 * sida2 * Math.cos (vinkel1/2);
			double	bisektrisen = p / (sida1 + sida2);
			return bisektrisen;
		}
		// Returnerar medianens l�ngd i ett doublev�rde n�r tre sidor i en triangel ges i doubletyp. Median som sk�r sida 1.
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
