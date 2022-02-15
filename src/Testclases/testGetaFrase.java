package Testclases;

import myProject.GUI;
import myProject.ModelPalabras;
import myProject.ParaNivel;

import java.util.ArrayList;
import java.util.Random;

public class testGetaFrase {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> nuevaLista= new ArrayList<>();
        ModelPalabras frase = new ModelPalabras();
        ParaNivel nivel = new ParaNivel();
        System.out.println("EL nivel " + nivel.getNivel());
        frase.generarPalabrasNivel(nivel.getNivel());
        System.out.println("FRASES EN NIVEL 1"+frase.getPalabrasMemorizar(1));
        System.out.println("FRASES EN NIVEL 1"+frase.getPalabrasNivel(1));
        frase.generarPalabrasNivel(nivel.getNivel());
        System.out.println("FRASES EN NIVEL 2"+frase.getPalabrasMemorizar(2));
        System.out.println("FRASES EN NIVEL 2"+frase.getPalabrasNivel(2));
        //nuevaLista = frase.getPalabrasMemorizar(nivel.getNivel()).clear();

        //System.out.println("Validacion: " + frase.validarPalabra(nivel.getNivel()));
    }
}
