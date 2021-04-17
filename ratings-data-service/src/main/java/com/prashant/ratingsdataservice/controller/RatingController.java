package com.prashant.ratingsdataservice.controller;

import com.prashant.ratingsdataservice.models.Rating;
import com.prashant.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId,4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable String userId) {
        List<Rating> userRatings = Arrays.asList(
            new Rating("1234",1),
            new Rating("5678",5)
        );
        return new UserRating(userId, userRatings);
    }
}
