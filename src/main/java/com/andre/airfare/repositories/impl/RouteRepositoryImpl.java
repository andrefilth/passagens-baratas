package com.andre.airfare.repositories.impl;

import com.andre.airfare.model.Route;
import com.andre.airfare.repositories.RouteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RouteRepositoryImpl implements RouteRepository {

    @Override
    public Mono<Route> save(Route route) {
        return verify(route.getRoutes());
    }

    @Override
    public Mono<String> find(String origin, String destiny) {
        Route newRouter = new Route("input-routes.csv");
        return Mono.justOrEmpty(newRouter.bestRoute(origin, destiny));
    }

    public Mono<Route> verify(List<String> routes)  {

        String pasta = System.getProperty("user.home");
        String arquivo = "/git/git/passagens-baratas/src/main/resources/input-routes.csv";
        File file = new File(pasta+arquivo);

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            for (String rotas: routes) {
                bw.write(rotas);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Route route = new Route();
        route.setRoutes(routes);
        return Mono.just(route);

    }
}
