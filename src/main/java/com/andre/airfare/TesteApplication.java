package com.andre.airfare;

import com.andre.airfare.model.Route;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class TesteApplication  {

    public static void main(String[] args) {
        SpringApplication.run(TesteApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Start program: ");
            Scanner scan = new Scanner(System.in);
            System.out.println("Input File: ");
            String nomeArquivo = scan.nextLine();
            Route routes = new Route(nomeArquivo);
            System.out.println("please enter the route: ");
            String route = scan.nextLine();
            Optional<String> bestRoute = routes.bestRoute(route.substring(0, 3), route.substring(4, 7));

            if(!bestRoute.isPresent()){
                System.out.println("No routes found");
            }
            System.out.println("Routes found: " + bestRoute.get());
        };
    }


}

