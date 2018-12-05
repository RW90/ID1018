package OU3;

public class BestamDenKortasteVagen {

	public static void main(String[] args) {
		
		/*// Setup
		java.util.Scanner	in = new java.util.Scanner(System.in);
		System.out.println("Bestäm hur många substationer det ska finnas i zon 2 och 3:");
		int 	u = in.nextInt();
		int		v = in.nextInt();
		
		// Generering av vägarna 
		
		/*double[]	m = new double[u];
		double[][]	n = new double[u][v];
		double[]	o = new double[v];
		
		for(int i = 0; i < u; i++) {
			m[i] = Math.random() * 41 + 9;
			
			for(int j = 0; j < v; j++) {
				n[i][j] = Math.random() * 41 + 9;
				if(i == 0) {
					o[j] = Math.random() * 41 + 9;
				}
			}
			
		}*/
		//"instans" 
		
		double[]	m = {15, 24, 11};
		double[]	o = {16, 14, 31, 9};
		double[][]	n = {{14, 12, 20, 11}, {15, 13, 14, 10}, {18, 17, 21, 13}};
		
		
		
		DenKortasteVagen	obj = new DenKortasteVagen();
		
		int[]	substationer = obj.mellanstationer(m, n, o);
		
		double 	minlangd = Math.round(obj.langd(m, n, o) * 1000d) / 1000d;
		
		System.out.println("Den kortaste sträckan är " + minlangd + " via substation " + substationer[0] + " och " + substationer[1] + ".");
		
		
		

	}

}
