package com.suprun.cinemacatalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "cinema_catalog", type = "cinema")
public class Cinema {

    @Id
    private String id;

    private String cinemaTitle;

//    private Date releaseYear;

//    private Rating rating;

    public Cinema() {
    }

    public Cinema(String title) {
        this.cinemaTitle = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCinemaTitle() {
        return cinemaTitle;
    }

    public void setCinemaTitle(String cinemaTitle) {
        this.cinemaTitle = cinemaTitle;
    }

    /*public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }
*/
    @Override
    public String toString() {
        return "Cinema{" +
                "id='" + id + '\'' +
                ", name='" + cinemaTitle + '\'' +
//                ", releaseYear=" + releaseYear +
                '}';
    }

}
