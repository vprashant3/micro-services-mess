package com.prashant.moviecatalogservice.controller;


import com.prashant.moviecatalogservice.models.CatalogItem;
import com.prashant.moviecatalogservice.models.Movie;
import com.prashant.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public CatalogItem getCatalog(@PathVariable String userId) {
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/rating/users/"+userId, UserRating.class);

        List<Movie> userMovies = userRating.getUserRatings().stream()
                .map(rating -> restTemplate.getForObject("https://api.themoviedb.org/3/movie/100?api_key=d5ab38ce0f8ef28f1ec44023ad3cfce6", Movie.class))
                .collect(Collectors.toList());
        return new CatalogItem(userId, userMovies);
    }
}
