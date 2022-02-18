package myProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;


/**
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430 - 3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class ModelPalabras {
    private ArrayList<String> diccionario = new ArrayList<>();
    private ArrayList<String> palabrasMemorizar = new ArrayList<>();
    private ArrayList<String> palabrasMemorizar_reset = new ArrayList<>();
    private ArrayList<String> palabrasNivel = new ArrayList<>();
    private ArrayList<String> palabrasNivel_reset = new ArrayList<>();
    private Timer timer3, timer2;
    private int aciertos;
    private boolean validar;
    private boolean validar2;
    private GUI interfaz;
    private ParaNivel nivell;
    private ModelPalabras palabras;

    /**
     * Constructor of GUI class
     */
    public ModelPalabras() {
        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaFile();
    }


    /**
     * Llama a las funciones que generan las palabras de cada nivel, ya sean la de memorizar o todas las palabras
     *
     * @return
     * @version v.1.0.0 date 11/02/2022
     */

    public void generarPalabrasNivel(int nivel) {
        palabrasMemorizar.clear();
        palabrasNivel.clear();
        todas_las_palabras(nivel);
        palabras_a_memorizar(nivel);
    }

    /**
     * Genera el array de las palabras a memorizar
     *
     * @return el array de palabras a memorizar
     * @version v.1.0.0 date 11/02/2022
     */
    public ArrayList<String> getPalabrasMemorizar(int nivel) {
        return palabrasMemorizar;
    }

    /**
     * Obtiene el array de las palabras completas (las a memorizar junto con las otras)
     *
     * @return el array de las palabras totales del nivel
     * @version v.1.0.0 date 11/02/2022
     */
    public ArrayList<String> getPalabrasNivel(int nivel) {
        return palabrasNivel;
    }

    /**
     * Genera los arrays de las palabras a memorizar dependiendo de su nivel
     *
     * @version v.1.0.0 date 11/02/2022
     */
    private void palabras_a_memorizar(int nivel) {
        Random aleatorio = new Random();
        if (nivel == 1) {
            for (int i = 0; i < 10; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));
            }
        } else if (nivel == 2) {
            palabrasMemorizar.clear();
            for (int i = 0; i < 20; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));
            }
        } else if (nivel == 3) {
            for (int i = 0; i < 25; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));

            }
        } else if (nivel == 4) {
            for (int i = 0; i < 30; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));


            }
        } else if (nivel == 5) {
            for (int i = 0; i < 35; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));
            }

        } else if (nivel == 6) {
            for (int i = 0; i < 40; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));

            }

        } else if (nivel == 7) {
            for (int i = 0; i < 50; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));

            }

        } else if (nivel == 8) {
            for (int i = 0; i < 60; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));
            }

        } else if (nivel == 9) {
            for (int i = 0; i < 70; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));
            }

        } else if (nivel == 10) {
            for (int i = 0; i < 100; i++) {
                palabrasMemorizar.add(palabrasNivel.get(aleatorio.nextInt(palabrasNivel.size())));
            }
        }
    }

    /**
     * Genera los arrays de todas las palabras dependiendo de su nivel
     *
     * @version v.1.0.0 date 11/02/2022
     */
    private void todas_las_palabras(int nivel) {
        Random aleatorio = new Random();
        if (nivel == 1) {
            for (int i = 0; i < 20; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));
            }

        } else if (nivel == 2) {
            for (int i = 0; i < 40; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));
            }

        } else if (nivel == 3) {
            for (int i = 0; i < 50; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));

            }

        } else if (nivel == 4) {
            for (int i = 0; i < 60; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));

            }

        } else if (nivel == 5) {
            for (int i = 0; i < 70; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));

            }

        } else if (nivel == 6) {
            for (int i = 0; i < 80; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));

            }

        } else if (nivel == 7) {
            for (int i = 0; i < 100; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));

            }

        } else if (nivel == 8) {
            for (int i = 0; i < 120; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));

            }

        } else if (nivel == 9) {
            for (int i = 0; i < 140; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));

            }

        } else if (nivel == 10) {
            for (int i = 0; i < 200; i++) {
                palabrasNivel.add(diccionario.get(aleatorio.nextInt(diccionario.size())));
            }
        }
    }

    /**
     * Valida por cada nivel si la palabra que esta en el array de palabras a memorizar hace parte del array de palabras del nivel
     *
     * @return array de booleanos con las palabras verificadas
     * @version v.1.0.0 date 12/02/2022
     */
    public ArrayList<Boolean> validarPalabra(int nivel) {
        ArrayList<Boolean> validar = new ArrayList<Boolean>();
        boolean validar2;
        if (nivel == 1) {
            for (int i = 0; i < 20; i++) {
                validar2 = false;
                for (int a = 0; a < 10; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }

        }
        if (nivel == 2) {
            for (int i = 0; i < 40; i++) {
                validar2 = false;
                for (int a = 0; a < 20; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }

        }
        if (nivel == 3) {
            for (int i = 0; i < 50; i++) {
                validar2 = false;
                for (int a = 0; a < 25; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }

        }
        if (nivel == 4) {
            for (int i = 0; i < 60; i++) {
                validar2 = false;
                for (int a = 0; a < 30; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }

        }
        if (nivel == 5) {
            for (int i = 0; i < 70; i++) {
                validar2 = false;
                for (int a = 0; a < 35; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }

        }
        if (nivel == 6) {
            for (int i = 0; i < 80; i++) {
                validar2 = false;
                for (int a = 0; a < 40; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }

        }
        if (nivel == 7) {
            for (int i = 0; i < 100; i++) {
                validar2 = false;
                for (int a = 0; a < 50; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }

        }
        if (nivel == 8) {
            for (int i = 0; i < 120; i++) {
                validar2 = false;
                for (int a = 0; a < 60; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }

        }
        if (nivel == 9) {
            for (int i = 0; i < 140; i++) {
                validar2 = false;
                for (int a = 0; a < 70; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }

        }
        if (nivel == 10) {
            for (int i = 0; i < 200; i++) {
                validar2 = false;
                for (int a = 0; a < 100; a++) {
                    if (palabrasNivel.get(i).equals(palabrasMemorizar.get(a))) {
                        validar2 = true;
                        break;
                    }
                }
                validar.add(i, validar2);
            }


        }
        return validar;
    }


}



