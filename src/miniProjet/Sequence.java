package miniProjet;

import java.util.ArrayList;

public class Sequence {
	
	ArrayList<Config> configs;
	
	public Sequence() {
		configs = new ArrayList<Config>();
	}
	
	public int getSize(){
		return configs.size();
	}
	public ArrayList<Config> getConfigs(){
		return configs;
	}
	
	
	
	
	
}
