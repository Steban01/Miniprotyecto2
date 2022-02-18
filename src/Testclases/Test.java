package Testclases;

import myProject.FileManager;

import java.util.ArrayList;
import myProject.GUI;
import myProject.ModelPalabras;
import myProject.ParaNivel;

import java.util.ArrayList;
import java.util.Random;
/**
 * Esta clase es usada para test y probar funciones de otras clases por medio de la consola
 *
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class Test {
    ArrayList<String> nuevaLista = new ArrayList<>();
    ModelPalabras frase = new ModelPalabras();
    ParaNivel nivel = new ParaNivel();
      //  System.out.println("EL nivel " + nivel.getNivel());
       // frase.generarPalabrasNivel(nivel.getNivel());
       // System.out.println("FRASES EN NIVEL 1" + frase.getPalabrasMemorizar(1));
       // System.out.println("FRASES EN NIVEL 1" + frase.getPalabrasNivel(1));
       // frase.generarPalabrasNivel(nivel.getNivel());
       // System.out.println("FRASES EN NIVEL 2" + frase.getPalabrasMemorizar(2));
       // System.out.println("FRASES EN NIVEL 2" + frase.getPalabrasNivel(2));
        //nuevaLista = frase.getPalabrasMemorizar(nivel.getNivel()).clear();
       // System.out.println("Validacion: " + frase.validarPalabra(nivel.getElNivel()));
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> nuevaLista = new ArrayList<>();
        FileManager fileManager = new FileManager();
        System.out.println("Lista de usuarios"+fileManager.lecturaJugadores());

    }
}
