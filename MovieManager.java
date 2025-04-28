import java.util.ArrayList;
import java.util.HashMap;

public class MovieManager {
    private ArrayList<Movie> movies;

    public MovieManager() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            for (Movie movie : movies) {
                System.out.println("Title: " + movie.title + ", Director: " + movie.director + ", Rating: " + movie.rating);
            }
        }
    }

    public void displayMovieRating(String title) {
        for (Movie movie : movies) {
            if (movie.title.equalsIgnoreCase(title)) {
                System.out.println("Rating of \"" + movie.title + "\": " + movie.rating);
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    public void findBestDirector() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        HashMap<String, double[]> directorStats = new HashMap<>();

        for (Movie movie : movies) {
            String director = movie.director;
            double rating = movie.rating;

            if (!directorStats.containsKey(director)) {
                directorStats.put(director, new double[]{rating, 1});
            } else {
                double[] stats = directorStats.get(director);
                stats[0] += rating;
                stats[1] += 1;
            }
        }

        String bestDirector = "";
        double bestAverage = -1;

        for (String director : directorStats.keySet()) {
            double[] stats = directorStats.get(director);
            double average = stats[0] / stats[1];

            if (average > bestAverage) {
                bestAverage = average;
                bestDirector = director;
            }
        }

        System.out.println("Best Director: " + bestDirector + " with average rating " + bestAverage);
    }
}
