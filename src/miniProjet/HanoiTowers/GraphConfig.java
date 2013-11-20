package miniProjet.HanoiTowers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class GraphConfig {
	
	int n;
	
	
	
	public GraphConfig(int n)
	{
		this.n = n;
	}

	public int getN(){
		return n;
	}
	
    /* Hanoi1 */
	
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

	public LinkedList<Config> hanoi1(Config first)
	{
		return shortestWay(first, ConfigFactory.makeLast(n));
	}
	
	
	/* HanoiRec */
	
	public void hanoiRec(Config first, LinkedList<Config> path, int n, int fromStack, int tempStack, int toStack)
	{
		if(n > 0)
		{
			this.hanoiRec(first, path, n-1, fromStack, toStack, 3-fromStack-toStack);

			first.move(fromStack, toStack);
			
			//System.out.println( first.toString() );
			path.add(first.clone());
			
			this.hanoiRec(first, path, n-1, 3-fromStack-toStack, fromStack, toStack);

		}
	}
	public LinkedList<Config> hanoi(int n, int fromStack, int toStack)
	{
		Config first = ConfigFactory.makeFirst(n);
		LinkedList<Config> path = new LinkedList<Config>();
		
		//System.out.println( first.toString() );
		path.add(first.clone());
		
		this.hanoiRec(first, path, n, fromStack, 3-fromStack-toStack, toStack);
		
		return path;
	}
	
	/* Hanoi 2 */
	
	public LinkedList<Config> hanoi2(Config first)
	{
		LinkedList<Config> path = new LinkedList<Config>();
		ArrayList<Integer> Pi = makePi(first);
		ArrayList<Integer> Pf = makePf(Pi);
		
		int n = first.getNbRings();
		int from, temp, to;
		
		path.add(first.clone());
		
		for(int d=1; d<=n; d++)
		{
			if(Pi.get(d) != Pf.get(d))
			{
				first.move(Pi.get(d), Pf.get(d));
				path.add(first.clone());
				
				from = 3 - Pi.get(d) - Pf.get(d);
				to = Pf.get(d);
				temp = getTemp(from, to);
				this.hanoiRec(first, path, d-1, from, temp, to);
			}
		}
		
		return path;
	}
	
	private ArrayList<Integer> makePi(Config c)
	{
		ArrayList<Integer> Pi = new ArrayList<Integer>();
		
		for(int i=0; i<=c.getNbRings(); i++){ Pi.add(0); }
		
		int nbS=0;
		for(Stack<Integer> stack : c.stacks)
		{
			for(Integer d : stack)
			{
				Pi.set(d, nbS);
			}
			nbS++;
		}
		
		return Pi;
	}
	
	private ArrayList<Integer> makePf(ArrayList<Integer> Pi)
	{
		ArrayList<Integer> Pf = new ArrayList<Integer>();
		int n = Pi.size()-1;
		int toStack = 2;

		for(int i=0; i <= n; i++){ Pf.add(0); }
		
		Pf.set(n, toStack);
		for(int d=n-1; d>=1; d--)
		{
			if(Pi.get(d+1) == Pf.get(d+1))
				Pf.set(d, Pf.get(d+1));
			else
				Pf.set(d, 3 - Pi.get(d+1) - Pf.get(d+1) ); 
		}
		
		return Pf;
	}
	
	private int getTemp(int from, int to)
	{
		return 3 - from - to;
	}
	
	
	/* Hanoi3 */
	
	public BigInteger hanoi3(Config first)
	{
		BigInteger nbMove = BigInteger.valueOf(0);
		BigInteger nb = BigInteger.valueOf(0);
		int n = first.getNbRings();
		
		ArrayList<Integer> Pi = makePi(first);
		ArrayList<Integer> Pf = makePf(Pi);
		
		for(int d=1; d<=n; d++)
		{
			if(Pi.get(d) != Pf.get(d))
			{
				//first.move(Pi.get(d), Pf.get(d));
				nbMove = nbMove.add(BigInteger.valueOf(getU(d-1) + 1));
				//System.out.println(nbMove);
				nb = nb.add(BigInteger.valueOf(1));
			}
		}
		
		return nb;
	}
	
	private int getU(int n){
		if(n>0)
			return (int) Math.pow(2, n) - 1;
		return 0;
	}
	
}
