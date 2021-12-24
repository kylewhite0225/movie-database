import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/*
Author: Kyle White
Course: CS401 Algorithms
Date: 6/4/2021
 */

/*
The Reader class parses the input csv file and stores each line in its own Movie object, into an
ArrayList of Movie objects.
 */

public class Reader {
    private ArrayList<Movie> csvArray;

    /*
    The constructor accepts a string filePath as a parameter, which is a path to the
    file that the user wishes to explore.
    @param filePath The path to the csv file that the user would like to search.
     */
    public Reader(String filePath) throws IOException {
        // A BufferedReader object is used to parse the csv file.
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        // This string is used to hold the information stored in each line of the csv.
        String line = "";
        csvArray = new ArrayList<>();
        // A while loop is used to iterate through the csv, checking if the line is null.
        while((line = reader.readLine()) != null) {
            // Split the line into an array using a regex checking for comma delimiters,
            // but making sure to ignore any commas that are within quotation symbols.
            String[] movie = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            // Skip first line in CSV (column labels)
            if (movie[0].equals("id")) {
                continue;
            }
            // Create an array for the three actors
            String[] actors = new String[3];
            // Add each actor into the array
            actors[0] = movie[5];
            actors[1] = movie[6];
            actors[2] = movie[7];
            // Create a URL object to store the IMDB link
            URL imdbLink = new URL(movie[8]);
            int id = Integer.parseInt(movie[0]);
            int duration;
            // There are some empty duration values in the csv, if they are not empty parse to integer.
            if(!movie[3].equals("")) {
                duration = Integer.parseInt(movie[3]);
            // Else set it to 0.
            } else {
                duration = 0;
            }
            int year;
            // There are some empty year values in the csv, if they are not empty parse to integer.
            if(!movie[12].equals("")) {
                year = Integer.parseInt(movie[12]);
            } else {
                year = 0;
            }
            double score = Double.parseDouble(movie[13]);
            // Initiate a MovieInfo object and pass the parameters of all of the non-searchable
            // terms within a Movie object.
            MovieInfo movieInfo = new MovieInfo(id, movie[1], movie[2], duration,
                    movie[4], actors, imdbLink, movie[10]);
            // Create a Movie object and pass all of the collected parameters.
            Movie movieObj = new Movie(year, score, movie[9], movie[11], movieInfo);
            // Add this movie to the ArrayList
            csvArray.add(movieObj);
        }
    }

    /*
    The getCsvArray accessor method returns the ArrayList of movies stored in csvArray.
    @return csvArray
     */
    public ArrayList<Movie> getCsvArray() {
        return csvArray;
    }
}
