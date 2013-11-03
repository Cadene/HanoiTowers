package miniProjet;

public class HanoiTowers {

	public static void main(String[] args)
	{
		String string = "= = Hanoi Towers = =\n\n";
		
		Sequence sequence;
		Config departure = new Config(0,1,false);
		Config arrival = new Config(3,0,true);
		
		GraphConfig gc = new GraphConfig(3,2);
		string += "Création d'"+ gc.toString() + ".\n\n";
		
		string += "Toutes configurations valides :\n";
		sequence = new Sequence( gc.generateValidConfigs() );
		string += sequence.toString();
		string += "\n";
		
		string += arrival.toString() + " est un voisin de (est après) " + departure.toString() + " ? ";
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
		
		System.out.println(string);
	}

}
