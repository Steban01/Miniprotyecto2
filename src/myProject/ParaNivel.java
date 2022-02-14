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
    private int porcentajeAciertos;

    /**
     * Constructor of GUI class
     */
    public ParaNivel() {
        nivel = 1;
        aciertos = 0;
    }

    public int getNivel() {
        return nivel;
    }

    public int aumentarNivel() {
        nivel = nivel + 1;
        return nivel;
    }

    public int aumentarAciertos() {
        aciertos = aciertos + 1;
        return aciertos;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int calcularPorcentajeAciertos(int aciertos) {
        if (aciertos >= 14 && aciertos < 28) {
            porcentajeAciertos = (aciertos * 100) / 20; //calcula el porcentaje dependiendo de los aciertos
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        if (aciertos >= 28 && aciertos < 38) {
            porcentajeAciertos = (aciertos * 100) / 40;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        if (aciertos >= 38 && aciertos < 48) {
            porcentajeAciertos = (aciertos * 100) / 50;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        if (aciertos >= 48 && aciertos < 56) {
            porcentajeAciertos = (aciertos * 100) / 60;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        if (aciertos >= 56 && aciertos < 68) {
            porcentajeAciertos = (aciertos * 100) / 70;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        if (aciertos >= 68 && aciertos < 90) {
            porcentajeAciertos = (aciertos * 100) / 80;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        if (aciertos >= 90 && aciertos < 108) {
            porcentajeAciertos = (aciertos * 100) / 100;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        if (aciertos >= 108 && aciertos < 133) {
            porcentajeAciertos = (aciertos * 100) / 120;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        if (aciertos >= 133 && aciertos < 200) {
            porcentajeAciertos = (aciertos * 100) / 140;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        if (aciertos == 200) {
            porcentajeAciertos = (aciertos * 100) / 200;
            JOptionPane.showMessageDialog(null, "Lograste superar la cantidad minima de aciertos para pasar de nivel");
        }
        return porcentajeAciertos;

    }

    public void finalizarPartida(int nivel, int aciertos) {
        if (nivel <= 10) {
            if (aciertos == 14) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
            if (aciertos == 28) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
            if (aciertos == 38) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
            if (aciertos == 48) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
            if (aciertos == 56) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
            if (aciertos == 68) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
            if (aciertos == 90) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
            if (aciertos == 108) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
            if (aciertos == 133) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
            if (aciertos == 100) {
                calcularPorcentajeAciertos(aciertos);
                aumentarNivel();
            }
        }
    }


}
