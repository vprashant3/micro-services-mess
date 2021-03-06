package com.prashant.moviecatalogservice.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CatalogItem {
    private String userId;
    private List<Movie> userMovies;
}
