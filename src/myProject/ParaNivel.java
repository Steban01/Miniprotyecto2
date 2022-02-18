package myProject;

import javax.swing.*;


/**
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430 - 3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class ParaNivel {
    private int elNivel;
    private int aciertos;
    private int porcentajeAciertos;

    /**
     * Constructor of GUI class
     */
    public ParaNivel() {
        aciertos = 0;
        elNivel = 1;
    }

    /**
     * Obtiene el nivel
     *
     * @return un entero de nivel
     * @version v.1.0.0 date 13/02/2022
     */
    public int getElNivel() {
        return elNivel;
    }

    /**
     * Aumenta los acierto a parir del anterior
     *
     * @return un entero de aciertos
     * @version v.1.0.0 date 13/02/2022
     */
    public int aumentarAciertos() {
        return aciertos++;
    }

    /**
     * Obtiene el nivel
     *
     * @return un entero de aciertos
     * @version v.1.0.0 date 13/02/2022
     */
    public int getAciertos(){
        return aciertos;
    }

    /**
     * Reinicia el valor de los aciertos
     *
     * @return un entero de aciertos
     * @version v.1.0.0 date 16/02/2022
     */
    public int reiniciar_aciertos(){
        return aciertos = 0;
    }

    /**
     * Reinicia el valor del porcentaje de aciertos
     *
     * @return un entero de porcentajes
     * @version v.1.0.0 date 18/02/2022
     */
    public int reiniciar_porcentaje_de_aciertos(){
        return porcentajeAciertos = 0;
    }

    /**
     * Calcula los aciertos y muestra un mensaje de superado dependiendo de la cantidad de aciertos que se tiene
     *
     * @return un entero de porcentaje
     * @version v.1.0.0 date 16/02/2022
     */
    public int calcularPorcentajeAciertos(int nivel, int aciertos) {
        if (nivel == 1 && aciertos > 0 && aciertos <= 20) {
            porcentajeAciertos = (aciertos * 100) / 20; //calcula el porcentaje dependiendo de los aciertos
            if (aciertos >= 14 && aciertos <= 20) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");

            }
        } else if (nivel == 2 && aciertos > 0 && aciertos <= 40) {
            porcentajeAciertos = (aciertos * 100) / 40;
            if (aciertos >= 28 && aciertos <= 40) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");

            }

        } else if (nivel == 3 && aciertos > 0 && aciertos <= 50) {
            porcentajeAciertos = (aciertos * 100) / 50;
            if (aciertos >= 38 && aciertos <= 50) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
            }
        } else if (nivel == 4 && aciertos > 0 && aciertos <= 60) {
            porcentajeAciertos = (aciertos * 100) / 60;
            if (aciertos >= 48 && aciertos <= 60) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
            }
        } else if (nivel == 5 && aciertos > 0 && aciertos <= 70) {
            porcentajeAciertos = (aciertos * 100) / 70;
            if (aciertos >= 56 && aciertos <= 70) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
            }
        } else if (nivel == 6 && aciertos > 0 && aciertos <= 80) {
            porcentajeAciertos = (aciertos * 100) / 80;
            if (aciertos >= 68 && aciertos <= 80) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
            }
        } else if (nivel == 7 && aciertos > 0 && aciertos <= 100) {
            porcentajeAciertos = (aciertos * 100) / 100;
            if (aciertos >= 90 && aciertos <= 100) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
            }
        } else if (nivel == 8 && aciertos > 0 && aciertos <= 120) {
            if (aciertos >= 108 && aciertos <= 120) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
            }
        } else if (nivel == 9 && aciertos > 0 && aciertos <= 140) {
            porcentajeAciertos = (aciertos * 100) / 140;
            if (aciertos >= 133 && aciertos <= 140) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
            }
        } else if (nivel == 10 && aciertos > 0 && aciertos == 200) {
            porcentajeAciertos = (aciertos * 100) / 200;
            if (aciertos == 200) {
                JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Suerte la proxima vez :C, no lograste obtener la cantidad minima de aciertos para superar el nivel.\n"
                    + "Vuelve a intentarlo con el boton iniciar");
            getElNivel();

        }
        return porcentajeAciertos;
    }


    /**
     * Establece el aumento del nivel dependiendo del nivel y de la cantidad de aciertos que tiene
     *
     * @return un entero de nivel
     * @version v.1.0.0 date 15/02/2022
     */
    public int aumentaNivel(int aciertos, int nivel) {
        if (nivel == 1 && aciertos >= 14 && aciertos <= 20) {
            elNivel = nivel + 1;

        } else if (nivel == 2 && aciertos >= 28 && aciertos <= 40) {
            elNivel = nivel + 1;

        } else if (nivel == 3 && aciertos >= 38 && aciertos <= 50) {

            elNivel = nivel + 1;
        } else if (nivel == 4 && aciertos >= 48 && aciertos <= 60) {

            elNivel = nivel + 1;
        } else if (nivel == 5 && aciertos >= 56 && aciertos <= 70) {

            elNivel = nivel + 1;
        } else if (nivel == 6 && aciertos >= 68 && aciertos <= 80) {

            elNivel = nivel + 1;
        } else if (nivel == 7 && aciertos >= 90 && aciertos <= 100) {

            elNivel = nivel + 1;
        } else if (nivel == 8 && aciertos >= 108 && aciertos <= 120) {

            elNivel = nivel + 1;
        } else if (nivel == 9 && aciertos >= 133 && aciertos <= 140) {

            elNivel = nivel + 1;
        } else if (nivel == 10 && aciertos == 200) {

            elNivel = nivel + 1;
        }
        return elNivel;
    }
}