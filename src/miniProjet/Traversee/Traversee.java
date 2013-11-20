package miniProjet.Traversee;


public class Traversee {

	public static void main()
	{
		String string = "= = Traversee = =\n\n";
		
		Config first = new Config(0,0,false);
		Config last = new Config(3,3,true);
		GraphConfig gc = new GraphConfig(3,2);
		
		string += "Creation d'"+ gc.toString() + ".\n\n";
		
		
		string += "Toutes configurations valides :\n";
		string += Function.toString(gc.generateValidConfigs());
		string += "\n";
		
		
		string += last.toString() + " est un voisin de (est apres) " + first.toString() + " ? ";
		string += gc.isNextTo(first, last);
		string += "\n\n";
		
		
		string += "Tout voisins valides de " + first.toString() + " dans " + gc.toString() + " :\n";
		string += Function.toString(gc.generateNext(first));
		string += "\n";
		
		
		string += "Parcours en largeur du graphe :\n";
		string += Function.toString(gc.breadthFirstSearch(first,last));
		string += "\n";
		
		
		string += "Traversee() :\n";
		string += Function.toString(gc.traversee());
		string += "\n";
		
		
		string += "Courbe :\n...";
		
		System.out.println(string);
		
		//GenerateCurve.traversee(30000,50);
		string = "new data in 'miniProjet/data/traversee'";
		
		System.out.println(string);
	}
	
	
	

}
