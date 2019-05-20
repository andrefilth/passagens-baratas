package com.andre.airfare.endpoint;

import com.andre.airfare.convert.RouteConvert;
import com.andre.airfare.endpoint.request.RouteRequest;
import com.andre.airfare.endpoint.response.RouteResponse;
import com.andre.airfare.services.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.andre.airfare.constants.Constants.AIRFARE_CONTEXT_PATH;
import static com.andre.airfare.convert.RouteConvert.*;

@RestController
@RequestMapping(AIRFARE_CONTEXT_PATH)
public class RouteEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(RouteEndpoint.class);
    private final RouteService service;

    @Autowired
    public RouteEndpoint(RouteService service) {
        this.service = service;
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/routes")
    public Mono<RouteResponse> create(@RequestBody RouteRequest request) {

        LOG.info("Solicitação de criação de novas rotas [{}]", request);

        return service.create(toModel(request))
                      .map(RouteResponse::new)
                      .doOnSuccess(wr -> LOG.info("Resposta de criação das rotas [{}]", wr));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/routes")
    public Mono<String> get(@RequestParam(value = "origin") String origin,@RequestParam(value = "destiny") String destiny ) {

        LOG.info("Buscando a melhor rota DE [{}], PARA [{}]", origin, destiny);

        return service.findBestRoute(origin, destiny)
                .doOnSuccess(wr -> LOG.info("Melhor rota [{}]", wr));
    }
}
