import java.net.URL;
import java.util.Objects;

/*
Author: Kyle White
Course: CS401 Algorithms
Date: 6/4/2021
 */

/*
The Movie class is a data storage class that contains several members for storing information
parsed from the csv file that is passed to the application. This method implements Comparable
for sorting purposes.
 */

public class Movie implements Comparable<Movie> {
    private int year;
    private double imdbScore;
    private String language;
    private String rating;
    private MovieInfo info;

    /*
    The constructor accepts several parameters for the construction of a Movie object.
    @param year The year the movie was released.
    @param imdbScore    The IMDB score.
    @param language The language of the movie.
    @param rating   The content rating of the movie.
    @param info A MovieInfo object containing the non-searchable parameters of the movie.
     */
    public Movie(int year, double imdbScore, String language, String rating, MovieInfo info) {
        this.year = year;
        this.imdbScore = imdbScore;
        this.language = language;
        this.rating = rating;
        this.info = info;
    }

    /*
    Override equals method to prevent copying errors.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /*
    Override hashCode method for proper hashing.
     */
    @Override
    public int hashCode() {
        return Objects.hash(year, imdbScore, language, rating);
    }

    /*
    Override toString method, returning the movie IDs only.
     */
    @Override
    public String toString() {
        return Integer.toString(info.getID());
    }

    /*
    Override the compareTo method for comparison and sorting purposes.
    @param o The Movie object to compare against.
     */
    @Override
    public int compareTo(Movie o) {
        if (this.info.getID() == o.info.getID()) {
            return 0;
        } else if (this.info.getID() < o.info.getID()) {
            return -1;
        } else {
            return 1;
        }
    }

    /*
    The printOut method creates a string representation of all of the information
    stored within a Movie object.
     */
    public String printOut() {
        String out = "-----------------------------" + "\n" +
                "ID: " + this.getId() + "\n" +
                "Color: " + this.getColor() + "\n" +
                "Title: " + this.getMovieTitle() + "\n" +
                "Duration: " + this.getDuration() + " Minutes" + "\n" +
                "Director Name: " + this.getDirectorName() + "\n" +
                "Actor 1: " + this.getActor1() + "\n" +
                "Actor 2: " + this.getActor2() + "\n" +
                "Actor 3: " + this.getActor3() + "\n" +
                "IMDB Link: " + this.getImdbLink() + "\n" +
                "Language: " + this.getLanguage() + "\n" +
                "Country: " + this.getCountry() + "\n" +
                "Content Rating: " + this.getRating() + "\n" +
                "Year: " + this.getYear() + "\n" +
                "IMDB Score: " + this.getImdbScore() + "\n" +
                "-----------------------------\n";
        return out;
    }

    /*
    vvvvv Standard getter and setter methods. vvvvv
     */

    public int getId() {
        return info.getID();
    }

    public String getColor() {
        return info.getColor();
    }

    public String getMovieTitle() {
        return info.getMovieTitle();
    }

    public int getDuration() {
        return info.getDuration();
    }

    public String getDirectorName() {
        return info.getDirectorName();
    }

    public String getActor1() {
        return info.getActors()[0];
    }

    public String getActor2() {
        return info.getActors()[1];
    }

    public String getActor3() {
        return info.getActors()[2];
    }

    public URL getImdbLink() {
        return info.getImdbLink();
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return info.getCountry();
    }

    public String getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setId(int id) {
        this.info.setID(id);
    }

    public void setColor(String color) {
        this.info.setColor(color);
    }

    public void setMovieTitle(String movieTitle) {
        this.info.setMovieTitle(movieTitle);
    }

    public void setDuration(int duration) {
        this.info.setDuration(duration);
    }

    public void setDirectorName(String directorName) {
        this.info.setDirectorName(directorName);
    }

    public void setActor_1(String actor_1) {
        this.info.getActors()[0] = actor_1;
    }

    public void setActor_2(String actor_2) {
        this.info.getActors()[1] = actor_2;
    }

    public void setActor_3(String actor_3) {
        this.info.getActors()[2] = actor_3;
    }

    public void setImdbLink(URL imdbLink) {
        this.info.setImdbLink(imdbLink);
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCountry(String country) {
        this.info.setCountry(country);
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    /*
    ^^^^^ Standard getter and setter methods. ^^^^^
     */
}
