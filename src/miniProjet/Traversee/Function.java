package miniProjet.Traversee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Function {

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
