import java.net.URL;

/*
Author: Kyle White
Course: CS401 Algorithms
Date: 6/4/2021
 */

/*
The MovieInfo class contains the non-searchable parameters of the Movie objects that
are parsed from the csv file passed into the application.
 */

public class MovieInfo {
    private int id;
    private String color;
    private String movieTitle;
    private int duration;
    private String directorName;
    private String[] actors;
    private URL imdbLink;
    private String country;

    /*
    The constructor accepts several parameters and initializes all of the members of the class.
    @param id   The ID of the movie.
    @param color    The color of the movie.
    @param movieTitle   The title of the movie.
    @param duration     The duration of the movie in minutes.
    @param directorName The name of the director
    @param actors   An array of the 3 headlining actor names.
    @param imdbLink A URL object containing the IMDB page link.
    @param country  The country of production.
     */
    public MovieInfo(int id, String color, String movieTitle, int duration, String directorName,
                     String[] actors, URL imdbLink, String country) {
        this.id = id;
        this.color = color;
        this.movieTitle = movieTitle;
        this.duration = duration;
        this.directorName = directorName;
        this.actors = actors;
        this.imdbLink = imdbLink;
        this.country = country;
    }

    /*
    vvvvv Standard getter and setter methods. vvvvv
     */
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public URL getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(URL imdbLink) {
        this.imdbLink = imdbLink;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /*
    ^^^^^ Standard getter and setter methods. ^^^^^
     */
}
