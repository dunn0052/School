import edu.princeton.cs.algs4.*;

public class Sort {
	
	public static <T extends Comparable<T>> void swap(T[] a, int idx1, int idx2 )
	{
		T temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	public static <T extends Comparable<T>> void InsertionSortNM(T[] a, int n, int m)
	{
		int l = n-m;
		for(int i = l; i < n; i++)
		{
			int k = i; //swap this specific i
			while(a[k-1].compareTo(a[k]) > 0)
				{
					swap(a, k, k-1);
					k--;	
				}
		}
	}

	public static void main(String[] args) {

	}

}
