package com.example.ec;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.services.TourPackageService;
import com.example.ec.services.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ExplorecaliApplication implements CommandLineRunner {

    @Autowired
    private TourService tourService;
    @Autowired
    private TourPackageService tourPackageService;

    public static void main(String[] args) {
        SpringApplication.run(ExplorecaliApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createTourPackages();
        createTours();
    }

    private void createTours() throws IOException {
        TourFromFile.read("src/main/resources/ExploreCalifornia.json").forEach(importedTour ->
                tourService.createTour(
                        importedTour.getTitle(),
                        importedTour.getDescription(),
                        importedTour.getBlurb(),
                        importedTour.getPrice(),
                        importedTour.getLength(),
                        importedTour.getBullets(),
                        importedTour.getKeywords(),
                        importedTour.getPackageType(),
                        importedTour.getDifficulty(),
                        importedTour.getRegion()
                )
        );
    }

    private void createTourPackages() {
        tourPackageService.createTourPackage("BC", "Backpack Cal");
        tourPackageService.createTourPackage("CC", "California Calm");
        tourPackageService.createTourPackage("CH", "California Hot springs");
        tourPackageService.createTourPackage("CY", "Cycle California");
        tourPackageService.createTourPackage("DS", "From Desert to Sea");
        tourPackageService.createTourPackage("KC", "Kids California");
        tourPackageService.createTourPackage("NW", "Nature Watch");
        tourPackageService.createTourPackage("SC", "Snowboard Cali");
        tourPackageService.createTourPackage("TC", "Taste of California");

    }

    private static class TourFromFile {
        private String packageType;
        private String title;
        private String description;
        private String blurb;
        private String price;
        private String length;
        private String bullets;
        private String keywords;
        private String difficulty;
        private String region;

        static List<TourFromFile> read(String fileToImport) throws IOException {
            return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                    .readValue(new FileInputStream(fileToImport), new TypeReference<>() {
                    });
        }

        public String getPackageType() {
            return packageType;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getBlurb() {
            return blurb;
        }

        public Double getPrice() {
            return Double.parseDouble(price);
        }

        public String getLength() {
            return length;
        }

        public String getBullets() {
            return bullets;
        }

        public String getKeywords() {
            return keywords;
        }

        public Difficulty getDifficulty() {
            return Difficulty.valueOf(difficulty);
        }

        public Region getRegion() {
            return Region.findByLabel(region);
        }
    }
}
