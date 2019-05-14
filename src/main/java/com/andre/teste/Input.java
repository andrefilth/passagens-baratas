package com.andre.teste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner (System.in);
//        System.out.println("Nome da primeira pessoa: ");
//        String nome1 = scan.nextLine();
        System.out.println("Nome o nome do arquivo para ler: ");
        String arquivo = scan.nextLine();
        Path path = Paths.get(arquivo);

        List<String> linhasArquivo = Files.readAllLines(path);
        for (String linha : linhasArquivo) {


        }
//        System.out.println("Peso em kg: ");
//        int peso1 = scan.nextInt(); scan.nextLine();
//        System.out.println("Nome da segunda pessoa: ");
//        String nome2 = scan.nextLine();
//        System.out.println("Peso em kg: ");
//        int peso2 = scan.nextInt(); scan.nextLine();
//        System.out.println("O individuo mais pesado eh: ");
//        if (peso1 > peso2) {
//            System.out.printf("%s, com %d kg%n", nome1, peso1);
//        } else if (peso1 < peso2) {
//            System.out.printf("%s, com %d kg%n", nome2, peso2);
//        } else {
//            System.out.printf("%s e %s tem o mesmo peso - %d kg%n", nome1, nome2, peso1);
//        }
    }
}
