package OU5;
import java.io.*;
public class PolyLinjeTest {

	public static void main(String[] args) {
		
		// Testvariabler
		
		PrintWriter	out = new PrintWriter(System.out, true);
		
		Punkt[]	horn2 = new Punkt[3];
		Punkt[]	horn3 = new Punkt[4];
		
		horn2[0] = new Punkt("A", 2, 3);
		horn2[1] = new Punkt("B", 4, 4);
		horn2[2] = new Punkt("C", 7, 6);
		
		horn3[0] = new Punkt("1", 6, 3);
		horn3[1] = new Punkt("2", 5, 8);
		horn3[2] = new Punkt("3", 9, 7);
		horn3[3] = new Punkt("4", 2, 1);
		
		// Testa konstruktorer
		
		PolyLinje	p1 = new PolyLinje();
		PolyLinje	p2 = new PolyLinje(horn2);
		PolyLinje	p3 = new PolyLinje(horn3);
		
		out.println(p1);
		out.println(p2);
		out.println(p3);
		
	
		// Testa mutatorer
		
		p1.laggTill(horn3[1]);
		p1.laggTill(horn2[2]);
		p1.setFarg("Grön");
		p1.setBredd(5);
		out.println(p1);
		
		p2.taBort("C");
		out.println(p2);
		
		p3.laggTillFramfor(horn2[0], "3");
		p3.setBredd(3);
		p3.setFarg("Blå");
		out.println(p3);
		
		
		// Testa inspektorer
		
		out.println(p1.getFarg());
		out.println(p3.getBredd());
		out.println(p3.langd());
		
		PolyLinje	p4 = new PolyLinje(p2.getHorn());
		out.println(p4);
		
		// Testa iterator
		
		PolyLinje.PolyLinjeIterator	pIter = p3.new PolyLinjeIterator();

		while(pIter.finnsHorn()) {
			out.println(pIter.horn());
			pIter.gaFram();
		}
	}
}