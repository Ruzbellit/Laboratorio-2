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


import java.util.*;
/**
 *
 * @author Daniel
 */
public class Aerolinea {
    
    private String nombre;
    
    ArrayList<Vuelo> vuelos;

    /**
     * Inicializa atributos, datos de la aerolinea.
     * @param String nombre de la aerolinea 
     */
     Aerolinea(String nombre)
        {
          this.nombre = nombre;
          vuelos = new ArrayList <>();
        }
     
     /**
     * obtiene el nombre de la aerolinea.
     * @return String con el nombre de la aerolinea 
     */
     public String getNombre()
     {
         return this.nombre;
     }
     
      /**
     * indica si un vuelo se encuenta disponible o no.
     * @param String con la ciudad de origen
     * @param String con la ciudad de destino
     * @return boolean indicando si hay o no vuelos con esos destinos
     */
     public boolean consultarVuelo(String origen, String destino)
     {
       boolean vueloDisponible = true;
      
      for (Vuelo x: vuelos)
      {
          
          if((x.getOrigen().equals(origen)) && x.getDestino().equals(destino))
          {
              return vueloDisponible;
          }
          else 
          {
              vueloDisponible = false;
          }
      }  
      
      return vueloDisponible;
      
     }
     
     /**
     * obtiene el precio de un vuelo al consultar su origen y destino.
     * @param String con la ciudad de origen
     * @param String con la ciudad de destino
     * @return double con el precio del vuelo. 
     */
    public double precioVuelo(String origen, String destino)
    {
      double precioVuelo = 0;
         
      for (Vuelo x: vuelos)
      {    
          if((x.getOrigen().equals(origen)) && x.getDestino().equals(destino))
          {
              precioVuelo = x.getPrecio();
          }
      }         
      return precioVuelo;
    }
    
     /**
     * agrega un vuelo a su lista de vuelos.
     * @param String con la ciudad de origen
     * @param String con la ciudad de destino 
     * @param double con el precio del vuelo
     */
    public void agregarVuelo (String origen, String destino, double precio)
    {   
        vuelos.add(new Vuelo(origen, destino, precio)); 
    }

}