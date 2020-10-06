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

import java.time.*;
/**
 *
 * @author ruzbe
 */
public class Reserva {
    
    private String nombreCliente;
    private String idCliente;
    private LocalDate fechaViaje;
    private LocalDate fechaRegreso;
    private int viajeros; 
    private String ciudadDestino;
    private int diasViaje;
    private String nombreHotel;
    private double costoHotel;
    private String nombreAerolinea;
    private double costoAerolinea;
    private String tipoTransporte;
    private double costoTransporte; 
    private String infoEventos;
    private double costoEventos;
    
     /**
     * inicializa los datos de la reserva.
     */
    Reserva(String idCliente, LocalDate fechaViaje, LocalDate fechaRegreso, int viajeros, 
            String ciudadDestino, int diasViaje, String nombreHotel, 
            double costoHotel, String nombreAerolinea, double costoAerolinea, String tipoTransporte,
            double costoTransporte, String infoEventos, double costoEventos) {
        this.idCliente = idCliente;
        this.fechaViaje = fechaViaje;
        this.fechaRegreso = fechaRegreso;
        this.viajeros = viajeros; 
        this.ciudadDestino = ciudadDestino;
        this.diasViaje = diasViaje;
        this.nombreHotel = nombreHotel;
        this.costoHotel = costoHotel;
        this.nombreAerolinea = nombreAerolinea;
        this.costoAerolinea = costoAerolinea;
        this.tipoTransporte = tipoTransporte;
        this.costoTransporte = costoTransporte; 
        this.infoEventos = infoEventos;
        this.costoEventos = costoEventos;
    }
    
     /**
     * Muestra la identificacion del cliente.
     * @return String con la identificacion del cliente.
     */
    public String getIdentCliente(){
        return this.idCliente;
    }
    
    /**
     * Muestra la ciudad del destino donde desea ir el cliente.
     * @return String con el nombre de la ciudad de destino.
     */
    public String getCiudadDestino(){
        return this.ciudadDestino;
    }
    
    /**
     * Muestra el hotel donde desea hospedarse el cliente.
     * @return String con el nombre del hotel.
     */
    public String getHotel(){
        return this.nombreHotel;
    }
    
    /**
     * Muestra la cantidad de personas que viajaran.
     * @return int con el numero de personas que viajaran.
     */
    public int getViajeros(){
        return this.viajeros;
    }
    
    /**
     * Muestra el costo total que se gastara en el hotel por los
     * dias y personas que se hospedaran.
     * @return double con el costo total de solo el hotel.
     */
    public double costoTotalHotel(){
        return this.costoHotel * this.diasViaje * this.viajeros;
    }
    
     /**
     * Muestra el costo total que se gastara en el transporte.
     * @return double con el costo total de solo el transporte para todas las personas.
     */
    public double costoTotalTransporte(){
        return this.costoTransporte * this.viajeros;
    }

     /**
     * Muestra el costo total del viaje completo con hoteles, transpote s aerolineas.
     * @return double con el costo total de todo el viaje.
     */
    public double costoViajeTotal() {
        return costoTotalHotel() +  this.costoEventos + 
                (this.costoTransporte * this.viajeros) + (this.costoAerolinea * this.viajeros);
    }
    
     /**
     * Muestra la informacion total de la reserva.
     * @return String con toda la informacion del viaje.
     */
    public String getInformacion() {
        String infoReserva = "ID Cliente: " + this.idCliente +
                "\nFecha de Viaje: " + this.fechaViaje.toString() +
                "\nDias de Viaje: " + Integer.toString(this.diasViaje) +
                "\nFecha de Regreso: " + this.fechaRegreso.toString() +
                "\nCantidad de Viajeros: " + this.viajeros + 
                "\nCiudad Destino: " + this.ciudadDestino +
                "\n\nNombre Hotel: " + this.nombreHotel +
                "\nCosto Hotel: " + Double.toString(this.costoHotel) +
                "\nCosto Hotel Total: " + this.costoTotalHotel() +
                "\nNombre Aerolinea" + this.nombreAerolinea +
                "\nCosto Aerolina: " + Double.toString(this.costoAerolinea) +
                "\n\nTipo Transporte: " +  this.tipoTransporte +
                "\nCosto Transporte: " + Double.toString(this.costoTransporte) +
                "\nCosto Transporte Total: " + Double.toString(costoTotalTransporte()) +
                "\n\nInformacion Eventos:\n" + this.infoEventos +
                "\nCosto Eventos: " + Double.toString(this.costoEventos) +
                "\n\nCosto Total: " + costoViajeTotal();
        
        if(fechaViaje.getDayOfMonth() >= 25)
        {
            infoReserva += "\n\nDescuento del 15% de acuerdo a politico de descuento" +
                    "\n\nCosto Total (Descuento 15%): " + ( costoViajeTotal() * (1 - .15) );
        }
                
        return infoReserva;
    }
    
}
