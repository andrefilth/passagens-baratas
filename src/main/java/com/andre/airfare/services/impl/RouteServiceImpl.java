package com.andre.airfare.services.impl;

import com.andre.airfare.endpoint.RouteEndpoint;
import com.andre.airfare.model.Route;
import com.andre.airfare.repositories.RouteRepository;
import com.andre.airfare.services.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static org.apache.commons.lang3.Validate.notEmpty;

@Service
public class RouteServiceImpl implements RouteService {

    private static final Logger LOG = LoggerFactory.getLogger(RouteEndpoint.class);
    private final RouteRepository repository;

    @Autowired
    public RouteServiceImpl(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Route> create(Route route) {

        return validateFields(route)
                .flatMap(repository::save);
    }

    @Override
    public Mono<String> findBestRoute(String origin, String destiny) {
        return validateFields(origin, destiny)
                .then(repository.find(origin, destiny));
                //.flatMap(repository.find);
    }



    private Mono<Void> validateFields(String origin, String destiny) {
        notEmpty(origin, "Origem");
        notEmpty(destiny, "Destino");
        LOG.info("Campos das rotas validados com sucesso");
        return Mono.empty();
    }


    private Mono<Route> validateFields(Route route) {
        notEmpty(route.getRoutes(), "Lista de rotas");
        LOG.info("Campos das rotas validados com sucesso. body: [{}]", route);
        return Mono.just(route);
    }
}
