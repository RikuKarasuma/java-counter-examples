package org.example.roadnetwork;

public interface Distance {

    /**
     * @return Distance between two points.
     */
    int distanceToInMiles();

    /**
     * @return The mph time cost travelling to this place
     *         due to external factors.
     *         e.g traffic stops, car congestion, accidents etc.
     */
    float timeCostPerMile();

}
