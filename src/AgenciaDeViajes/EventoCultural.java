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
import java.time.*;
/**
 *
 * @author ruzbe
 */
public class EventoCultural {
    
    private String nombreEvento;
    private String ciudad;
    private double costo;
    private String horario;
    private LocalDate fecha;
    private String lugar;
    
    /**
     * inicializa los datos de un evento cultural.
     */
    EventoCultural(String nombreEvento, String ciudad, double costo, 
            String horario, String fecha, String lugar){
       this.nombreEvento = nombreEvento;
       this.ciudad = ciudad;
       this.costo = costo;
       this.horario = horario;
       this.fecha = LocalDate.parse(fecha);
       this.lugar = lugar;
   }
    
    /**
     * Obtiene el nombre del evento.
     * @return String con el nombre del evento
     */
    public String getNombre(){
        return this.nombreEvento;
    }
    
    /**
     * Obtiene el nombre de la ciudad en que se hará el evento.
     * @return String con el nombre de la ciudad del evento
     */
    public String getCiudad(){
        return this.ciudad;
    }
    
    /**
     * Obtiene el costo del evento.
     * @return double con el costo del evento.
     */
    public double getCosto(){
        return this.costo;
    }
    
    /**
     * Obtiene la fecha del evento.
     * @return LocalDate con la fecha del evento.
     */
    public LocalDate getFecha(){
        return this.fecha;
    }
    
    /**
     * Obtiene toda la informacion del evento.
     * @return String con la informacion del evento.
     */
    public String getInformacion(){
        String infoTotal = "Evento: " + getNombre() +
                "\nCiudad: " + this.ciudad +
                "\nCosto: " + this.costo +
                "\nHorario: " + this.horario +
                "\nFecha: " + this.fecha.toString() +
                "\nLugar: " + this.lugar;
        return infoTotal;
    }

}
