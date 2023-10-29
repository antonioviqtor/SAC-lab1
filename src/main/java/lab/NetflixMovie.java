package lab;

import com.opencsv.bean.CsvBindByPosition;

public class NetflixMovie {
    @CsvBindByPosition(position = 0)
    private String showId;
    @CsvBindByPosition(position = 1)
    private String movieType;
    @CsvBindByPosition(position = 2)
    private String movieTitle;
    @CsvBindByPosition(position = 3)
    private String director;
    @CsvBindByPosition(position = 4)
    private String country;
    @CsvBindByPosition(position = 5)
    private String releaseYear;
    @CsvBindByPosition(position = 6)
    private String rating;
    @CsvBindByPosition(position = 7)
    private String listedIn;
    @CsvBindByPosition(position = 8)
    private String description;

    public NetflixMovie() {
    }

    public String getShowId() {
        return this.showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getMovieType() {
        return movieType;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public String getListedIn() {
        return listedIn;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "NetflixMovie{" +
                "showId='" + showId + '\'' +
                ", type='" + movieType + '\'' +
                ", title='" + movieTitle + '\'' +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", rating='" + rating + '\'' +
                ", listed_in='" + listedIn + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setListedIn(String listedIn) {
        this.listedIn = listedIn;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
