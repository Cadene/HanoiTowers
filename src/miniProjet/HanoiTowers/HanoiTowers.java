package miniProjet.HanoiTowers;

import miniProjet.HanoiTowers.Config;
import miniProjet.HanoiTowers.GraphConfig;

public class HanoiTowers {

	public static void main(String[] args) {
		
		String string = "= = HanoiTowers = =\n\n";
		
		Config departure = new Config(10);
	
		string += departure.toString();
		
		
		System.out.println(string);
		//GraphConfig gc = new GraphConfig(3,2);
		//string += "Création d'"+ gc.toString() + ".\n\n";
	}

}
