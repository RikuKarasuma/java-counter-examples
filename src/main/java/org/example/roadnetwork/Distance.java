package org.example.roadnetwork;

public interface Distance {

    /**
     * @return Distance between two points.
     */
    int distanceToInMiles();

    /**
     * @return The time cost(in minutes) travelling to this place
     *         due to external factors.
     *         e.g traffic stops, car congestion, accidents etc.
     */
    int timeCostPerMile();

}
