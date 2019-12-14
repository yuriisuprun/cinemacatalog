package com.suprun.cinemacatalog.repository;

import com.suprun.cinemacatalog.model.Cinema;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaDAO {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public List<Cinema> findAllCinemaByCinemaTitle(String title) {

        QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(title)
                                .lenient(true)
                                .field("cinemaTitle")
                ).should(QueryBuilders.queryStringQuery("*" + title + "*")
                        .lenient(true)
                        .field("cinemaTitle"));

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<Cinema> cinemas = elasticsearchTemplate.queryForList(build, Cinema.class);
        return cinemas;
    }

    public List<Cinema> findAllCinema() {

        QueryBuilder query = QueryBuilders.matchAllQuery();

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<Cinema> cinemas = elasticsearchTemplate.queryForList(build, Cinema.class);
        return cinemas;
    }

    public List<Cinema> findCinemaBySpecificQuery(String specificQuery) {

        QueryBuilder query = QueryBuilders
                .matchQuery("cinemaTitle", specificQuery);

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<Cinema> cinemas = elasticsearchTemplate.queryForList(build, Cinema.class);
        return cinemas;
    }

}
