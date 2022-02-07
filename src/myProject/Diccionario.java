package myProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class Diccionario{
    private ArrayList<String> diccionario = new ArrayList<String>();
    private int nivel = 0;

    public Diccionario(){
        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaFile();
    }

    public String get_Frase_In_Nivel_Correcta(int nivel) {
        if (nivel == 1) {
            for (int i = 0; i < 11; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(10)+1);
            }
        } else if (nivel == 2) {
            for (int i = 0; i < 21; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(20)+1);
            }

        } else if (nivel == 3) {
            for (int i = 0; i < 26; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(25) + 1);
            }

        } else if (nivel == 4) {
            for (int i = 0; i < 31; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(60) + 1);
            }

        } else if (nivel == 5) {
            for (int i = 0; i < 36; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(70) + 1);
            }

        } else if (nivel == 6) {
            for (int i = 0; i < 41; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(80) + 1);
            }

        } else if (nivel == 7) {
            for (int i = 0; i < 51; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(100) + 1);
            }

        } else if (nivel == 8) {
            for (int i = 0; i < 61; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(120) + 1);
            }

        } else if (nivel == 9) {
            for (int i = 0; i < 71; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(140) + 1);
            }

        } else if (nivel == 10) {
            for (int i = 0; i < 101; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(200) + 1);
            }

        }
        return "Fin";
    }

    public String get_Frase_in_Nivel(int nivel){
        if (nivel == 1) {
            for (int i = 0; i < 21; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(20)+1);
            }
        } else if (nivel == 2) {
            for (int i = 0; i < 21; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(20)+1);
            }

        } else if (nivel == 3) {
            for (int i = 0; i < 26; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(25) + 1);
            }

        } else if (nivel == 4) {
            for (int i = 0; i < 31; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(60) + 1);
            }

        } else if (nivel == 5) {
            for (int i = 0; i < 36; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(70) + 1);
            }

        } else if (nivel == 6) {
            for (int i = 0; i < 41; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(80) + 1);
            }

        } else if (nivel == 7) {
            for (int i = 0; i < 51; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(100) + 1);
            }

        } else if (nivel == 8) {
            for (int i = 0; i < 61; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(120) + 1);
            }

        } else if (nivel == 9) {
            for (int i = 0; i < 71; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(140) + 1);
            }

        } else if (nivel == 10) {
            for (int i = 0; i < 101; i++) {
                Random aleatorio = new Random();
                return diccionario.get(aleatorio.nextInt(200) + 1);
            }

        }
        return "Fin";
    }


}