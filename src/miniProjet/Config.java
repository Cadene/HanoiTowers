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
	
	public boolean isValid(GrapheConfig gc)
	{
		if(nA == nE || nE == gc.getN() || nE == 0)
			return true;
		return false;
	}
	
	public boolean isNextTo(Config c, GrapheConfig gc)
	{
		if(nE == c.getNE() && nA > c.getNA && (nA - c.getNA <= gc.getK()))
			return true;
		else if(nE - c.getNE() == nA - c.getNA() && nA - c.getNA() > 0 && nA - c.getNA() >= k)
			return true;
		else if()
			
		else
			return false;
		
	}
}
