package miniProjet.Traversee;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Traversee {

	public static void main()
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
		
		GenerateCurve.traversee(30000,6);
		string = "new data in 'miniProjet/data/traversee'";
		
		System.out.println(string);
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
