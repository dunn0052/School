// Kevin Dunn Assignment 2 Csci 2002 - 10

import edu.princeton.cs.algs4.*;

public class SAAGeneric
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
	
	public static void main(String[] args) 
	{
		int[] a = new int[5];
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		a[3] = 25;
		a[4] = 15;
		//int[]	a = GenerateRandomArray(10,100);
		
		for(int i = 0; i < a.length; i++)
			{
				StdOut.print(a[i]);
				StdOut.print(" ");
			}
		StdOut.println("");
		//rotate(a,5);
		for(int i = 0; i < a.length; i++)
		{
			StdOut.print(a[i]);
			StdOut.print(" ");
		}
		//StdOut.println(find(a, 26));
		//StdOut.println(find(a, 0, a.length, 12));
	}
}
