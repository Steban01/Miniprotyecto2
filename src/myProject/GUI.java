package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    private Escucha escucha;
    private ModelUsuario modelUsuario;
    private ParaNivel nivel;
    private int elNivel;
    private FileManager fileManager;
    private String userName;
    private ModelPalabras words;
    private JTextArea palabras;
    private JPanel panelUserName, panelNivel, separador;
    private JButton botonSalida, botonAyuda, botonSi, botonNo, botonJugar, botonPalabras;


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
        escucha = new Escucha();
        words = new ModelPalabras();
        modelUsuario = new ModelUsuario();
        nivel = new ParaNivel();
        fileManager = new FileManager();
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

        panelUserName = new JPanel();
        panelUserName.setBorder(BorderFactory.createTitledBorder("UserName: " + userName));
        panelUserName.setPreferredSize(new Dimension(100, 35));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(panelUserName, constraints);
        /*panelUserName.setBackground(Color.darkGray);
        panelUserName.setForeground(Color.WHITE);*/

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
        botonSalida.addMouseListener(escucha);
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
        botonAyuda.addMouseListener(escucha);

        botonSi = new JButton("Si");
        botonSi.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonSi, constraints);
        botonSi.setEnabled(false);
        botonSi.addMouseListener(escucha);

        botonNo = new JButton("No");
        botonNo.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(botonNo, constraints);
        botonNo.setEnabled(false);
        botonNo.addMouseListener(escucha);

        botonJugar = new JButton("Jugar");
        botonJugar.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonJugar, constraints);
        botonJugar.addMouseListener(escucha);

        botonPalabras = new JButton("a");
        botonPalabras.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonPalabras, constraints);
        botonNo.setEnabled(false);
        botonPalabras.addMouseListener(escucha);

        timer1 = new Timer(1000, escucha);
        timer2 = new Timer(2000, escucha);
        elNivel = nivel.getNivel();


        userName = JOptionPane.showInputDialog("Para iniciar el juego debes de ingresar tu usuario");
        JOptionPane.showMessageDialog(null, "Hola " + userName + ", bienvenido al juego I know that word, dale al boton ayuda para conocer mas sobre el juego");
        fileManager.escribirTexto(userName);
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
        private int counter, counter2;

        public Escucha() {
            counter = 0;
            counter2 = 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //words.generarPalabrasNivel(nivel.getNivel());
            System.out.println(words.getPalabrasMemorizar());
            Random aleatorio = new Random();
            if (e.getSource() == timer1 && userName!="") {
                counter++;
                if (counter < words.getPalabrasMemorizar().size()) {
                    //.out.println(words.getPalabrasMemorizar());
                    palabras.setText(words.getPalabrasMemorizar().get(aleatorio.nextInt(10)));
                } else {
                    timer1.stop();
                    botonNo.setEnabled(true);
                    botonSi.setEnabled(true);
                    botonPalabras.setEnabled(true);
                    botonPalabras.addMouseListener(escucha);
                }
            }

            if (e.getSource() == timer2) {
                counter2++;
                if (counter2 < words.getPalabrasNivel().size()) {
                    System.out.println(words.getPalabrasNivel());
                    palabras.setText(words.getPalabrasNivel().get(aleatorio.nextInt(20)));
                } else {
                    timer2.stop();
                    JOptionPane.showMessageDialog(null, "Tu puntaje es:\n" + words.puntaje());
                    counter2 = 0;
                    botonJugar.setEnabled(false);
                }
            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == botonAyuda && e.getClickCount() == 1) {
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            }
            if (e.getSource() == botonSalida && e.getClickCount() == 1) {
                System.exit(0);
            }
            if(userName.isEmpty()){
                botonJugar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Necesitas un nombre de usuario para continuar");
                userName = JOptionPane.showInputDialog("Ingresa tu usuario");
                while(userName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Necesitas un nombre de usuario para continuar");
                    userName = JOptionPane.showInputDialog("Ingresa tu usuario");
                    botonJugar.setEnabled(true);
                }
                JOptionPane.showMessageDialog(null, "Hola " + userName + ", bienvenido al juego I know that word, dale al boton ayuda para conocer mas sobre el juego");
                fileManager.escribirTexto(userName);

            }
            if (e.getSource() == botonJugar && e.getClickCount() == 1 && userName!=null) {
                timer1.start();
                words.generarPalabrasNivel(elNivel);
                botonJugar.removeActionListener(escucha);
                botonJugar.setEnabled(false);
            }

            if (e.getSource() == botonPalabras && e.getClickCount() == 1) {
                //Random aleatorio = new Random();
                timer2.start();
                botonPalabras.removeMouseListener(escucha);
                botonPalabras.setEnabled(false);
                //words.generarPalabrasNivel(nivel.getNivel());
                //palabras.setText(words.getPalabrasNivel().get(aleatorio.nextInt(20)));

            }
            if (e.getSource() == botonSi && e.getClickCount() == 1) {
                for (int i = 0; i < words.validarPalabra(elNivel).size(); i++){
                    System.out.println(words.validarPalabra(elNivel));
                    if (words.validarPalabra(elNivel).get(i) == true) {
                        words.puntaje();
                        break;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "NO es esa :(");
                    }
                }

                if (e.getSource() == botonNo && e.getClickCount() == 1) {
                    for (int i = 0; i < words.validarPalabra(elNivel).size(); i++) {
                        if(words.validarPalabra(elNivel).get(i)==false){
                        words.puntaje();
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NO es esa :(");
                        }
                    }
                }
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
}












