package com.suprun.cinemacatalog.repository;

import com.suprun.cinemacatalog.model.Cinema;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends ElasticsearchRepository<Cinema, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"cinemaTitle\": \"?0\"}}]}}")
    List<Cinema> findByCinemaTitleUsingCustomQuery(String title);

}
