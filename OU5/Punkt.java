package OU5;

public class Punkt {
	
	// Klassvariabler
	private String	namn;
	private double	x;
	private double	y;
	
	// Konstruktorer
	Punkt () {
		
		x = 0;
		y = 0;
		namn = "def";
	}
	
	Punkt (String namn, double x, double y) {
		
		this.namn = namn;
		this.x = x;
		this.y = y;
		
	}
	
	Punkt (Punkt p) {
		
		this.namn = p.getNamn();
		this.x = p.getX();
		this.y = p.getY();
		
	}
	
	// Inspektorer
	
	public String getNamn () {
		
		return this.namn;
	}
	
	public int getX () {
		
		return (int) this.x;
	}

	public int getY () {
		
		return (int) this.y;
	}
	
	// Mutatorer
	
	public void setNamn (String namn) {
		
		this.namn = namn;
	}
	
	public void setX (double x) {
		
		this.x = x;
	}
	
	public void setY (double y) {
		
		this.y = y;
	}
	
	// Kombinator och komparator
	
	public boolean equals (Punkt p) {
		
		boolean	equalx = this.x == p.getX();
		boolean equaly = this.y == p.getY();
		boolean equal = equalx && equaly;
		
		return equal;
	}
	
	
	public double avstand () {
		
		double	dx = Math.pow (this.x, 2);
		double	dy = Math.pow (this.y, 2);
		double	avstand = Math.sqrt (dx + dy);
		
		return avstand;
	}
	
	public double avstand (Punkt p) {
		
		double	dx = Math.pow (this.x - p.getX(), 2);
		double	dy = Math.pow (this.y - p.getY(), 2);
		double	avstand = Math.sqrt (dx + dy);
		
		return avstand;
	}
	
	// Standardsträngskapare
	
	public String toString() {
		
		String	punktString = "(" + this.namn + ", " + this.x + ", " + this.y + ")";
		
		return punktString;
	}
	
	
	
	
	
	
	
	
	
	
	
}
