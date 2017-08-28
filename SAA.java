// Kevin Dunn Assignment 4 Csci 2002 - 10

import edu.princeton.cs.algs4.*;

public class SAA
{
	private static int[] GenerateRandomArray(int size, int max)
	{
		int[] a = new int[size];
		for (int i = 0; i < size; i++)
		{
			a[i] = StdRandom.uniform(max);
		}
		return a;
	}

	public static <T> int find(T[] a, T val)
	{
	
		for(int i = 0; i < a.length; i++ )
			if(a[i].equals(val))
				return i;
		return -1;
		
	}

	
	
	public static <T> int find(T[] a, int lo, int hi, T val)
	{
		for(int i = lo; i < hi; i++ )
			if(a[i].equals(val))
				return i;
			
		
		return -1;
		
	}
	
	public static <T> int count(T[] a, T val)
	{
		int track = 0;
		for(int i = 0; i < a.length; i++ )
		{
			if(a[i].equals(val))
			{
				track = track + 1;
			}
			
		}
		return track;
	}
	
	public static <T> int count(T[] a, int lo, int hi, T val)
	{
		int track = 0;
		for(int i = lo; i < hi; i++ )
			{if(a[i].equals(val))
			{
				track = track + 1;
			}
			
			}
		return track;
	}
	
	public static <T> boolean allOf(T[] a, T val)
	{
		for(int i = 0; i < a.length; i++)
		{
			if(!a[i].equals(val))
				return false;
		}
		return true;	
	}
	
	public static <T> boolean allOf(T[] a, int lo, int hi, T val)
	{
		for(int i = lo; i < hi; i++)
		{
			if(a[i].equals(val))
				return false;
		}
		return true;	
	}
	
	
	public static <T> boolean anyOf(T[] a, T val)
	{
		for(int i = 0; i < a.length; i++)
		{
			if(a[i].equals(val))
				return true;
		}
		return false;	
	}
	
	public static <T> boolean anyOf(T[] a, int lo, int hi, T val)
	{
		for(int i = lo; i < hi; i++)
		{
			if(a[i].equals(val))
				return true;
		}
		return false;	
	}
	
	public static <T> boolean noneOf(T[] a, T val)
	{
		return !anyOf(a,val);
	}
	
	public static <T> boolean noneOf(T[] a, int lo, int hi, T val)
	{
		return !anyOf(a, lo, hi, val);
		
	}
	
	public static <T extends Comparable<T>> boolean isSorted(T[] a)
	{
		for(int i = 1; i < a.length; i ++)
		{
			if(a[i-1].compareTo(a[i]) > a[i].compareTo(a[i-1]))
				return false;
		}
		return true;
	}
	
	public static <T extends Comparable<T>> boolean isSorted(T[] a, int lo, int hi)
	{
		for(int i = 0; i < (hi-lo) - 1; i ++)
		{
			if(a[lo+1].compareTo(a[lo + i + 1]) > a[lo + i + 1].compareTo(a[lo + 1]))
				return false;
		}
		return true;
	}
	
	public static <T> void  swap(T[] a, int idx1, int idx2 )
	{
		T temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	public static <T> void reverse(T[] a)
	{
		for(int i = 0; i < (a.length)/2; i++)
			swap(a, i, a.length - 1 - i);
	}
	
	public static <T> void reverse(T[] a, int lo, int hi)
	{
		for(int i = 0; i < (hi - lo)/2; i++)
			{
			swap(a, lo + i, hi - i - 1);
			
			}
	}
	
	public static <T> void copy(T[] aFrom, T[] aTo)
	{
		if(aFrom.length <= aTo.length)
		{
			for(int i = 0; i < aFrom.length; i ++)
				aTo[i] = aFrom[i];
		}
		else
		{
			for(int i = 0; i < aTo.length; i ++)
				aTo[i] = aFrom[i];
		}
	}
	
	public static <T> void copy(T[] aFrom, T[] aTo, int lo, int hi)
	{
		if(hi > aFrom.length)
		{
			if(aFrom.length > aTo.length)
			{
				for(int i = 0; i < (aTo.length- lo); i ++)
					aTo[lo + i] = aFrom[lo + i];
			}
			else
			{
				for(int i = 0; i < (aFrom.length- lo); i ++)
					aTo[lo + i] = aFrom[lo + i];
			}
			
		}
		else if(hi > aTo.length)
		{
			for(int i = 0; i < (aTo.length- lo); i ++)
				aTo[lo + i] = aFrom[lo + i];
		}
		else
		{
			for(int i = 0; i < (hi- lo); i ++)
				aTo[lo + i] = aFrom[lo + i];
		}
	}
	
	public static <T> void rotate(T[] a, int lo)
	{
		for(int j = lo; j > 0; j--)
		{
			for(int i = a.length - 1; i > 0; i--)
			{
				swap(a,i, i - 1);
			}
		}
		
	}
	
	public static <T extends Comparable<T>> int lowerBound(T[] a, T key)
	{
		int i = 0;
		while(i < a.length)
		{	
			if(a[i].compareTo(key) >= 0)
				break;
			i++;
		}
	return i;
		
	}
	
	public static <T extends Comparable<T>> int upperBound(T[] a, T key)
	{
		int i = 0;
		while(i < a.length)
		{	
			if(a[i].compareTo(key) > 0)
				break;
			i++;
		}
	return i;
	}
	
	public static <T extends Comparable<T>> int lowerBound(T[] a,
			int lo, int hi, T key)
			{
			while (lo < hi) {
			// invariant : for all i in [0,lo), a[i] < key
			// invariant : for all i in [hi,l), a[i] >= key
			int mid = lo + (hi - lo) / 2;
			if (a[mid].compareTo(key) < 0)
			lo = mid + 1;
			else
			hi = mid;
			}
			// invariant : lo == hi
			// postcondition : for all i in [0,k) a[i] < key
			// postcondition : for all i in [k,l) a[i] >= key
			return lo;
			}
	
	public static <T extends Comparable<T>> int upperBound(T[] a, int lo, int hi, T key)
			{
			while (lo < hi) 
			{
			// invariant : for all i in [0,lo), a[i] < key
			// invariant : for all i in [hi,l), a[i] >= key
			int mid = lo + (hi - lo) / 2;
			if (a[mid].compareTo(key) > 0)
			{
			lo = mid + 1;
			StdOut.printf("lo %d3\n", lo);
			}
			else
			{
			hi = mid;
			StdOut.printf("hi %3d\n", hi);
			}
			}
			// invariant : lo == hi
			// postcondition : for all i in [0,k) a[i] < key
			// postcondition : for all i in [k,l) a[i] >= key
			return lo;
			}
	
	public static void main(String[] args) 
	{
		Integer[] a = new Integer[12];
		a[0] = 2;
		a[1] = 2;
		a[2] = 2;
		a[3] = 4;
		a[4] = 4;
		a[5] = 4;
		a[6] = 6;
		a[7] = 6;
		a[8] = 6;
		a[9] = 8;
		a[10] = 8;
		a[11] = 8;
		Integer key = 9;
		
		/*Integer[] a = new Integer[1];
		a[0] = 1;
		Integer key = 1;
		*/
		int lb = SAA.lowerBound(a, key);
		int ub = SAA.upperBound(a, key);
		StdOut.printf("%3d %3d\n", lb, ub);
	}
	
	
}
