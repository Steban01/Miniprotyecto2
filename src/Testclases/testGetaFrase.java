package Testclases;

import myProject.Diccionario;

import java.util.ArrayList;
import java.util.Random;

public class testGetaFrase {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Diccionario aja = new Diccionario();
            System.out.println(aja.get_Frase_In_Nivel_Correcta(1));
            Thread.sleep(1000);
        }
        System.out.println("pasaste al nivel 2");
        for (int i = 0; i < 40; i++) {
            Diccionario aja = new Diccionario();

            System.out.println(aja.get_Frase_In_Nivel_Correcta(2));
            Thread.sleep(1000);
        }
    }


}
