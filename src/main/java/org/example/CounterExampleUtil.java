package org.example;

import org.example.roadnetwork.PlottedRoute;
import org.example.roadnetwork.Point;
import org.example.roadnetwork.model.*;
import org.example.roadnetwork.util.DistanceCalcUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Counterexample exercises from the book 'The Algorithm Design Manual 3rd Edition.'.
 */
public class CounterExampleUtil {

    /**
     * 1-1. [3] Show that a + b can be less than min(a, b).
     * 1-2. [3] Show that a × b can be less than min(a, b).
     * @return
     */
    public static int aMinB(final int a, final int b) {
        return Math.min(a, b);
    }

    public static int aPlusB(final int a, final int b) {
        return a + b;
    }

    public static int aByB(final int a, final int b) {
        return a * b;
    }

    /**
     * 1-3. [5] Design/draw a road network with two points a and b such that the fastest
     * route between a and b is not the shortest route
     *
     * 1st Model.
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
     *
     * 1-4. [5] Design/draw a road network with two points a and b such that the shortest
     * route between a and b is not the route with the fewest turns.
     *
     * 2nd Model.
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
     *
     */
    public static PlottedRoute travelToB(final Point start,
                                         final Point destination,
                                         final List<Point> locations,
                                         final boolean fastest) {

        final var potential_routes = Arrays.asList(DistanceCalcUtil.plotFastestRoutes(start, destination, locations));


        return fastest ?
               potential_routes.stream()
                               .min( (x1, x2) -> Float.compare(x1.timeToGetThere(), x2.timeToGetThere()))
                               .orElseThrow(RuntimeException::new) :
               potential_routes.stream()
                               .min( (x1, x2) -> Float.compare(x1.totalDistance(), x2.totalDistance()))
                               .orElseThrow(RuntimeException::new);
    }

}