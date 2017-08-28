import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class IMDB {
	
	public static void main(String[] args) {

		In in = new In("movies.txt");
		
		ST<String, String> Actors = new ST<String, String>();
		ST<String, String> Movies = new ST<String, String>();


		// Read the input file.
		while (in.hasNextLine()) {
			
			// Split the  line by '/' characters.  The movie is the first
			// item; the remaining items are all names of actors.
			String[] a = in.readLine().split("/");
			
			Arrays.sort(a, 1, a.length);
			//sort actor list
			
			String movie = a[0];
			
			// For each actor in this movie...
			for (int i = 1; i < a.length; i++) {
				String actor = a[i];
				
				if(!Actors.contains(actor))
				{
					Actors.put(actor, movie);
				}
				else
				{
				Actors.put(actor, Actors.get(actor) + "\n" + movie);
				}
				
				//initialize first entry
				
				if(!Movies.contains(movie))
				{
					Movies.put(movie, actor);
				}
				else
				{
					Movies.put(movie, Movies.get(movie) + "\n" + actor);
				}
				
				//adds movie/actor to value list
				
			}
		
		}
		
		//StdOut.println(a[0]);
		while (!StdIn.isEmpty()) {
			String query = StdIn.readLine();
			if(Actors.contains(query))
			{
			StdOut.println(Actors.get(query));
			}
			else if(Movies.contains(query))
			{
			StdOut.println(Movies.get(query));
			}
			// If this is a movie, print out all the actors in it.

			// If this is an actor, print his/her filmography.
		}
	}
}
