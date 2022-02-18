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
     * @return
     * @version v.1.0.0 date 00/02/2022
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
     * @return
     * @version v.1.0.0 date 00/02/2022
     */
    public void escribirTexto(String linea) {
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
    }

    /**
     * @return
     * @version v.1.0.0 date 00/02/2022
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
