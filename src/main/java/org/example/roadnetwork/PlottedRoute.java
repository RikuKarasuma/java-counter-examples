package org.example.roadnetwork;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface PlottedRoute {

    void addRoute(Point new_location, int distance, float timeCost);

    Point[] getPlottedRoute();

    int totalDistance();

    float timeToGetThere();

    default String createPlottedStr() {
        return Arrays.stream(getPlottedRoute())
                .map(Point::getName)
                .collect(Collectors.joining("-"));
    }
}
