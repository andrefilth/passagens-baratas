package com.andre.airfare.services;

import com.andre.airfare.model.Route;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface RouteService {

    Mono<Route> create(Route toModel);

    Mono<String> findBestRoute(String origin, String destiny);

}
