/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentresejuego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
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
    JButton botones[] = new JButton[16];// b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
    JLabel lVidas, lFallos, lAciertos;

    String rutaTemaImagenes = "1/";

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
        for (int x = 0; x < 16; x++) {
            botones[x] = new JButton("");
        }

        lVidas = new JLabel("Vidas: ");
        lFallos = new JLabel("Fallos: ");
        lAciertos = new JLabel("Aciertos: ");

        pArriba.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 2), ""));
        pAMenu.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 1), ""));
        pAOpcion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 1), ""));
        pCentro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 4), "Concentrese"));
        pAbajo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 2), ""));

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
        for (int x = 0; x < 16; x++) {
            pCentro.add(botones[x]);
        }

        contenPPal = getContentPane();
        contenPPal.setLayout(new BorderLayout());
        contenPPal.add(pArriba, BorderLayout.NORTH);
        contenPPal.add(pCentro, BorderLayout.CENTER);
        contenPPal.add(pAbajo, BorderLayout.SOUTH);

        //listener y manejo de eventos
        ManejaEventos eventos = new ManejaEventos();
        bIniciar.addActionListener(eventos);

        for (int x = 0; x < 16; x++) {
            botones[x].addActionListener(eventos);
        }
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

        public void actualizarJuego() {
            lAciertos.setText("Aciertos: " + juego.aciertos);
            lFallos.setText("Fallos: " + juego.fallos);
            lVidas.setText("Vidas: " + juego.vidas);

            int b = 0;
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    if (juego.estadoCasilla(x, y)) {
                        botones[b].setIcon(new ImageIcon(getClass().getResource(rutaTemaImagenes + juego.imagenCasilla(x, y) + ".png")));
                    } else {
                        botones[b].setIcon(new ImageIcon(getClass().getResource(rutaTemaImagenes + 0 + ".png")));
                    }
                    b++;
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == bIniciar) {
                juego.iniciarJuego();
                actualizarJuego();
            } else {
                int x = 0;
                int y = 0;
                for (int b = 0; b < 16; b++) {
                    if (ae.getSource() == botones[b]) {
                        juego.destaparCasilla(x, y);
                        actualizarJuego();
                        break;
                    }
                    y++;
                    if (y == 4) {
                        x++;
                        y = 0;
                    }
                }
            }
        }
    }

}
