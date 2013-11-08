package miniProjet.HanoiTowers;

import java.util.ArrayList;
import java.util.Stack;

public class Config {

	ArrayList<Stack<Integer>> stacks;

	/* Constructeurs */
	
	private void init(){
		stacks = new ArrayList<Stack<Integer>>();
		for(int p=0; p<3; p++){
			stacks.add(new Stack<Integer>());
		}
	}
	
	public Config(){
		init();
	}
	
	public Config(ArrayList<Integer> tab)
	{
		this.init();
		
		for(int i=tab.size()-1; i>=0; i--)
		{
			stacks.get(tab.get(i)-1).push(i+1);
		}
	}
	
	public int getNbRings(){
		int nbR = 0;
		for(Stack<Integer> stack : stacks){
			for(Integer integer : stack){
				nbR++;
			}
		}
		return nbR;
	}
	
	/* Setters */
	
	public void setStacks(ArrayList<Stack<Integer>> stacks){
		this.stacks = stacks;
	}
	
	public String toString(){
		String s = "";
		int nbP = 1;
		for(Stack<Integer> stack : stacks){
			s += "p["+nbP+"]: ";
			for(Integer i : stack){
				s += i + " ";
			}
			s += "\n";
			nbP++;
		}
		return s;
	}
	
	public String toKey(int nbRings){
		
		String s = "";
		int[] tab = new int[nbRings];
		
		int nbStack = 1;
		for(Stack<Integer> stack : stacks)
		{
			for(Integer integer : stack)
			{
				tab[integer-1] = nbStack;
			}
			nbStack++;
		}
		
		boolean isFirst = true;
		for(int i=0; i<nbRings; i++)
		{
			if(isFirst){
				s += tab[i];
				isFirst = false;
			}else{
				s += ";" + tab[i];
			}
		}
		
		return s;
	}

	public Config clone()
	{
		Config conf = new Config();
		ArrayList<Stack<Integer>> newStacks = new ArrayList<Stack<Integer>>();
		
		int i = 0;
		for(Stack<Integer> stack : this.stacks)
		{
			newStacks.add(new Stack<Integer>());
			
			for(Integer integer : stack)
			{
				newStacks.get(i).push(integer);
			}
			i++;
		}
		
		conf.setStacks(newStacks);
		return conf;
	}
	
	public boolean equal(Config c)
	{
		for(int i=0; i<this.stacks.size(); i++)
		{
			if(this.stacks.get(i).size() != c.stacks.get(i).size())
				return false;
		}
		return true;
	}
	
	public void move(int fromStack, int toStack)
	{
		//System.out.println(fromStack + " " + toStack);
		int ring = this.stacks.get(fromStack).pop();
		this.stacks.get(toStack).push(ring);
	}
	
}
