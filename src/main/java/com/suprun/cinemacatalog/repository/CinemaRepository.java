package com.suprun.cinemacatalog.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.domain.Pageable;

import com.suprun.cinemacatalog.model.Cinema;

import java.util.Date;

@Repository
public interface CinemaRepository extends ElasticsearchRepository<Cinema, String> {

    Page<Cinema> findByCinemaTitle(String title, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    Page<Cinema> findByCinemaTitleUsingCustomQuery(String name, Pageable pageable);

    @Query("{\"bool\": {\"must\": {\"match_all\": {}}, \"filter\": {\"term\": {\"tags\": \"?0\" }}}}")
    Page<Cinema> findByFilteredReleaseYearQuery(Date releaseYear, Pageable pageable);

    @Query("{\"bool\": {\"must\": {\"match\": {\"authors.name\": \"?0\"}}, \"filter\": {\"term\": {\"tags\": \"?1\" }}}}")
    Page<Cinema> findByCinemaTitleAndFilteredReleaseYearQuery(String title, Date releaseYear, Pageable pageable);
}
