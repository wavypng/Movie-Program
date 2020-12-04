/*
 * Rigoberto Hinojos
 * 
 * 
 * 
 */




import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main

{
	static Scanner input = new Scanner(System.in);

	static ArrayList<Movie> movieList = null;
	
	public static void main(String[] args)
	{
		String choice;
		String user;
		String Password = "manager1";
		movieList = new ArrayList<Movie>();
		System.out.println("Welcome To AMC Movies");
		System.out.println("Please Press 'M' For manager or 'U' for user");
		user = input.next();
		while (!user.equalsIgnoreCase("m") && !user.equalsIgnoreCase("u"))
		{
			System.out.println("Incorrect Try again");
			user = input.next();
		}
		
		if (user.equalsIgnoreCase("m"))
		{		
		System.out.println("Enter Password");
		Password = input.next();
		
		while (!Password.equals("manager1"))
		{
			System.out.println("Incorrect Try again");
			Password = input.next();
		}
		
		if (Password.equals("manager1"))
		while (true) {
			
			displayMenu();
			choice = input.next();

	while(!choice.equals("1")&&!choice.equals("2")&&!choice.equals("3")&&!choice.equals("4")&&!choice.equals("5")&&!choice.equals("6")&&!choice.equals("7")&&!choice.equals("0"))
	{
		        System.out.println("Invalid input!");
		        System.out.print("Enter an integer: ");
		       choice = input.next();
		    }
			
			if (choice.equals ("0")) {
				break;
			}
			
			
			if (choice.equals ("1")) {
				doMenuOption_AddNewMovie();
			}
			if (choice.equals ("2")) {
				doMenuOption_ShowMovies();
			}
			if (choice.equals ("3")) {
				doMenuOption_RemoveMovie();
			}
			if (choice.equals ("4")) {
				doMenuOption_SortByTitle();
			}
			if (choice.equals ("5")) {
				doMenuOption_SortByRating();
			}	
			if (choice.equals ("6")) {
				doMenuOption_ShowByDirector();
			}	
			if (choice.equals ("7")) {
				doMenuOption_Search();
			}	
		}
		
		}
		
		else if (user.equalsIgnoreCase("u"))
		{
			while (true) {
				displayMenu4User();
				choice = input.next();
				
				while(!choice.equals("1")&&!choice.equals("2")&&!choice.equals("3")&&!choice.equals("4")&&!choice.equals("5")&&!choice.equals("0"))
				{
					        System.out.println("Invalid input!");
					        System.out.print("Enter an integer: ");
					       choice = input.next();
					    }
				if (choice.equals ("0")) {
					break;
				}
				if (choice.equals("1")) {
					doMenuOption_ShowMovies();
				}
				if (choice.equals("2")) {
					doMenuOption_SortByTitle();
				}
				if (choice.equals("3")) {
					doMenuOption_SortByRating();
				}
				if (choice.equals("4")) {
					doMenuOption_ShowByDirector();
				}	
				if (choice.equals("5")) {
					doMenuOption_Search();
				}	
		}
		}
		
		
	}// end main
	
	
	
	
	/*
	 * Add movie method
	 */
	public static void doMenuOption_AddNewMovie() {

		Movie movie = getMovieFromUser();
		movieList.add(movie);	
	}
	/*
	 * End Add movie method
	 */
	
	
	
	/*
	 * Remove movie Method
	 */
	public static void doMenuOption_RemoveMovie() {
		String name;
		 System.out.println("Enter movie title: ");
		 Movie foundMovie = null;
		 
      	name=input.next();
      	//remove specified movie object by title
      	
          for(Movie m:movieList)
      	{
               if(name.equals(m.getMovie_name()))
           	{
            	   
            foundMovie =m ;
           	}
      	}
   	   
         	
			movieList.remove(foundMovie);
	}
	/*
	 * End of remove movie method
	 * 
	 */
	
	
	
	
	/*
	 * Method to sort by title
	 * 
	*/
	public static void doMenuOption_SortByTitle() {
		
	int question4sort;
	
		System.out.println("unsorted list:");
		System.out.println("-----------------------------------------");
		for (int i = 0; i < movieList.size(); i++) {
			System.out.println("|  Name: " + movieList.get(i).name + "|  Year:  " + movieList.get(i).year
					+ " |    Director: " + movieList.get(i).director);
		}
		System.out.println("-------------------------------------------");
		System.out.println("");
		System.out.println(" | Press (1) to sort from A-Z | Press (2) To sort from Z-A |");
		question4sort = input.nextInt();
		System.out.println("After sorting by title");
     	
     	
     	if (question4sort == 1)
     	{
     	Collections.sort(movieList);
     	System.out.println(movieList);
     	
     	}
     	else if (question4sort == 2)
     	{
     		Collections.sort(movieList,Collections.reverseOrder());
     		System.out.println(movieList);
     	}
	}
	public static void doMenuOption_Search() 
	{
		String name;
		 System.out.println("Enter movie title: ");
		 Movie foundMovie = null;
		 
     	name=input.next();
     	//remove specified movie object by title
     	
         for(Movie m:movieList)
     	{
              if(name.equals(m.getMovie_name()))
          	{
           	   
         System.out.println(m);
          	}
     	}
  	   
        	
	}
		
		
	public static void doMenuOption_SortByRating() {
	Collections.sort(movieList,Movie.compareToRating);
     System.out.println(movieList);
		
	}
	
	public static void doMenuOption_ShowMovies()
	{
		for (int i = 0; i < movieList.size(); i++) {
			System.out.println("|  Name: " + movieList.get(i).name + "|  Year:  " + movieList.get(i).year
					+ " |    Director: " + movieList.get(i).director+ " |    Actor: " + movieList.get(i).Actor+"|  Rating:  "+movieList.get(i).rating);
		}
		
	}
	public static void doMenuOption_ShowByDirector() {
		for (int i = 0; i < movieList.size(); i++) {
			System.out.println(" | Director: " + movieList.get(i).director + " | Name: " + movieList.get(i).name );
		}
	}

	public static Movie getMovieFromUser() {
	
		System.out.println("Enter Name of the Movie");
		String name = input.next();

		System.out.println("Enter year: ");

		int year = input.nextInt();

		System.out.println("Enter Director name: ");

		String director = input.next();
		
		System.out.println("Enter main Actor(s): ");
		String Actor =input.next();

		System.out.println("Enter movie rating (1 - 10): ");

		int rating = input.nextInt();

		return new Movie(Actor,name, year, rating, director);
	}
	public static void displayMenu4User() {
		System.out.println("Please select from one of the following menu options 0-5 ");
		System.out.println("(1)Show List of movies");
		System.out.println("(2) Sort movie by Title");
		System.out.println("(3) Sort movie by Rating");
		System.out.println("(4) Show movies by a director");
		System.out.println("(5) Search by movie name");
		System.out.println("(0) to exit program");
	}
	public static void displayMenu() {
		
		System.out.println("Please select from one of the following menu options 0-7 ");
		System.out.println("(1) Add a movie");
		System.out.println("(2) Show List of movies");
		System.out.println("(3) Remove a movie");
		System.out.println("(4) Sort movie by Title");
		System.out.println("(5) Sort movie by Rating");
		System.out.println("(6) Show movies by a director");
		System.out.println("(7) Search for a movie");
		System.out.println("(0) to exit program");
	}

}// end class
