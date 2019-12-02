package com.suprun.cinemacatalog.service;

import com.suprun.cinemacatalog.model.Cinema;
import com.suprun.cinemacatalog.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Optional;

@Service
public class CinemaServiceImpl  implements CinemaService{

    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public Cinema save(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public Optional<Cinema> findOne(String id) {
        return cinemaRepository.findById(id);
    }

    @Override
    public Iterable<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public Page<Cinema> findByTitle(String title, Pageable pageable) {
        return cinemaRepository.findByCinemaTitle(title, pageable);
    }

    @Override
    public Page<Cinema> findByTitleUsingCustomQuery(String title, Pageable pageable) {
        return cinemaRepository.findByCinemaTitleUsingCustomQuery(title, pageable);
    }

    @Override
    public Page<Cinema> findByFilteredReleaseYearQuery(Date releaseYear, Pageable pageable) {
        return cinemaRepository.findByFilteredReleaseYearQuery(releaseYear, pageable);
    }

    @Override
    public Page<Cinema> findByTitleAndFilteredReleaseYearQuery(String title, Date releaseYear, Pageable pageable) {
        return cinemaRepository.findByCinemaTitleAndFilteredReleaseYearQuery(title, releaseYear, pageable);
    }

    @Override
    public long count() {
        return cinemaRepository.count();
    }

    @Override
    public void delete(Cinema cinema) {
        cinemaRepository.delete(cinema);
    }
}
