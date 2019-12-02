package com.suprun.cinemacatalog.controller;

import com.suprun.cinemacatalog.model.Cinema;
import com.suprun.cinemacatalog.repository.CinemaDAOImpl;
import com.suprun.cinemacatalog.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CinemaDAOImpl cinemaDAO;

    @RequestMapping("/all")
    public List<Cinema> getAllCinema() {
        return cinemaDAO.getAllCinema();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Cinema addCinema(@RequestBody Cinema cinema) {
        cinemaRepository.save(cinema);
        return cinema;
    }
}
