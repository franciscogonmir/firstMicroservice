package com.example.ec.services;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;

public interface TourService {

    Tour createTour(String title, String description, String blurb, Double price,
                    String duration, String bullets,
                    String keywords, String tourPackageName, Difficulty difficulty, Region region);

    Long total();
}
