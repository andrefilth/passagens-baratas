package com.andre.airfare.services;

import com.andre.airfare.model.Route;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public interface RouteService {

    Mono<Route> create(Route toModel);
}
