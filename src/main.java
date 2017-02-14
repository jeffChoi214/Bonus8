import java.util.ArrayList;
import java.util.Scanner;
/*
 * Created by Jeff Choi on 2/14/17.
 */
public class main {
    public static Movie[] makeMovies(int arraySize) {
         Movie[] movies = new Movie[arraySize];
         movies[0] = new Movie("animated1", "animated");
         movies[1] = new Movie("drama", "drama");
         movies[2] = new Movie("horror", "horror");
         movies[3] = new Movie("scifi", "scifi");
         movies[4] = new Movie("animated2", "animated");
         movies[5] = new Movie("drama2", "drama");
         movies[6] = new Movie("horror2", "horror");
         movies[7] = new Movie("animated00", "animated");
         movies[8] = new Movie("drama3", "drama");
         movies[9] = new Movie("horror3", "horror");
         return movies;
    }

    public static Movie[] makeLargeMovies() {
        Movie[] movies = new Movie[100];
        for (int i = 0; i < 100; ++i) {
            movies[i] = MovieIO.getMovie(i);
        }
        return movies;
    }

    public static ArrayList<Movie> movieList() {
        ArrayList<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            movieList.add(MovieIO.getMovie(i));
        }

        return movieList;
    }


    public static int getCategory(Scanner sc, Validator validate) {
        int holder = validate.getInt(sc);

        while (!(holder >= 1 && holder <= 6)) {
            System.out.println("Please choose a category between 1 through 6!");
            holder = validate.getInt(sc);
        }
        return holder;
    }

    public static void printCategories() {
        System.out.println("1. Animated");
        System.out.println("2. Drama");
        System.out.println("3. Horror");
        System.out.println("4. Scifi");
        System.out.println("5. Comedy");
        System.out.println("6. Musical");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validator validate = new Validator();
        int arraySize = 10;
        Movie[] movies = makeMovies(arraySize);
        Movie[] largeMovies = makeLargeMovies();
        ArrayList<Movie> movieList = movieList();
        System.out.println("Welcome to the Movie List Application\n");
        System.out.println("There are 100 movies in this list and 6 different types.");

        while (true) {
            printCategories();
            System.out.println("What category are you interested in? ");
            int category = getCategory(sc, validate);

            if (category == 1) {
                // animated
                movieList.stream().filter(x -> x.getCategory().toLowerCase().equals("animated")).forEach(x -> System.out.println(x.getTitle()));
            } else if (category == 2) {
                movieList.stream().filter(x -> x.getCategory().toLowerCase().equals("drama")).forEach(x -> System.out.println(x.getTitle()));
            } else if (category == 3) {
                movieList.stream().filter(x -> x.getCategory().toLowerCase().equals("horror")).forEach(x -> System.out.println(x.getTitle()));
            } else if (category == 4) {
                movieList.stream().filter(x -> x.getCategory().toLowerCase().equals("scifi")).forEach(x -> System.out.println(x.getTitle()));
            } else if (category == 5) {
                movieList.stream().filter(x -> x.getCategory().toLowerCase().equals("comedy")).forEach(x -> System.out.println(x.getTitle()));
            } else {
                movieList.stream().filter(x -> x.getCategory().toLowerCase().equals("musical")).forEach(x -> System.out.println(x.getTitle()));
            }

            System.out.println("Continue?(y/n) ");
            char toContinue = sc.next().toLowerCase().charAt(0);

            while (toContinue != 'y' && toContinue != 'n') {
                System.out.println("Please enter a y or n");
                toContinue = sc.next().toLowerCase().charAt(0);
            }

            if (toContinue == 'n') {
                System.out.println("Thank you for coming!");
                break;
            }
        }
    }
}
