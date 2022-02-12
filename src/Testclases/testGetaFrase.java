package Testclases;

import myProject.Diccionario;
import myProject.ParaNivel;

import java.util.ArrayList;
import java.util.Random;

public class testGetaFrase {

    public static void main(String[] args) throws InterruptedException {
        Diccionario frase = new Diccionario();
        ParaNivel nivel = new ParaNivel();
        //System.out.println("La validacion es: "+nivel.validarPalabra());
        //System.out.println("La validacion es: "+frase.recorrerLista());
        //System.out.println("La validacion es: "+ frase.todas_las_palabras(1));
       // System.out.println("La validacion es: "+frase.validarPalabra());
        frase.generarPalabrasNivel(nivel.getNivel());
        System.out.println( frase.getPalabrasMemorizar());
        System.out.println(frase.getPalabrasNivel());
        System.out.println("Validacion: "+frase.validarPalabra(nivel.getNivel()));





    }

}
