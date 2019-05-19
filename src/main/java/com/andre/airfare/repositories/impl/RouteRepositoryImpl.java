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

@Service
public class RouteRepositoryImpl implements RouteRepository {

    @Override
    public Mono<Route> save(Route route) {
        return verify(route.getRoutes());
    }

    public Mono<Route> verify(List<String> routes)  {

        File file = new File("E:\\arquivo");
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

        return Mono.just(new Route(routes));

    }
}
