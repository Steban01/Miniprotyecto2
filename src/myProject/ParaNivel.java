package myProject;
import java.util.ArrayList;
import java.util.Random;

/**
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430 - 3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class paraNivel {
    private String palabra;
    private int nivel;
    private boolean validar;
    private Diccionario words;
    private FileManager unaPalabra;


    /**
     * Constructor of GUI class
     */
    public paraNivel(){
        palabra= "";
        validar = false;
        nivel = 1;
    }


   /*public boolean validarPalabra(){

        for(int i=0; i < words.get_Frase_in_Nivel(nivel).size();i++){
            if(words.get_Frase_in_Nivel(nivel).get(i) == words.get_Frase(nivel)){
                validar = true;

            }
            else{
                validar = false;
            }

        }
    }*/

}
