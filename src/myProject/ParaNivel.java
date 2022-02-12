package myProject;
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
    public ParaNivel(){
        nivel = 1;
        aciertos = 0;
    }

    public int getNivel() {
        return nivel;
    }

    public int aumentarNivel(){
        nivel = nivel + 1;
        return nivel;
    }

    public void finalizarPartida(){
        if(nivel<=10){
            if(aciertos == 14){
                porcentajeAciertos = (aciertos*100)/20; //calcula el porcentaje dependiendo de los aciertos
                aumentarNivel();
            }
            if(aciertos == 28){
                porcentajeAciertos = (aciertos*100)/40;
                aumentarNivel();
            }
            if(aciertos == 38){
                porcentajeAciertos = (aciertos*100)/50;
                aumentarNivel();
            }
            if(aciertos == 48){
                porcentajeAciertos = (aciertos*100)/60;
                aumentarNivel();
            }
            if(aciertos == 56){
                porcentajeAciertos = (aciertos*100)/70;
                aumentarNivel();
            }
            if(aciertos == 68){
                porcentajeAciertos = (aciertos*100)/80;
                aumentarNivel();
            }
            if(aciertos == 90){
                porcentajeAciertos = (aciertos*100)/100;
                aumentarNivel();
            }
            if(aciertos == 108){
                porcentajeAciertos = (aciertos*100)/120;
                aumentarNivel();
            }
            if(aciertos == 133){
                porcentajeAciertos = (aciertos*100)/140;
                aumentarNivel();
            }
            if(aciertos == 100){
                porcentajeAciertos = (aciertos*100)/200;
                aumentarNivel();
            }
        }
    }


}
