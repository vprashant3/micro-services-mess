package com.prashant.ratingsdataservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rating {
    public String movieId;
    public int rating;
}
