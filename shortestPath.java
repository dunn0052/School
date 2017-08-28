//Kevin Dunn Csci 2002 - Assignment 10

import edu.princeton.cs.algs4.*;

public class shortestPath {

	public static void main(String[] args) {
		
		In in = new In("words4.txt");
		In inGraph = new In("wordgraph.txt");
		
		String[] a = in.readAllStrings();
		
		Graph graph = new Graph(inGraph);
		
		ST<String, Integer> wordGraph = new ST<String, Integer>();
		ST<Integer, String> indexGraph = new ST<Integer, String>();
		
		
		//map words to index and vice versa
		for(int i = 0; i < a.length; i++)
		{
			wordGraph.put(a[i], i);
			indexGraph.put(i, a[i]);
		}
	
		while (!StdIn.isEmpty()) {
			String input = StdIn.readLine();
			String[] words = input.split(" ");
			
			//make sure word is in the list
			if(!wordGraph.contains(words[0]) || !wordGraph.contains(words[1]))
				StdOut.println("Word is not in list. Try again");
			else
			{	
				//starting point
				BreadthFirstPaths k = new BreadthFirstPaths(graph, wordGraph.get(words[0]));
			
				StdOut.printf(words[0] + " -> " + words[1]+ "\n");
				for(Integer j: k.pathTo(wordGraph.get(words[1])))
				{
					StdOut.printf(indexGraph.get(j) + " ");
				}
				StdOut.printf("\n");
			}
		}
		
	
	}

}
