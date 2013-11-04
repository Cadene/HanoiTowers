package miniProjet.Traversee;

import java.util.ArrayList;

public class Sequence {
	
	ArrayList<Config> configs;
	
	public Sequence() {
		configs = new ArrayList<Config>();
	}
	public Sequence(ArrayList<Config> c) {
		configs = c;
	}
	
	public int getSize(){
		return configs.size();
	}
	public ArrayList<Config> getConfigs(){
		return configs;
	}
	
	public String toString()
	{
		if(configs == null){
			return "Traversee impossible.\n";
		}
		String s= "";
		int i = 1;
		for(Config c : configs){
			s += i + ": " + c.toString() + "\n";
			i++;
		}
		return s;
	}
	
	
	
	
}
