package org.example;


import org.junit.jupiter.api.Test;

import static org.example.CounterExampleUtil.*;

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
     */
    @Test
    public void shouldShowThatAtoBShortestRouteIsNotTheFastest() {

        CounterExampleUtil.travelToB();
    }
}
