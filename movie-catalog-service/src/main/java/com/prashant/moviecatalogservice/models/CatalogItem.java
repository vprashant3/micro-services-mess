package com.prashant.moviecatalogservice.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogItem {

    private String name;
    private String description;
    private int rating;

}
