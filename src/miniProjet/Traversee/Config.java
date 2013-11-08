package miniProjet.Traversee;

import java.util.ArrayList;


public class Config {

	int nE;
	int nA;
	boolean p;

	/* Constructeurs */
	
	public Config()
	{
		this.nE = 0;
		this.nA = 0;
		this.p = false;
	}
	
	public Config(int nE, int nA, boolean p)
	{
		this.nE = nE;
		this.nA = nA;
		this.p = p;
	}
	
	
	/* Getters */
	
	public int getNE(){
		return nE;
	}
	public int getNA(){
		return nA;
	}
	public boolean getP(){
		return p;
	}
	
	/* Other */
	
	
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
	
	public boolean equal(Config c){
		return (nA == c.nA && nE == c.nE & p == c.p);
	}

}
