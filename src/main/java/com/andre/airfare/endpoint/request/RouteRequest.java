package com.andre.airfare.endpoint.request;

import com.andre.airfare.model.Route;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class RouteRequest {

    private List<String> routes;

    public List<String> getRouters() {
        return routes;
    }

    public void setRoutes(List<String> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("routes", routes)
                .build();
    }
}
