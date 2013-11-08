package miniProjet.HanoiTowers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphConfig {
	
	int n;
	
	public GraphConfig(int n)
	{
		this.n = n;
	}

	public int getN(){
		return n;
	}
	

	
	public ArrayList<Config> generateNext(Config c)
	{	
		ArrayList<Config> neighbours = new ArrayList<Config>();
		int r1, r2;
		Config x = c.clone();
		
		for(int i=0; i<3; i++)
		{
			//System.out.println(x.toString());
			if(!x.stacks.get(i).isEmpty())
			{
				for(int j=1; j<=2; j++)
				{
					r1 = x.stacks.get(i).pop();
					
					if(!x.stacks.get((i+j)%3).isEmpty())
					{
						r2 = x.stacks.get((i+j)%3).peek();
					
						if(r1 < r2)
						{
							x.stacks.get((i+j)%3).push(r1);
							neighbours.add(x);
						}
					}
					else
					{
						x.stacks.get((i+j)%3).push(r1);
						neighbours.add(x);
					}
					
					//System.out.println("- new -\n" + x.toString());
					x = c.clone();
				}	

			}
		}
		
		return neighbours;
	}
	
	public HashMap<String,Integer> breadthFirstSearch(Config first, Config last)
	{
		LinkedList<Config> f = new LinkedList<Config>();
		HashMap<String,Integer> visited = new HashMap<String,Integer>();
		
		Config x = first.clone();
		Integer actualInt = new Integer(0);
		Integer lastInt;
		
		visited.put(x.toKey(n),actualInt);
		f.add(x); // x en dernier
		
		while (f.size() != 0)
		{
			x = f.poll(); // premier element
			lastInt = visited.get(x.toKey(n)) + 1; // distance supposees des voisins de x
			//System.out.println(x.toKey());
			
			for (Config y : this.generateNext(x)) // pour chaque voisins
			{
				actualInt = visited.get(y.toKey(n)); // distance actuelle
				
				if(actualInt == null) // si pas encore visité
				{ 
					visited.put(y.toKey(n), lastInt); // distance de y = distance de x + 1
					
					if(y.equal(last))
					{
						return visited;
					}
					f.add(y); // y en premier
				}
				else
				{
					//System.out.println(y.toString());
				}
			}
		}
		
		return null;
	}
	
	public void hanoiProc(Config first, LinkedList<Config> path, int n, int fromStack, int tempStack, int toStack)
	{
		if(n > 0)
		{
			this.hanoiProc(first, path, n-1, fromStack, toStack, tempStack);

			first.move(fromStack, toStack);
			
			//System.out.println( first.toString() );
			path.add(first.clone());
			
			this.hanoiProc(first, path, n-1, tempStack, fromStack, toStack);

		}
	}
	
	
	public LinkedList<Config> hanoi(int fromStack, int tempStack, int toStack)
	{
		Config first = ConfigFactory.makeFirst(n);
		LinkedList<Config> path = new LinkedList<Config>();
		
		//System.out.println( first.toString() );
		path.add(first.clone());
		
		this.hanoiProc(first, path, n, fromStack, tempStack, toStack);
		
		return path;
		
	}
	
	public LinkedList<Config> hanoi1(Config first)
	{
		return shortestWay(first, ConfigFactory.makeLast(n));
	}
	
	public LinkedList<Config> shortestWay(Config first, Config last)
	{
		HashMap<String,Integer> visited = this.breadthFirstSearch(first, last);
		
		if(visited == null)
		{
			return new LinkedList<Config>();
		}
		
		Config x;
		Integer actualInt;
		Integer lastInt;
		LinkedList<Config> l = new LinkedList<Config>();
		
		x = ConfigFactory.makeLast(n);
		l.add(x);
		lastInt = visited.get(x.toKey(n));
		
		while(lastInt != 0)
		{
			for (Config y : this.generateNext(x))
			{
				actualInt = visited.get(y.toKey(n));
				
				if(actualInt != null && lastInt == actualInt+1){
					x = y;
					break;
				}
			}
			l.addFirst(x);
			lastInt = visited.get(x.toKey(n));
		}
		
		return l;
	}
	
	public String toString(){
		return "";
	}
	
}
