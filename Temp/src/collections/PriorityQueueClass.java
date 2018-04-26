package collections;

import java.util.ArrayList;
import java.util.List;


class Movie implements Comparable<Movie>
{  
	private double rating;
    private String name;
    private int year;
    public Movie(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }
 
    // Getter methods for accessing private data
    public double getRating() { return rating; }
    public String getName()   {  return name; }
    public int getYear()      {  return year;  }

	@Override
	public int compareTo(Movie m) {
		// TODO Auto-generated method stub
		System.out.println("m.name: "+m.name);
		System.out.println("m.year: "+m.year);
		System.out.println();
		return m.year;
	}
	
}  

public class PriorityQueueClass {

	public static void main(String[] args)
	{
		/*PriorityQueue<Movie> list = new PriorityQueue<Movie>();*/
		List<Movie> list=new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        
        System.out.println("Movies before sorting : ");
        System.out.println();
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                               movie.getRating() + " " +
                               movie.getYear());
        }
 
 
        /*System.out.println("Movies after sorting : ");
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                               movie.getRating() + " " +
                               movie.getYear());
        }*/
	}

}
