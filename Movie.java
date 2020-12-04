import java.util.Comparator;

public class Movie implements Comparable<Movie>
	{
	 
	public static Comparator<Movie> compareToRating;
	public String name = "none";  
	  public int year;
	  public int rating;  
	  public String director;
	  public String Actor;
	  
	  
	   Movie(String Actor,String name,int year, int rating,String director)
	   {
		   this.Actor=Actor;
		   this.name=name;
	       this.year = year;
	       this.rating = rating;
	       this.director = director;
	       
	   }


	public Object getMovie_name() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	public int compareToRating(Movie s) 
	{
		int compare = rating=(s.rating);
		if (compare ==0)
		{
			compare = Integer.compare(year, s.year);
			
		}
		return compare;
	}

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		
		int compare = name.compareToIgnoreCase(o.name);
		if (compare ==0)
		{
			compare = Integer.compare(year, o.year);
			
		}
		return compare;
	}
	public String toString()
	{
		return "|   Name:   " + name + "|   Year:   " + "|   Director:   " + director+"| Actor(s):    "+Actor +"|  Rating:"+rating +"\n";
	}



	
	} // end of Movie class

