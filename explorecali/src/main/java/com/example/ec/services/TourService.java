package com.example.ec.services;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;
import com.example.ec.domain.TourPackage;

public interface TourService {

    Tour createTour(long id, String title, String description, String blurb, Double price, String duration, String bullets, String keyword, TourPackage tourPackages, Region region, Difficulty difficulty);
    Long total();
}
