package OU3;

public class DenKortasteVagen {
	
	static int	k;
	static int l;
	static double	min;
	
	public static int[] mellanstationer(double[] a, double[][] b, double[] c) {
		
		if(min == 0.0)
			faktiskFunktion(a, b, c);
		
		int[]	stationer = {k, l};
		
		return stationer;
		
	}
	
	public static double langd(double[] a, double[][] b, double[] c) {
		
		if(min == 0.0)
			faktiskFunktion(a, b, c);
		
		return min;
		
	}

	private static void faktiskFunktion(double[] a, double[][] b, double[] c) {
		
		k = 0;
		l = 0;
		min = a[0] + b[0][0] + c[0];
		
		for(int i = 0; i < a.length; i++) {
			
			for(int j = 0; j < c.length; j++) {
				
				if(min > a[i] + c[j] + b[i][j]) {
					
					k = i;
					l = j;
				}
			}
		}
		
		min = a[k] + c[l] + b[k][l];
	}
}
