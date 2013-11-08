package miniProjet;

import miniProjet.HanoiTowers.HanoiTowers;
import miniProjet.Traversee.Traversee;


public class miniProjet {

	public static void main(String[] args)
	{
		//Traversee.mainExo2();
		
		HanoiTowers.mainExo3_1();
	}

}

/*import javax.swing.JOptionPane;

public class miniProjet {
	
	    public static void hanoi(int n, String from, String temp, String to) {
	        if (n == 0) return;
	        hanoi(n-1, from, to, temp);
	        System.out.println("Bougez le disque " + n + " de " + from + " à " + to);
	        hanoi(n-1, temp, from, to);
	    }

	    public static void main(String[] args) {
	    	String a;
	    	int n;
	    	a = JOptionPane.showInputDialog("Combien de diques ?");
	    	n = Integer.parseInt(a);
	        hanoi(n, "A", "B", "C");
	    }
}*/