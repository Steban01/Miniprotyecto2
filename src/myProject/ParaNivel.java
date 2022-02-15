package myProject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430 - 3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class ParaNivel {
    private int nivel;
    private int aciertos;
    private int errores;
    private int porcentajeAciertos;
    private ModelPalabras words;


    public int getElNivel() {
        return elNivel;
    }

    private int elNivel;

    /**
     * Constructor of GUI class
     */
    public ParaNivel() {
        nivel = 1;
        aciertos = 0;
        elNivel = 1;
        //errores=0;
    }

    public int getNivel() {
        return nivel;
    }

    /*public int aumentarNivel(int nivel) {
        nivel = nivel + 1;
        return nivel;
    }*/

    public int aumentarAciertos() {
        aciertos = aciertos + 1;
        return aciertos;
    }

    public int aumentarErrores(){
        errores = errores + 1;
        return errores;
    }

    public int getErrores(){
        return errores;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int errores(int nivel, int aciertos){
        if(nivel==1 && aciertos >= 14 && aciertos < 28){
           errores=20-aciertos; // le resta la cantidad maxima de aciertos por nivel a la cantidad de aciertos que obtuvo en el n
        }
        return errores;
    }

    public int calcularPorcentajeAciertos(int aciertos) {
        if (aciertos >= 0 && aciertos <= 20) {
            porcentajeAciertos = (aciertos * 100) / 20; //calcula el porcentaje dependiendo de los aciertos
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        else if (aciertos >= 0 && aciertos <= 40) {
            porcentajeAciertos = (aciertos * 100) / 40;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 0 && aciertos <= 50) {
            porcentajeAciertos = (aciertos * 100) / 50;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 0 && aciertos <= 60) {
            porcentajeAciertos = (aciertos * 100) / 60;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 0 && aciertos <= 70) {
            porcentajeAciertos = (aciertos * 100) / 70;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 0 && aciertos <= 80) {
            porcentajeAciertos = (aciertos * 100) / 80;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 0 && aciertos <= 100) {
            porcentajeAciertos = (aciertos * 100) / 100;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        else if (aciertos >= 0 && aciertos <= 120) {
            porcentajeAciertos = (aciertos * 100) / 120;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else  if (aciertos >= 0 && aciertos <= 140) {
            porcentajeAciertos = (aciertos * 100) / 140;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        else  if (aciertos>= 0 && aciertos == 200) {
            porcentajeAciertos = (aciertos * 100) / 200;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        else{
            JOptionPane.showMessageDialog(null, "Suerte la proxima vez, no lograste obtener la cantidad minima de aciertos para superar el nivel.\n"
                    +"Vuelve a intentarlo con le boton iniciar");
            getNivel();
        }
        return porcentajeAciertos;
    }
    public int aumentaNivel(int aciertos, int nivel){
        if (nivel == 1 && aciertos >= 14 && aciertos <= 20){
            System.out.println();
            //calcularPorcentajeAciertos(aciertos);
            elNivel = nivel + 1;
        }
        else if (nivel == 2 && aciertos >= 28 && aciertos <= 40){
            System.out.println();
            elNivel = nivel + 1;
        }
        else if (nivel == 3 && aciertos >= 38 && aciertos <= 50){
            System.out.println();
            //calcularPorcentajeAciertos(aciertos);
            elNivel = nivel + 1;
        }
        else if (nivel == 4 && aciertos >= 48 && aciertos <= 60){
            System.out.println();
            //calcularPorcentajeAciertos(aciertos);
            elNivel = nivel + 1;
        }
        else if (nivel == 5 && aciertos >= 56 && aciertos <= 70){
            System.out.println();
            //calcularPorcentajeAciertos(aciertos);
            elNivel = nivel + 1;
        }
        else if (nivel == 6 && aciertos >= 68 && aciertos <= 80){
            System.out.println();
            //calcularPorcentajeAciertos(aciertos);
            elNivel = nivel + 1;
        }
        else if (nivel == 7 && aciertos >= 90 && aciertos <= 100){
            System.out.println();
            //calcularPorcentajeAciertos(aciertos);
            elNivel = nivel + 1;
        }
        else if (nivel == 8 && aciertos >= 108 && aciertos <= 120){
            System.out.println();
            //calcularPorcentajeAciertos(aciertos);
            elNivel = nivel + 1;
        }
        else if (nivel == 9 && aciertos >= 133 && aciertos <= 140){
            System.out.println();
            //calcularPorcentajeAciertos(aciertos);
            elNivel = nivel + 1;
        }
        else if (nivel == 10 && aciertos == 200){
            System.out.println();
            //calcularPorcentajeAciertos(aciertos);
            elNivel = nivel + 1;
        }
        else{
            return elNivel = nivel;
        }
        return elNivel;
    }
}
