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
        if (aciertos >= 14 && aciertos < 28) {
            porcentajeAciertos = (aciertos * 100) / 20; //calcula el porcentaje dependiendo de los aciertos
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        else if (aciertos >= 28 && aciertos < 38) {
            porcentajeAciertos = (aciertos * 100) / 40;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 38 && aciertos < 48) {
            porcentajeAciertos = (aciertos * 100) / 50;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 48 && aciertos < 56) {
            porcentajeAciertos = (aciertos * 100) / 60;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 56 && aciertos < 68) {
            porcentajeAciertos = (aciertos * 100) / 70;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 68 && aciertos < 90) {
            porcentajeAciertos = (aciertos * 100) / 80;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else if (aciertos >= 90 && aciertos < 108) {
            porcentajeAciertos = (aciertos * 100) / 100;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        else if (aciertos >= 108 && aciertos < 133) {
            porcentajeAciertos = (aciertos * 100) / 120;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }

        else  if (aciertos >= 133 && aciertos < 200) {
            porcentajeAciertos = (aciertos * 100) / 140;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        else  if (aciertos == 200) {
            porcentajeAciertos = (aciertos * 100) / 200;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");

        }
        else{
            JOptionPane.showMessageDialog(null, "Suerte la proxima vez");
            getNivel();
        }
        return porcentajeAciertos;
    }
    public int aumentaNivel(int aciertos, int nivel){
        if (nivel == 1 && aciertos >= 14 && aciertos < 28){
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
