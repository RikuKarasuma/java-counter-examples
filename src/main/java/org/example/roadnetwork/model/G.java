package org.example.roadnetwork.model;

import org.example.roadnetwork.Distance;
import org.example.roadnetwork.Point;

import java.util.HashMap;
import java.util.Map;

public final class G implements Point {

    private static final String POINT_NAME = "G";

    private static final Map<String, Distance> TRAVEL_COST_INDEX = new HashMap<>(Map.of(
        "E", new Journey(25, 1),
        "B", new Journey(25, 1)
    ));

    @Override
    public String getName() {
        return POINT_NAME;
    }

    @Override
    public Map<String, Distance> roadMap() {
        return TRAVEL_COST_INDEX;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}
