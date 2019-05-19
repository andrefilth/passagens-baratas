package com.andre.airfare.repositories;

import com.andre.airfare.model.Route;
import reactor.core.publisher.Mono;

public interface RouteRepository {
    Mono<Route> save(Route route);
}
