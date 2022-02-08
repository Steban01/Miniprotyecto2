package Testclases;

import myProject.Diccionario;

import java.util.ArrayList;
import java.util.Random;

public class testGetaFrase {
    public static void main(String[] args) throws InterruptedException {

        Diccionario aja = new Diccionario();
        System.out.println("Las frases" + aja.get_Frase_in_Nivel(1));
        Thread.sleep(1000);
        System.out.println("pasaste al nivel 2");
        System.out.println("Las frases" + aja.get_Frase_in_Nivel(2));
        Thread.sleep(1000);
    }


}
