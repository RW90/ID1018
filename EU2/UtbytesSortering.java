package EU2;
import java.util.Arrays;

public class UtbytesSortering {
	
	public static void main(String[] args) {
		
		int[]	sek = new int[15];
		for(int i = 0; i < sek.length; i++)
			sek[i] = (int) (Math.random() * 50);
		
		int	i = 0;
		int	j = 0;
		int temp = 0;
		System.out.println(Arrays.toString(sek));
		
		while(i < sek.length - 1) {
			
			j = i + 1;
			while(j <= sek.length - 1) {
				if(sek[i] > sek[j]) {
					temp = sek[i];
					sek[i] = sek[j];
					sek[j] = temp;
				}
				j++;
			}
			System.out.println(Arrays.toString(sek));
			i++;
		}
	}

}
