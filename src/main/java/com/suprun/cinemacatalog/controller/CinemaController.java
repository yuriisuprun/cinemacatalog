package com.suprun.cinemacatalog.controller;

import com.suprun.cinemacatalog.model.Cinema;
import com.suprun.cinemacatalog.service.CinemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CinemaController {

    @Autowired
    private CinemaServiceImpl cinemaServiceImpl;

    @GetMapping("/all")
    public Iterable<Cinema> getAllCinema() {
        return cinemaServiceImpl.getAllCinema();
    }

    @GetMapping("/add/{id}/{title}")
    public Cinema addCinema(@PathVariable("id") String id, @PathVariable("title") String title) {
        return cinemaServiceImpl.add(id, title);
    }

    @GetMapping("/cinema/{title}")
    public List<Cinema> findByCinemaTitleUsingCustomQuery(@PathVariable("title") String title) {
        return cinemaServiceImpl.findByCinemaTitleUsingCustomQuery(title);
    }

    @GetMapping("/allCinema/{title}")
    public List<Cinema> findAllCinemaByTitle(@PathVariable("title") String title) {
        return cinemaServiceImpl.findAllCinemaByCinemaTitle(title);
    }

    @GetMapping("/allCinema")
    public List<Cinema> findAllCinema() {
        return cinemaServiceImpl.findAllCinema();
    }

    @GetMapping("/allCinemaBySpecificQuery/{specificQuery}")
    public List<Cinema> findCinemaBySpecificQuery(@PathVariable("specificQuery") String specificQuery) {
        return cinemaServiceImpl.findCinemaBySpecificQuery(specificQuery);
    }
}