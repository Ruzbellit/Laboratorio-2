/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentresejuego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ruzbe
 */
public class GUIConcentrese extends JFrame {

    //componentes de la GUI
    Container contenPPal;
    JPanel pArriba, pAMenu, pAOpcion, pCentro, pAbajo;
    JMenuBar barra;
    JMenu menu;
    JMenuItem salirJuego;
    JMenuItem volverJugar;
    JMenuItem ayuda;
    JMenuItem mosEstadisticas;
    JComboBox<String> listDesplegable;
    JButton bIniciar;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
    JLabel lVidas, lFallos, lAciertos;

    String rutaImagenesTema = "1/";

    public GUIConcentrese() {
        pArriba = new JPanel();
        pAMenu = new JPanel();//
        pAOpcion = new JPanel();
        pCentro = new JPanel();
        pAbajo = new JPanel();

        barra = new JMenuBar();
        menu = new JMenu("Menu");
        salirJuego = new JMenuItem("Salir del Juego");
        volverJugar = new JMenuItem("Volver a jugar");
        mosEstadisticas = new JMenuItem("Mostrar estadisticas");
        ayuda = new JMenuItem("Ayuda");
        listDesplegable = new JComboBox<>();

        bIniciar = new JButton("Iniciar Juego");
        b1 = new JButton("");
        b2 = new JButton("");
        b3 = new JButton("");
        b4 = new JButton("");
        b5 = new JButton("");
        b6 = new JButton("");
        b7 = new JButton("");
        b8 = new JButton("");
        b9 = new JButton("");
        b10 = new JButton("");
        b11 = new JButton("");
        b12 = new JButton("");
        b13 = new JButton("");
        b14 = new JButton("");
        b15 = new JButton("");
        b16 = new JButton("");

        lVidas = new JLabel("Vidas: ");
        lFallos = new JLabel("Fallos: ");
        lAciertos = new JLabel("Aciertos: ");

        pArriba.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 2), ""));
        pAMenu.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 1), ""));
        pAOpcion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 1), ""));
        pCentro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 4), "Concentrese"));
        pAbajo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 2), ""));

        b1.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b2.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b3.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b4.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b5.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b6.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b7.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b9.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b10.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b11.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b12.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b13.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b14.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b15.setIcon(new ImageIcon(getClass().getResource("1/0.png")));
        b16.setIcon(new ImageIcon(getClass().getResource("1/0.png")));

        /*
        b1.setIcon(new ImageIcon(getClass().getResource("01/01.png")));
        b2.setIcon(new ImageIcon(getClass().getResource("01/02.png")));
        b3.setIcon(new ImageIcon(getClass().getResource("01/03.png")));
        b4.setIcon(new ImageIcon(getClass().getResource("01/04.png")));
        b5.setIcon(new ImageIcon(getClass().getResource("01/05.png")));
        b6.setIcon(new ImageIcon(getClass().getResource("01/06.png")));
        b7.setIcon(new ImageIcon(getClass().getResource("01/07.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("01/08.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("01/08.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("01/08.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("01/08.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("01/08.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("01/08.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("01/08.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("01/08.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("01/08.png")));
         */
        pArriba.setLayout(new BorderLayout());
        pAMenu.setLayout(new FlowLayout(25));
        pAOpcion.setLayout(new GridLayout(1, 2, 5, 2));
        pArriba.add(pAMenu, BorderLayout.NORTH);
        pArriba.add(pAOpcion, BorderLayout.CENTER);
        pCentro.setLayout(new GridLayout(4, 4, 2, 2));
        pAbajo.setLayout(new FlowLayout(25));

        pAMenu.add(barra);
        barra.add(menu);
        menu.add(salirJuego);
        menu.add(volverJugar);
        menu.add(mosEstadisticas);
        menu.add(ayuda);
        pAOpcion.add(listDesplegable);
        pAOpcion.add(bIniciar);
        pAbajo.add(lVidas);
        pAbajo.add(lFallos);
        pAbajo.add(lAciertos);

        listDesplegable.addItem("Elegir tema");
        listDesplegable.addItem("Pricesas disney");
        listDesplegable.addItem("Florecitas");
        listDesplegable.addItem("Animalitos");

        pCentro.add(b1);
        pCentro.add(b2);
        pCentro.add(b3);
        pCentro.add(b4);
        pCentro.add(b5);
        pCentro.add(b6);
        pCentro.add(b7);
        pCentro.add(b8);
        pCentro.add(b9);
        pCentro.add(b10);
        pCentro.add(b11);
        pCentro.add(b12);
        pCentro.add(b13);
        pCentro.add(b14);
        pCentro.add(b15);
        pCentro.add(b16);

        contenPPal = getContentPane();
        contenPPal.setLayout(new BorderLayout());
        contenPPal.add(pArriba, BorderLayout.NORTH);
        contenPPal.add(pCentro, BorderLayout.CENTER);
        contenPPal.add(pAbajo, BorderLayout.SOUTH);

        //listener y manejo de eventos
        ManejaEventos eventos = new ManejaEventos();
        bIniciar.addActionListener(eventos);

        b1.addActionListener(eventos);
        b2.addActionListener(eventos);
        b3.addActionListener(eventos);
        b4.addActionListener(eventos);
        b5.addActionListener(eventos);
        b6.addActionListener(eventos);
        b7.addActionListener(eventos);
        b8.addActionListener(eventos);
        b9.addActionListener(eventos);
        b10.addActionListener(eventos);
        b11.addActionListener(eventos);
        b12.addActionListener(eventos);
        b13.addActionListener(eventos);
        b14.addActionListener(eventos);
        b15.addActionListener(eventos);
        b16.addActionListener(eventos);

        ayuda.addActionListener(eventos);

        setTitle("Juego Concentrese");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GUIConcentrese concentrese = new GUIConcentrese();
    }

    class ManejaEventos implements ActionListener {

        ConcentreseJuego juego;

        public ManejaEventos() {
            juego = new ConcentreseJuego();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == bIniciar) {
                lAciertos.setText("Aciertos: " + juego.aciertos);
                juego.iniciarJuego();
            } else if (ae.getSource() == b1) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(0, 0) + ".png";
                b1.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b2) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(0, 1) + ".png";
                b2.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b3) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(0, 2) + ".png";
                b3.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b4) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(0, 3) + ".png";
                b4.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b5) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(1, 0) + ".png";
                b5.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b6) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(1, 1) + ".png";
                b6.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b7) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(1, 2) + ".png";
                b7.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b8) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(1, 3) + ".png";
                b8.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b9) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(2, 0) + ".png";
                b9.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b10) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(2, 1) + ".png";
                b10.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b11) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(2, 2) + ".png";
                b11.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b12) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(2, 3) + ".png";
                b12.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b13) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(3, 0) + ".png";
                b13.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b14) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(3, 1) + ".png";
                b14.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b15) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(3, 2) + ".png";
                b15.setIcon(new ImageIcon(getClass().getResource(ruta)));
            } else if (ae.getSource() == b16) {
                String ruta = rutaImagenesTema + juego.destaparCasilla(3, 3) + ".png";
                b16.setIcon(new ImageIcon(getClass().getResource(ruta)));
            }
        }
    }

}
