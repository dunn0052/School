import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class HGTestSortNM {

	private static <T extends Comparable<T>> boolean isSorted(T[] a, int lo, int hi) {
		for (int i = lo + 1; i < hi; i++)
			if (a[i - 1].compareTo(a[i]) > 0)
				return false;
		return true;
	}

	private static <T extends Comparable<T>> boolean isSorted(T[] a) {
		return isSorted(a, 0, a.length);
	}

	public static void main(String[] args) {

		// Get n and m from the command line, and allocate the array.
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		Integer[] a = new Integer[n];
		
		// Generate a random array.  Note that we set a seed so that
		// we get predictable values each time.
		StdRandom.setSeed(0);
		for (int i = 0; i < n; i++)
			a[i] = StdRandom.uniform(-n, n);
		
		// Sort the first n-m elements.
		Arrays.sort(a, 0, n-m);
		
		// Test the sorts.
		Sort.InsertionSortNM(a, n, m);
		if (isSorted(a))
			StdOut.println("Ok");
		else
			StdOut.println("Sort failure");
	}
}
