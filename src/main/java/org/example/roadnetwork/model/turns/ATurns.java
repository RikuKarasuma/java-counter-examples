package org.example.roadnetwork.model.turns;

import org.example.roadnetwork.Distance;
import org.example.roadnetwork.Point;
import org.example.roadnetwork.model.Journey;

import java.util.HashMap;
import java.util.Map;

public final class ATurns implements Point {

    private static final String POINT_NAME = "A";

    private static final Map<String, Distance> TRAVEL_COST_INDEX = new HashMap<>(Map.of(
        "B", new Journey(75, 1),
        "C", new Journey(30, 1),
        "D", new Journey(30, 1)
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
