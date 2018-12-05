package OU5;

public class PolyLinje {
	
	// Variabler
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	
	// Konstruktor
	public PolyLinje () {
		
		this.horn = new Punkt[0];
	}
	
	public PolyLinje (Punkt[] horn) {
		
		this.horn = new Punkt[horn.length];
		
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt (horn[i]);
	}
	
	// toStringmetod
	public String toString () {
		
		StringBuilder	polyStringb = new StringBuilder("([");
		
		for(int i = 0; i < this.horn.length; i++) 
			polyStringb.append("(" + this.horn[i].getNamn() + ", " + this.horn[i].getX() + ", " + this.horn[i].getY() + ")");
		
		polyStringb.append("]" + ", " + this.farg + ", " + this.bredd + ")");
		
		String	polyString = polyStringb.toString();
		
		return polyString;
		
	}
	
	// Inspektorer
	public Punkt[] getHorn () {
		
		Punkt[] p = new Punkt[horn.length];
		
		for (int i = 0; i < horn.length; i++)
			p[i] = new Punkt (this.horn[i]);
		
		return p;
		
	}
	
	public String getFarg () {
		
		return this.farg;
	}
	
	public int getBredd () {
	
		return this.bredd;
	}
	
	public double langd () {
		double	summa = 0;
		for(int i = 0; i < this.horn.length - 2; i++) 
			summa += this.horn[i].avstand(this.horn[i+1]);
		
		return summa;
	}
	
	// Mutatorer
	public void setFarg (String farg) {
		
		this.farg = farg;
	}
	
	public void setBredd (int bredd) {
		
		this.bredd = bredd;
	}
	
	public void laggTill (Punkt horn) {
		
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		
		for (i = 0; i < this.horn.length; i++) 
			h[i] = this.horn[i];
		
		h[i] = new Punkt (horn);
		
		this.horn = h;
	}
	
	public void laggTillFramfor (Punkt horn, String hornNamn) {
		
		Punkt[] h = new Punkt[this.horn.length + 1];
		boolean	flag = false;
		
		try {
			for (int i = this.horn.length - 1; i >= 0; i--) {
					if(flag)
						h[i] = this.horn[i];
					else {
						
						h[i + 1] = this.horn[i];
						if(this.horn[i].getNamn().equals(hornNamn)) {
							h[i] = new Punkt(horn);
							flag = true;
						}
						
					}
			}
			
			if(!flag)
				throw new IllegalArgumentException("Ingen punkt med det namnet i listan!");
		
			this.horn = h;
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void taBort (String hornNamn) {
		
		Punkt[]	h = new Punkt[this.horn.length - 1];
		boolean	flag = false;
		for(int i = 0; i < this.horn.length; i++) {
			if(flag)
				h[i-1] = this.horn[i];
			else {
				if(this.horn[i].getNamn().equals(hornNamn))
					flag = true;
				else
					h[i] = this.horn[i];
			}
		}
		
		this.horn = h;
	}
	
	public class PolyLinjeIterator
	{
		
		private int aktuell = -1;
		
		public PolyLinjeIterator ()
		{
			if (PolyLinje.this.horn.length > 0)
				aktuell = 0;
		}
		
		public boolean finnsHorn ()
		{
			return aktuell != -1;
		}
		
		public Punkt horn () throws java.util.NoSuchElementException
		{
			if (!this.finnsHorn ())
				throw new java.util.NoSuchElementException ("slut av iterationen");				
			Punkt horn = PolyLinje.this.horn[aktuell];
			return horn;
		}
		
		public void gaFram ()
		{
			if (aktuell >= 0 && aktuell < PolyLinje.this.horn.length - 1)
				aktuell++;
			else
				aktuell = -1;
		}
	}

}
