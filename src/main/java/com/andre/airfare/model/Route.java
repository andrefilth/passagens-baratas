package com.andre.airfare.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Route {

    private final List<String> routes;


    public Route(String nomeArquivo) {
        this.routes = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/"+nomeArquivo))).lines().collect(Collectors.toList());
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

   /* public Optional<String> bestRoute(String route) {
        List<Integer> integer = this.routes.stream()
                .filter(s -> s.contains(route))
                .flatMap(this::somenteDigitos)
                //.sorted(Compa)
                .collect(Collectors.toList());

        System.out.println("Numeros " + integer);
        return null;
    }*/

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
