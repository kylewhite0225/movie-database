import edu.princeton.cs.algs4.RedBlackBST;
import java.util.*;

/*
Author: Kyle White
Course: CS401 Algorithms
Date: 6/4/2021
 */

/*
The UI class handles the user interaction and output to the terminal.
It has one private member, db, which is a MovieDatabase object used in
searching operations with multiple search terms.
 */

public class UI {
    private MovieDatabase db;

    /*
    The constructor accepts a MovieDatabase object as a parameter, and
    sets the private member db to the provided parameter MovieDatabase.
    @param db   A MovieDatabase object containing the objects to search.
     */
    public UI(MovieDatabase db) {
        this.db = db;
    }

    /*
    The initiate method initiates the interaction with the user
    and performs all of the searching operations, looping, and
    user entered parameter checking.
     */
    public void initiate() {
        Scanner scanner = new Scanner(System.in);
        // exit boolean to track whether or not the user would like to
        // remain in the application after performing a search, using
        // a do-while loop.
        boolean exit = false;
        do {
            System.out.println("Please enter your search criteria: ");

            // Year criteria
            // yearFormat is used to check if the user enters a correct search term,
            // using a do-while loop.
            boolean yearFormat = false;
            String year;
            do {
                System.out.print("Year: ");
                // Collect user input
                year = scanner.next();
                // Year must be a 4 digit number (in String form for now), or a - to skip this term.
                yearFormat = year.matches("^[0-9]{4}$") || year.matches("^[-]{1}$");
                if (!yearFormat) {
                    System.out.println("Year must be a 4 digit number or '-' to skip.");
                }
            } while (!yearFormat);

            // Score criteria
            // scoreFormat is used to check if the user enters a correct search term.
            boolean scoreFormat = false;
            String score;
            do {
                System.out.print("Score: ");
                // Collect user input
                score = scanner.next();
                // Score must be a 2 digit double with one decimal place, or a - to skip this term.
                scoreFormat = score.matches("^[0-9]{1}\\.[0-9]{1}$") || score.matches("^[-]{1}$");
                if (!scoreFormat) {
                    System.out.println("Score must be a two digit double such as 5.0, or '-' to skip.");
                }
            } while(!scoreFormat);

            // Language criteria
            // languageFormat is used to check if the user enters a correct search term.
            boolean languageFormat = false;
            String language;
            do {
                System.out.print("Language: ");
                // Collect user input
                language = scanner.next();
                // Language must be alphabetical characters only, or a - to skip this term.
                languageFormat = language.matches("^[A-Za-z]*$") || language.matches("^[-]{1}$");
                if (!languageFormat) {
                    System.out.println("Language must be alphabetical characters only, or '-' to skip.");
                }
            } while (!languageFormat);

            // Rating criteria
            // ratingFormat is used to check if the user enters a correct search term.
            boolean ratingFormat = false;
            String rating;
            do {
                System.out.print("Rating: ");
                // Collect user input
                rating = scanner.next();
                // Rating must be alphanumeric characters and dashes only, or a single - to skip this term.
                ratingFormat = rating.matches("^[A-Za-z0-9-]*$") || rating.matches("^[-]{1}$");
                if (!ratingFormat) {
                    System.out.println("Rating must be alphanumeric characters and dashes only, or '-' to skip.");
                }
            } while (!ratingFormat);

            // Create an ArrayList<HashSet<Movie>> object to store the search results from each query.
            ArrayList<HashSet<Movie>> searchResults = new ArrayList<>();

            // Search year
            // If the search term is '-' then skip.
            if(!year.equals("-")) {
                int intYear = Integer.parseInt(year);
                // Get the RedBlackBST object from the movie database containing HashSets sorted by year.
                RedBlackBST<Integer, HashSet<Movie>> years = db.getDB("Year");
                // Create a new HashSet to store the HashSet<Movie> that matches the input year.
                HashSet<Movie> yearResult = new HashSet<>(years.get(intYear));
                // Add this HashSet to the search results.
                searchResults.add(yearResult);
            }

            // Search score
            // If the search term is '-' then skip.
            if(!score.equals("-")) {
                double doubleScore = Double.parseDouble(score);
                // Get the RedBlackBST object from the movie database containing HashSets sorted by score.
                RedBlackBST<Double, HashSet<Movie>> scores = db.getDB("Score");
                // Create a new HashSet that stores the HashSet<Movie> that matches the input score.
                HashSet<Movie> scoreResult = new HashSet<>(scores.get(doubleScore));
                // Add this HashSet to the search results.
                searchResults.add(scoreResult);
            }

            // Search language
            // If the search term is '-' then skip.
            if(!language.equals("-")) {
                // Get the RedBlackBST object from the movie database containing HashSets sorted by language.
                RedBlackBST<String, HashSet<Movie>> languages = db.getDB("Language");
                // Create a new HashSet that stores the HashSet<Movie> that matches the input language.
                HashSet<Movie> languageResult = new HashSet<>(languages.get(language));
                // Add this HashSet to the search results.
                searchResults.add(languageResult);
            }

            // Search rating
            // If the search term is '-' then skip.
            if(!rating.equals("-")) {
                // Get the RedBlackBST object from the movie database containing HashSets sorted by rating.
                RedBlackBST<String, HashSet<Movie>> ratings = db.getDB("Rating");
                // Create a new HashSet that stores the HashSet<Movie> that matches the input rating.
                HashSet<Movie> ratingResult = new HashSet<>(ratings.get(rating));
                // Add this HashSet to the search results.
                searchResults.add(ratingResult);
            }

            // If there are any results in the searchResults ArrayList.
            if(searchResults.size() > 0) {
                // Iterate through the search results and perform HashSet retainAll method
                // on the first element with each successive element. This filters all of
                // the results down to a single list that matches all 4 search terms.
                for (int i = 1; i < searchResults.size(); i++) {
                    searchResults.get(0).retainAll(searchResults.get(i));
                }
                // Convert the search results to a List of movies just for sorting purposes.
                List<Movie> list = new ArrayList<Movie>(searchResults.get(0));
                // Sort by ID (the Movie class implements comparable)
                Collections.sort(list);
                // Print the list in array format.
                System.out.println();
                System.out.println("Your search returned " + list.size() + " results.");
                System.out.println();
                System.out.println(list);
                // For each movie in the list, print out the details with the Movie.printOut() method.
                for (Movie m: list) {
                    System.out.println(m.printOut());
                }
            } else {
                // Print out a message if no results are found.
                System.out.println("The search returned 0 results. Are your search terms correct?");
            }

            // loop is used to check if the user would like to search again or quit, using a do-while loop.
            boolean loop = true;
            String ans;
            do {
                System.out.println("Would you like to search again? Enter Y for yes, or Q to quit.\n");
                ans = scanner.next();
                // If the user enters Y or y
                if (ans.equals("Y") || ans.equals("y")) {
                    // Exit loop and continue searching
                    loop = false;
                // If the user enters Q or q
                } else if (ans.equals("Q") || ans.equals("q")) {
                    // Exit loop and quit the application
                    loop = false;
                    exit = true;
                } else {
                    System.out.println("Please enter a correct option.");
                }
            } while (loop);
        } while (!exit);
    }
}
