package com.andre.teste;


import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class Input {

    public static void main(String[] args) throws IOException {
        List<String> strings = Arrays.asList("GRU,CDG,75", "GRU,BRC,SCL,ORL,CDG,40","GRU,CDG,ORL,39");
        String s = strings.stream().min((p1, p2) -> Integer.compare(somenteDigitos(p1), somenteDigitos(p2)))
                .get();

        String s1 = "GRU,CDG,ORL,39";
        assertEquals(s1, s);
        System.out.println(s);

//
    }
    private static int somenteDigitos(String palavra) {
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
