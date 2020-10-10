/*
  Autor: Ruzbellit Rossy Romero Ramirez (1925456)
  Email: ruzbellit.romero@correounivalle.edu.co
  Autor: Christian Villanueva Paez (1924546)
  Email: christian.villanueva@correounivalle.edu.co
  Autor: Daniel Rodriguez Sanchez (1927631)
  Email: daniel.rodriguez.sanchez@correounivalle.edu.co
  Fecha última modificación: 2020-09-14
*/
package AgenciaDeViajes;

import javax.swing.*;
import java.util.*;
import java.time.*;

/**
 *
 * @author villa
 */
public class AgenciaDeViajes {

    //declaracion de los array de reservas, hoteles, aerolineas y transportes
    private ArrayList<Reserva> reservaciones;
    private ArrayList<Hotel> hoteles;
    private ArrayList<Aerolinea> aerolineas;
    private ArrayList<EventoCultural> eventosCulturales;
    private ArrayList<TransporteCiudad> transportes;

    //declaración del area de texto
    JTextArea area;
    JScrollPane barras;

    /**
     * inicializa las listas y las areas de texto
     */
    AgenciaDeViajes() {
        reservaciones = new ArrayList<>();
        hoteles = new ArrayList<>();
        aerolineas = new ArrayList<>();
        eventosCulturales = new ArrayList();
        transportes = new ArrayList<>();

        area = new JTextArea();
        barras = new JScrollPane(area);
        barras.createVerticalScrollBar();
        listadoDePrueba();
    }

    /**
     * permite ingresar informacion de alguno de las opciones disponibles
     * (hotel, aerolinea, medios de transporte, eventos culturales)
     */
    private void ingresarInformacion() {
        String opcion = "";
        do {

            opcion = JOptionPane.showInputDialog("Escoga el tipo de informacion que desea ingresar\n"
                    + "1. Hotel\n"
                    + "2. Aerolínea\n"
                    + "3. Medios de Transporte\n"
                    + "4. Eventos Culturales\n"
                    + "5. Regresar al Menú");

            switch (opcion) {
                case "1": //ingresar la informacion del hotel
                    String nombreH = JOptionPane.showInputDialog("Ingrese nombre del hotel").trim().toUpperCase();
                    int estrellas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la calificacion de estrellas").trim());
                    String ciudadH = JOptionPane.showInputDialog("Ingrese la ciudad del hotel").trim().toUpperCase();
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese costo del hotel por habitacion"));

                    hoteles.add(new Hotel(estrellas, nombreH, ciudadH, precio));

                    area.setText(
                            "Informacion del hotel ingresado con exito\n\n"
                            + nombreH + "\n" + estrellas + "\n" + ciudadH + "\n" + precio
                    );
                    JOptionPane.showMessageDialog(null, barras);
                    break;
                case "2": //ingresar informacion y los vuelos de una aerolinea
                    String nombreA = JOptionPane.showInputDialog("Ingrese el nombre de la aerolinea").trim().toUpperCase();
                    Aerolinea aerolinea = new Aerolinea(nombreA);
                    String opcionA = "";

                    do {
                        opcionA = JOptionPane.showInputDialog("Desea agregar vuelos a la aerolinea"
                                + "\n1. Agregar vuelo"
                                + "\n0. Salir");
                        switch (opcionA) {
                            case "0":
                                break;
                            case "1":
                                String origenA = JOptionPane.showInputDialog("Ingrese la ciudad de origen del vuelo").trim().toUpperCase();
                                String destinoA = JOptionPane.showInputDialog("Ingrese la ciudad de destino del vuelo").trim().toUpperCase();
                                double precioA = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del vuelo").trim());
                                aerolinea.agregarVuelo(origenA, destinoA, precioA);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                        }
                    } while (!opcionA.equals("0"));
                    aerolineas.add(aerolinea);

                    area.setText("Informacion de la aerolina ingresado con exito:\n\n"
                            + nombreA);
                    JOptionPane.showMessageDialog(null, barras);
                    break;

                case "3": //ingresar informacion de medios de transporte en una ciudad
                    String ciudadT = JOptionPane.showInputDialog("Ingrese la ciudad").trim().toUpperCase();
                    double precioBus = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo del pasaje del bus").trim());
                    double precioChiva = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo del pasaje de chiva").trim());
                    double precioBicicleta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo del alquiler de la bicicleta").trim());

                    transportes.add(new TransporteCiudad(ciudadT, precioBus, precioChiva, precioBicicleta));

                    area.setText("Informacion de los medios de transporte ingresado con exito:\n"
                            + "\nCiudad: " + ciudadT
                            + "\nPrecio pasaje Bus: " + precioBus
                            + "\nPrecio pasaje Chiva: " + precioChiva
                            + "\nPrecio alquiler Bicicleta: " + precioBicicleta);
                    JOptionPane.showMessageDialog(null, barras);
                    break;

                case "4": //ingresar informacion sobre los eventos culturales
                    String nombreE = JOptionPane.showInputDialog("Ingrese el nombre del evento").trim().toUpperCase();
                    String ciudadE = JOptionPane.showInputDialog("Ingrese la ciudad").trim().toUpperCase();
                    double costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo por persona").trim());
                    String horario = JOptionPane.showInputDialog("Ingrese el horario").trim();
                    String fecha = JOptionPane.showInputDialog("Ingrese la fecha del evento (yyyy-MM-dd)").trim();
                    String lugar = JOptionPane.showInputDialog("Ingrese el lugar del evento").trim().toUpperCase();

                    eventosCulturales.add(new EventoCultural(nombreE, ciudadE, costo, horario, fecha, lugar));

                    area.setText("Informacion del evento ingresado con exito\n"
                            + "\nEvento: " + nombreE
                            + "\nCiudad: " + ciudadE
                            + "\nCosto entrada: " + costo
                            + "\nHorario: " + horario
                            + "\nFecha evento: " + fecha
                            + "\nLugar evento: " + lugar);
                    JOptionPane.showMessageDialog(null, barras);
                    break;

                case "5":
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                    break;
            }
        } while (!opcion.equals("5"));
    }

    /**
     * lista las posibles opciones a escoger de acuerdo a los parametros
     * ingresados (ciudad, rango de valores, dias de viaje, cantidad de
     * personas)
     */
    public String catalogo(String ciudadDestino, int valorMinimo, int valorMaximo, int diasViaje, int cantidadPersonas) {

        String datos = "Opciones disponibles de acuerdo a los parametros indicados:\n"
                + "Ciudad destino: " + ciudadDestino
                + "\nRango de precio: " + valorMinimo + " - " + valorMaximo
                + "\nDias de viaje: " + diasViaje
                + "\nCantidad de personas a viajar: " + cantidadPersonas + "\n";
        int contador = 1;

        /*
        lista los hoteles de la ciudad, combinado con los eventos a los que
        puede asistir
         */
        for (Hotel x : hoteles) {
            if (x.getCiudad().equals(ciudadDestino)) {
                double precioTotal = 0;
                if (x.getPrecio() * diasViaje * cantidadPersonas < valorMaximo) {
                    precioTotal = x.getPrecio() * diasViaje * cantidadPersonas;
                    datos += "\n\tOpcion " + contador
                            + "\nNombre Hotel: " + x.getNombre()
                            + "\nEstrellas: " + x.getEstrellas()
                            + "\nPrecio hotel dia: " + x.getPrecio()
                            + "\nPrecio Total (Hotel): " + precioTotal;
                    contador++;

                    /*
                    muestra los eventos de la ciudad, combinado con los diferentes
                    tipo de transporte y su precio
                     */
                    datos += "\n\nPosibles eventos a asistir:";
                    for (EventoCultural e : eventosCulturales) {
                        if (e.getCiudad().equals(ciudadDestino)) {
                            datos += "\n" + e.getInformacion();

                            for (TransporteCiudad t : transportes) {
                                if (t.getCiudad().equals(ciudadDestino)) {
                                    datos += "\nPrecio Total en Bus (Hotel, Evento, Transporte): ";
                                    if (precioTotal + t.getPrecio("BUS") * cantidadPersonas * diasViaje < valorMaximo) {
                                        datos += precioTotal + e.getCosto() * cantidadPersonas + t.getPrecio("BUS") * cantidadPersonas * diasViaje;
                                    } else {
                                        datos += "Excede el precio maximo\n";
                                    }

                                    datos += "\nPrecio Total en Chiva (Hotel, Evento, Transporte): ";
                                    if (precioTotal + t.getPrecio("CHIVA") * cantidadPersonas * diasViaje < valorMaximo) {
                                        datos += precioTotal + e.getCosto() * cantidadPersonas + t.getPrecio("CHIVA") * cantidadPersonas * diasViaje;
                                    } else {
                                        datos += "Excede el precio maximo\n";
                                    }

                                    datos += "\nPrecio Total en Bicicleta (Hotel, Evento, Transporte): ";
                                    if (precioTotal + t.getPrecio("BICICLETA") * cantidadPersonas * diasViaje < valorMaximo) {
                                        datos += precioTotal + e.getCosto() * cantidadPersonas + t.getPrecio("BICICLETA") * cantidadPersonas * diasViaje + "\n";
                                    } else {
                                        datos += "Excede el precio maximo\n";
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        return datos;
    }

    /**
     * lista todos los hoteles
     *
     * @return lista de hoteles
     */
    public String listarHoteles() {
        if (!hoteles.isEmpty()) {
            String datos = "";
            for (Hotel x : hoteles) {
                datos += x.getInformacion() + "\n\n";
            }
            return datos;
        } else {
            return "No hay hoteles listados";
        }
    }

    /**
     * lista los hoteles de acuerdo a la ciudad solicitada
     *
     * @param ciudad
     * @return lista de hoteles
     */
    public String listarHoteles(String ciudad) {
        if (!hoteles.isEmpty()) {
            String datos = "";
            for (Hotel x : hoteles) {
                if (x.getCiudad().equals(ciudad)) {
                    datos += x.getInformacion() + "\n";
                }
            }
            if (datos.equals("")) {
                return "No hay Hoteles disponibles para la ciudad seleccionada";
            }
            return datos;
        } else {
            return "No hay hoteles listados para esta ciudad";
        }
    }

    /**
     * lista los hoteles de acuerdo a la ciudad y cantidad de estrellas
     * solicitada
     *
     * @param ciudad
     * @param estrellas
     * @return lista de hoteles
     */
    public String listarHoteles(String ciudad, int estrellas) {
        if (!hoteles.isEmpty()) {
            String datos = "";
            int enumerador = 1;
            boolean disponible = false;
            for (Hotel x : hoteles) {
                if (x.getCiudad().equals(ciudad) && x.getEstrellas() == estrellas) {
                    datos += enumerador + ". " + x.getInformacion() + "\n";
                    enumerador++;
                    disponible = true;
                }
            }
            if (disponible) {
                return datos;
            } else {
                return "No hay hoteles listados para esta ciudad\ny con la calificacion en estrellas deseada";
            }
        } else {
            return "No hay hoteles listados para esta ciudad\ny con la calificacion en estrellas deseada";
        }
    }

    /**
     * lista todos los eventos disponibles
     *
     * @return
     */
    public String listarEventosCulturales() {
        if (!eventosCulturales.isEmpty()) {
            String datos = "";
            for (EventoCultural x : eventosCulturales) {
                datos += x.getInformacion() + "\n\n";
            }
            return datos;
        } else {
            return "No hay eventos culturales listados";
        }
    }

    /**
     * lista todos los eventos disponibles en una ciudad establecida
     *
     * @return
     */
    public String listarEventosCulturales(String ciudad) {
        if (!eventosCulturales.isEmpty()) {
            String datos = "";
            for (EventoCultural x : eventosCulturales) {
                if (x.getCiudad().equals(ciudad)) {
                    datos += x.getInformacion() + "\n\n";
                }
            }
            if (datos.equals("")) {
                return "No hay eventos culturales disponibles para la ciudad seleccionada";
            }
            return datos;
        } else {
            return "No hay eventos culturales listados";
        }
    }

    /**
     * hace un listado de los eventos en una ciudad y dentro de una fecha
     * establecida
     *
     * @param ciudad
     * @return lista de eventos
     */
    private String listarEventosCulturales(String ciudad, LocalDate fechaViaje, LocalDate fechaRegreso) {
        if (!eventosCulturales.isEmpty()) {
            String datos = "";
            for (EventoCultural x : eventosCulturales) {
                if (x.getCiudad().equals(ciudad) && x.getFecha().isAfter(fechaViaje) && x.getFecha().isBefore(fechaRegreso)) {
                    datos += x.getInformacion() + "\n";
                }
            }
            return datos;
        } else {
            return "No hay eventos culturales listados para esta ciudad";
        }
    }

    /**
     * hace un listado de precios de los medios de transporte que hay en una
     * ciudad
     *
     * @param ciudad
     * @return lista de precios de los medios de transporte
     */
    private String listarTransporteCiudad(String ciudad) {
        for (TransporteCiudad x : transportes) {
            if (x.getCiudad().equals(ciudad)) {
                return x.getInformacionPrecios();
            }
        }
        return "No hay medios de transporte listados para esta ciudad";
    }

    /**
     * hace un listado de las aerolineas que contengan vuelos hacia las ciudades
     * indicadas y su precio
     *
     * @param origen
     * @param destino
     * @return lista de los vuelos hacia las ciudades indicadas y sus precios
     */
    private String listarAerolineas(String origen, String destino) {
        String datos = "";
        for (Aerolinea x : aerolineas) {
            if (x.consultarVuelo(origen, destino)) {
                datos += x.getNombre() + "\nPrecio: " + x.precioVuelo(origen, destino) + "\n";
            }
        }
        return datos;
    }

    /**
     * el usuario ingresa la informacion acerca de la reserva a realizar, con
     * respecto a las opciones disponibles
     */
    private void realizarReserva() {
        String ciudadDestinoReserva = JOptionPane.showInputDialog("Ingrese ciudad de destino").trim().toUpperCase();

        LocalDate fechaViaje = LocalDate.parse(JOptionPane.showInputDialog("Ingrese fecha de viaje (yyyy-MM-dd)").trim());
        int diasViaje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los dias de viaje").trim());
        LocalDate fechaRegreso = fechaViaje.plusDays(diasViaje);

        /*pregunta acerca de las estrellas del hotel deseado y lista los hoteles disponibles,
        para seleccionar solo debe introducir el nombre del hotel
         */
        int estrellasHotelReserva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las estrellas del hotel deseado"));
        String escogerHotel = "Introduzca el nombre del hotel deseado:\n" + listarHoteles(ciudadDestinoReserva, estrellasHotelReserva);
        String nombreHotel = JOptionPane.showInputDialog(escogerHotel).toUpperCase();
        double costoHotel = 0;
        for (Hotel x : hoteles) {
            if (x.getNombre().equals(nombreHotel)) {
                costoHotel = x.getPrecio();
                break;
            }
        }

        /*
        
         */
        String escogerAerolinea = "Escoja la aerolinea deseada\n" + listarAerolineas("CALI", ciudadDestinoReserva);
        String nombreAerolinea = JOptionPane.showInputDialog(escogerAerolinea).trim().toUpperCase();
        for (Aerolinea x : aerolineas) {
            if (x.getNombre().equals(nombreAerolinea)) {
                x.precioVuelo("CALI", ciudadDestinoReserva);
                break;
            }
        }

        int viajeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas viajar").trim());

        /*
        el usuario ingresa el tipo de transporte deseado
         */
        String escogerMedioTransporte = "Introduza el tipo de medio de transporte deseado\n" + listarTransporteCiudad(ciudadDestinoReserva);
        String tipoTransporteDeseado = JOptionPane.showInputDialog(escogerMedioTransporte).trim().toUpperCase();
        double costoTransporte = 0;
        for (TransporteCiudad x : transportes) {
            if (x.getCiudad().equals(ciudadDestinoReserva)) {
                costoTransporte = x.getPrecio(tipoTransporteDeseado);
                break;
            }
        }

        /*
        el usuario ingresa los eventos a reservar
         */
        String escogerEventoCultural = "Introduzca el nombre del evento cultural a visitar\n"
                + "Digite 0 para ninguno\n"
                + listarEventosCulturales(ciudadDestinoReserva, fechaViaje, fechaRegreso);
        String infoEventosCulturales = "";
        double costoEventos = 0;
        String opcion = "";
        do {
            opcion = JOptionPane.showInputDialog(escogerEventoCultural).trim().toUpperCase();
            switch (opcion) {
                case "0":
                    break;
                default:
                    for (EventoCultural x : eventosCulturales) {
                        if (x.getNombre().equals(opcion)) {
                            infoEventosCulturales += x.getInformacion() + "\n";
                            costoEventos += x.getCosto();
                        }
                    }
            }
        } while (!opcion.equals("0"));

        String idClienteReserva = JOptionPane.showInputDialog("Ingrese la cedula para guardar la reserva").trim();

        if (fechaViaje.getDayOfMonth() >= 25) {
            JOptionPane.showMessageDialog(null, "Aplicado descuento del 15% al valor total, por concepto de viaje al final de mes a cargo de la agencia");
        }

        reservaciones.add(new Reserva(idClienteReserva, fechaViaje, fechaRegreso, viajeros, ciudadDestinoReserva, diasViaje, nombreHotel, costoHotel, nombreAerolinea, 10000, tipoTransporteDeseado, costoTransporte, infoEventosCulturales, costoEventos));
    }

    /**
     * busca una reserva de acuerdo con el numero de identidad a la cual fue
     * guardada la reserva
     */
    private void consultarReserva() {
        String buscarReserva = JOptionPane.showInputDialog("Ingrese el documento de identidad del cliente").trim();
        if (!reservaciones.isEmpty()) {
            for (Reserva x : reservaciones) {
                if (x.getIdentCliente().equals(buscarReserva)) {
                    area.setText(x.getInformacion());
                    JOptionPane.showMessageDialog(null, barras);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "No se ha encontrado reservas con los parametros ingresados");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado reservas con los parametros ingresados");
        }

    }

    /**
     * muestra la ciudad mas solicitada para viajar y los hoteles preferidos por
     * los usuarios
     */
    private void estadisticas() {
        //
        ArrayList<String> ciudades = new ArrayList<>();
        for (Reserva r : reservaciones) {
            if (!ciudades.contains(r.getCiudadDestino())) {
                ciudades.add(r.getCiudadDestino());
            }
        }
        String datos = "Ciudades con mas reservas:\n";
        for (String c : ciudades) {
            int contador = 0;
            for (Reserva r: reservaciones) {
                if (r.getCiudadDestino().equals(c)) {
                    contador++;
                }
            }
            datos += c + ": " + contador + "\n";
        }

        //
        ArrayList<String> hoteles = new ArrayList<>();
        for (Reserva r: reservaciones ) {
            if (!hoteles.contains(r.getHotel())) {
                hoteles.add(r.getHotel());
            }
        }
        datos += "\nHoteles con mas huespedes:\n";
        for(String h: hoteles){
            int contador = 0;
            for(Reserva r: reservaciones){
                if (r.getHotel().equals(h)) {
                    contador += r.getViajeros();
                }
            }
            datos += h + ": " + contador + "\n";
        }

        area.setText(datos);
        JOptionPane.showMessageDialog(null, datos);
    }

    /**
     * despliega todas las opciones a elegir, ademas de la fecha actual
     */
    private void menu() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog("Viajemos por Colombia\n\n"
                    + "Ciudad Actual: Cali\n"
                    + "" + LocalDate.now() + "\n\n"
                    + "1. Ingresar Informacion\n"
                    + "2. Consultar opciones disponibles\n"
                    + "3. Listar hoteles\n"
                    + "4. Listar eventos culturales\n"
                    + "5. Realizar reservacion\n"
                    + "6. Consultar reserva\n"
                    + "7. Estadisticas\n"
                    + "8. Salir");

            switch (opcion) {
                case "1": //ingresar informacion
                    ingresarInformacion();
                    break;
                case "2": // consultar todas las opciones disponibles
                    //el usuario ingresa los parametros para listar las opciones disponibles
                    String ciudadDestino = JOptionPane.showInputDialog("Ingrese la ciudad de destino").trim().toUpperCase();
                    int valorMinimo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor minimo del viaje").trim());
                    int valorMaximo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor maximo del viaje").trim());
                    int diasViaje = Integer.parseInt(JOptionPane.showInputDialog("Digite los dias de viaje").trim());
                    int cantidadPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas a viajar").trim());
                    String datos = catalogo(ciudadDestino, valorMinimo, valorMaximo, diasViaje, cantidadPersonas);
                    area.setText(datos);
                    JOptionPane.showMessageDialog(null, barras);
                    break;
                case "3": //listar hoteles
                    area.setText(listarHoteles());
                    JOptionPane.showMessageDialog(null, barras);
                    break;
                case "4": //listar eventos culturales
                    area.setText(listarEventosCulturales());
                    JOptionPane.showMessageDialog(null, barras);
                    break;
                case "5": //realizar reserva
                    realizarReserva();
                    break;
                case "6": //consultar reservaciones
                    consultarReserva();
                    break;
                case "7": //mostrar estadisticas
                    estadisticas();
                    break;
                case "8": //salir
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                    break;
            }
        } while (!opcion.equals("8"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AgenciaDeViajes app = new AgenciaDeViajes();
        app.menu();
    }

    /**	
     * agrega un hotel, una aerolinea, un evento y medios de transportes a las	
     * listas iniciales	
     */	
    private void listadoDePrueba() {	
        hoteles.add(new Hotel(3, "INTERCONTINENTAL", "Bogotá", 60000));	
        hoteles.add(new Hotel(5, "SUPREMO", "Bogotá", 100000));	
        hoteles.add(new Hotel(3, "AMERICANO", "Medellín", 50000));	
        hoteles.add(new Hotel(5, "PARAISO", "Medellín", 80000));	
        eventosCulturales.add(new EventoCultural("CONCIERTO SHAKIRA", "Bogotá", 25000, "5 P.M - 10 P.M", "2020-10-12", "SOACHA"));	
        eventosCulturales.add(new EventoCultural("DIA DE LA INDEPENDENCIA", "Bogotá", 0, "5 P.M - 10 P.M", "2020-07-20", "PALACIO DE NARIÑO"));	
        eventosCulturales.add(new EventoCultural("FERIA DE LAS FLORES", "Medellín", 20000, "5 P.M - 10 P.M", "2020-07-01", "PRINCIPALES AUTOPISTAS"));	
        eventosCulturales.add(new EventoCultural("FIESTA DE LA VIRGEN DEL CARMEN", "Medellín", 4000, "5 P.M - 10 P.M", "2020-07-16", "MUNICIPIO DE FRONTINO"));	
        transportes.add(new TransporteCiudad("Bogotá", 2500, 2000, 1000));	
        transportes.add(new TransporteCiudad("Medellín", 2200, 1600, 600));	
    }

}
