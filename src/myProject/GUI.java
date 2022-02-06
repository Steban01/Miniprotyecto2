package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @version v.1.0.0 date:02/02/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class GUI extends JFrame {

    public static final String MENSAJE_INICIO = "Hola!!, bienvenido a I KNOW THAT WORD. \n" +
            "El juego consiste en presentar al jugador una secuencia de palabras de una en una, es decir,\n"
            + "";

    private Header headerProject;
    private Timer timer1, timer2;
    private Escucha escucha;
    private ModelUsuario modelUsuario;
    private JTextArea palabras;
    private JPanel panelUserName, panelNivel, separador;
    private JButton botonSalida, botonAyuda, botonSi, botonNo, botonJugar;


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
        botonSalida.addActionListener(escucha);
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
        botonAyuda.addActionListener(escucha);

        botonSi = new JButton("Si");
        botonSi.setPreferredSize(new Dimension(100, 45));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonSi, constraints);
        botonSi.setEnabled(false);

        botonSi.addActionListener(escucha);

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

        timer1 = new Timer(1000, escucha);


        timer2 = new Timer(7000, escucha);


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
    private class Escucha implements ActionListener {
        private int counter;

        public Escucha() {
            counter = 0;
        }

        Diccionario diccionario = new Diccionario();

        @Override
        public void actionPerformed(ActionEvent e) {
            timer1.start();

            if (e.getSource()==timer1) {
                    counter++;
                    if (counter <= 10) {
                        palabras.setText(diccionario.get_Frase_In_Nivel(1));
                    } else {
                        timer1.stop();
                        botonNo.setEnabled(true);
                        botonSi.setEnabled(true);
                    }

                } else {
                    timer1.start();
                    counter = 0;
                    botonJugar.setEnabled(false);
                    botonJugar.removeActionListener(escucha);
                }

            }


        }

    }






