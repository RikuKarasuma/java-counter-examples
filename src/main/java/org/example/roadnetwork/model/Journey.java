package org.example.roadnetwork.model;

import org.example.roadnetwork.Distance;

public class Journey implements Distance {

    private int distanceToPointInMiles = 0;
    private float timeCostPerMile = 0;

    public Journey(final int distanceTo, final float timeCost) {
        this.distanceToPointInMiles = distanceTo;
        this.timeCostPerMile = timeCost;
    }

    @Override
    public int distanceToInMiles() {
        return this.distanceToPointInMiles;
    }

    @Override
    public float timeCostPerMile() {
        return this.timeCostPerMile;
    }


}
