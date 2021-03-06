/*
  Autor: Ruzbellit Rossy Romero Ramirez (1925456)
  Email: ruzbellit.romero@correounivalle.edu.co
  Autor: Christian Villanueva Paez (1924546)
  Email: christian.villanueva@correounivalle.edu.co
  Autor: Daniel Rodriguez Sanchez (1927631)
  Email: daniel.rodriguez.sanchez@correounivalle.edu.co
  Fecha última modificación: 2020-10-16
*/
package AgenciaDeViajes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;


/**
 *
 * @author ruzbe
 */
public class GUIAgenciaDeViajes extends JFrame{
    
    Container contenPPal;
    JTabbedPane pestañas;
    JPanel pConsulOpc, pListHotelEven, pRealizReserv, pConsultReserv, pIngresInfo, pEstadisticas;

    ArrayList<String> ciudades;
    
    //componentes de la GUI pestaña 1(consultar opciones)
    JPanel pIzquierda, pCentro;
    JComboBox<String> ciudadDestino,ciudadOrigen;
    JLabel lCiudadDestino, lCiudadOrigen, lValMin, lValMax, lDiasViaje, lPersonasViaje;
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
    JComboBox<String> ciudadOrigenP3, ciudadDestinoP3, hotelP3, aerolineaP3, transporteP3;
    JFormattedTextField fTFechaViaje, fTNumCC;
    JLabel lFechaViaje, lCiudadOrigenP3, lCiudadP3, lNumCC, lDiasViajeP3, lViajerosP3, 
            lHotelP3, lAerolineaP3, lTransporteP3, lEventoAsistirP3;
    JSpinner sDiasViajeP3, sViajerosP3;
    JCheckBox cEventOp1, cEventOp2, cEventOp3; 
    JButton bCrearReserv;
    ArrayList<JCheckBox> checkboxes;

    //componentes de la GUI pestaña 4 (Consultar Reserva)
    JPanel pArribaP4, pCenP4;
    JLabel lNumCCP4, lDatosReservP4;
    JFormattedTextField fTNumCCP4;
    JTextArea tDatosReserv;
    JScrollPane barrasP4;
    JButton bBuscarP4;
    
    //componentes de la GUI pestaña 5 (Agregar Info)
    JPanel pHotelP5, pAerolineaP5, pTransporteP5, pEventosP5;
    JLabel lHotelP5, lNomHotel, lEstrellas, lCiudad, lCostHabitacion,
            lAerolineaP5, lNomAeroLinea, lAgregarVuelo, lCiudOrigen, lCiudDestino, lPrecioVuelo,
            lTransporteP5, lCiudadTransp, lCostBus, lCostChiva, lCostBici,
            lEventosP5, lNomEvent, lCiudadEvent, lCostPersona, lHorarioEvent, lFechaEvent, lLugarEvent;
    JComboBox<String> ciudadHotelP5, ciudadDestinoP5, ciudadOrigenP5, ciudadTranspP5, ciudadEventP5;
    JFormattedTextField fTCostHabitacion, fTCostVuelo, fTCostBus, ftCostChiva, fTCostBici, fTCostEvent,
            fTHorarioEvent, fTFechaEvent;
    JTextField tNomHotel, tNomAerolinea, tNomEvento, tLugarEvent;
    JSpinner sEstrellasH;
    JButton bIngresHotel, bIngresAerolinea, bIngresTransp, bIngresEvent;
    
    //componentes de la GUI pestaña 6 (Estadisticas)
    JPanel pDerP6, pIzqP6;
    JLabel lCiudadesP6, lHotelesP6;
    JButton bBuscarCiudR, bBuscarHotelR;
    JTextArea tCiudadesP6, tHotelesP6;
    JScrollPane barrasCP6, barrasHP6;
    
    public GUIAgenciaDeViajes()
    {
        ciudades = new ArrayList();
        ciudades.add("Cali");
        ciudades.add("Bogotá");
        ciudades.add("Medellín");
        ciudades.add("Cartagena");
        
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
        ciudadOrigen = new JComboBox<>();
        
        lCiudadOrigen = new JLabel("Ciudad Origen: ");
        lCiudadDestino = new JLabel("Ciudad Destino: ");
        lValMin = new JLabel("Valor Minimo: ");
        lValMax = new JLabel("Valor Maximo: ");
        lDiasViaje = new JLabel("Cantidad días de viaje: ");
        lPersonasViaje = new JLabel("Viajeros: ");
        
        
        NumberFormat numFormat = NumberFormat.getInstance();
        NumberFormatter integerFormatter = new NumberFormatter(numFormat);
        integerFormatter.setValueClass(Integer.class);
        integerFormatter.setMinimum(0);
        integerFormatter.setAllowsInvalid(false);
        integerFormatter.setCommitsOnValidEdit(true);
        fTValMin = new JFormattedTextField(integerFormatter);
        fTValMax = new JFormattedTextField(integerFormatter);
        
        SpinnerModel intSpinnerDias = new SpinnerNumberModel(1, 1, 20, 1);
        sDiasViaje = new JSpinner(intSpinnerDias);
        SpinnerModel intSpinnerPersonas = new SpinnerNumberModel(1, 1, 20, 1);
        sPersonasViaje = new JSpinner(intSpinnerPersonas);
        
        bBuscarP1 = new JButton("Buscar");
        
        area = new JTextArea("Opciones disponibles de acuerdo a los parametros indicados:");
        barras = new JScrollPane(area);
        
        pCentro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 30),""));
        pIzquierda.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10),""));
        
        for (String ciudad : ciudades) { 		      
            ciudadDestino.addItem(ciudad);
            ciudadOrigen.addItem(ciudad);
        }
        
        pIzquierda.setLayout(new BoxLayout(pIzquierda,1));
        pIzquierda.add(Box.createRigidArea(new Dimension(0,10)));
        pIzquierda.add(lCiudadOrigen);
        pIzquierda.add(ciudadOrigen);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,30)));
        pIzquierda.add(lCiudadDestino);
        pIzquierda.add(ciudadDestino);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,30)));
        pIzquierda.add(lValMin);
        pIzquierda.add(fTValMin);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,45)));
        pIzquierda.add(lValMax);
        pIzquierda.add(fTValMax);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,45)));
        pIzquierda.add(lDiasViaje);
        pIzquierda.add(sDiasViaje);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,45)));
        pIzquierda.add(lPersonasViaje);
        pIzquierda.add(sPersonasViaje);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,30)));
        pIzquierda.add(bBuscarP1);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,20)));
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
        
        for (String ciudad : ciudades) { 		      
            ciudadDestinoP2.addItem(ciudad);
        }
        
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

        ciudadOrigenP3 = new JComboBox<>();
        ciudadDestinoP3 = new JComboBox<>();
        hotelP3 = new JComboBox<>();
        aerolineaP3 = new JComboBox<>();
        transporteP3 = new JComboBox<>();
        
        fTNumCC = new JFormattedTextField(integerFormatter);
        DateFormat formatoFecha;
        formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        fTFechaViaje = new JFormattedTextField(formatoFecha);
        
        lFechaViaje = new JLabel("Fecha de viaje (yyyy-MM-dd) ");
        lCiudadOrigenP3 = new JLabel("Ciudad origen");
        lCiudadP3 = new JLabel("Ciudad destino");
        lNumCC = new JLabel("Número de cédula: ");
        lDiasViajeP3 = new JLabel("Dias de viaje: ");
        lViajerosP3 = new JLabel("Viajeros: ");
        lHotelP3 = new JLabel("Hotel: ");
        lAerolineaP3 = new JLabel("Aerolinea: ");
        lTransporteP3 = new JLabel("Tipo de transporte: ");
        lEventoAsistirP3 = new JLabel("Eventos a asistir: ");
        
        sDiasViajeP3 = new JSpinner(intSpinnerDias);
        sViajerosP3 = new JSpinner(intSpinnerPersonas);
        
        cEventOp1 = new JCheckBox("Opcion 1");
        cEventOp2 = new JCheckBox("Opcion 2");
        cEventOp3 = new JCheckBox("Opcion 3");
        checkboxes = new ArrayList<JCheckBox>();
        
        bCrearReserv = new JButton("Crear Reservacion");
 
        for (String ciudad : ciudades) { 		      
            ciudadDestinoP3.addItem(ciudad);
            ciudadOrigenP3.addItem(ciudad);
        }
        
        pIzqP3.setLayout(new BoxLayout(pIzqP3,1));
        pIzqP3.add(Box.createRigidArea(new Dimension(0,10)));
        pIzqP3.add(lNumCC);
        pIzqP3.add(fTNumCC);
        pIzqP3.add(Box.createRigidArea(new Dimension(0,50)));
        pIzqP3.add(lFechaViaje);
        pIzqP3.add(fTFechaViaje);
        pIzqP3.add(Box.createRigidArea(new Dimension(0,50)));
        pIzqP3.add(lCiudadOrigenP3);
        pIzqP3.add(ciudadOrigenP3);
        pIzqP3.add(Box.createRigidArea(new Dimension(0,50)));
        pIzqP3.add(lCiudadP3);
        pIzqP3.add(ciudadDestinoP3);
        
        
        pCenP3.setLayout(new BoxLayout(pCenP3,1));
        pCenP3.add(Box.createRigidArea(new Dimension(0,10)));
        pCenP3.add(lDiasViajeP3);
        pCenP3.add(sDiasViajeP3);
        pCenP3.add(Box.createRigidArea(new Dimension(0,50)));
        pCenP3.add(lViajerosP3);
        pCenP3.add(sViajerosP3);
        pCenP3.add(Box.createRigidArea(new Dimension(0,30)));
        pCenP3.add(lEventoAsistirP3);
        
        pDerP3.setLayout(new BoxLayout(pDerP3,1));
        pDerP3.add(Box.createRigidArea(new Dimension(0,10)));
        pDerP3.add(lAerolineaP3);
        pDerP3.add(aerolineaP3);
        pDerP3.add(Box.createRigidArea(new Dimension(0,80)));
        pDerP3.add(lHotelP3);
        pDerP3.add(hotelP3);
        pDerP3.add(Box.createRigidArea(new Dimension(0,80)));
        pDerP3.add(lTransporteP3);
        pDerP3.add(transporteP3);
        pDerP3.add(Box.createRigidArea(new Dimension(0,30)));
        pDerP3.add(bCrearReserv);
        
        pRealizReserv.setLayout(new GridLayout(1,3,3,0));
        pRealizReserv.add(pIzqP3);
        pRealizReserv.add(pCenP3);
        pRealizReserv.add(pDerP3);
        
        //pestaña 4 (Consultar Reserva)
        pArribaP4 = new JPanel();
        pCenP4 = new JPanel();
        
        lNumCCP4 = new JLabel("Número de cédula: ");
        lDatosReservP4 = new JLabel("Datos de su Reserva: ");

        fTNumCCP4 = new JFormattedTextField(integerFormatter);
        
        tDatosReserv = new JTextArea("Su reserva: ");
        barrasP4 = new JScrollPane(tDatosReserv);
        bBuscarP4 = new JButton("Buscar");
        
        pConsultReserv.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 30),""));
        
        pArribaP4.setLayout(new BoxLayout(pArribaP4,1));
        pArribaP4.add(lNumCCP4);
        pArribaP4.add(fTNumCCP4);
        pArribaP4.add(bBuscarP4);
        
        pCenP4.setLayout(new BoxLayout(pCenP4,1));
        pCenP4.add(lDatosReservP4);
        pCenP4.add(barrasP4);
        
        pConsultReserv.setLayout(new BorderLayout());
        pConsultReserv.add(pArribaP4, BorderLayout.NORTH);
        pConsultReserv.add(pCenP4, BorderLayout.CENTER);
       
        //pestaña 5 (Agregar info)
        pHotelP5 = new JPanel();
        pAerolineaP5 = new JPanel();
        pTransporteP5 = new JPanel();
        pEventosP5 = new JPanel();
    
        lHotelP5 = new JLabel("HOTEL");
        lNomHotel = new JLabel("Nombre");
        lEstrellas = new JLabel("Estrellas");
        lCiudad = new JLabel("Ciudad");
        lCostHabitacion = new JLabel("Costo por habitacion");
        lAerolineaP5 = new JLabel("AEROLINEA");
        lNomAeroLinea = new JLabel("Nombre");
        lAgregarVuelo = new JLabel("*Agregar Vuelo");
        lCiudOrigen = new JLabel("Ciudad origen");
        lCiudDestino = new JLabel("Ciudad destino");
        lPrecioVuelo = new JLabel("Precio por vuelo");
        lTransporteP5 = new JLabel("MEDIOS DE TRANSPORTE");
        lCiudadTransp = new JLabel("Ciudad");
        lCostBus = new JLabel("Costo por Bus");
        lCostChiva = new JLabel("Costo por Chiva");
        lCostBici = new JLabel("Costo por Bici");
        lEventosP5 = new JLabel("EVENTOS");
        lNomEvent = new JLabel("Nombre");
        lCiudadEvent = new JLabel("Ciudad");
        lCostPersona = new JLabel("Costo por persona");
        lHorarioEvent = new JLabel("Hora (HH/MM)");
        lFechaEvent = new JLabel("Fecha (AAAA-MM-DD)");
        lLugarEvent = new JLabel("Lugar");
        
        tNomHotel = new JTextField("");
        tNomAerolinea = new JTextField("");
        tNomEvento = new JTextField("");
        tLugarEvent = new JTextField("");
        
        ciudadHotelP5 = new JComboBox();
        ciudadDestinoP5 = new JComboBox();
        ciudadOrigenP5 = new JComboBox();
        ciudadTranspP5 = new JComboBox();
        ciudadEventP5 = new JComboBox();
        
        for (String ciudad : ciudades) { 		      
            ciudadHotelP5.addItem(ciudad);
            ciudadDestinoP5.addItem(ciudad);
            ciudadOrigenP5.addItem(ciudad);
            ciudadTranspP5.addItem(ciudad);
            ciudadEventP5.addItem(ciudad);
        }
        
         MaskFormatter mascaraFP5H;
         MaskFormatter mascaraFP5F;
        try {
            mascaraFP5H = new MaskFormatter("##/##");
            mascaraFP5F = new MaskFormatter("####-##-##");
            fTHorarioEvent = new JFormattedTextField(mascaraFP5H);
            fTFechaEvent = new JFormattedTextField(mascaraFP5F);
            
        } catch(ParseException ex){
            JOptionPane.showMessageDialog(null, "no se pudo formatear");            
        }

        fTCostHabitacion = new JFormattedTextField(integerFormatter);
        fTCostVuelo = new JFormattedTextField(integerFormatter);
        fTCostBus = new JFormattedTextField(integerFormatter);
        ftCostChiva = new JFormattedTextField(integerFormatter);
        fTCostBici = new JFormattedTextField(integerFormatter);
        fTCostEvent = new JFormattedTextField(integerFormatter);
       
        sEstrellasH = new JSpinner();
        
        bIngresHotel = new JButton("Agregar Hotel");
        bIngresAerolinea = new JButton("Agregar Aerolinea");
        bIngresTransp = new JButton("Agregar Transporte");
        bIngresEvent = new JButton("Agregar Evento");
       
        pIngresInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 30),""));
        
        pHotelP5.setLayout(new BoxLayout(pHotelP5,1));
        pHotelP5.add(Box.createRigidArea(new Dimension(0,10)));
        pHotelP5.add(lHotelP5);
        pHotelP5.add(Box.createRigidArea(new Dimension(0,30)));
        pHotelP5.add(lNomHotel);
        pHotelP5.add(tNomHotel);
        pHotelP5.add(Box.createRigidArea(new Dimension(0,50)));
        pHotelP5.add(lEstrellas);
        pHotelP5.add(sEstrellasH);
        pHotelP5.add(Box.createRigidArea(new Dimension(0,60)));
        pHotelP5.add(lCiudad);
        pHotelP5.add(ciudadHotelP5);
        pHotelP5.add(Box.createRigidArea(new Dimension(0,50)));
        pHotelP5.add(lCostHabitacion);
        pHotelP5.add(fTCostHabitacion);
        pHotelP5.add(Box.createRigidArea(new Dimension(0,30)));
        pHotelP5.add(bIngresHotel);
        pHotelP5.add(Box.createRigidArea(new Dimension(0,30)));
        
        
        pAerolineaP5.setLayout(new BoxLayout(pAerolineaP5,1));
        pAerolineaP5.add(Box.createRigidArea(new Dimension(0,10)));
        pAerolineaP5.add(lAerolineaP5);
        pAerolineaP5.add(Box.createRigidArea(new Dimension(0,30)));
        pAerolineaP5.add(lNomAeroLinea);
        pAerolineaP5.add(tNomAerolinea);
        pAerolineaP5.add(Box.createRigidArea(new Dimension(0,30)));
        pAerolineaP5.add(lAgregarVuelo);
        pAerolineaP5.add(Box.createRigidArea(new Dimension(0,5)));
        pAerolineaP5.add(lCiudOrigen);
        pAerolineaP5.add(ciudadOrigenP5);
        pAerolineaP5.add(Box.createRigidArea(new Dimension(0,50)));
        pAerolineaP5.add(lCiudDestino);
        pAerolineaP5.add(ciudadDestinoP5);
        pAerolineaP5.add(Box.createRigidArea(new Dimension(0,50)));
        pAerolineaP5.add(lPrecioVuelo);
        pAerolineaP5.add(fTCostVuelo);
        pAerolineaP5.add(Box.createRigidArea(new Dimension(0,30)));
        pAerolineaP5.add(bIngresAerolinea);
        pAerolineaP5.add(Box.createRigidArea(new Dimension(0,30)));
      
        
        pTransporteP5.setLayout(new BoxLayout(pTransporteP5,1));
        pTransporteP5.add(Box.createRigidArea(new Dimension(0,10)));
        pTransporteP5.add(lTransporteP5);
        pTransporteP5.add(Box.createRigidArea(new Dimension(0,30)));
        pTransporteP5.add(lCiudadTransp);
        pTransporteP5.add(ciudadTranspP5);
        pTransporteP5.add(Box.createRigidArea(new Dimension(0,50)));
        pTransporteP5.add(lCostBus);
        pTransporteP5.add(fTCostBus);
        pTransporteP5.add(Box.createRigidArea(new Dimension(0,50)));
        pTransporteP5.add(lCostChiva);
        pTransporteP5.add(ftCostChiva);
        pTransporteP5.add(Box.createRigidArea(new Dimension(0,45)));
        pTransporteP5.add(lCostBici);
        pTransporteP5.add(fTCostBici);
        pTransporteP5.add(Box.createRigidArea(new Dimension(0,30)));
        pTransporteP5.add(bIngresTransp);
        pTransporteP5.add(Box.createRigidArea(new Dimension(0,30)));
        
        
        pEventosP5.setLayout(new BoxLayout(pEventosP5,1));
        pEventosP5.add(Box.createRigidArea(new Dimension(0,10)));
        pEventosP5.add(lEventosP5);
        pEventosP5.add(Box.createRigidArea(new Dimension(0,30)));
        pEventosP5.add(lNomEvent);
        pEventosP5.add(tNomEvento);
        pEventosP5.add(Box.createRigidArea(new Dimension(0,20)));
        pEventosP5.add(lCiudadEvent);
        pEventosP5.add(ciudadEventP5);
        pEventosP5.add(Box.createRigidArea(new Dimension(0,20)));
        pEventosP5.add(lCostPersona);
        pEventosP5.add(fTCostEvent);
        pEventosP5.add(Box.createRigidArea(new Dimension(0,20)));
        pEventosP5.add(lHorarioEvent);
        pEventosP5.add(fTHorarioEvent);
        pEventosP5.add(Box.createRigidArea(new Dimension(0,20)));
        pEventosP5.add(lFechaEvent);
        pEventosP5.add(fTFechaEvent);
        pEventosP5.add(Box.createRigidArea(new Dimension(0,20)));
        pEventosP5.add(lLugarEvent);
        pEventosP5.add(tLugarEvent);
        pEventosP5.add(Box.createRigidArea(new Dimension(0,30)));
        pEventosP5.add(bIngresEvent);
        pEventosP5.add(Box.createRigidArea(new Dimension(0,30)));
        
        
        pIngresInfo.setLayout(new GridLayout(1,4,15,0));
        pIngresInfo.add(pHotelP5);
        pIngresInfo.add(pAerolineaP5);
        pIngresInfo.add(pTransporteP5);
        pIngresInfo.add(pEventosP5);
   
        //pestaña 6 (Estadisticas)
        pIzqP6 = new JPanel();
        pDerP6 = new JPanel();
        
        lCiudadesP6 = new JLabel("Reservas ciudades");
        lHotelesP6 = new JLabel("Reservas Hoteles");
        
        bBuscarCiudR = new JButton("Buscar");
        bBuscarHotelR = new JButton("Buscar");
                
        tCiudadesP6  = new JTextArea("");
        tHotelesP6 = new JTextArea("");
        
        barrasCP6 = new JScrollPane(tCiudadesP6);
        barrasHP6 = new JScrollPane(tHotelesP6);
        
        pEstadisticas.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 30),""));
                
        pIzqP6.setLayout(new BoxLayout(pIzqP6, 1));
        pIzqP6.add(lCiudadesP6);
        pIzqP6.add(barrasCP6);
        pIzqP6.add(bBuscarCiudR);
        
        pDerP6.setLayout(new BoxLayout(pDerP6, 1));
        pDerP6.add(lHotelesP6);
        pDerP6.add(barrasHP6);
        pDerP6.add(bBuscarHotelR);
        
        pEstadisticas.setLayout(new GridLayout(1,2,3,0));
        pEstadisticas.add(pIzqP6);
        pEstadisticas.add(pDerP6);
       
        
        //Anadicion de pestañas y paneles
       
        pestañas.add(pConsulOpc, "Consultar Opciones");//R
        pestañas.add(pListHotelEven, "Listar Hoteles y Eventos ");//C
        pestañas.add(pRealizReserv, "Realizar Reservacion");//R
        pestañas.add(pConsultReserv, "Consultar Reserva");//D
        pestañas.add(pIngresInfo, "Ingresar Informacion");//C
        pestañas.add(pEstadisticas, "Estadisticas");//D
        
        contenPPal = getContentPane();
        contenPPal.add(pestañas);
        
        // asociar eventos que va a escuchar
        ManejadoraEventos mEvento = new ManejadoraEventos();
        bBuscarP1.addActionListener(mEvento);
        bBuscarP2.addActionListener(mEvento);
        bCrearReserv.addActionListener(mEvento);
        bBuscarP4.addActionListener(mEvento);
        bIngresHotel.addActionListener(mEvento);
        bIngresAerolinea.addActionListener(mEvento);
        bIngresTransp.addActionListener(mEvento);
        bIngresEvent.addActionListener(mEvento);
        bBuscarCiudR.addActionListener(mEvento);
        bBuscarHotelR.addActionListener(mEvento);
        ciudadDestinoP3.addActionListener(mEvento);
        ciudadOrigenP3.addActionListener(mEvento);

        setTitle("Agencia De Viajes");
        setSize(900, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Maneja cada uno de los eventos de los componentes de la GUI
     */
    class ManejadoraEventos implements ActionListener {
        
        AgenciaDeViajes agenciaViajes;
        
        public ManejadoraEventos()
        {
            agenciaViajes = new AgenciaDeViajes();
            transporteP3.addItem("BUS");
            transporteP3.addItem("CHIVA");
            transporteP3.addItem("BICICLETA");
        }

        @Override
        public void actionPerformed(ActionEvent ae) 
        {

            if(ae.getSource() == bBuscarP1)
            {
                Boolean esValido = true;
                String origen = "";
                String destino = "";
                int vMin = 0;
                int vMax = 0;
                int diasViaje = (Integer)sDiasViaje.getValue();
                int cantViajeros = (Integer)sPersonasViaje.getValue();
                String datos = "";
                //area.setText(datos);
                
                try {
                    origen = ciudadOrigen.getItemAt(ciudadOrigen.getSelectedIndex());
                    destino = ciudadDestino.getItemAt(ciudadDestino.getSelectedIndex());
                    vMin = fTValMin.getValue() == null ? 0 : (Integer)fTValMin.getValue();
                    vMax = fTValMax.getValue() == null ? 0 : (Integer)fTValMax.getValue();
                    
                    esValido = esValido && Validaciones.validarVuelo(origen, destino) && 
                            Validaciones.validarMaxMin(vMin, vMax);
                    
                    
                }catch(Exception e){
                    esValido = false;
                    datos = "Datos incompletos. Por favor seleccione un valor para cada campo\n" + e;
                }
                if (esValido) {
                       datos = agenciaViajes.catalogo(origen ,destino, vMin, vMax, diasViaje, cantViajeros);
                       area.setText(datos);
                }
            }
            if(ae.getSource() == bBuscarP2)
            {
                String destino = ciudadDestinoP2.getItemAt(ciudadDestinoP2.getSelectedIndex());
                String listaHoteles = agenciaViajes.listarHoteles(destino);
                String listaEventos = agenciaViajes.listarInfoEventosCulturales(destino);
                tHotelesList.setText(listaHoteles);
                tEventosList.setText(listaEventos);
            }
            // Eventos cuando una ciudad es seleccionada en crear Reservación
            if (ae.getSource() == ciudadDestinoP3 || ae.getSource() == ciudadOrigenP3) {
                String ciudadOrigen = ciudadOrigenP3.getItemAt(ciudadOrigenP3.getSelectedIndex());
                String ciudadDestino = ciudadDestinoP3.getItemAt(ciudadDestinoP3.getSelectedIndex());

                // llenar comboBox de hoteles para la ciudad seleccionada
                ArrayList<String> nombreHoteles = agenciaViajes.arrNombreHoteles(ciudadDestino);
                hotelP3.removeAllItems();
                for (String nombreHotel : nombreHoteles) {
                    hotelP3.addItem(nombreHotel);
                }

                // llenar comboBox de aerolineas
                ArrayList<String> aerolineas = agenciaViajes.arrNombreAerolineas(ciudadOrigen, ciudadDestino);
                aerolineaP3.removeAllItems();
                for (String nombreAerolinea : aerolineas) {
                    aerolineaP3.addItem(nombreAerolinea);
                }

                // Pintar checkboxes de eventos culturales según la ciudad seleccionada
                for (int i = 0; i < checkboxes.size(); i++) {
                    pCenP3.remove(checkboxes.get(i));
                }
                checkboxes.clear();
                ArrayList<EventoCultural> eventos = agenciaViajes.listarEventosCulturales(ciudadDestino);
                for (int i = 0; i < eventos.size(); i++) {
                    JCheckBox checkbox = new JCheckBox(eventos.get(i).getNombre());
                    checkboxes.add(checkbox);
                }
                for (int i = 0; i < checkboxes.size(); i++) {
                    pCenP3.add(checkboxes.get(i));
                }

                pCenP3.revalidate();
            }
            if(ae.getSource() == bCrearReserv)
            {
                Boolean esValido = true;
                String info = "";
                String cedulaCliente = "";
                String ciudadOrigen = "";
                String ciudadDestino = "";
                LocalDate fechaViaje = LocalDate.now();
                int diasViaje = 0;
                String nombreHotel = "";
                String nombreAerolinea = "";
                int viajeros = 0;
                String transporteCiudad = "";
                ArrayList<String> eventosSeleccionados = new ArrayList();
                try {
                    cedulaCliente = fTNumCC.getValue() == null ? "" : fTNumCC.getValue().toString();
                    ciudadOrigen = ciudadOrigenP3.getItemAt(ciudadOrigenP3.getSelectedIndex());
                    ciudadDestino = ciudadDestinoP3.getItemAt(ciudadDestinoP3.getSelectedIndex());
                    fechaViaje = fTFechaViaje.getText().equals("") ? null : LocalDate.parse(fTFechaViaje.getText());
                    diasViaje = (Integer)sDiasViajeP3.getValue();
                    nombreHotel = hotelP3.getSelectedIndex() == -1 ? "" : hotelP3.getItemAt(hotelP3.getSelectedIndex());
                    nombreAerolinea = aerolineaP3.getSelectedIndex() == -1 ? "" : aerolineaP3.getItemAt(aerolineaP3.getSelectedIndex());
                    viajeros = (Integer)sViajerosP3.getValue();
                    transporteCiudad = transporteP3.getItemAt(transporteP3.getSelectedIndex());

                    for (JCheckBox chkbEventos: checkboxes) {
                        if (chkbEventos.isSelected()) {
                            eventosSeleccionados.add(chkbEventos.getText());
                        }
                    }

                    esValido = esValido && Validaciones.validarCedula(cedulaCliente) &&
                        Validaciones.validarFecha(fechaViaje) &&
                        Validaciones.validarVuelo(ciudadOrigen, ciudadDestino) &&
                        Validaciones.validarHotel(nombreHotel) &&
                        Validaciones.validarAerolinea(nombreAerolinea);

                } catch (Exception e) {
                    esValido = false;
                    info = "Datos incompletos. Por favor seleccione un valor para cada campo\n" + e;
                }

                if (esValido) {
                    info = agenciaViajes.realizarReserva(cedulaCliente, ciudadDestino, fechaViaje, diasViaje, nombreHotel,
                        nombreAerolinea, viajeros, transporteCiudad, eventosSeleccionados);
                } else {
                    info += "\nNo se pudo guardar la reserva!";
                }
                JOptionPane.showMessageDialog(null, info);
            }
            if(ae.getSource() == bBuscarP4)
            {
                String numeroCedula = Integer.toString((Integer)fTNumCCP4.getValue());
                String infoReserv = agenciaViajes.consultarReserva(numeroCedula);
                tDatosReserv.setText(infoReserv);
            }
            if(ae.getSource() == bIngresHotel)
            {
                String nombreH = tNomHotel.getText();
                int estrellas = (Integer)sEstrellasH.getValue();
                String ciudadH = ciudadHotelP5.getItemAt(ciudadHotelP5.getSelectedIndex());
                double precio = (Integer)fTCostHabitacion.getValue();
                String mensaje = agenciaViajes.registrarHotel(nombreH, estrellas, ciudadH, precio);
                JOptionPane.showMessageDialog(null, mensaje);
            }
            if(ae.getSource() == bIngresAerolinea)
            {
                //No se como hacerlo
                String nombreA = tNomAerolinea.getText();
                String ciudadOrigen = ciudadOrigenP5.getItemAt(ciudadOrigenP5.getSelectedIndex());
                String ciudadDestino = ciudadDestinoP5.getItemAt(ciudadDestinoP5.getSelectedIndex());
                double costoVuelo = (Integer) fTCostVuelo.getValue();
                String mensaje = agenciaViajes.registrarAerolinea(nombreA, ciudadOrigen, ciudadDestino, costoVuelo);
                JOptionPane.showMessageDialog(null, mensaje);
            }
            if(ae.getSource() == bIngresTransp)
            {
                String ciudadT = ciudadTranspP5.getItemAt(ciudadDestinoP5.getSelectedIndex());
                double precioBus = (Integer)fTCostBus.getValue();
                double precioChiva = (Integer)ftCostChiva.getValue();
                double precioBicicleta = (Integer)fTCostBici.getValue();
                String mensaje = agenciaViajes.registrarTransporte(ciudadT, precioBus, precioChiva, precioBicicleta);
                JOptionPane.showMessageDialog(null, mensaje);
            }
            if(ae.getSource() == bIngresEvent)
            {
                String nombreE = tNomEvento.getText();
                String ciudadE = ciudadEventP5.getItemAt(ciudadEventP5.getSelectedIndex());
                double costo = (Integer)fTCostEvent.getValue();
                String horario = fTHorarioEvent.getText();
                String fecha = fTFechaEvent.getText();
                String lugar = tLugarEvent.getText();
                String mensaje = agenciaViajes.registrarEventos(nombreE, ciudadE, costo, horario, fecha, lugar);
                JOptionPane.showMessageDialog(null, mensaje);
            }
            if(ae.getSource() == bBuscarCiudR)
            {
                String estadisticasCiudades = agenciaViajes.estadisticasMasCiudades();
                tCiudadesP6.setText(estadisticasCiudades);
                        
            }
            if(ae.getSource() == bBuscarHotelR)
            {
                String estadisticasCiudades = agenciaViajes.estadisticasMasHoteles();
                tHotelesP6.setText(estadisticasCiudades);
                        
            }
        }
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
