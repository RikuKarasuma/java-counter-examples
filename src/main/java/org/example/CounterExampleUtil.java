package org.example;

import org.example.roadnetwork.Point;
import org.example.roadnetwork.model.*;
import org.example.roadnetwork.util.DistanceCalcUtil;

import java.util.Arrays;
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
     *                  75 miles
     *                   ->E->
     *                  /    \
     *                 50 miles
     *                --> C -->
     *               /          \
     *     50 miles A --------> B 50 miles
     *              \          /
     *               --> D -->
     *                50 miles
     *                \     /
     *                 ->F->
     *                75 miles
     *
     *
     * Using the model within roadnetwork package, we demonstrate that sometimes the
     * straightest route isn't always the fastest.
     */
    public static void travelToB() {
        final List<Point> locations = Arrays.asList(
            new A(),
            new B(),
            new C(),
            new D(),
            new E(),
            new F(),
            new H(),
            new G()
        );

        final var starting_point = new A();
        final var destination_point = new B();


//        DistanceCalcUtil.plotFastestRoutes("A", "B", locations)
        final var routes = DistanceCalcUtil.plotFastestRoutes("A", "B", locations);


        System.out.println("\nRoutes:");
        for ( var route : routes)
            System.out.println(route);


    }

}