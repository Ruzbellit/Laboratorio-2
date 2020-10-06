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
public class GUIConcentrese extends JFrame{
    
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
    
    public GUIConcentrese()
    {
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
        
        pArriba.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 2),""));
        pAMenu.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 1),""));
        pAOpcion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 1),""));
        pCentro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 4),"Concentrese"));
        pAbajo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 2),""));
        
        b1.setIcon(new ImageIcon(getClass().getResource("imagenes/java.png")));
        b2.setIcon(new ImageIcon(getClass().getResource("imagenes/html.png")));
        b3.setIcon(new ImageIcon(getClass().getResource("imagenes/javascript.png")));
        b4.setIcon(new ImageIcon(getClass().getResource("imagenes/c++.png")));
        b5.setIcon(new ImageIcon(getClass().getResource("imagenes/python.png")));
        b6.setIcon(new ImageIcon(getClass().getResource("imagenes/php.png")));
        b7.setIcon(new ImageIcon(getClass().getResource("imagenes/css.png")));
        b8.setIcon(new ImageIcon(getClass().getResource("imagenes/go.png")));
        
        pArriba.setLayout(new BorderLayout());
        pAMenu.setLayout(new FlowLayout(25));
        pAOpcion.setLayout(new GridLayout(1, 2, 5, 2));
        pArriba.add(pAMenu,BorderLayout.NORTH);
        pArriba.add(pAOpcion,BorderLayout.CENTER);
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
        
        pCentro.add(b1); pCentro.add(b2); pCentro.add(b3); pCentro.add(b4); 
        pCentro.add(b5); pCentro.add(b6); pCentro.add(b7); pCentro.add(b8); 
        pCentro.add(b9); pCentro.add(b10); pCentro.add(b11); pCentro.add(b12);
        pCentro.add(b13); pCentro.add(b14); pCentro.add(b15); pCentro.add(b16);
        
        contenPPal = getContentPane();
        contenPPal.setLayout(new BorderLayout());
        contenPPal.add(pArriba,BorderLayout.NORTH);
        contenPPal.add(pCentro,BorderLayout.CENTER);
        contenPPal.add(pAbajo,BorderLayout.SOUTH);
        
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
    
    class ManejaEventos implements ActionListener
    {
        ConcentreseJuego juego;
        
        public ManejaEventos() {
            juego = new ConcentreseJuego();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    
}
