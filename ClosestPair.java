import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ClosestPair {
	
	public static <T> int CP(int[] a)
	{
		Arrays.sort(a);
		int k = Math.abs(a[1] - a[0]);
		
		for(int i = 2; i < a.length; i++)
		{
			
			int m = Math.abs(a[i] - a[i-1]);
			if(m < k)
				k = m;
			
		}
	return k;
	}
	

	public static void main(String[] args) {
		int[] a = StdIn.readAllInts();
		StdOut.printf("%d", CP(a));

	}

}
