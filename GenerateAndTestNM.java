
import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class GenerateAndTestNM {

	private static <T extends Comparable<T>> boolean isSorted(T[] a, int lo, int hi) {
		for (int i = lo + 1; i < hi; i++)
			if (a[i - 1].compareTo(a[i]) > 0)
				return false;
		return true;
	}

	private static <T extends Comparable<T>> boolean isSorted(T[] a) {
		return isSorted(a, 0, a.length);
	}

	private static void timeMergeSort(int[] a, int n, int m) {
		Integer[] aInt = new Integer[n];
		for (int i = 0; i < n; i++)
			aInt[i] = a[i];
		Stopwatch sw = new Stopwatch();
		Merge.sort(aInt);
		double elapsed = sw.elapsedTime();
		StdOut.printf("Merge     sort : %d, %d, %7.3f\n", n, m, elapsed);
	}

	private static void timeInsertionSort(int[] a, int n, int m) {
		Integer[] aInt = new Integer[n];
		for (int i = 0; i < n; i++)
			aInt[i] = a[i];
		Stopwatch sw = new Stopwatch();
		Sort.InsertionSortNM(aInt, n, m);
		if (!isSorted(aInt))
			StdOut.println("Sort failure!\n");
		double elapsed = sw.elapsedTime();
		StdOut.printf("Insertion sort : %d, %d, %7.3f\n", n, m, elapsed);
	}
	
	public static void main(String[] args) {
	int m = 4;
		while(m<257)
		{
		for(int j = 5; j > 0; j--)
		{
			int n = 4000000;
			int[] a = new int[n];
		
		
			// Generate a random array.  Note that we set a seed so that
			// we get predictable values each time.
			StdRandom.setSeed(0);
			for (int i = 0; i < n; i++)
				a[i] = StdRandom.uniform(-n, n);
		
			// Sort the first n-m elements.
			Arrays.sort(a, 0, n-m);
		
			// Test the sorts.
			timeInsertionSort(a, n, m);
		}
		m = m*2;
		}
		
		m = 4;
		while(m<257)
		{
		for(int j = 5; j > 0; j--)
		{
			int n = 4000000;
			int[] a = new int[n];
		
		
			// Generate a random array.  Note that we set a seed so that
			// we get predictable values each time.
			StdRandom.setSeed(0);
			for (int i = 0; i < n; i++)
				a[i] = StdRandom.uniform(-n, n);
		
			// Sort the first n-m elements.
			Arrays.sort(a, 0, n-m);
		
			// Test the sorts.
			timeMergeSort(a, n, m);
		}
		m = m*2;
		}
	}
}
