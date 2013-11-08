package miniProjet.Traversee;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Traversee {

	public static void mainExo2()
	{
		String string = "= = Traversee = =\n\n";
		
		Config first = new Config(0,0,false);
		Config last = new Config(3,3,true);
		GraphConfig gc = new GraphConfig(3,2);
		
		string += "Creation d'"+ gc.toString() + ".\n\n";
		
		
		string += "Toutes configurations valides :\n";
		string += Traversee.toString(gc.generateValidConfigs());
		string += "\n";
		
		
		string += last.toString() + " est un voisin de (est apres) " + first.toString() + " ? ";
		string += gc.isNextTo(first, last);
		string += "\n\n";
		
		
		string += "Tout voisins valides de " + first.toString() + " dans " + gc.toString() + " :\n";
		string += Traversee.toString(gc.generateNext(first));
		string += "\n";
		
		
		string += "Parcours en largeur du graphe :\n";
		string += Traversee.toString(gc.breadthFirstSearch(first,last));
		string += "\n";
		
		
		string += "Traversee() :\n";
		string += Traversee.toString(gc.traversee());
		string += "\n";
		
		
		string += "Courbe :\n...";
		
		System.out.println(string);
		
		Traversee.generateCurveCPU(30000,6);
		string = "new data in 'miniProjet/data/traversee'";
		
		System.out.println(string);
	}
	
	public static void generateCurveCPU(int maxN, int every)
	{
		long startTime, endTime;
		GraphConfig gc;
		
	    try{
	    	String fileName = "./data/traversee/"+maxN+":"+every+".txt";
			PrintWriter out  = new PrintWriter(new FileWriter(fileName));
	    	
			int i=0;
			for(int n=3; n < maxN+1; n=n+every)
			{
				gc = new GraphConfig(n,4);
	
				startTime = System.nanoTime();
				gc.traversee();
				endTime = System.nanoTime();
				
				out.println(n + ";" + (endTime - startTime));
				if(n>i){
					System.out.println(n);
					i+=1000;
				}
			}
		
			out.close();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
	public static String toString(LinkedList<Config> configs){
		String s = "";
		for(Config conf : configs){
			s += conf.toString() + "\n";
		}
		return s;
	}
	
	public static String toString(ArrayList<Config> configs){
		String s = "";
		for(Config conf : configs){
			s += conf.toString() + "\n";
		}
		return s;
	}
	
	public static String toString(HashMap<String,Integer> configs){
		String s = "";
		/*for(Config key : configs.keySet()){
			s += key.toString() + " : " + configs.get(key).toString() + "\n";
		}*/
		return s;
	}

}
