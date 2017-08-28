import edu.princeton.cs.algs4.*;

public class FarthestPair {

	public static int FP(int[] a)
	{
		int hi = a[0];
		int lo = a[0];
		for(int i = 1; i < a.length; i++)
		{
			if(a[i] > hi)
				hi = a[i];
			else if(a[i]< lo)
				lo = a[i];
		}
	return hi - lo;
	}
	
	public static void main(String[] args) {
		int[] a = StdIn.readAllInts();
		StdOut.printf("%d", FP(a));

	}

}
