//Kevin Dunn Csci 2002 - 10

import edu.princeton.cs.algs4.*;

public class UndoRedoList<T> {
	
	@SuppressWarnings("unchecked")
	private Stack<T> undo = new Stack();
	
	@SuppressWarnings("unchecked")
	private Stack<T> redo = new Stack();
	
	public void add(T item)
	{
		undo.push(item);
		if(!redo.isEmpty())
			redo.pop();
	}
	
	public T undo()
	{
		T a = undo.pop();
		redo.push(a);
		return a;
	}

	public T redo()
	{
		T a = redo.pop();
		undo.push(a);
		return a;
	}
	
	public boolean canUndo()
	{
		return !undo.isEmpty();
	}
	
	public boolean canRedo()
	{
		return !redo.isEmpty();
	}
	
	public static void main(String[] args) {
		UndoRedoList<String> ur = new UndoRedoList<String>();
		ur.add("a");
		ur.add("b");
		ur.add("c");
		ur.add("d");
		String s = ur.undo();
		String t = ur.redo();
		if (!s.equals(t))
		StdOut.println("Error");
		s = ur.undo();
		t = ur.undo();
		StdOut.printf("Removed %s and %s\n", s, t);
		ur.add("e");
		ur.add("f");
		while (ur.canUndo())
		StdOut.printf("next undo : %s\n", ur.undo());
		while (ur.canRedo())
		StdOut.printf("next redo : %s\n", ur.redo());


	}

}
