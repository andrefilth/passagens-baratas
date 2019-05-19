package com.andre.airfare.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Route {

    private final List<String> routes;

    public Route(List<String> routes) {
        this.routes = routes;
    }

    public Route(String archive) {
        this.routes = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/"+archive))).lines().collect(Collectors.toList());
    }

    public List<String> getRoutes() {
        return routes;
    }



    public Optional<String> bestRoute(String origin, String destiny){
        return this.routes.stream()
                .filter(s -> s.contains(origin))
                .filter(s -> s.contains(destiny))
                .min((p1, p2) -> Integer.compare(somenteDigitos(p1), somenteDigitos(p2)))
                ;
    }

    private int somenteDigitos(String palavra) {
        String digitos = "";
        char[] letras  = palavra.toCharArray();
        for (char letra : letras) {
            if(Character.isDigit(letra)) {
                digitos += letra;
            }
        }
        return Integer.parseInt(digitos);

    }
}
