package miniProjet.HanoiTowers;

import java.util.ArrayList;
import java.util.Random;

public class ConfigFactory {

	public static Config makeFirst(int nbDisques)
	{
		Config conf = new Config();
		
		for(int n= nbDisques; n >= 1; n--){
			conf.stacks.get(0).push(n);
		}
		
		return conf;
	}
	
	public static Config makeLast(int nbDisques)
	{
		Config conf = new Config();
		
		for(int n= nbDisques; n >= 1; n--){
			conf.stacks.get(2).push(n);
		}
		
		return conf;
	}

	public static Config makeRandom(int nbDisques)
	{
		ArrayList<Integer> tab = new ArrayList<Integer>();
		Random rand = new Random();
		
		for (int n=1; n <= nbDisques; n++)
		{
			tab.add(rand.nextInt(3)+1);
		}
		
		return new Config(tab);
	}
	
}
