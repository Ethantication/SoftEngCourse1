import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner; // Note: Do not change this line.
    public static void manageMovies() {
        MovieManager movieManager = new MovieManager();
        int movieCount = 0;

        while (true) {
            System.out.println("Welcome to the Movies Management System!");
            System.out.println("1. Add a new movie\n2. Display all movies\n" +
                    "3. Display movie rating\n4. Find the best director\n5. Exit\n");
            System.out.println("Please enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (movieCount >= 100) {
                        System.out.println("Movie limit reached. Exiting...");
                        return;
                    }

                    System.out.println("Enter movie title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter director:");
                    String director = scanner.nextLine();
                    System.out.println("Enter rating:");
                    double rating = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    if (rating < 0 || rating > 10) {
                        System.out.println("Invalid Rating");
                    } else {
                        movieManager.addMovie(new Movie(title, director, rating));
                        movieCount++;
                    }
                    break;

                case 2:
                    movieManager.displayAllMovies();
                    break;

                case 3:
                    System.out.println("Enter the title of the movie:");
                    String searchTitle = scanner.nextLine();
                    movieManager.displayMovieRating(searchTitle);
                    break;

                case 4:
                    movieManager.findBestDirector();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void main(String[] args) throws IOException {
        String path = args[0];

        scanner = new Scanner(new File(path));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfTests; i++) {
            System.out.println("Test number " + i + " starts.");
            try {
                manageMovies();
            } catch(Exception e){
                System.out.println("Exception " + e);
            }
            System.out.println("Test number " + i + " ended.");
            System.out.println("-----------------------------------------------");
        }
        System.out.println("All tests have ended.");
    }
}