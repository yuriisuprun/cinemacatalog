package com.suprun.cinemacatalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "cinema_catalog", type = "cinema")
public class Cinema {

    @Id
    private String id;

    private String cinemaTitle;

    public Cinema() {
    }

    public Cinema(String cinemaTitle) {
        this.cinemaTitle = cinemaTitle;
    }

    public Cinema(String id, String cinemaTitle) {
        this.id = id;
        this.cinemaTitle = cinemaTitle;
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

    @Override
    public String toString() {
        return "Cinema{" +
                "id='" + id + '\'' +
                ", cinemaTitle='" + cinemaTitle + '\'' +
                '}';
    }
}
