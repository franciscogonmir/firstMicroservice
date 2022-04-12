package com.example.ec.domain;

import javax.persistence.*;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column(length = 2000)
    private String description;
    @Column(length = 2000)
    private String blurb;
    @Column
    private Double price;
    @Column
    private String duration;
    @Column(length = 2000)
    private String bullets;
    @Column
    private String keyword;
    @ManyToOne
    private TourPackage tourPackages;
    @Column
    @Enumerated
    private Region region;
    @Column
    @Enumerated
    private Difficulty difficulty;


    public Tour(long id, String title, String description, String blurb, Double price, String duration, String bullets, String keyword, TourPackage tourPackages, Region region, Difficulty difficulty) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keyword = keyword;
        this.tourPackages = tourPackages;
        this.region = region;
        this.difficulty = difficulty;
    }

    protected Tour(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBullets() {
        return bullets;
    }

    public void setBullets(String bullets) {
        this.bullets = bullets;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public TourPackage getTourPackages() {
        return tourPackages;
    }

    public void setTourPackages(TourPackage tourPackages) {
        this.tourPackages = tourPackages;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", blurb='" + blurb + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", bullets=" + bullets +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
