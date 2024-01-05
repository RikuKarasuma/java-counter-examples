package org.example;


import org.example.roadnetwork.Point;
import org.example.roadnetwork.model.fastest.*;
import org.example.roadnetwork.model.turns.ATurns;
import org.example.roadnetwork.model.turns.BTurns;
import org.example.roadnetwork.model.turns.CTurns;
import org.example.roadnetwork.model.turns.DTurns;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.example.CounterExampleUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Counterexample exercises from the book 'The Algorithm Design Manual 3rd Edition.'.
 */
public class CounterExampleUtilTest {

    /**
     * 1-1. [3] Show that a + b can be less than min(a, b).
     */
    @Test
    public void shouldShowThatAPlusBCanBeLessThanMinAB() {

        // Achievable using negatives.
        assert aPlusB(-1 , -7) <
               aMinB(-1, -7);
    }

    /**
     * 1-2. [3] Show that a × b can be less than min(a, b).
     */
    @Test
    public void shouldShowThatAByBCanBeLessThanMinAB() {

        // Achievable multiplying a positive by a negative.
        assert aByB(8 , -7) <
               aMinB(8, -7);
    }

    /**
     * 1-3. [5] Design/draw a road network with two points a and b such that the fastest
     * route between a and b is not the shortest route
     *
     *                  75 miles
     *                   ->E-> -
     *                  /    \   \
     *                 50 miles   G
     *                --> C -->   |
     *               /          \ /
     *     50 miles A --------> B 50 miles
     *              \          / \
     *               --> D -->   |
     *                50 miles   F
     *                \     /  /
     *                 ->F->  -
     *                75 miles
     *
     *
     * Using the model within roadnetwork package, we demonstrate that sometimes the
     * straightest route isn't always the fastest.
     */
    @Test
    public void shouldShowThatAtoBShortestRouteIsNotTheFastest() {
        final List<Point> locations = Arrays.asList(
                new A(),
                new B(),
                new C(),
                new D(),
                new E(),
                new F()
        );

        final var starting_point = new A();
        final var destination_point = new B();
        final var expected_time_in_hours = 1.7241379f;
        final var select_fastest_route = true;

        // We calculate various routes generated from the plotted points
        // within 'roadnetwork' package.
        // Then use various factors such as total distance and time cost
        // and a standard speed of 60 mph to calculate the fastest route.
        final var calculated_quickest_route_which_is_longer = travelToB(starting_point,
                destination_point, locations, select_fastest_route).timeToGetThere();

        assertEquals(expected_time_in_hours, calculated_quickest_route_which_is_longer);
    }

    /**
     * 1-4. [5] Design/draw a road network with two points a and b such that the shortest
     * route between a and b is not the route with the fewest turns.
     *
     *                 30 miles
     *                --> C -->
     *               /          \
     *     75 miles A --------> B 75 miles -- Lets say this isn't the straightest road.
     *              \          /
     *               --> D -->
     *                30 miles
     *
     *
     * Using the model within roadnetwork package, we demonstrate that sometimes the
     * shortest route doesn't have the fewest turns.
     */
    @Test
    public void shouldShowThatAtoBShortestRouteIsNotTheOneWithTheFewestTurns() {
        final List<Point> locations = Arrays.asList(
                new ATurns(),
                new BTurns(),
                new CTurns(),
                new DTurns()
        );

        final var starting_point = new ATurns();
        final var destination_point = new BTurns();
        final var expected_distance = 60;
        final var expected_turns = 3;
        final var select_fastest_route = false;

        // We calculate various routes generated from the plotted points
        // within 'roadnetwork' package.
        // Then use various factors such as total distance and time cost
        // and a standard speed of 60 mph to calculate the shortest route
        // with the most turns.
        final var calculated_shortest_route_which_has_more_turns = travelToB(starting_point,
                destination_point, locations, select_fastest_route);

        assertEquals(expected_distance, calculated_shortest_route_which_has_more_turns.totalDistance());
        assertEquals(expected_turns, calculated_shortest_route_which_has_more_turns.getNumberOfTurns());
    }
}
