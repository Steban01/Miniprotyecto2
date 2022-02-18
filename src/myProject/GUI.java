package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


/**
 * @version v.1.0.0 date:02/02/2022
 * @autor Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class GUI extends JFrame {

    public static final String MENSAJE_INICIO = "Hola!!, bienvenido a I KNOW THAT WORD. \n" +
            "Al darle el boton Start, comenzara a salir una serie de palabras a memorizar, es decir,\n"
            + "aparece una palabra, dura 5 segundos en pantalla, luego se borra y aparece la siguiente.\n"
            + "Después de memorizar las primeras palabras usted debera de darle click al boton play para que inicie la ronda de juego, donde sale\n"
            + "el doble de palabras que salieron al incicio.\n"
            + "Por cada una las palabras usted deberá indicar si la palabra estaba o no contenida en el\n"
            + "listado a memorizar y tendrá un tiempo de 7 segundos para responder, en caso de no hacerlo se tomará\n"
            + "como un error. En la imagen de al lado puedes ver la cantiadad de palabras que salen por nivel y los porcentajes minimos que debes de tener para pasar de nivel\n"
            + "¡¡Buena suerte :)!!";

    private Header headerProject;
    private Timer timer1, timer2;
    private int nivelNEW;
    private FileManager fileManager;
    private ImageIcon imageBotonIniciar, imageBotonSalir, imageBotonAyuda, imageBotonSi, imageBotonNo, imageBotonJugar, imageReglas, imageHeader;
    private String userName;
    private ModelPalabras words;
    private Escucha escucha;
    private ModelUsuario modelUsuario;
    private String show;
    private ParaNivel nivel;
    private JTextArea palabras;
    private JLabel labelUserName, labelNivel;
    private JPanel separador;
    private JButton botonSalida, botonAyuda, botonSi, botonNo, botonIniciar, botonJugar;
    private boolean validarU;

    public ArrayList<Boolean> getValidarUsuario() {
        return validarUsuario;
    }

    ArrayList<Boolean> validarUsuario = new ArrayList<>();

    /**
     * Constructor of GUI class
     */
    public GUI() {
        initGUI();
        //Default JFrame configuration
        this.setTitle("I know that word app");
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(255, 255, 255, 0));
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object
        escucha = new Escucha();
        words = new ModelPalabras();
        modelUsuario = new ModelUsuario();
        nivel = new ParaNivel();
        fileManager = new FileManager();

        //Set up JComponents
        headerProject = new Header("", Color.BLACK);
        headerProject.setPreferredSize(new Dimension(340, 24));
        ImageIcon imageHeader = new ImageIcon(getClass().getResource("/recursos/header.png"));
        headerProject.setIcon(imageHeader);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(headerProject, constraints);
        headerProject.setBackground(Color.WHITE);


        palabras = new JTextArea();
        palabras.setPreferredSize(new Dimension(300, 100));
        palabras.setEditable(false);
        palabras.setFont(new Font("Arial", Font.ITALIC, 40));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(palabras, constraints);

        labelUserName = new JLabel();
        labelUserName.setPreferredSize(new Dimension(100, 40));
        labelUserName.setHorizontalTextPosition(2);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(labelUserName, constraints);
        labelUserName.setBackground(new Color(255, 255, 255, 0));
        labelUserName.setOpaque(true);
        labelUserName.setForeground(Color.BLACK);
        labelUserName.setFont(new Font("Times new roman", Font.ITALIC, 15));
        labelUserName.setBorder(BorderFactory.createTitledBorder("UserName:"));

        labelNivel = new JLabel();
        labelNivel.setBorder(BorderFactory.createTitledBorder("Nivel:"));
        labelNivel.setFont(new Font("Times new roman", Font.BOLD, 15));
        labelNivel.setText(String.valueOf(nivel.getElNivel()));
        labelNivel.setPreferredSize(new Dimension(100, 35));
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(labelNivel, constraints);

        separador = new JPanel();
        separador.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(separador, constraints);

        botonSalida = new JButton("");
        botonSalida.setPreferredSize(new Dimension(100, 45));
        ImageIcon imageBotonsalir = new ImageIcon(getClass().getResource("/recursos/exit.jpeg"));
        botonSalida.setIcon(imageBotonsalir);
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(botonSalida, constraints);
        botonSalida.addMouseListener(escucha);

        botonAyuda = new JButton();
        botonAyuda.setPreferredSize(new Dimension(108, 45));
        ImageIcon imageBotonAyuda = new ImageIcon(getClass().getResource("/recursos/ayudaa.jpeg"));
        botonAyuda.setIcon(imageBotonAyuda);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(botonAyuda, constraints);
        botonAyuda.addMouseListener(escucha);

        botonSi = new JButton();
        botonSi.setPreferredSize(new Dimension(67, 72));
        ImageIcon imageBotonSi = new ImageIcon(getClass().getResource("/recursos/si.jpeg"));
        botonSi.setIcon(imageBotonSi);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonSi, constraints);
        botonSi.setEnabled(false);
        botonSi.addMouseListener(escucha);

        botonNo = new JButton();
        ImageIcon imageBotonNo = new ImageIcon(getClass().getResource("/recursos/no.jpeg"));
        botonNo.setIcon(imageBotonNo);
        botonNo.setPreferredSize(new Dimension(67, 72));
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(botonNo, constraints);
        botonNo.setEnabled(false);
        botonNo.addMouseListener(escucha);

        botonIniciar = new JButton();
        ImageIcon imageBotonIniciar = new ImageIcon(getClass().getResource("/recursos/comenzar.jpeg"));
        botonIniciar.setIcon(imageBotonIniciar);
        botonIniciar.setPreferredSize(new Dimension(119, 47));
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonIniciar, constraints);
        botonNo.setEnabled(false);
        botonIniciar.addMouseListener(escucha);

        botonJugar = new JButton();
        ImageIcon imageBotonJugar = new ImageIcon(getClass().getResource("/recursos/jugar.jpeg"));
        botonJugar.setIcon(imageBotonJugar);
        botonJugar.setPreferredSize(new Dimension(120, 45));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonJugar, constraints);
        botonJugar.setEnabled(false);
        botonJugar.addMouseListener(escucha);

        timer1 = new Timer(5000, escucha);
        timer2 = new Timer(7000, escucha);

        //Aca se verifica si el usuario es nuevo o antiguo
        userName = JOptionPane.showInputDialog("Para iniciar el juego debes de ingresar tu usuario");
        labelUserName.setText(userName);
        if (fileManager.lecturaJugadores().contains(userName) && userName != "") {
            JOptionPane.showMessageDialog(null, "Hola " + userName + " bienvenido de nuevo!!");
        } else{
            fileManager.escribirTexto_Con_Nivel(userName,nivel.getElNivel());
            JOptionPane.showMessageDialog(null, "Hola " + userName + ", bienvenido al juego I know that word, dale al boton ayuda para conocer mas sobre el juego",
                    "Game",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("/recursos/hola.jpeg")));
        }

    }

    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener, MouseListener {
        private int counter1, counter2, counter3, counter4;

        public Escucha() {
            counter1 = -1;
            counter2 = -1;
            counter3 = -1;
            counter4 = -1;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Random aleatorio = new Random();
            if (e.getSource() == timer1 && userName != " ") {
                counter1++;
                if (counter1 < words.getPalabrasMemorizar(nivel.getElNivel()).size()) {
                    counter2++;
                    if (counter2 < words.getPalabrasMemorizar(nivel.getElNivel()).size()) {
                        palabras.setText(words.getPalabrasMemorizar(nivel.getElNivel()).get(counter2));
                    }
                } else {
                    timer1.stop();
                    botonNo.setEnabled(true);
                    botonSi.setEnabled(true);
                    botonJugar.setEnabled(true);
                    botonJugar.addMouseListener(escucha);
                    counter1 = -1;
                    counter2 = -1;

                }
            }

            if (e.getSource() == timer2) {
                counter3++;
                if (counter3 < words.getPalabrasNivel(nivel.getElNivel()).size()) {
                    counter4++;
                    if (counter4 < words.getPalabrasNivel(nivel.getElNivel()).size()) {
                        palabras.setText(words.getPalabrasNivel(nivel.getElNivel()).get(counter4));
                    }
                } else {
                    timer2.stop();
                    puntaje();
                    nivel.aumentaNivel(nivel.getAciertos(), nivel.getElNivel());
                    JOptionPane.showMessageDialog(null, "Tu número de aciertos es:\n" + nivel.getAciertos() +
                            "\nTu porcentaje de aciertos es:\n" + nivel.calcularPorcentajeAciertos(nivel.getElNivel(), nivel.getAciertos()) + "%\n");
                    labelNivel.removeAll();
                    labelNivel.setText(String.valueOf(nivel.getElNivel()));
                    botonIniciar.addMouseListener(escucha);
                    botonIniciar.setEnabled(true);
                    botonNo.setEnabled(false);
                    botonSi.setEnabled(false);
                    botonJugar.setEnabled(false);
                    botonJugar.removeMouseListener(escucha);
                    words.getPalabrasMemorizar(nivel.getElNivel()).clear();
                    words.getPalabrasNivel(nivel.getElNivel()).clear();
                    validarUsuario.clear();
                    nivelNEW = nivel.getElNivel();
                    nivel.reiniciar_aciertos();
                    nivel.reiniciar_porcentaje_de_aciertos();
                    counter3 = -1;
                    counter4 = -1;

                }
            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == botonAyuda && e.getClickCount() == 1) {
                ImageIcon imageReglas = new ImageIcon(getClass().getResource("/recursos/reglas.jpeg"));
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO, "Bienvenido Jugador", JOptionPane.QUESTION_MESSAGE, imageReglas);
            }
            if (e.getSource() == botonSalida && e.getClickCount() == 1) {
                System.exit(0);
                fileManager.escribirTexto_Con_Nivel(userName,nivel.getElNivel());
            }
            //Verificacion para que el juego no inicie si el jugador no ha ingresado su nombre de usuario
            if (userName.isEmpty()){
                while (userName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Necesitas un nombre de usuario para continuar","ERROR",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("/recursos/errorU.jpeg")));
                    userName = JOptionPane.showInputDialog("Ingresa tu usuario");
                    labelUserName.removeAll();
                    labelUserName.setBackground(Color.WHITE);
                    labelUserName.setText(userName);
                    botonIniciar.setEnabled(true);
                }
                ImageIcon imageMessage = new ImageIcon(getClass().getResource("/recursos/hola.jpeg"));
                JOptionPane.showMessageDialog(null, "Hola " + userName + ", bienvenido al juego I know that word, dale al boton ayuda para conocer mas sobre el juego","Game",JOptionPane.INFORMATION_MESSAGE,imageMessage);
                fileManager.escribirTexto_Con_Nivel(userName, nivel.getElNivel());
            }
            if (e.getSource() == botonIniciar && e.getClickCount() == 1 && userName != null) {
                timer1.start();
                words.generarPalabrasNivel(nivel.getElNivel());
                //Para la visualicacion de las listas
                /*System.out.println(words.getPalabrasMemorizar(nivel.getElNivel()));
                System.out.println(words.getPalabrasNivel(nivel.getElNivel()));
                System.out.println(words.validarPalabra(nivel.getElNivel()));*/
                botonIniciar.removeActionListener(escucha);
                botonIniciar.setEnabled(false);

            }

            if (e.getSource() == botonJugar && e.getClickCount() == 1) {
                timer2.start();
                botonJugar.removeMouseListener(escucha);
                botonJugar.setEnabled(false);
            }

            if (e.getSource() == botonSi && e.getClickCount() == 1) {
                validarU = true;
                validarUsuario.add(validarU);
            }

            if (e.getSource() == botonNo && e.getClickCount() == 1) {
                validarU = false;
                validarUsuario.add(validarU);

            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }

    /**
     * Calcula el puntaje dependiendo de la validacion de las palabras, solo aumenta los aciertossi los booleanos coinciden
     *
     * @return el valor de tipo entero de los aciertos
     * @version v.1.0.0 date 13/02/2022
     */
    public int puntaje(){
        for (int i = 0; i < getValidarUsuario().size(); i++) {
            for (int a = 0; a < words.validarPalabra(nivel.getElNivel()).size(); a++) {
                if (getValidarUsuario().get(i) == words.validarPalabra(nivel.getElNivel()).get(a)) {
                    nivel.aumentarAciertos();
                    break;
                }
            }
        }
        return nivel.getAciertos();
    }
}
