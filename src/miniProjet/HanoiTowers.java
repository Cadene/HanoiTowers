package miniProjet;

public class HanoiTowers {

	public static void main(String[] args)
	{
		String string = "= = Hanoi Towers = =\n";
		
		GraphConfig gc = new GraphConfig(3,2);
		
		string += "Toutes configurations valides :\n";
		string += Function.ArrayListToString( gc.allValidConfigs() );
		
		string += "Tous voisins valides :\n";
		string += Function.ArrayListToString( gc.allValidNextTo(new Config(0,1,0)) );
		
		System.out.println(string);
	}

}
