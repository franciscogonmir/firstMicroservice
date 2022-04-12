package com.example.ec.services;

import com.example.ec.domain.TourPackage;
import com.example.ec.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TourPackageServiceImpl implements TourPackageService {

    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageServiceImpl(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    @Override
    public TourPackage createTourPackage(String code, String name) {
        return tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    @Override
    public TourPackage findById(String id) {
        return tourPackageRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Iterable<TourPackage> lookup() {
        return tourPackageRepository.findAll();
    }

    @Override
    public Long total() {
        return tourPackageRepository.count();
    }
}
