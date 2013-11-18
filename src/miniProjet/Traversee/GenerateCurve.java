package miniProjet.Traversee;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GenerateCurve {

	
	public static void traversee(int maxN, int every)
	{
		long startTime, endTime;
		GraphConfig gc;
		
	    try{
	    	String fileName = "./data/traversee/"+maxN+":"+every+".txt";
			PrintWriter out  = new PrintWriter(new FileWriter(fileName));
	    	
			int i=0;
			for(int n=3; n < maxN+1; n=n+every)
			{
				gc = new GraphConfig(n,4);
	
				startTime = System.nanoTime();
				gc.traversee();
				endTime = System.nanoTime();
				
				out.println(n + ";" + (endTime - startTime));
				if(n>i){
					System.out.println(n);
					i+=1000;
				}
			}
		
			out.close();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
}
