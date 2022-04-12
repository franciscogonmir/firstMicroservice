package com.example.ec.services;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;
import com.example.ec.domain.TourPackage;
import com.example.ec.repository.TourPackageRepository;
import com.example.ec.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }


    @Override
    public Tour createTour(long id, String title, String description, String blurb, Double price, String duration, String bullets, String keyword, TourPackage tourPackages, Region region, Difficulty difficulty) {
        return tourRepository.findById(id)
                .orElse(tourRepository.save(
                        new Tour(
                                id,
                                title,
                                description,
                                blurb,
                                price,
                                duration,
                                bullets,
                                keyword,
                                tourPackageRepository.findById(tourPackages.getCode()).orElseThrow(() -> new RuntimeException("Tour package not exist in our database")),
                                region,
                                difficulty)));
    }

    @Override
    public Long total() {
        return tourRepository.count();
    }
}
