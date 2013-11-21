package miniProjet.Traversee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphConfig {
	
	int n;
	int k;
	
	
	/* Constructeurs */
	
	public GraphConfig(int n, int k)
	{
		this.n = n;
		this.k = k;
	}

	
	/* Getters */
	
	public int getN(){
		return n;
	}
	public int getK(){
		return k;
	}


	/* Others */
	
	public String toString(){
		return "un graphe des config n="+this.n+" k="+this.k;
	}
	
	public boolean isValid(Config c)
	{
		if(c.nA == c.nE || c.nE == n || c.nE == 0)
			return true;
		return false;
	}
	
	public boolean isNextTo(Config c1, Config c2)
	{
		if(c1.p == c2.p)
			return false;
		if(!this.isValid(c1))
			return false;
		if(!this.isValid(c2))
			return false;
		
		if(c1.nE == c2.nE){
			if(c1.nA > c2.nA
				&& (c1.nA - c2.nA <= k)){
				return true;
			}
			if(c1.nA < c2.nA
				&& (c2.nA - c1.nA  <= k)){
				return true;
			}
		}
		
		if(c1.nE != c2.nE){
			if(Math.abs(c1.nA - c2.nA)
				+ Math.abs(c1.nE - c2.nE) <= k){
				return true;
			}
		}
		
		return false;
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
				
				if(this.isValid(island))
					configs.add(island);
				if(this.isValid(earth))
					configs.add(earth);
			}
		}	
		return configs;
	}
	

	public ArrayList<Config> generateNext(Config c)
	{	
		int nE;
		int nA;
		Config neighbour;
		ArrayList<Config> neighbours = new ArrayList<Config>();
		
		if(c.p)
		{
			
			for(nE = c.nE;  nE >= c.nE-k && nE >= 0; nE--)
			{
				for (nA = c.nA; nA >= c.nA-k && nA >= 0; nA--)
				{
					if ( (Math.abs(c.nA-nA) + Math.abs(c.nE-nE) <= k)
						&& !( (nA == c.nA) && (nE == c.nE)) )
					{
						neighbour = new Config(nE, nA, !c.p);
					
						if(this.isValid(neighbour))
							neighbours.add(neighbour);
					}
				}
			}
		}
		else
		{	
			for(nE = c.nE; nE <= c.nE+k && nE <= n ; nE++)
			{
				for (nA = c.nA; nA <= c.nA+k && nA <= n; nA++)
				{
					if ( (Math.abs(c.nA-nA) + Math.abs(c.nE-nE) <= k)
						&& !( (nA == c.nA) && (nE == c.nE)) )
					{
						neighbour = new Config(nE, nA, !c.p);
					
						if(this.isValid(neighbour))
							neighbours.add(neighbour);
					}
				}
			}
		}

		return neighbours;
	}

	public HashMap<String,Integer> breadthFirstSearch(Config first, Config last)
	{
		LinkedList<Config> f = new LinkedList<Config>();
		HashMap<String,Integer> visited = new HashMap<String,Integer>();
		
		Config x;
		x = first;
		Integer actualInt = new Integer(0);
		Integer lastInt;
		
		visited.put(x.toKey(),actualInt);
		f.add(x); // x en dernier
		
		while (f.size() != 0)
		{
			x = f.poll(); // premier element
			lastInt = visited.get(x.toKey()) + 1; // distance supposees des voisins de x
			
			//System.out.println(x.toKey());
			for (Config y : this.generateNext(x)) // pour chaque voisins
			{
				actualInt = visited.get(y.toKey()); // distance actuelle
				
				if(actualInt == null) // si pas encore visité
				{ 
					visited.put(y.toKey(), lastInt); // dx = distance supposees
					
					if(y.equal(last))
					{
						return visited;
					}
					f.add(y); // y en premier
				}
				/*else
				{
					System.out.println(y.toString());
				}*/
			}
		}
		
		return null;
	}
	
	
	public LinkedList<Config> traversee()
	{
		return shortestWay(new Config(0,0,false), new Config(n,n,true));
	}
	
	public LinkedList<Config> shortestWay(Config first, Config last)
	{
		HashMap<String,Integer> visited = this.breadthFirstSearch(first,last);
		
		if(visited == null)
		{
			return new LinkedList<Config>();
		}
		Config x;
		Integer actualInt;
		Integer lastInt;
		LinkedList<Config> l = new LinkedList<Config>();
		
		x = new Config(this.getN(), this.getN(), true);
		l.add(x);
		lastInt = visited.get(x.toKey());
		
		while(lastInt != 0)
		{
			for (Config y : this.generateNext(x))
			{
				actualInt = visited.get(y.toKey());
				
				if(actualInt != null && lastInt == actualInt+1){
					x = y;
					break;
				}
			}
			l.addFirst(x);
			lastInt = visited.get(x.toKey());
		}
		
		return l;
	}
	
	
}
