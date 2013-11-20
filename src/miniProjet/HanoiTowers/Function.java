package miniProjet.HanoiTowers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Function {
	
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
	
}
