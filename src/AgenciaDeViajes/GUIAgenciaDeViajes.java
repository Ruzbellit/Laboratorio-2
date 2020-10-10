/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgenciaDeViajes;

import java.awt.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;



/**
 *
 * @author ruzbe
 */
public class GUIAgenciaDeViajes extends JFrame{
    
    Container contenPPal;
    JTabbedPane pestañas;
    JPanel pConsulOpc, pListHotelEven, pRealizReserv, pConsultReserv, pIngresInfo, pEstadisticas;
    
    //componentes de la GUI pestaña 1(consultar opciones)
    JPanel pIzquierda, pCentro;
    JComboBox<String> ciudadDestino;
    JLabel lCiudadDestino, lValMin, lValMax, lDiasViaje, lPersonasViaje;
    JFormattedTextField fTValMin, fTValMax;
    JSpinner sDiasViaje, sPersonasViaje;
    JScrollPane barras;
    JTextArea area;
    JButton bBuscarP1;
    
    //componentes de la GUI pestaña 2 (Listar Hoteles/Eventos)
    JPanel pArribaP2, pCentroP2;
    JComboBox<String> ciudadDestinoP2;
    JScrollPane barrasHP2, barrasEP2;
    JTextArea tHotelesList, tEventosList;
    JButton bBuscarP2;
    
     //componentes de la GUI pestaña 3 (Realizar Reserva)
    JPanel pIzqP3, pCenP3, pDerP3;
    JComboBox<String> ciudadDestinoP3, hotelP3, aerolineaP3, transporteP3;
    JFormattedTextField fTFechaViaje, fTNumCC;
    JLabel lFechaViaje, lCiudadP3, lNumCC, lDiasViajeP3, lEstrellasHotel, lViajerosP3, 
            lHotelP3, lAerolineaP3, lTransporteP3, lEventoAsistirP3;
    JSpinner sDiasViajeP3, sEstrellasHotel, sViajerosP3;
    JCheckBox cEventOp1, cEventOp2, cEventOp3; 
 ; 
    JButton bCrearReserv;
   
   
    //componentes de la GUI pestaña 4 (Consultar Reserva)
    //componentes de la GUI pestaña 5 (Agregar Info)
    //componentes de la GUI pestaña 6 (Estadisticas)
    public GUIAgenciaDeViajes()
    {
        
        pestañas = new JTabbedPane();
        
        pConsulOpc = new JPanel();
        pListHotelEven = new JPanel();
        pRealizReserv = new JPanel();
        pConsultReserv = new JPanel();
        pIngresInfo = new JPanel();
        pEstadisticas = new JPanel();
         
        //pestaña 1(consultar opciones)
        pIzquierda = new JPanel();
        pCentro = new JPanel();
         
        ciudadDestino = new JComboBox<>();
        
        lCiudadDestino = new JLabel("Ciudad: ");
        lValMin = new JLabel("Ingrese Valor Minimo: ");
        lValMax = new JLabel("Ingrese Valor Maximo: ");
        lDiasViaje = new JLabel("Ingrese los dias de viaje: ");
        lPersonasViaje = new JLabel("Ingrese las personas a viajar: ");
        
        MaskFormatter mascaraF;
        try
        {
            mascaraF = new MaskFormatter("#######");
            fTValMin = new JFormattedTextField(mascaraF);
            fTValMax = new JFormattedTextField(mascaraF);
            
        }catch(ParseException ex){
            System.out.print("no se pudo formatear");
            
        }
        
        sDiasViaje = new JSpinner();
        sPersonasViaje = new JSpinner();
        
        bBuscarP1 = new JButton("Buscar");
        
        area = new JTextArea("Opciones disponibles de acuerdo a los parametros indicados:");
        barras = new JScrollPane(area);
        
        pCentro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 30),""));
        pIzquierda.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 10),""));
        
        ciudadDestino.addItem("Cali");
        ciudadDestino.addItem("Medellin");
        ciudadDestino.addItem("Cartagena");
        
        pIzquierda.setLayout(new BoxLayout(pIzquierda,1));
        pIzquierda.add(lCiudadDestino);
        pIzquierda.add(ciudadDestino);
        pIzquierda.add(lValMin);
        pIzquierda.add(fTValMin);
        pIzquierda.add(lValMax);
        pIzquierda.add(fTValMax);
        pIzquierda.add(lDiasViaje);
        pIzquierda.add(sDiasViaje);
        pIzquierda.add(lPersonasViaje);
        pIzquierda.add(sPersonasViaje);
        pIzquierda.add(bBuscarP1);
        pCentro.setLayout(new GridLayout(1,1));
        pCentro.add(barras);
        
        pConsulOpc.setLayout(new BorderLayout());
        pConsulOpc.add(pIzquierda,BorderLayout.WEST);
        pConsulOpc.add(pCentro,BorderLayout.CENTER);
        
        //pestaña 2 (Listar Hoteles y Eventos)
        pArribaP2 = new JPanel();
        pCentroP2 = new JPanel();
        
        ciudadDestinoP2 = new JComboBox<>();
        
        tHotelesList = new JTextArea("Hoteles listados:");
        tEventosList = new JTextArea("Eventos listados:");    
        barrasHP2 = new JScrollPane(tHotelesList);
        barrasEP2 = new JScrollPane(tEventosList);
        
        bBuscarP2 = new JButton("Buscar");
        
        ciudadDestinoP2.addItem("Cali");
        ciudadDestinoP2.addItem("Medellin");
        ciudadDestinoP2.addItem("Cartagena");
        
        pListHotelEven.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 30),""));
          
        pArribaP2.add(ciudadDestinoP2);
        pArribaP2.add(bBuscarP2);
        pCentroP2.setLayout(new GridLayout(1,2,3,0));
        pCentroP2.add(barrasHP2);
        pCentroP2.add(barrasEP2);
        
        pListHotelEven.setLayout(new BorderLayout());
        pListHotelEven.add(pArribaP2,BorderLayout.NORTH);
        pListHotelEven.add(pCentroP2,BorderLayout.CENTER);
        
        //pestaña 3 (Realizar Reserva)
        pIzqP3 = new JPanel();
        pCenP3 = new JPanel();
        pDerP3 = new JPanel();

        ciudadDestinoP3 = new JComboBox<>();
        hotelP3 = new JComboBox<>();
        aerolineaP3 = new JComboBox<>();
        transporteP3 = new JComboBox<>();
        
         MaskFormatter mascaraF3;
        try
        {
            mascaraF3 = new MaskFormatter("##/##/##");
            fTFechaViaje = new JFormattedTextField(mascaraF3);
            fTNumCC = new JFormattedTextField(mascaraF3);
            
        }catch(ParseException ex){
            System.out.print("no se pudo formatear");
            
        }
        
        lFechaViaje = new JLabel("Fecha de viaje(DD/MM/AA: ");
        lCiudadP3 = new JLabel("Ciudad");
        lNumCC = new JLabel("Número de cédula: ");
        lDiasViajeP3 = new JLabel("Dias de viaje: ");
        lEstrellasHotel = new JLabel("Estrellas del Hotel: ");
        lViajerosP3 = new JLabel("Viajeros: ");
        lHotelP3 = new JLabel("Hotel: ");
        lAerolineaP3 = new JLabel("Aerolinea): ");
        lTransporteP3 = new JLabel("Tipo de transporte: ");
        lEventoAsistirP3 = new JLabel("Eventos a asistir: ");
        
        sDiasViajeP3 = new JSpinner();
        sEstrellasHotel = new JSpinner();
        sViajerosP3 = new JSpinner();
        
        cEventOp1 = new JCheckBox("Opcion 1");
        cEventOp2 = new JCheckBox("Opcion 2");
        cEventOp3 = new JCheckBox("Opcion 3");
        
        bCrearReserv = new JButton("Crear Reservacion");
 
        ciudadDestinoP3.addItem("Cali");
        ciudadDestinoP3.addItem("Medellin");
        ciudadDestinoP3.addItem("Cartagena");
        hotelP3.addItem(" --- ");
        aerolineaP3.addItem(" --- ");
        transporteP3.addItem(" --- ");
        
        pIzqP3.setLayout(new BoxLayout(pIzqP3,1));
        pIzqP3.add(lNumCC);
        pIzqP3.add(fTNumCC);
        pIzqP3.add(lDiasViajeP3);
        pIzqP3.add(sDiasViajeP3);
        pIzqP3.add(lHotelP3);
        pIzqP3.add(hotelP3);
        pIzqP3.add(lEventoAsistirP3);
        pIzqP3.add(cEventOp1);
        pIzqP3.add(cEventOp2);
        pIzqP3.add(cEventOp3);
        
        pCenP3.setLayout(new BoxLayout(pCenP3,1));
        pCenP3.add(lFechaViaje);
        pCenP3.add(fTFechaViaje);
        pCenP3.add(lEstrellasHotel);
        pCenP3.add(sEstrellasHotel);
        pCenP3.add(lAerolineaP3);
        pCenP3.add(aerolineaP3);
        pCenP3.add(bCrearReserv);
        
        pDerP3.setLayout(new BoxLayout(pDerP3,1));
        pDerP3.add(lCiudadP3);
        pDerP3.add(ciudadDestinoP3);
        pDerP3.add(lViajerosP3);
        pDerP3.add(sViajerosP3);
        pDerP3.add(lTransporteP3);
        pDerP3.add(transporteP3);
        
        pRealizReserv.setLayout(new GridLayout(1,3,3,0));
        pRealizReserv.add(pIzqP3);
        pRealizReserv.add(pCenP3);
        pRealizReserv.add(pDerP3);
        
        //pestaña 4 (Consultar Reserva)
        
        //pestaña 5 (Agregar info)
        
        //pestaña 6 (Estadisticas)
        
        //Anadicion de pestañas y paneles
       
        pestañas.add(pConsulOpc, "Consultar Opciones");//R
        pestañas.add(pListHotelEven, "Listar Hoteles y Eventos ");//C
        pestañas.add(pRealizReserv, "Realizar Reservacion");//R
        pestañas.add(pConsultReserv, "Consultar Reserva");//D
        pestañas.add(pIngresInfo, "Ingresar Informacion");//C
        pestañas.add(pEstadisticas, "Estadisticas");//D
        
        contenPPal = getContentPane();
        contenPPal.add(pestañas);
        
        setTitle("Agencia De Viajes");
        setSize(900, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
    }
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //AgenciaDeViajes app = new AgenciaDeViajes();
        GUIAgenciaDeViajes app = new GUIAgenciaDeViajes();
    }


   
    
}
