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
    private boolean Usuarioisthere;

    /**
     * Class Constructor
     */
    public ModelUsuario() {
        nivel = new ParaNivel();
        fileManager = new FileManager();

    }

    public String userName() {
        userName = JOptionPane.showInputDialog("Para iniciar el juego debes de ingresar tu usuarioh");
        return userName;
    }

    public String getUserName() {
        return userName;
    }

    /*public String concatenarElNivel(){

    }

    public Boolean busquedaUsername() {

    }*/


}

