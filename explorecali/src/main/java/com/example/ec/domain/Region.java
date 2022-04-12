package com.example.ec.domain;

public enum Region {
    NORTHERN_CALIFORNIA("Northern California"),
    CENTRAL_COAST("Central Coast"),
    SOUTHERN_CALIFORNIA("Southern California"),
    VARIES("Varies");

    private final String label;

    Region(String label) {
        this.label = label;
    }

    public static Region findByLabel(String byLabel) {
        for (Region region : Region.values()) {
            if (region.label.equals(byLabel)) {
                return region;
            }
        }
        return null;
    }
}
