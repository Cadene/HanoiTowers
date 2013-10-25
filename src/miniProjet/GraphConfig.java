package miniProjet;

import java.util.ArrayList;

public class GraphConfig {
	
	int n;
	int k;
	
	public GraphConfig(int n, int k)
	{
		this.n = n;
		this.k = k;
	}

	public int getN(){
		return n;
	}
	public int getK(){
		return k;
	}
	
	public ArrayList<Config> allValidConfigs()
	{
		ArrayList<Config> configs = new ArrayList<Config>();
		Config earth;
		Config island;
		
		for(int nE=0; nE<=n; nE++){
			for(int nA=0; nA<=n; nA++){
				
				earth = new Config(nE,nA,0);
				island = new Config(nE,nA,1);
				
				if(nE==0 && nA==0)
					configs.add(earth);
				else
				if(nE==n && nA==n)
					configs.add(island);
				else{
					if(island.isValid(this))
						configs.add(island);
					if(earth.isValid(this))
						configs.add(earth);
				}
			}
		}	
		return configs;
	}
	
	public ArrayList<Config> allValidNextTo(Config c)
	{
		ArrayList<Config> configs = new ArrayList<Config>();
		
		if(c.getP() == 1)
		{
			configs.add(new Config(c.getNE(), c.getNA(), 0));
		}
		else
		{
			for(int nA=c.getNA()+1; nA - c.getNA() <= k; nA++)
				configs.add(new Config(c.getNE(), nA, 1));
			for(int nA=c.getNA()+1, nE=c.getNE()+1; nA - c.getNA() <= k/2; nA++)
				configs.add(new Config(nE, nA, 1));
		}
		return configs;
	}
	
	
	//public Sequence Traversee(){}

}
