package Testclases;

import myProject.GUI;
import myProject.ModelPalabras;
import myProject.ParaNivel;

import java.util.ArrayList;
import java.util.Random;

public class testGetaFrase {

    public static void main(String[] args) throws InterruptedException {
       ModelPalabras  model= new ModelPalabras();
       ParaNivel nivel = new ParaNivel();
       String palabra;
       palabra = " ";
       model.generarPalabrasNivel(nivel.getNivel());
       System.out.println(model.getPalabrasMemorizar());
       System.out.println(model.getPalabrasNivel());
       System.out.println(model.validarPalabra(nivel.getNivel()));
        for(int i= 0; i <= model.getPalabrasMemorizar().size();i++){
            System.out.println(model.getPalabrasMemorizar().get(i));
        }

    }

}
