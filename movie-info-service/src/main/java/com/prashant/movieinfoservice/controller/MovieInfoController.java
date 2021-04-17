package com.prashant.movieinfoservice.controller;


import com.prashant.movieinfoservice.models.Movie;
import com.prashant.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @Value("${movie.db.api.key}")
    private String movieDbApiKey;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId) {
        MovieSummary movieSummary = restTemplate
                .getForObject("https://api.themoviedb.org/3/movie/" + movieId+"?api_key="+movieDbApiKey, MovieSummary.class);
        return new Movie(movieSummary.getId(),movieSummary.getTitle(),movieSummary.getOverview());
    }
}
