package miniProjet.HanoiTowers;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import miniProjet.HanoiTowers.Config;
import miniProjet.HanoiTowers.GraphConfig;

public class HanoiTowers {

	public static void mainExo3_1() {
		
		String string = "= = HanoiTowers = =\n\n";
		
		
		string += "Creation de la configuration :\n\n";
		Config x;
		ArrayList<Integer> tab = new ArrayList<Integer>();
		tab.add(3);
		tab.add(3);
		x = new Config(tab);
		string += x.toString();
		string += "\n";
		

		int nbDisques = 3;
		GraphConfig gc = new GraphConfig(nbDisques);
		string += "Création d'un graphe de " + nbDisques + " disques\n\n";
		
		
		string += "Hanoi1 :\n";
		string += HanoiTowers.toKey( gc.hanoi1( ConfigFactory.makeFirst(nbDisques) ));
		string += "\n";
		
		
		string += "Hanoi1 Random :\n";
		string += HanoiTowers.toKey( gc.hanoi1( ConfigFactory.makeRandom(nbDisques) ));
		string += "\n";
		
		//string += "Courbe :\n...\n";
		//HanoiTowers.generateCurveCPU(10,1);
		//System.out.println(string);
		//string = "new data in 'miniProjet/data/hanoi1'";
		
		
		string += "Hanoi Recursif :\n";
		string += HanoiTowers.toKey( gc.hanoi(0, 1, 2) );
		string += "\n";

		
		System.out.println(string);

	}
	
	
	
	public static String toString(ArrayList<Config> configs){
		String s = "";
		for(Config conf : configs){
			s += conf.toString() + "\n";
		}
		return s;
	}
	
	public static String toKey(LinkedList<Config> configs){
		String s = "";
		for(Config c : configs){
			s += "(" + c.toKey(c.getNbRings()) + ")\n";
		}
		return s;
	}
	
	public static String toKey(HashMap<String,Integer> configs){
		String s = "";
		for(String key : configs.keySet()){
			s += "(" + key + ") : " + configs.get(key) + "\n";
		}
		return s;
	}
	
	public static void generateCurveCPU(int maxN, int every)
	{
		long startTime, endTime;
		GraphConfig gc;
		Config rand;

		int moyenne = 50;
		
	    try{
	    	String fileName = "./data/hanoi1/"+maxN+":"+every+".txt";
			PrintWriter out  = new PrintWriter(new FileWriter(fileName));
	    	
			int i=0;
			for(int n=1; n <= maxN; n=n+every)
			{
				gc = new GraphConfig(n);
				startTime = 0;
				endTime = 0;
				for(int m=1; m <= moyenne; m++)
				{
					rand = ConfigFactory.makeRandom(n);
					//System.out.println(rand.toString());
					startTime += System.nanoTime();
					gc.hanoi1( rand  );
					endTime += System.nanoTime();
				}

				out.println(n + ";" + ( (endTime - startTime) / moyenne) );
				if(n>i){
					System.out.println(n);
					i+=1;
				}
			}
		
			out.close();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}

}
