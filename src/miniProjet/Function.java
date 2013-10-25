package miniProjet;

import java.util.ArrayList;

public class Function {


	public static String ArrayListToString(ArrayList<Config> configs)
	{
		String s= "";
		int i = 1;
		for(Config c : configs){
			s += i + ": " + c.toString() + "\n";
			i++;
		}
		return s;
	}

}
