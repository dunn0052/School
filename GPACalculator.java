import edu.princeton.cs.algs4.*;

public class GPACalculator {

	public static void main(String[] args) {


	RedBlackBST<String, Double> G = new RedBlackBST<>();
	
	G.put("A+", 4.33);
	G.put("A", 4.00);
	G.put("A-", 3.67);
	G.put("B+", 3.33);
	G.put("B", 3.00);
	G.put("B-", 2.67);
	G.put("C+", 2.33);
	G.put("C", 2.00);
	G.put("C-", 1.67);
	G.put("D", 1.00);
	G.put("F", 0.00);
	
	
	while(!StdIn.isEmpty())
	{
		String ID = StdIn.readString();
		int nscores = StdIn.readInt();
		double sum = 0;
		for(int i = 0; i < nscores; i++)
			sum = sum + G.get(StdIn.readString());
		StdOut.printf("%s %6.2f\n",  ID, sum/nscores);
		
	}

	}

}
