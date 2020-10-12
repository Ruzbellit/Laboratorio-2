/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgenciaDeViajes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
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
    JButton bCrearReserv;

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
    JFormattedTextField fTCostHabitacion, fTCostVuelo, fTCostBus, ftCostChiva, fTCostBici, fTCostEvent,
            fTHorarioEvent, fTFechaEvent;
    JTextField tNomHotel, tCiudadHotel, tNomAerolinea, tCiudadOrigen, tCiudadDestino, tCiudadTrasp, 
            tNomEvento, tCiudadEvent, tLugarEvent;
    JSpinner sEstrellasH;
    JButton bIngresHotel, bIngresAerolinea, bIngresTransp, bIngresEvent;
    
    //componentes de la GUI pestaña 6 (Estadisticas)
    JPanel pDerP6, pIzqP6;
    JLabel lCiudadesP6, lHotelesP6;
    JTextArea tCiudadesP6, tHotelesP6;
    JScrollPane barrasCP6, barrasHP6;
    
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
        lValMin = new JLabel("Valor Minimo: ");
        lValMax = new JLabel("Valor Maximo: ");
        lDiasViaje = new JLabel("Cantidad días de viaje: ");
        lPersonasViaje = new JLabel("Viajeros: ");
        
        
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter numberFormatter = new NumberFormatter(format);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(0);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setCommitsOnValidEdit(true);
        fTValMin = new JFormattedTextField(numberFormatter);
        fTValMax = new JFormattedTextField(numberFormatter);
        
        SpinnerModel intSpinnerDias = new SpinnerNumberModel(1, 1, 20, 1);
        sDiasViaje = new JSpinner(intSpinnerDias);
        SpinnerModel intSpinnerPersonas = new SpinnerNumberModel(1, 1, 20, 1);
        sPersonasViaje = new JSpinner(intSpinnerPersonas);
        
        bBuscarP1 = new JButton("Buscar");
        
        area = new JTextArea("Opciones disponibles de acuerdo a los parametros indicados:");
        barras = new JScrollPane(area);
        
        pCentro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 30),""));
        pIzquierda.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10),""));
        
        ciudadDestino.addItem("Cali");
        ciudadDestino.addItem("Bogotá");
        ciudadDestino.addItem("Medellín");
        ciudadDestino.addItem("Cartagena");
        
        pIzquierda.setLayout(new BoxLayout(pIzquierda,1));
        pIzquierda.add(lCiudadDestino);
        pIzquierda.add(ciudadDestino);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,50)));
        pIzquierda.add(lValMin);
        pIzquierda.add(fTValMin);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,50)));
        pIzquierda.add(lValMax);
        pIzquierda.add(fTValMax);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,50)));
        pIzquierda.add(lDiasViaje);
        pIzquierda.add(sDiasViaje);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,50)));
        pIzquierda.add(lPersonasViaje);
        pIzquierda.add(sPersonasViaje);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,60)));
        pIzquierda.add(bBuscarP1);
        pIzquierda.add(Box.createRigidArea(new Dimension(0,40)));
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
        ciudadDestinoP2.addItem("Bogotá");
        ciudadDestinoP2.addItem("Medellín");
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
        
        lFechaViaje = new JLabel("Fecha de viaje(AAAA-MM-DD: ");
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
        ciudadDestinoP3.addItem("Bogotá");
        ciudadDestinoP3.addItem("Medellín");
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
        pArribaP4 = new JPanel();
        pCenP4 = new JPanel();
        
        lNumCCP4 = new JLabel("Número de cédula: ");
        lDatosReservP4 = new JLabel("Datos de su Reserva: ");
        
        NumberFormat formatP4 = NumberFormat.getInstance();
        NumberFormatter numberFormatterP4 = new NumberFormatter(formatP4);
        numberFormatterP4.setValueClass(Integer.class);
        numberFormatterP4.setMinimum(0);
        numberFormatterP4.setAllowsInvalid(false);
        numberFormatterP4.setCommitsOnValidEdit(true);
        fTNumCCP4 = new JFormattedTextField(numberFormatterP4);
        
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
        tCiudadHotel = new JTextField("");
        tNomAerolinea = new JTextField("");
        tCiudadOrigen = new JTextField("");
        tCiudadDestino = new JTextField("");
        tNomEvento = new JTextField("");
        tCiudadTrasp = new JTextField("");
        tCiudadEvent = new JTextField("");
        tLugarEvent = new JTextField("");
        
         MaskFormatter mascaraFP5H;
         MaskFormatter mascaraFP5F;
        try
        {
            mascaraFP5H = new MaskFormatter("##/##");
            mascaraFP5F = new MaskFormatter("####-##-##");
            fTHorarioEvent = new JFormattedTextField(mascaraFP5H);
            fTFechaEvent = new JFormattedTextField(mascaraFP5F);
            
        }catch(ParseException ex){
            System.out.print("no se pudo formatear");
            
        }
        
        NumberFormat formatP5 = NumberFormat.getInstance();
        NumberFormatter numberFormatterP5 = new NumberFormatter(formatP5);
        numberFormatterP5.setValueClass(Integer.class);
        numberFormatterP5.setMinimum(0);
        numberFormatterP5.setAllowsInvalid(false);
        numberFormatterP5.setCommitsOnValidEdit(true);
        fTCostHabitacion = new JFormattedTextField(numberFormatterP5);
        fTCostVuelo = new JFormattedTextField(numberFormatterP5);
        fTCostBus = new JFormattedTextField(numberFormatterP5);
        ftCostChiva = new JFormattedTextField(numberFormatterP5);
        fTCostBici = new JFormattedTextField(numberFormatterP5);
        fTCostEvent = new JFormattedTextField(numberFormatterP5);
       
        sEstrellasH = new JSpinner();
        
        bIngresHotel = new JButton("Agregar Hotel");
        bIngresAerolinea = new JButton("Agregar Aerolinea");
        bIngresTransp = new JButton("Agregar Transporte");
        bIngresEvent = new JButton("Agregar Evento");
       
        pIngresInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 30),""));
        
        pHotelP5.setLayout(new BoxLayout(pHotelP5,1));
        pHotelP5.add(lHotelP5);
        pHotelP5.add(lNomHotel);
        pHotelP5.add(tNomHotel);
        pHotelP5.add(lEstrellas);
        pHotelP5.add(sEstrellasH);
        pHotelP5.add(lCiudad);
        pHotelP5.add(tCiudadHotel);
        pHotelP5.add(lCostHabitacion);
        pHotelP5.add(fTCostHabitacion);
        pHotelP5.add(bIngresHotel);
        
        
        pAerolineaP5.setLayout(new BoxLayout(pAerolineaP5,1));
        pAerolineaP5.add(lAerolineaP5);
        pAerolineaP5.add(lNomAeroLinea);
        pAerolineaP5.add(tNomAerolinea);
        pAerolineaP5.add(lAgregarVuelo);
        pAerolineaP5.add(lCiudOrigen);
        pAerolineaP5.add(tCiudadOrigen);
        pAerolineaP5.add(lCiudDestino);
        pAerolineaP5.add(tCiudadDestino);
        pAerolineaP5.add(lPrecioVuelo);
        pAerolineaP5.add(fTCostVuelo);
        pAerolineaP5.add(bIngresAerolinea);
      
        
        pTransporteP5.setLayout(new BoxLayout(pTransporteP5,1));
        pTransporteP5.add(lTransporteP5);
        pTransporteP5.add(lCiudadTransp);
        pTransporteP5.add(tCiudadTrasp);
        pTransporteP5.add(lCostBus);
        pTransporteP5.add(fTCostBus);
        pTransporteP5.add(lCostChiva);
        pTransporteP5.add(ftCostChiva);
        pTransporteP5.add(lCostBici);
        pTransporteP5.add(fTCostBici);
        pTransporteP5.add(bIngresTransp);
        
        
        pEventosP5.setLayout(new BoxLayout(pEventosP5,1));
        pEventosP5.add(lEventosP5);
        pEventosP5.add(lNomEvent);
        pEventosP5.add(tNomEvento);
        pEventosP5.add(lCiudadEvent);
        pEventosP5.add(tCiudadEvent);
        pEventosP5.add(lCostPersona);
        pEventosP5.add(fTCostEvent);
        pEventosP5.add(lHorarioEvent);
        pEventosP5.add(fTHorarioEvent);
        pEventosP5.add(lFechaEvent);
        pEventosP5.add(fTFechaEvent);
        pEventosP5.add(lLugarEvent);
        pEventosP5.add(tLugarEvent);
        pEventosP5.add(bIngresEvent);
        
        
        pIngresInfo.setLayout(new GridLayout(1,4,3,0));
        pIngresInfo.add(pHotelP5);
        pIngresInfo.add(pAerolineaP5);
        pIngresInfo.add(pTransporteP5);
        pIngresInfo.add(pEventosP5);
   
        //pestaña 6 (Estadisticas)
        pIzqP6 = new JPanel();
        pDerP6 = new JPanel();
        
        lCiudadesP6 = new JLabel("Ciudades con mas Reservas");
        lHotelesP6 = new JLabel("Hoteles con mas Reservas");
        
        tCiudadesP6  = new JTextArea("");
        tHotelesP6 = new JTextArea("");
        
        barrasCP6 = new JScrollPane(tCiudadesP6);
        barrasHP6 = new JScrollPane(tHotelesP6);
        
        pEstadisticas.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 30),""));
                
        pIzqP6.setLayout(new BoxLayout(pIzqP6, 1));
        pIzqP6.add(lCiudadesP6);
        pIzqP6.add(barrasCP6);
        
        pDerP6.setLayout(new BoxLayout(pDerP6, 1));
        pDerP6.add(lHotelesP6);
        pDerP6.add(barrasHP6);
        
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

        setTitle("Agencia De Viajes");
        setSize(900, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    class ManejadoraEventos implements ActionListener {
        
        AgenciaDeViajes agenciaViajes;
        
        public ManejadoraEventos()
        {
            agenciaViajes = new AgenciaDeViajes();
        }

        @Override
        public void actionPerformed(ActionEvent ae) 
        {

            if(ae.getSource() == bBuscarP1)
            {
                String destino = ciudadDestino.getItemAt(ciudadDestino.getSelectedIndex());
                int vMin = (Integer)fTValMin.getValue();
                int vMax = (Integer)fTValMax.getValue();
                int diasViaje = (Integer)sDiasViaje.getValue();
                int cantViajeros = (Integer)sPersonasViaje.getValue();
                String datos = agenciaViajes.catalogo(destino, vMin, vMax, diasViaje, cantViajeros);
                area.setText(datos);
            }
            if(ae.getSource() == bBuscarP2)
            {
                String destino = ciudadDestinoP2.getItemAt(ciudadDestinoP2.getSelectedIndex());
                String listaHoteles = agenciaViajes.listarHoteles(destino);
                String listaEventos = agenciaViajes.listarEventosCulturales(destino);
                tHotelesList.setText(listaHoteles);
                tEventosList.setText(listaEventos);
            }
            if(ae.getSource() == bCrearReserv)
            {
                JOptionPane.showMessageDialog(null, "Falta enlazar acción!");
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
                String ciudadH = tCiudadHotel.getText();
                double precio = (Integer)fTCostHabitacion.getValue();
                String mensaje = agenciaViajes.registrarHotel(nombreH, estrellas, ciudadH, precio);
                JOptionPane.showMessageDialog(null, mensaje);
            }
            if(ae.getSource() == bIngresAerolinea)
            {
                
            }
            if(ae.getSource() == bIngresTransp)
            {
                String ciudadT = tCiudadTrasp.getText();
                double precioBus = (Integer)fTCostBus.getValue();
                double precioChiva = (Integer)ftCostChiva.getValue();
                double precioBicicleta = (Integer)fTCostBici.getValue();
                String mensaje = agenciaViajes.registrarTransporte(ciudadT, precioBus, precioChiva, precioBicicleta);
                JOptionPane.showMessageDialog(null, mensaje);
            }
            if(ae.getSource() == bIngresTransp)
            {
                // String nombreE = tCiudadTrasp.getText();
                // String ciudadE = tCiudadTrasp.getText();
                // double costo
                // String horario
                // String fecha
                // String lugar
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
