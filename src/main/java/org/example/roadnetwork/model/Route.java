package org.example.roadnetwork.model;

import org.example.roadnetwork.PlottedRoute;
import org.example.roadnetwork.Point;

import java.util.LinkedList;
import java.util.List;

public class Route implements PlottedRoute {

    private final List<Point> locations = new LinkedList<>();
    private int totalDistance = 0;

    @Override
    public void addRoute(final Point new_location, final int distance) {
        locations.add(new_location);
        totalDistance += distance;
    }

    @Override
    public Point[] getPlottedRoute() {
        return locations.toArray(new Point[0]);
    }

    @Override
    public int totalDistance() {
        return totalDistance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "locations=" + locations +
                ", totalDistance=" + totalDistance +
                '}';
    }
}
