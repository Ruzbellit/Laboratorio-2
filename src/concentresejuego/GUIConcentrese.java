/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentresejuego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Timer;
import java.util.TimerTask;
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
    JButton botones[] = new JButton[16];
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
        listDesplegable.addItem("Lenguajes de Programacion");
        listDesplegable.addItem("Princesas disney");
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
        listDesplegable.addItemListener(eventos);
        ayuda.addActionListener(eventos);
        mosEstadisticas.addActionListener(eventos);

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

    class ManejaEventos implements ActionListener, ItemListener {

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
                        botones[b].setEnabled(true);
                    } else {                        
                        botones[b].setIcon(new ImageIcon(getClass().getResource(rutaTemaImagenes + 0 + ".png")));
                        //botones[b].setEnabled(false);
                    }
                    b++;
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == bIniciar && listDesplegable.getSelectedIndex() != 0) {
                iniciarJuego();
            } else if (ae.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, juego.mostrarAyuda());
            } else if (ae.getSource() == mosEstadisticas) {
                JOptionPane.showMessageDialog(null, juego.mostrarEstadisticas());
            } else {
                int x = 0;
                int y = 0;
                for (int b = 0; b < 16; b++) {
                    if (ae.getSource() == botones[b]) {
                        juego.destaparCasilla(x, y);
                        actualizarJuego();
                        if (juego.getParCasillasDestapadas()) {
                            juego.compararCasillas();
                            vistaParejaCasillas();
                            switch (juego.getEstadoJuego()) {
                                case 0: //perdio el juego
                                    JOptionPane.showMessageDialog(null, "Juego perdido");
                                    iniciarJuego();
                                    break;
                                case 1: //gano la partida
                                    JOptionPane.showMessageDialog(null, "Juego Ganado");
                                    break;
                            }

                        }
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

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                switch (listDesplegable.getSelectedIndex()) {
                    case 1:
                        rutaTemaImagenes = "1/";
                        break;
                    case 2:
                        rutaTemaImagenes = "2/";
                        break;
                    case 3:
                        rutaTemaImagenes = "3/";
                        break;
                }
            }
        }

        public void primeraVista() {
            Timer vista = new Timer();
            TimerTask tiempo = new TimerTask() {
                @Override
                public void run() {
                    juego.taparTodasCasillas();
                    actualizarJuego();
                }
            };
            vista.schedule(tiempo, 4000);
        }

        public void vistaParejaCasillas() {
            Timer vista = new Timer();
            TimerTask tiempo = new TimerTask() {
                @Override
                public void run() {
                    actualizarJuego();
                }
            };
            vista.schedule(tiempo, 1000);
        }

        public void iniciarJuego() {
            juego.iniciarJuego();
            juego.destaparTodasCasillas();
            actualizarJuego();
            primeraVista();
        }
    }

}
