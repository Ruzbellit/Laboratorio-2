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
    JLabel lValMin, lValMax, lDiasViaje, lPersonasViaje;
    JFormattedTextField fTValMin, fTValMax;
    JSpinner sDiasViaje, sPersonasViaje;
    JScrollPane barras;
    JTextArea area;
    
     //componentes de la GUI pestaña 3 (Realizar Reserva)
    JComboBox<String> ciudadDestinoP3, nombreHotel, nombreAerolinea, tipoTransporte;
    JFormattedTextField fTFechaViaje, fTNumCC;
    JLabel lFechaViaje, lNumCC, lDiasViajeP3, lEstrellasHotel, lPersonasViajeP3, 
            lNomHotel, lNomAerolinea, lTipoTransporte, lEventoAsistir;
    JSpinner sDiasViajeP3, sEstrellasHotel, sPersonasViajeP3;
    JCheckBox cEventosAsistir; 
    JButton bCrearReserv;
    JTextArea tDescuentos;
   
    
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
        
        area = new JTextArea("Opciones disponibles de acuerdo a los parametros indicados:");
        barras = new JScrollPane(area);
        
        pCentro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 30),""));
        pIzquierda.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK, 10),""));
        
        ciudadDestino.addItem("Elegir Ciudad Destino");
        ciudadDestino.addItem("Cali");
        ciudadDestino.addItem("Medellin");
        ciudadDestino.addItem("Cartagena");
        
        pIzquierda.setLayout(new BoxLayout(pIzquierda,1));
        pIzquierda.add(ciudadDestino);
        pIzquierda.add(lValMin);
        pIzquierda.add(fTValMin);
        pIzquierda.add(lValMax);
        pIzquierda.add(fTValMax);
        pIzquierda.add(lDiasViaje);
        pIzquierda.add(sDiasViaje);
        pIzquierda.add(lPersonasViaje);
        pIzquierda.add(sPersonasViaje);
        pCentro.setLayout(new GridLayout(1,1));
        pCentro.add(barras);
        
        pConsulOpc.setLayout(new BorderLayout());
        pConsulOpc.add(pIzquierda,BorderLayout.WEST);
        pConsulOpc.add(pCentro,BorderLayout.CENTER);
        
        //pestaña 2 (Listar Hoteles y Eventos)
        
        
        
        //pestaña 3 (Realizar Reserva)
        ciudadDestinoP3 = new JComboBox<>();
        nombreHotel = new JComboBox<>();
        nombreAerolinea = new JComboBox<>();
        tipoTransporte = new JComboBox<>();
        
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
        lNumCC = new JLabel("Ingrese su numero de cedula: ");
        lDiasViajeP3 = new JLabel("Dias de viaje: ");
        lEstrellasHotel = new JLabel("Estrellas del Hotel: ");
        lPersonasViajeP3 = new JLabel("Personas a viajar: ");
        lNomHotel = new JLabel("Nombre del hotel: ");
        lNomAerolinea = new JLabel("Nombre de la Aerolinea): ");
        lTipoTransporte = new JLabel("Tipo de transporte: ");
        lEventoAsistir = new JLabel("Eventos a asistir: ");
        
        sDiasViajeP3 = new JSpinner();
        sEstrellasHotel = new JSpinner();
        sPersonasViajeP3 = new JSpinner();
        
        cEventosAsistir = new JCheckBox();
        
        bCrearReserv = new JButton("Crear Reservacion");
        
        tDescuentos = new JTextArea("Descuentos: ");
        
        ciudadDestinoP3.addItem("Ciudad Destino");
        ciudadDestinoP3.addItem("Cali");
        ciudadDestinoP3.addItem("Medellin");
        ciudadDestinoP3.addItem("Cartagena");
        nombreHotel.addItem("Nombre del Hotel");
        nombreAerolinea.addItem("Nombre de la Aerolinea");
        tipoTransporte.addItem("Tipo de transporte");
        
        pRealizReserv.setLayout(new FlowLayout(25));
        pRealizReserv.add(ciudadDestinoP3);
        pRealizReserv.add(lFechaViaje);
        pRealizReserv.add(fTFechaViaje);
        pRealizReserv.add(lNumCC);
        pRealizReserv.add(fTNumCC);
        pRealizReserv.add(lDiasViajeP3);
        pRealizReserv.add(sDiasViajeP3);
        pRealizReserv.add(lEstrellasHotel);
        pRealizReserv.add(sEstrellasHotel);
        pRealizReserv.add(lPersonasViajeP3);
        pRealizReserv.add(sPersonasViajeP3);
        pRealizReserv.add(lNomHotel);
        pRealizReserv.add(nombreHotel);
        pRealizReserv.add(lNomAerolinea);
        pRealizReserv.add(nombreAerolinea);
        pRealizReserv.add(lTipoTransporte);
        pRealizReserv.add(tipoTransporte);
        pRealizReserv.add(lEventoAsistir);
        
        pRealizReserv.add(bCrearReserv);
        pRealizReserv.add(tDescuentos);
        
        
        //pestaña 4 (Consultar Reserva)
        
        
        
        
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
