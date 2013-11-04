package miniProjet.Traversee;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Traversee {

	public static void main(String[] args)
	{
		String string = "= = Hanoi Towers = =\n\n";
		
		Sequence sequence;
		Config departure = new Config(0,1,false);
		Config arrival = new Config(3,0,true);
	
		GraphConfig gc = new GraphConfig(3,2);
		string += "Cr??ation d'"+ gc.toString() + ".\n\n";
		
		string += "Toutes configurations valides :\n";
		sequence = new Sequence( gc.generateValidConfigs() );
		string += sequence.toString();
		string += "\n";
		
		string += arrival.toString() + " est un voisin de (est apr??s) " + departure.toString() + " ? ";
		string += arrival.isNextTo(departure, gc);
		string += "\n\n";
		
		string += "Tout voisins valides de " + departure.toString() + " dans " + gc.toString() + " :\n";
		sequence = new Sequence(departure.generateNext(gc));
		string += sequence.toString();
		string += "\n";
		
		string += "Parcours en largeur du graphe :\n";
		string += gc.breadthFirstSearch().toString();
		string += "\n";
		
		string += "Traversee() :\n";
		string += gc.traversee().toString();
		string += "\n";
		
		string += "Courbe :\n";
		Traversee.generateCurveCPU(1500);
		System.out.println(string);
	}
	
	public static void generateCurveCPU(int maxN)
	{
		long[] tab = new long[maxN];
		long startTime, endTime;
		GraphConfig gc;
		for(int n=3; n < maxN; n++)
		{
			gc = new GraphConfig(n,4);

			startTime = System.nanoTime();
			gc.traversee();
			endTime = System.nanoTime();
			
			tab[n] = endTime - startTime;
		}
		
		String fileName = "./data/data.txt";
	    try{
	      PrintWriter out  = new PrintWriter(new FileWriter(fileName));
	      for (int n = 3; n < tab.length; n++)
	        out.println(n + ";" + tab[n]);
	      out.close();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}

}
