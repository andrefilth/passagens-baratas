package com.andre.airfare.model;

import com.andre.airfare.endpoint.request.RouteRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class Route {

    private List<String> routes;
    private String origin;
    private String destiny;

    public Route() {
    }

    public Route(String archive) {
        this.routes = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/"+archive))).lines().collect(Collectors.toList());
        this.destiny = null;
        this.origin = null;
    }

    public List<String> getRoutes() {
        return routes;
    }


    public String getOrigin() {
        return origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setRoutes(List<String> routes) {
        this.routes = routes;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("routes", routes)
                .append("origin", origin)
                .append("destiny", destiny)
                .build();
    }
}
