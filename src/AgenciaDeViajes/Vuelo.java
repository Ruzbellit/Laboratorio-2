/*
  Autor: Ruzbellit Rossy Romero Ramirez (1925456)
  Email: ruzbellit.romero@correounivalle.edu.co
  Autor: Daniel Rodriguez Sanchez (1927631)
  Email: daniel.rodriguez.sanchez@correounivalle.edu.co
  Autor: Christian Villanueva Paez (1924546)
  Email: christian.villanueva@correounivalle.edu.co
  Fecha última modificación: 2020-09-14
*/
package AgenciaDeViajes;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Vuelo {
    
    private String origen;
    private String destino;
    private double precio;
    
     /**
     * Inicializa atributos, datos del vuelo.
     * @param origen lugar donde inicia
     * @param destino lugar donde va a llegar
     * @param precio valor del vuelo
     */
    Vuelo(String origen, String destino, double precio)
    {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;  
    }
    
    /**
     * devuelve el lugar donde sale el vuelo.
     * @return String ciudad donde sale el vuelo
     */
    public String getOrigen()
    {
        return this.origen;  
    }
    
    /**
     * devuelve el lugar donde llega el vuelo.
     * @return String con la ciudad donde llega el vuelo.
     */
    public String getDestino()
    {
        return this.destino;
    }
    
    /**
     * devuelve el valor del vuelo.
     * @double con el valor del vuelo
     */
    public double getPrecio()
    {
        return this.precio;
    }
    
    /**
     * indica si el trayecto de un vuelo se encuenta disponible o no.
     * @return boolean que indica si hay o no vuelos
     * @param String lugar origen
     * @param String lugar destino
     */
    public boolean trayecto(String origen, String destino)
    {
        boolean vueloDisponible = true;
        
          if((this.getOrigen().equals(origen)) && this.getDestino().equals(destino))
          {
              return vueloDisponible;
          }
          else 
          {
              vueloDisponible = false;
          }
      
        return vueloDisponible;
      
    }
    
    
}
