package myProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430 - 3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class Diccionario{
    private ArrayList<String> diccionario = new ArrayList<>();
    private ArrayList<String> palabrasNivel = new ArrayList<>();
    private String palabra;
    private Diccionario palabras;
    private int nivel = 1;

    public Diccionario(){
        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaFile();
        palabra = "";

    }

    public String sacaPalabras(){
        if(nivel == 1){
            palabra = palabrasNivel.get(1);
        }
        return palabra;
    }

    public ArrayList<String> get_Frase(int nivel) {
        Random aleatorio = new Random();
    if (nivel == 1) {
        for (int i = 0; i < 10; i++) {
             palabrasNivel.add(diccionario.get(aleatorio.nextInt(10)));

        }
    }

    else if (nivel == 2) {
        for (int i = 0; i < 20 ; i++) {
            palabrasNivel.add(diccionario.get(aleatorio.nextInt(20)));

        }
    }

    else if (nivel == 3) {
        for (int i = 0; i < 25; i++) {
            palabrasNivel.add(diccionario.get(aleatorio.nextInt(25)));

        }

    }
    else if (nivel == 4) {
        for (int i = 0; i < 30; i++) {

            palabrasNivel.add(diccionario.get(aleatorio.nextInt(30)));
        }

    }
    else if (nivel == 5) {
        for (int i = 0; i < 36; i++) {
             palabrasNivel.add(diccionario.get(aleatorio.nextInt(36)));
        }

    } else if (nivel == 6) {
        for (int i = 0; i < 40; i++) {
             palabrasNivel.add(diccionario.get(aleatorio.nextInt(40)));
        }

    } else if (nivel == 7) {
        for (int i = 0; i < 50; i++) {
            palabrasNivel.add(diccionario.get(aleatorio.nextInt(50)));
        }

    }
    else if (nivel == 8) {
        for (int i = 0; i < 60; i++) {
            palabrasNivel.add(diccionario.get(aleatorio.nextInt(60)));
        }

    }
    else if (nivel == 9) {
        for (int i = 0; i < 70; i++) {
            palabrasNivel.add(diccionario.get(aleatorio.nextInt(70)));

        }

    }
    else if (nivel == 10) {
        for (int i = 0; i < 100; i++) {
            palabrasNivel.add(diccionario.get(aleatorio.nextInt(100)));
        }
    }
        return palabrasNivel;

}


    public ArrayList<String> get_Frase_in_Nivel(int nivel){
        Random aleatorio = new Random();
        if (nivel == 1){
            for (int i = 0; i < 20; i++) {

                palabrasNivel.add(diccionario.get(aleatorio.nextInt(20)));
            }
        } else if (nivel == 2) {
            for (int i = 0; i < 40; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(40)));
            }

        } else if (nivel == 3) {
            for (int i = 0; i < 50; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(50)));
            }

        } else if (nivel == 4) {
            for (int i = 0; i < 60; i++) {
                palabrasNivel.add( diccionario.get(aleatorio.nextInt(60)));
            }

        } else if (nivel == 5) {
            for (int i = 0; i < 70; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(70)));
            }

        } else if (nivel == 6) {
            for (int i = 0; i < 80; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(80)));

            }

        } else if (nivel == 7) {
            for (int i = 0; i < 100; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(100)));
            }

        } else if (nivel == 8) {
            for (int i = 0; i < 120; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(120)));
            }

        } else if (nivel == 9) {
            for (int i = 0; i < 140; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(140)));
            }

        } else if (nivel == 10) {
            for (int i = 0; i < 200; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(200)));
            }
        }
        return palabrasNivel;
    }



}