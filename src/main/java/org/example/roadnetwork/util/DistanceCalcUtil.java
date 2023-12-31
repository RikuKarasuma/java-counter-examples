package org.example.roadnetwork.util;

import org.example.roadnetwork.PlottedRoute;
import org.example.roadnetwork.Point;
import org.example.roadnetwork.model.Route;

import java.util.*;

public class DistanceCalcUtil {



    /**
     * Randomly chooses points ahead until we reach destination, and we run out
     * of alternative starting points. Plots routes.
     */
    public static PlottedRoute[] plotFastestRoutes(final String starting_point_name,
                                                   final String destination_name,
                                                   final List<Point> points) {

        final var starting_point = points.stream()
                .filter(point -> point.getName().equals(starting_point_name))
                .findAny()
                .orElseThrow(RuntimeException::new);


        final var destination_point = points.stream()
                .filter(point -> point.getName().equals(destination_name))
                .findAny()
                .orElseThrow(RuntimeException::new);

        final var potentialRoutes = new ArrayList<PlottedRoute>();

        final var starting_directions = starting_point.roadMap();

        while (!starting_directions.isEmpty()) {
            final var route = new Route();
            route.addRoute(starting_point, 0);
            potentialRoutes.add(travelToDestination(starting_point, destination_point, points, route));

            final var innerRoutesTravelled = Arrays.stream(route.getPlottedRoute()).filter(point -> !point.getName().equals(starting_point_name)).findAny();

            starting_directions.remove(innerRoutesTravelled.get().getName());
        }

        return potentialRoutes.toArray(new PlottedRoute[0]);
    }

    private static PlottedRoute travelToDestination(final Point starting_point,
                                                    final Point destination,
                                                    List<Point> points,
                                                    final PlottedRoute route) {

        // Could not find destination before running out of points.
        if (points.isEmpty())
            return null;

        final var destination_name = destination.getName();

        // Try to find destination first off.
        final var next_point = starting_point.roadMap().get(destination_name);

        // If we cannot find a direct route
        if (Objects.isNull(next_point)) {

            // Find a random next point and its outgoing routes.
            final var next_point_found = starting_point.roadMap()
                    .entrySet()
                    .stream()
                    .filter(point -> Arrays.stream(route.getPlottedRoute()).noneMatch(point1 -> point1.getName().equals(point.getKey())))
                    .findAny()
                    .orElseThrow(RuntimeException::new);

            // Find it within our remaining list of possible destinations.
            final var next_point_after = points.stream()
                    .filter(point -> next_point_found.getKey().equals(point.getName()))
                    .findAny()
                    .orElseThrow(RuntimeException::new);

            // Remove our current point as we already travelled to it.
            points = points.stream().filter(point -> !point.getName().equals(next_point_found.getKey())).toList();

            // Add next destination to route.
            route.addRoute(next_point_after, next_point_found.getValue().distanceToInMiles());

            // Repeat process until we find location or run out of points.
            travelToDestination(next_point_after, destination, points, route);
        }
        else
            route.addRoute(destination, next_point.distanceToInMiles());

        return route;
    }


}
