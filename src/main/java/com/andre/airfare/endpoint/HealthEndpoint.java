package com.andre.airfare.endpoint;


import com.andre.airfare.endpoint.response.HealthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.andre.airfare.constants.Constants.AIRFARE_CONTEXT_PATH;


@RestController
public class HealthEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(HealthEndpoint.class);

    @GetMapping(AIRFARE_CONTEXT_PATH + "/health")
    public Mono<HealthResponse> health() {
        return Mono.just(new HealthResponse())
                .doOnSuccess(t -> LOG.info("Status da aplicação [{}]", t));
    }

}
