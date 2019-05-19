package com.andre.airfare.convert;

import com.andre.airfare.endpoint.RouteEndpoint;
import com.andre.airfare.endpoint.request.RouteRequest;
import com.andre.airfare.model.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RouteConvert {

    private static final Logger LOG = LoggerFactory.getLogger(RouteConvert.class);

    public static Route toModel(RouteRequest request) {
    return new Route(request.getRouters());
    }
}
