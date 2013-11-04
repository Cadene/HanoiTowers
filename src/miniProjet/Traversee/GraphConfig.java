package miniProjet.Traversee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

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
	
	public ArrayList<Config> generateValidConfigs()
	{
		ArrayList<Config> configs = new ArrayList<Config>();
		Config earth;
		Config island;
		
		for(int nE=0; nE<=n; nE++){
			for(int nA=0; nA<=n; nA++){
				
				earth = new Config(nE,nA,false);
				island = new Config(nE,nA,true);
				
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
	
	public Sequence breadthFirstSearch(){
		
		Config x;
		LinkedList<Config> f = new LinkedList<Config>();
		ArrayList<Config> l = new ArrayList<Config>();
		HashMap<String,Boolean> visited = new HashMap<String,Boolean>();

		x = new Config(0,0,false);
		visited.put(x.toKey(),true);
		f.addFirst(x);
		l.add(x);
		
		while (f.size() != 0)
		{
			x = f.poll();
			//System.out.println(x.toString());
			for (Config y : x.generateNext(this))
			{
				if(visited.get(y.toKey()) == null){
					visited.put(y.toKey(), true);
					f.addFirst(y);
					l.add(y); 
				}else{
					//System.out.println(y.toString());
				}
			}
		}
		
		return new Sequence(l);
	}
	
	public Sequence traversee()
	{
		LinkedList<Config> f = new LinkedList<Config>();
		ArrayList<Config> l = new ArrayList<Config>();
		HashMap<String,Integer> visited = new HashMap<String,Integer>();
		
		Config x = new Config(0,0,false);
		Integer actualInt = new Integer(0);
		Integer lastInt;
		
		visited.put(x.toKey(),actualInt);
		f.addFirst(x);
		l.add(x);
		
		while (f.size() != 0)
		{
			x = f.poll();
			lastInt = visited.get(x.toKey()) + 1;
			//System.out.println(x.toString());
			for (Config y : x.generateNext(this))
			{
				actualInt = visited.get(y.toKey());
				
				if(actualInt == null){
					visited.put(y.toKey(), lastInt);
					f.addFirst(y);
					l.add(y); 
				}else{
					//System.out.println(y.toString());
				}
			}
		}
		
		x = new Config(this.getN(),this.getN(),true);
		actualInt = visited.get(x.toKey());
		ArrayList<Config> l2 = new ArrayList<Config>();
		
		if(actualInt == null){
			return new Sequence(null);
		}
		l2.add(x);
		//System.out.println("Try1");
		lastInt = visited.get(x.toKey());
		while(lastInt != 0)
		{
			for (Config y : x.generateNext(this))
			{
				actualInt = visited.get(y.toKey());
				//System.out.println(actualInt);
				if(lastInt == actualInt+1){
					x = y;
					break;
				}
			}
			l2.add(x);
			lastInt = visited.get(x.toKey());
		}
		
		return new Sequence(l2);
	}
	
	public String toString(){
		return "un graphe des config n="+this.n+" k="+this.k;
	}
	
}
