import java.io.IOException;
import java.util.*;
import edu.princeton.cs.algs4.RedBlackBST;

/*
Author: Kyle White
Course: CS401 Algorithms
Date: 6/4/2021
 */

/*
The App class is the main movie search application. The main method accepts the file name
from the user and passes it to the Reader class, then builds 4 RedBlackBST<T, HashSet<Movie>> objects,
inserts them into a MovieDatabase object, and then passes the MovieDatabase object to the UI class.
 */

public class App {
    public static void main(String[] args) {
        // Create scanner object to accept user input from the console.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName;
        fileName = scanner.nextLine();
        fileName = "src/" + fileName;
        // Instantiate a null ArrayList<Movie> to store Movie objects from the Reader class.
        ArrayList<Movie> movies = null;
        try {
            // The reader class parses the CSV file and stores the Movies in an ArrayList<Movie>.
            Reader reader = new Reader(fileName);
            movies = reader.getCsvArray();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (movies == null) {
            throw new RuntimeException("Your movie list is empty.");
        }

        // Create RedBlackBST objects for each search method, year, score, language, and IMDB rating.
        RedBlackBST<Integer, HashSet<Movie>> rbtYear = buildRBTYear(movies);
        RedBlackBST<Double, HashSet<Movie>> rbtScore = buildRBTScore(movies);
        RedBlackBST<String, HashSet<Movie>> rbtLang = buildRBTLang(movies);
        RedBlackBST<String, HashSet<Movie>> rbtRating = buildRBTRating(movies);

        // MovieDatabase class has a private member map which is a
        // HashMap<String, RedBlackTree<T, HashSet<Movie>>> object for storing
        // the RedBlackBST objects under each key.
        MovieDatabase db = new MovieDatabase<>();
        db.addRBT("Year", rbtYear);
        db.addRBT("Score", rbtScore);
        db.addRBT("Language", rbtLang);
        db.addRBT("Rating", rbtRating);

        // The UI class handles the rest of the user interaction going forward.
        UI ui = new UI(db);
        ui.initiate();
    }

    /*
    The buildRBTYear method accepts an ArrayList<Movie> object as a parameter
    and iterates through the ArrayList, adding each Movie by year to a HashSet<Movie> stored in
    RedBlackBST which is sorted by year.
    @param movies   An ArrayList<Movie> of Movie objects
    @return rbtYear A RedBlackBST<Integer, HashSet<Movie>> object
     */
    private static RedBlackBST<Integer, HashSet<Movie>> buildRBTYear(ArrayList<Movie> movies) {
        RedBlackBST<Integer, HashSet<Movie>> rbtYear = new RedBlackBST<>();
        // Iterate through the ArrayList<Movie> of Movie objects
        for (int i = 0; i < movies.size(); i++) {
            // If rbtYear contains a specific year key
            if(rbtYear.contains(movies.get(i).getYear())) {
                // Create new HashSet<Movie>
                HashSet<Movie> set;
                // Set this new HashSet to the HashSet stored at the year key
                set = rbtYear.get(movies.get(i).getYear());
                // Add the new movie object
                set.add(movies.get(i));
                // Add this key value pair to rbtYear
                rbtYear.put(movies.get(i).getYear(), set);
            } else {
                // If rbtYear does not contain the key, create a new HashSet
                // and add the Movie object.
                HashSet<Movie> set = new HashSet<>();
                set.add(movies.get(i));
                // Add this key value pair to rbtYear
                rbtYear.put(movies.get(i).getYear(), set);
            }
        }
        return rbtYear;
    }

    /*
    The buildRBTScore method works identically to buildRBTYear.
    @param movies   An ArrayList<Movie> of Movie objects
    @return rbtScore A RedBlackBST<Double, HashSet<Movie>> object
     */
    private static RedBlackBST<Double, HashSet<Movie>> buildRBTScore(ArrayList<Movie> movies) {
        RedBlackBST<Double, HashSet<Movie>> rbtScore = new RedBlackBST<>();
        for (int i = 0; i < movies.size(); i++) {
            if(rbtScore.contains(movies.get(i).getImdbScore())) {
                HashSet<Movie> set;
                set = rbtScore.get(movies.get(i).getImdbScore());
                set.add(movies.get(i));
                rbtScore.put(movies.get(i).getImdbScore(), set);
            } else {
                HashSet<Movie> set = new HashSet<>();
                set.add(movies.get(i));
                rbtScore.put(movies.get(i).getImdbScore(), set);
            }
        }
        return rbtScore;
    }

    /*
    The buildRBTLang method works identically to buildRBTYear.
    @param movies   An ArrayList<Movie> of Movie objects
    @return rbtLang A RedBlackBST<String, HashSet<Movie>> object
     */
    private static RedBlackBST<String, HashSet<Movie>> buildRBTLang(ArrayList<Movie> movies) {
        RedBlackBST<String, HashSet<Movie>> rbtLang = new RedBlackBST<>();
        for (int i = 0; i < movies.size(); i++) {
            if(rbtLang.contains(movies.get(i).getLanguage())) {
                HashSet<Movie> set;
                set = rbtLang.get(movies.get(i).getLanguage());
                set.add(movies.get(i));
                rbtLang.put(movies.get(i).getLanguage(), set);
            } else {
                HashSet<Movie> set = new HashSet<>();
                set.add(movies.get(i));
                rbtLang.put(movies.get(i).getLanguage(), set);
            }
        }
        return rbtLang;
    }

    /*
    The buildRBTRating method works identically to buildRBTYear.
    @param movies   An ArrayList<Movie> of Movie objects
    @return rbtRating A RedBlackBST<String, HashSet<Movie>> object
     */
    private static RedBlackBST<String, HashSet<Movie>> buildRBTRating(ArrayList<Movie> movies) {
        RedBlackBST<String, HashSet<Movie>> rbtRating = new RedBlackBST<>();
        for (int i = 0; i < movies.size(); i++) {
            if(rbtRating.contains(movies.get(i).getRating())) {
                HashSet<Movie> set;
                set = rbtRating.get(movies.get(i).getRating());
                set.add(movies.get(i));
                rbtRating.put(movies.get(i).getRating(), set);
            } else {
                HashSet<Movie> set = new HashSet<>();
                set.add(movies.get(i));
                rbtRating.put(movies.get(i).getRating(), set);
            }
        }
        return rbtRating;
    }
}
