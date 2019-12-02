package com.suprun.cinemacatalog.service;

import com.suprun.cinemacatalog.model.Cinema;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CinemaService {

    Cinema save(Cinema cinema);

    Optional<Cinema> findOne(String id);

    Iterable<Cinema> findAll();

    Page<Cinema> findByTitle(String name, Pageable pageable);

    Page<Cinema> findByTitleUsingCustomQuery(String title, Pageable pageable);

    Page<Cinema> findByFilteredReleaseYearQuery(Date releaseYear, Pageable pageable);

    Page<Cinema> findByTitleAndFilteredReleaseYearQuery(String title, Date releaseYear, Pageable pageable);

    long count();

    void delete(Cinema cinema);
}
