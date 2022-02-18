package myProject;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;

/**
 * Esta clase es usada para el mandejo de archivos txt
 *
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class FileManager {
    public static final String PATH_WORDS = "src/myProject/diccionario.txt";
    public static final String PATH_USERS = "src/myProject/usuarios.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    /**
     * Establece un array list con las palabras del juego
     *
     * @return
     * @version v.1.0.0 date 02/02/2022
     */
    public ArrayList<String> lecturaFile() {
        ArrayList<String> frases = new ArrayList<String>();
        try {
            fileReader = new FileReader(PATH_WORDS);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                frases.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return frases;
    }

    /**
     * Escribe en el archivo de texto
     *
     * @version v.1.0.0 date 12/02/2022
     */
    public void escribirTexto(String linea, int nivel) {
        try{
            fileWriter = new FileWriter(PATH_USERS, true);
            output = new BufferedWriter(fileWriter);
            output.write(linea+" , ");
            output.write(String.valueOf(nivel));
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*public void escribirTexto_Con_Nivel(String linea,) {
        try {
            fileWriter = new FileWriter(PATH_USERS, true);
            output = new BufferedWriter(fileWriter);
            output.write(linea);
            //output.write(String.valueOf(nivel));
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    /**
     * Establece un array list con los nombres de los jugadores
     *
     * @return Array list de tipo String con los nombres de los jugadores
     * @version v.1.0.0 date 12/02/2022
     */
    public ArrayList<String> nombresJugadoresLectura() {
        ArrayList<String> users = new ArrayList<String>();
        try {
            fileReader = new FileReader(PATH_USERS);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                users.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return users;
    }


}
