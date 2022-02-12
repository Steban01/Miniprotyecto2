package myProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430 - 3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class Diccionario {
    private ArrayList<String> diccionario = new ArrayList<>();
    private ArrayList<String> palabrasMemorizar = new ArrayList<>();
    private ArrayList<String> palabrasNivel = new ArrayList<>();
    private String palabra;
    private boolean validar;

    private Diccionario palabras;
    private int nivel = 1;

    public Diccionario() {
        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaFile();
        palabra = " ";

    }


    public ArrayList<String> palabras_a_memorizar(int nivel) {
        Random aleatorio = new Random();
        if (nivel == 1) {
            for (int i = 0; i < 10; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(10)));
            }
        } else if (nivel == 2) {
            for (int i = 0; i < 20; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(20)));
            }
        } else if (nivel == 3) {
            for (int i = 0; i < 25; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(25)));

            }
        } else if (nivel == 4) {
            for (int i = 0; i < 30; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(30)));


            }
        } else if (nivel == 5) {
            for (int i = 0; i < 35; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(36)));


            }

        } else if (nivel == 6) {
            for (int i = 0; i < 40; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(40)));


            }

        } else if (nivel == 7) {
            for (int i = 0; i < 50; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(50)));


            }

        } else if (nivel == 8) {
            for (int i = 0; i < 60; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(60)));


            }

        } else if (nivel == 9) {
            for (int i = 0; i < 70; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(70)));


            }

        } else if (nivel == 10) {
            for (int i = 0; i < 100; i++) {
                palabrasMemorizar.add(diccionario.get(aleatorio.nextInt(100)));


            }
        }
        return palabrasMemorizar;
    }



    public ArrayList<String> todas_las_palabras(int nivel) {
        Random aleatorio = new Random();
        if (nivel == 1) {
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
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(60)));

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

    public String recorrerLista(){
        for (int i = 0; i < 20; i++) {
            palabra = palabras_a_memorizar(1).get(i);
        }
        return palabra;
    }

    public boolean validarPalabra(){
        for (int i = 0; i <= todas_las_palabras(1).size(); i++) {
            if (todas_las_palabras(1).get(i).contains(recorrerLista())) {
                return validar = true;
            } else {
                return validar = false;
            }
        }
        return validar;
    }

    public static void main(String[] args) throws InterruptedException {
        int counter;
        counter = 0;
        String h = "Presunto, Cuatro, Asustar, Cuatro, Prevenir, Rifle, Presunto, Prevenir, Scam, Prevenir";
        String palabra;
        Boolean validar;
        Diccionario frase = new Diccionario();
        System.out.println("Palabras a memorizar: " + frase.palabras_a_memorizar(1));
        System.out.println("Todas las palabras: " + frase.todas_las_palabras(1));
        System.out.println("palabra " + frase.recorrerLista());


        for (int i = 0; i < 20; i++) {
            if (frase.todas_las_palabras(1).get(i).contains(frase.recorrerLista())) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }


    }

}



