package com.suprun.cinemacatalog.service;

import com.suprun.cinemacatalog.model.Cinema;
import com.suprun.cinemacatalog.repository.CinemaDAO;
import com.suprun.cinemacatalog.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDAO cinemaDAO;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public Iterable<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema add(String id, String title) {
        Cinema cinema = new Cinema(id, title);
        cinemaRepository.save(cinema);
        return cinema;
    }

    @Override
    public List<Cinema> findByCinemaTitleUsingCustomQuery(String title) {
        List<Cinema> cinemas = cinemaRepository.findByCinemaTitleUsingCustomQuery(title);
        System.out.println(cinemas);
        return cinemas;
    }

    @Override
    public List<Cinema> findAllCinemaByCinemaTitle(String title) {
        return cinemaDAO.findAllCinemaByCinemaTitle(title);
    }

    @Override
    public List<Cinema> findAllCinema() {
        return cinemaDAO.findAllCinema();
    }

    public List<Cinema> findCinemaBySpecificQuery(String specificQuery) {
        return cinemaDAO.findCinemaBySpecificQuery(specificQuery);
    }

}
