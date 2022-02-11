package Testclases;

import myProject.Diccionario;
import myProject.ParaNivel;

import java.util.ArrayList;
import java.util.Random;

public class testGetaFrase {
    public static void main(String[] args) throws InterruptedException {
        Diccionario frase = new Diccionario();
        ParaNivel xd = new ParaNivel();
        String lol = "Llevar,Prevenir,Scam";


        for (int i = 0; i <= frase.todas_las_palabras(1).size(); i++) {
            String lista= frase.todas_las_palabras(1).get(i);
        }


    }

}
