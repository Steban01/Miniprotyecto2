package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
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
    private Diccionario words;
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
        Diccionario diccionario = new Diccionario();
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object
        escucha = new Escucha();

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
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(palabras, constraints);

        panelUserName = new JPanel();
        panelUserName.setBorder(BorderFactory.createTitledBorder("UserName: "));
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
        panelNivel.setBorder(BorderFactory.createTitledBorder("Nivel: "));
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
        this.add(separador, constraints);

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
        botonNo.addActionListener(escucha);

        botonJugar = new JButton("Jugar");
        botonJugar.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonJugar, constraints);
        botonJugar.addActionListener(escucha);

        botonPalabras = new JButton("Ronda de palabras");
        botonPalabras.setPreferredSize(new Dimension(100, 45));
        this.add(botonPalabras, constraints);
        palabras.add(botonPalabras);
        botonPalabras.addActionListener(escucha);

        timer1 = new Timer(1500, escucha);

        timer2 = new Timer(1500, escucha);


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

        Diccionario words = new Diccionario();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == timer1) {
                counter++;
                if (counter <= 10) {
                    palabras.setText("xd");
                } else {
                    timer1.stop();
                    botonNo.setEnabled(true);
                    botonSi.setEnabled(true);
                    botonJugar.setEnabled(false);
                    timer1.restart();
                    counter2++;
                    if (counter2 <= 20) {
                        palabras.setText("a");//words.get_Frase_in_Nivel(1));
                    } else {
                        timer1.stop();
                        counter2 = 0;
                        botonJugar.setEnabled(true);
                    }
                }
            } else {
                timer1.start();
                counter = 0;
                botonJugar.removeActionListener(escucha);
            }
            /*if(counter==11){
                timer1.restart();
                counter = 0;
                counter++;
                if(counter<21){
                    palabras.setText(diccionario.get_Frase_in_Nivel(1));
                }
                else{
                    timer1.stop();
                }
                timer1.stop();
            }
             */
            /*if (e.getSource() == timer2) {
                timer2.start();
                counter++;
                if (counter <21) {
                    palabras.setText(diccionario.get_Frase_in_Nivel(1));
                }else {
                    timer2.stop();

                }
            }else{
                timer2.start();
                counter = 0;
                botonJugar.setEnabled(false);
                botonJugar.removeActionListener(escucha2);
            }*/
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == botonAyuda && e.getClickCount() == 1) {
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            }
            if (e.getSource() == botonSalida && e.getClickCount() == 1) {
                System.exit(0);
            }
            if (e.getSource() == botonNo && e.getClickCount() == 1 && words.validarPalabra() == false) {

            }
            if (e.getSource() == botonSi && e.getClickCount() == 1 && words.validarPalabra() == true) {

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












