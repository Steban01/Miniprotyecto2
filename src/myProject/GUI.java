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
            "Al darle el boton jugar, comenzaran a salir una serie de palabras a memorizar, es decir,\n"
            + "aparece una palabra, dura 5 segundos en pantalla, luego se borra y aparece la siguiente.\n"
            + "Usted debera de memorizar las palabras que salgan, despues de la serie de palabras a memorizar\n"
            + "el juego presentará un listado con el doble de palabras que se mostraron.\n"
            + "Por cada una las palabras usted deberá indicar si la palabra estaba o no contenida en el\n"
            + "listado a memorizar y tendrá un tiempo de 7 segundos para responder, en caso de no hacerlo se tomará\n"
            + "como un error.";

    private Header headerProject;
    private Timer timer1, timer2;
    private Escucha escucha1,escucha2;
    private ParaNivel nivel;
    private int elNivel;
    private int nivelNEW;
    private int aciertosNEW;
    private int errores;
    private FileManager fileManager;
    private ModelUsuario modelUsuario;
    private String userName;
    private ModelPalabras words;
    private JTextArea palabras;
    private JPanel panelNivel, separador;
    private JLabel labelUserName;
    private JButton botonSalida, botonAyuda, botonSi, botonNo, botonJugar, botonPalabras;
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
        //this.setSize(200, 100);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
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
        escucha2= new Escucha();
        escucha1 = new Escucha();
        words = new ModelPalabras();
        nivel = new ParaNivel();
        fileManager = new FileManager();
        modelUsuario = new ModelUsuario();
        //Set up JComponents
        headerProject = new Header("I know that word!!", Color.BLACK);
        headerProject.setFont(new Font("times new roman", Font.BOLD, 15));
        headerProject.setPreferredSize(new Dimension(200, 70));
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(headerProject, constraints);
        headerProject.setBackground(Color.darkGray);
        headerProject.setForeground(Color.WHITE);

        palabras = new JTextArea();
        palabras.setBorder(BorderFactory.createTitledBorder("Palabras: "));
        palabras.setPreferredSize(new Dimension(300, 200));
        palabras.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(palabras, constraints);

        labelUserName = new JLabel();
        //labelUserName.setBorder(BorderFactory.createTitledBorder("UserName: " + userName));
        labelUserName.setPreferredSize(new Dimension(100, 25));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(labelUserName, constraints);
        /*panelUserName.setBackground(Color.darkGray);
        panelUserName.setForeground(Color.WHITE);*/

        nivelNEW = 1;
        System.out.println("NIVEL INICIAL: " + nivel.getElNivel());
        panelNivel = new JPanel();
        panelNivel.setBorder(BorderFactory.createTitledBorder("Nivel: " + nivel.getNivel()));
        panelNivel.setPreferredSize(new Dimension(100, 35));
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(panelNivel, constraints);
        //panelUserName.setForeground(Color.WHITE);

        separador = new JPanel();
        separador.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        //this.add(separador, constraints);

        botonSalida = new JButton("Salir");
        botonSalida.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(botonSalida, constraints);
        botonSalida.addMouseListener(escucha1);
        //panelUserName.setBackground(Color.darkGray);
        //panelUserName.setForeground(Color.WHITE);

        botonAyuda = new JButton("Ayuda");
        botonAyuda.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(botonAyuda, constraints);
        botonAyuda.addMouseListener(escucha1);

        botonSi = new JButton("Si");
        botonSi.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonSi, constraints);
        botonSi.setEnabled(false);
        botonSi.addMouseListener(escucha1);

        botonNo = new JButton("No");
        botonNo.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(botonNo, constraints);
        botonNo.setEnabled(false);
        botonNo.addMouseListener(escucha1);

        botonJugar = new JButton("Inicio");
        botonJugar.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonJugar, constraints);
        botonJugar.addMouseListener(escucha1);

        botonPalabras = new JButton("Jugar");
        botonPalabras.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonPalabras, constraints);
        //botonPalabras.setEnabled(false);
        botonPalabras.addMouseListener(escucha2);

        timer1 = new Timer(1000, escucha1);
        timer2 = new Timer(1000, escucha2);

        userName = JOptionPane.showInputDialog("Para iniciar el juego debes de ingresar tu usuario");
        JOptionPane.showMessageDialog(null, "Hola " + userName + ", bienvenido al juego I know that word, dale al boton ayuda para conocer mas sobre el juego");
        //fileManager.escribirTexto(userName);
        labelUserName.setBorder(BorderFactory.createTitledBorder("UserName: "));
        labelUserName.setText(userName);
       if (fileManager.nombresJugadoresLectura().contains(userName)){
           JOptionPane.showMessageDialog(null, "Hola " +userName + " bienvenido de nuevo!!");
           //fileManager.nombresJugadoresLectura().add("hola");
        }
       else{
            fileManager.escribirTexto(userName);
            JOptionPane.showMessageDialog(null, "Hola " + userName + ", bienvenido al juego I know that word, dale al boton ayuda para conocer mas sobre el juego");
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
        private int counter, counter2, counter3, counter4, counter5, counter6;

        public Escucha() {
            counter = 0;
            counter2 = 0;
            counter3 = -1;
            counter4 = -1;
            counter5 = -1;
            counter6 = -1;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Random aleatorio = new Random();
            String palabra;
            palabra = " ";
            if (e.getSource() == timer1 ){
                counter++;
                if (counter < words.getPalabrasMemorizar(nivel.getElNivel()).size()){
                    counter3++;
                    palabras.setText(words.getPalabrasMemorizar(nivel.getElNivel()).get(counter3));
                }
            }else{
                timer1.stop();
               // words.getPalabrasMemorizar(nivel.getNivel()).clear();
                botonNo.setEnabled(true);
                botonSi.setEnabled(true);
                botonPalabras.setEnabled(true);
                botonPalabras.addMouseListener(escucha2);
                counter=0;
                counter3=0;
            }


            if (e.getSource() == timer2) {
                counter2++;
                if (counter2 < words.getPalabrasNivel(nivel.getElNivel()).size()) {
                    counter4++;
                    if (counter4 < words.getPalabrasNivel(nivel.getElNivel()).size()) {
                        palabras.setText(words.getPalabrasNivel(nivel.getElNivel()).get(counter4));
                    }

                }else{
                    timer2.stop();

                    JOptionPane.showMessageDialog(null, "Tu número de aciertos es:\n" + puntaje()
                            + "\nTu porcentaje de aciertos es:\n" + nivel.calcularPorcentajeAciertos(nivel.getAciertos()) + "%\n");
                    nivel.errores(nivel.getNivel(),nivel.getAciertos());
                    JOptionPane.showMessageDialog(null, "Tu numero de errores fueron: "+ nivel.getErrores());
                    nivel.aumentaNivel(nivel.getAciertos(),nivel.getNivel());
                    panelNivel.removeAll();
                    panelNivel.setBorder(BorderFactory.createTitledBorder("Nivel: " + nivel.getNivel()));

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("SE AUMENTO EL NIVEL(?"+nivel.aumentaNivel(nivel.getAciertos(),nivel.getNivel()));
                    System.out.println("NIVEL EN ESTE MOMENTO: " + nivel.getElNivel());
                    System.out.println("Aciertos: " + nivel.getAciertos());
                    System.out.println("---------------------------------------------------------------------");
                    words.getPalabrasMemorizar(nivel.getNivel()).clear();
                    words.getPalabrasNivel(nivel.getNivel()).clear();

                    //nivelNEW = nivel.getNivel();
                    botonJugar.addMouseListener(escucha1);
                    botonJugar.setEnabled(true);
                    botonNo.setEnabled(false);
                    botonSi.setEnabled(false);
                    botonNo.removeMouseListener(escucha1);
                    botonSi.removeMouseListener(escucha1);
                    counter2=0;
                    counter4=0;
                    /*words.generarPalabrasNivel(nivel.getNivel());
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("ACA SE USA EL GET NIVEL");
                    System.out.println(words.getPalabrasMemorizar(nivel.getNivel()));
                    System.out.println(words.getPalabrasNivel(nivel.getNivel()));
                    System.out.println("---------------------------------------------------------------------");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("ACA SE USA EL GET EL NIVEL");
                    System.out.println(words.getPalabrasMemorizar(nivel.getElNivel()));
                    System.out.println(words.getPalabrasNivel(nivel.getElNivel()));
                    System.out.println("---------------------------------------------------------------------");*/
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == botonAyuda && e.getClickCount() == 1) {
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            }
            if (userName.isEmpty()) {
                botonJugar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Necesitas un nombre de usuario para continuar");
                userName = JOptionPane.showInputDialog("Ingresa tu usuario");
                while (userName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Necesitas un nombre de usuario para continuar");
                    userName = JOptionPane.showInputDialog("Ingresa tu usuario");
                    botonJugar.setEnabled(true);
                }
                //Verifica si ese nombre de usuario ya estaba registrado
                if (fileManager.nombresJugadoresLectura().contains(userName)) {
                    for (int i = 0; i < fileManager.nombresJugadoresLectura().size(); i++){
                        if (fileManager.nombresJugadoresLectura().get(i) == userName) {
                            JOptionPane.showMessageDialog(null, "Hola " + userName + "bienvenido de nuevo!!");
                        }
                    }
                } else {
                    fileManager.escribirTexto(userName);
                    JOptionPane.showMessageDialog(null, "Hola " + userName + ", bienvenido al juego I know that word, dale al boton ayuda para conocer mas sobre el juego");
                }
            }

            if (e.getSource() == botonSalida) {
                System.exit(0);
                fileManager.escribirTexto(userName);

            }
            if (e.getSource() == botonJugar && e.getClickCount() == 1 && userName != null ) {
                timer1.start();
                words.generarPalabrasNivel(nivel.getElNivel());
                botonJugar.removeActionListener(escucha1);
                botonJugar.setEnabled(false);
                counter = 0;
                counter3=0;
               // System.out.println("---------------------------------------------------------------------");
                System.out.println("QUE MONDA DE NIVEL ENTRA ACA: " + nivel.getElNivel());
               System.out.println(words.getPalabrasMemorizar(nivel.getElNivel()));
                System.out.println(words.getPalabrasNivel(nivel.getElNivel()));
               // System.out.println(words.validarPalabra(nivel.getElNivel()));
               // System.out.println("---------------------------------------------------------------------");

            }
            /*if (e.getSource() == botonJugar && e.getClickCount() ==2 && userName != null) {
                timer1.start();
                words.generarPalabrasNivel(nivel.getElNivel());
                System.out.println("---------------------------------------------------------------------");
                System.out.println("QUE MONDA DE NIVEL ENTRA ACA doble click: " + nivel.getElNivel());
                System.out.println(words.getPalabrasMemorizar(nivel.getElNivel()));
                System.out.println(words.getPalabrasNivel(nivel.getElNivel()));
                System.out.println(words.validarPalabra(nivel.getElNivel()));
                System.out.println("---------------------------------------------------------------------");
                botonJugar.removeActionListener(escucha);
                botonJugar.setEnabled(false);
                counter = 0;
            }*/
            if (e.getSource() == botonPalabras) {
                timer2.start();
                botonPalabras.removeMouseListener(escucha2);
                botonPalabras.setEnabled(false);
                counter2 = 0;

            }
            if (e.getSource() == botonSi) {
                validarU = true;
                validarUsuario.add(validarU);
            }


            if (e.getSource() == botonNo) {
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

    public int puntaje(){
        for (int i = 0; i < getValidarUsuario().size(); i++) {
            for (int a = 0; a < words.getPalabrasMemorizar(nivel.getNivel()).size(); a++) {
                if (getValidarUsuario().get(i) == words.validarPalabra(nivel.getNivel()).get(a)) {
                    nivel.aumentarAciertos();
                    break;
                }
            }
        }
        return nivel.getAciertos();
    }
}