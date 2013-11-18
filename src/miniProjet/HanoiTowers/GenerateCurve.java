package miniProjet.HanoiTowers;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GenerateCurve {

	public static void hanoi1(int maxN, int every)
	{
		long startTime, endTime;
		GraphConfig gc;
		Config rand;

		int moyenne = 50;
		
	    try{
	    	String fileName = "./data/hanoi1/"+maxN+":"+every+".txt";
			PrintWriter out  = new PrintWriter(new FileWriter(fileName));
	    	
			int i=0;
			for(int n=1; n <= maxN; n=n+every)
			{
				gc = new GraphConfig(n);
				startTime = 0;
				endTime = 0;
				for(int m=1; m <= moyenne; m++)
				{
					rand = ConfigFactory.makeRandom(n);
					//System.out.println(rand.toString());
					startTime += System.nanoTime();
					gc.hanoi1( rand  );
					endTime += System.nanoTime();
				}

				out.println(n + ";" + ( (endTime - startTime) / moyenne) );
				if(n>i){
					System.out.println(n);
					i+=1;
				}
			}
		
			out.close();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
	public static void hanoi2(int maxN, int every)
	{
		long startTime, endTime;
		GraphConfig gc;
		Config rand;

		int moyenne = 50;
		
	    try{
	    	String fileName = "./data/hanoi2/"+maxN+":"+every+".txt";
			PrintWriter out  = new PrintWriter(new FileWriter(fileName));
	    	
			int i=0;
			for(int n=1; n <= maxN; n=n+every)
			{
				gc = new GraphConfig(n);
				startTime = 0;
				endTime = 0;
				for(int m=1; m <= moyenne; m++)
				{
					rand = ConfigFactory.makeRandom(n);
					//System.out.println(rand.toString());
					startTime += System.nanoTime();
					gc.hanoi2( rand  );
					endTime += System.nanoTime();
				}

				out.println(n + ";" + ( (endTime - startTime) / moyenne) );
				if(n>i){
					System.out.println(n);
					i+=1;
				}
			}
		
			out.close();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
}
