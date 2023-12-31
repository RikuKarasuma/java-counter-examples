package org.example.roadnetwork.model;

import org.example.roadnetwork.Distance;

public class Journey implements Distance {

    private int distanceToPointInMiles = 0;
    private int timeCostPerMile = 0;

    public Journey(final int distanceTo, final int timeCost) {
        this.distanceToPointInMiles = distanceTo;
        this.timeCostPerMile = timeCost;
    }

    @Override
    public int distanceToInMiles() {
        return this.distanceToPointInMiles;
    }

    @Override
    public int timeCostPerMile() {
        return this.timeCostPerMile;
    }


}
