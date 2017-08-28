
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class LinkedList<T>  implements Iterable<T>{
	
	public LinkedList()
	{
	}
	
	private class Node<T>
	{
		 T s;
		 Node next;
		
		public Node(T t, Node n )
		{
			s = t;
			next = n;
		}
	}
	
	Node first = null;
	
	@SuppressWarnings("unchecked")
	public <T> void add(T t)
	{
		
		@SuppressWarnings("rawtypes")
		Node n = new Node(t, first);
		first = n;
	}
	
	public void displayNodes()
	{
		
		for(Node n = first; n != null; n = n.next)
		{
			StdOut.print(n.s + " -> ");
		}
		StdOut.println("null");
	}
	
	private <T> Node find(T t)
	{
		for(Node n = first; n != null; n = n.next)
		{
			if(n.s.equals(t))
			return n;
			
		}
	return null;
	}
	
	
	
	public <T> boolean removeAfter(T t)
	{
		Node n = find(t);
		if(n.equals(null))
			return false;
		
		if(n.next != null)
		{
			n.next = n.next.next;
		}
		
		return true;
				
	}
	
	@SuppressWarnings("unchecked")
	public <T> boolean insertAfter(T a, T s)
	{
		
		while(find(a) != null)
		{
			@SuppressWarnings("rawtypes")
			Node n = new Node(s, find(a).next);
			find(a).next = n;
			return true;
		}
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> int remove(T s)
	{
		first = new Node("", first);
		Node n = first;
		int i = 0;
		while(n.next != null)
		{
			if(n.next.s.equals(s))
			{
			n.next = n.next.next;
			i++;
			}
			else
			{
				n = n.next;
			}

		}
		first = first.next;
		return i;
	}
	
	public static void main(String[] args) {
		
		}

	public Iterator<T> iterator()
	{
		return new ListIterator();
	}
		
	private class ListIterator implements Iterator<T>
	{
		@SuppressWarnings("unchecked")
		private Node<T> current = first;
		T t = current.s;
		
		public boolean hasNext()
		{
			return current != null;
		}
		
		public void remove()
		{
			
		}
		
		@SuppressWarnings("unchecked")
		public T next()
		{
			
			T t = current.s;
			current = current.next;
			return t;
		}
	}
	}
	

