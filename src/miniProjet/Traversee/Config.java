package miniProjet.Traversee;

import java.util.ArrayList;

public class Config {

	int nE;
	int nA;
	boolean p;

	public Config(int nE, int nA, boolean p)
	{
		this.nE = nE;
		this.nA = nA;
		this.p = p;
	}
	
	public int getNE(){
		return nE;
	}
	public int getNA(){
		return nA;
	}
	public boolean getP(){
		return p;
	}
	
	public boolean isValid(GraphConfig gc)
	{
		if(nA == nE || nE == gc.getN() || nE == 0)
			return true;
		return false;
	}
	
	public boolean isNextTo(Config begin, GraphConfig gc)
	{
		if(p == begin.getP())
			return false;
		if(!this.isValid(gc))
			return false;
		if(!begin.isValid(gc))
			return false;
		
		if(nE == begin.getNE()){
			if(nA > begin.getNA()
				&& (nA - begin.getNA() <= gc.getK())){
				return true;
			}
			if(nA < begin.getNA()
				&& (begin.getNA() -nA  <= gc.getK())){
				return true;
			}
		}
		
		if(nE != begin.getNE()){
			if(Math.abs(nA - begin.getNA())
				+ Math.abs(nE - begin.getNE()) <= gc.getK()){
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<Config> generateNext(GraphConfig gc)
	{	
		int nE;
		int nA;
		Config neighbour;
		ArrayList<Config> neighbours = new ArrayList<Config>();
		
		if(this.p)
		{
			
			for(nE = this.nE;  nE >= this.nE-gc.getK() && nE >= 0; nE--)
			{
				for (nA = this.nA; nA >= this.nA-gc.getK() && nA >= 0; nA--)
				{
					if ( (Math.abs(this.nA-nA) + Math.abs(this.nE-nE) <= gc.getK())
						&& !( (nA == this.nA) && (nE == this.nE)) )
					{
						neighbour = new Config(nE, nA, !this.getP());
					
						if(neighbour.isValid(gc))
							neighbours.add(neighbour);
					}
				}
			}
		}
		else
		{	
			for(nE = this.nE; nE <= this.nE+gc.getK() && nE <= gc.getN() ; nE++)
			{
				for (nA = this.nA; nA <= this.nA+gc.getK() && nA <= gc.getN(); nA++)
				{
					if ( (Math.abs(this.nA-nA) + Math.abs(this.nE-nE) <= gc.getK())
						&& !( (nA == this.nA) && (nE == this.nE)) )
					{
						neighbour = new Config(nE, nA, !this.getP());
					
						if(neighbour.isValid(gc))
							neighbours.add(neighbour);
					}
				}
			}
		}

		return neighbours;
	}
	
	public String toString(){
		String s = "("+nE+", "+nA+", ";
		if(p)
			s += "1)";
		else
			s += "0)";
		return s;
	}
	
	public String toKey(){
		String s = nE +";"+ nA + ";";
		if(p)
			s += "1";
		else
			s += "0";
		return s;
	}
}
