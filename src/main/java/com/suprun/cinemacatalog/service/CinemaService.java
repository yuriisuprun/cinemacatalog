package com.suprun.cinemacatalog.service;

import com.suprun.cinemacatalog.model.Cinema;

import java.util.List;

public interface CinemaService {

    Iterable<Cinema> getAllCinema();

    Cinema add(String id, String name);

    List<Cinema> findByCinemaTitleUsingCustomQuery(String title);

    List<Cinema> findAllCinemaByCinemaTitle(String title);

    List<Cinema> findAllCinema();

}
