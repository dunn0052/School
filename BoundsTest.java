
import edu.princeton.cs.algs4.*;

public class BoundsTest {

	public static void main(String[] args) {

		// The int read from stdin is the size of the array.
		int n = StdIn.readInt();
		Integer[] a = new Integer[n];

		// The next n ints are the array itself.
		for (int i = 0; i < n; i++)
			a[i] = StdIn.readInt();

		// Read keys until we have no more input. For each
		// key, call lower_bound() and upper_bound() and
		// show the results.
		while (!StdIn.isEmpty()) {
			Integer key = StdIn.readInt();
			int lb = SAA.lowerBound(a, key);
			int ub = SAA.upperBound(a, key);
			StdOut.printf("%3d %3d\n", lb, ub);
		}
	}

}
