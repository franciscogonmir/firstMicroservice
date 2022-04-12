package com.example.ec.services;

import com.example.ec.domain.TourPackage;

public interface TourPackageService {

    TourPackage createTourPackage(String code, String name);
    TourPackage findById(String id);
    Iterable<TourPackage> lookup();
    Long total();
}
