package com.andre.airfare.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {

    @Test
    void getRoutes() {
        Route route = new Route("input-routes.csv", destiny);
        List<String> routes = route.getRoutes();
        assertEquals(routes.size(), 6);
    }

    @Test
    void bestRoute() {
    }
}