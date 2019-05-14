package com.andre.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class TesteApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TesteApplication.class, args);
        Scanner scan = new Scanner (System.in);
        System.out.print ("Nome da primeira pessoa: ");
        String nome1 = scan.nextLine();
        System.out.print ("Peso em kg: ");
        int peso1 = scan.nextInt(); scan.nextLine();
        System.out.print ("Nome da segunda pessoa: ");
        String nome2 = scan.nextLine();
        System.out.print ("Peso em kg: ");
        int peso2 = scan.nextInt(); scan.nextLine();
        System.out.println ("O individuo mais pesado eh: ");
        if (peso1 > peso2) {
            System.out.printf ("%s, com %d kg%n", nome1, peso1);
        } else if (peso1 < peso2) {
            System.out.printf ("%s, com %d kg%n", nome2, peso2);
        } else {
            System.out.printf ("%s e %s tem o mesmo peso - %d kg%n", nome1, nome2, peso1);
        }
    }
    }

