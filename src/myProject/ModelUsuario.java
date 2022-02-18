package myProject;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @version v.1.0.0 date: 08/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430 - 3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class ModelUsuario {
    private String userName;
    private FileManager fileManager;
    private ParaNivel nivel;

    /**
     * Class Constructor
     */
    public ModelUsuario() {
        nivel = new ParaNivel();
        fileManager = new FileManager();

    }

    /**
     * Escribe el userName del usuario
     *
     * @return un entero de nivel
     * @version v.1.0.0 date 13/02/2022
     */
    public String userName() {
        fileManager.escribirTexto_Con_Nivel(userName, nivel.getElNivel());
        return userName;
    }

    /**
     * Obtiene el userName del usuario
     *
     * @return un entero de nivel
     * @version v.1.0.0 date 13/02/2022
     */
    public String getUserName(){
        return userName;
    }
}

