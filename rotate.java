import edu.princeton.cs.algs4.StdOut;

public class rotate {
	
	public static void swap(int[] a, int idx1, int idx2 )
	{
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	public static int rotate(int[] a, int lo)
	{
		for(int j = lo -1; j > 0; j--)
		{
			for(int i = a.length - 1; i > 0; i--)
			{
				swap(a,i, i - 1);
			}
		}
		return lo - 1;
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
		rotate(a,3);
		for(int i = 0; i < a.length; i++)
		{
			StdOut.print(a[i]);
			StdOut.print(" ");
		}
		//StdOut.println(find(a, 26));
		//StdOut.println(find(a, 0, a.length, 12));
	}

}
