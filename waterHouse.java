//Kevin Dunn Csci 2002 - Assignment 10

import edu.princeton.cs.algs4.*;
public class waterHouse {
	
	
	
	
	
	
	public static void main(String[] args) {
		 In in = new In("utility_graph.txt");
		 EdgeWeightedGraph G = new EdgeWeightedGraph(in);
	     PrimMST mst = new PrimMST(G); 
	     
	     //Put edges in symbol table to order by weight 
	     ST<Double, Edge> k = new ST<Double, Edge>();
	     for (Edge e : mst.edges()) 
	     {
	    	k.put(e.weight(), e);
	     }
	     
	     for(Double j: k.keys())
	     {
		StdOut.println(k.get(j));
	     }
	     
		
	}

}
