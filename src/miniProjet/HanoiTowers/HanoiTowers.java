package miniProjet.HanoiTowers;

import java.util.ArrayList;

import miniProjet.HanoiTowers.Config;
import miniProjet.HanoiTowers.GraphConfig;

public class HanoiTowers {

	public static void main1() {
		
		String string = "= = Hanoi1 = =\n\n";
		
		int nbDisques = 3;
		GraphConfig gc = new GraphConfig(nbDisques);
		Config first = ConfigFactory.makeFirst(nbDisques);
		
		string += Function.toKey( gc.hanoi1( first ) );
		string += "\n\n";
		
		string += "Courbe :\n...\n";
		System.out.println(string);
		GenerateCurve.hanoi1(15,1);
		string = "new data in 'miniProjet/data/hanoi1'";
		string += "\n\n";

		System.out.println(string);
		
	}
	
	public static void mainRec() {
		
		String string = "= = HanoiRec = =\n\n";
		
		int nbDisques = 3;
		int fromStack = 0;
		int toStack = 2;
		GraphConfig gc = new GraphConfig(nbDisques);
		
		string += Function.toKey( gc.hanoi(nbDisques, fromStack, toStack) );
		string += "\n\n";

		System.out.println(string);
		
	}
	
	public static void main2() {
	
		String string = "= = Hanoi2 = =\n\n";
		
		int nbDisques = 2;
		GraphConfig gc = new GraphConfig(nbDisques);
		Config first = ConfigFactory.makeFirst(nbDisques);
		
		string += Function.toKey( gc.hanoi2( first ) );
		string += "\n\n";
		
		string += "Courbe :\n...\n";
		System.out.println(string);
		GenerateCurve.hanoi2(17,1);
		string = "new data in 'miniProjet/data/hanoi2'";
		string += "\n\n";

		System.out.println(string);
	}
	
	
	
	public static void main3() {
		
		String string = "= = Hanoi3 = =\n\n";
		
		Config x;
 		ArrayList<Integer> tab = new ArrayList<Integer>();
 		
		for(int i=1; i<=10; i++)
			tab.add(1);
		
		tab.add(3);
		
		for(int i=12; i<=18; i++)
			tab.add(2);
		
		for(int i=19; i<=40; i++)
			tab.add(1);
		
		for(int i=41; i<=63; i++)
			tab.add(3);
		
		tab.add(2);
		
 		x = new Config(tab);
		
		int nbDisques = 64;
		GraphConfig gc = new GraphConfig(nbDisques);
		
		x = ConfigFactory.makeFirst(8);
		
		string +=  gc.hanoi3( x ) ;
		string += "\n\n";

		System.out.println(string);
	}
	
	
	
	
	
	
	

}
