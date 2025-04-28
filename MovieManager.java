import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {
    ArrayList<Movie> movies = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addMovie() {
        System.out.println("Enter movie name:");
        String title = scanner.nextLine();

        if (movies.size() >= 100) {
            System.out.println("Movies limit reached.");
            return;
        }

        System.out.println("Enter rating:");
        double rating = Double.parseDouble(scanner.nextLine());

        if (rating < 0 || rating > 10) {
            System.out.println("Invalid rating.");
            return;
        }

        System.out.println("Enter director name:");
        String director = scanner.nextLine();

        Movie movie = new Movie(title, director, rating);
        movies.add(movie);

        System.out.println("Movie added successfully!");

    }
    public void displayAllMovies(){
        if(movies.isEmpty()){
            System.out.println("No movies are available");
            return;
        } else{
            for(Movie movie : movies){
                System.out.println("Name: " + movie.title + ",rating: " + movie.rating + ",director: " + movie.director);
            }
        }

    }



    public void displayMovieRating(String title) {
        System.out.println("Enter movie name:");
        String movie_title = scanner.nextLine();
        for (Movie movie : movies) {
            if (movie.title.equalsIgnoreCase(movie_title)) {
                System.out.println("Rating for" + movie.title + " : " + movie.rating);
                return;

            }
        }
        System.out.println("Movie not found with name " + movie_title);
    }


    public void findBestDirector() {


    }
}
