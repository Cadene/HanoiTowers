package miniProjet;

public class Config {

	int nE;
	int nA;
	int p;

	public Config(int nE, int nA, int p)
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
	public int getP(){
		return p;
	}
	
	public boolean isValid(GraphConfig gc)
	{
		if(nA == nE || nE == gc.getN() || nE == 0)
			return true;
		return false;
	}
	
	public boolean isNextTo(Config c, GraphConfig gc)
	{
		if(p == c.getP())
			return false;
		
		if(nE == c.getNE()
				&& nA > c.getNA()
				&& (nA - c.getNA() <= gc.getK()))
			return true;
		else if(nE - c.getNE() == nA - c.getNA()
				&& nA - c.getNA() > 0
				&& nA - c.getNA() <= gc.getK()/2)
			return true;
		else
			return false;
	}
	
	public String toString(){
		return "("+nE+", "+nA+", "+p+")";
	}
}
