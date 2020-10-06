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

/**
 *
 * @author Daniel
 */
public class Hotel {
    private int estrellas;
    private String nombre;
    private String ciudad;
    private double precio;
    
     /**
     * Inicializa atributos, datos del hotel.
     * @param int estrellas del hotel
     * @param String nombre del hotel
     * @param String nombre de la ciudad donde esta el hotel
     * @param double precio del hotel por noche 
     */
    Hotel(int estrellas, String nombre, String ciudad, double precio)
    {
    this.estrellas = estrellas;
    this.nombre = nombre;
    this.ciudad = ciudad;
    this.precio = precio;
    
    }
    
    /**
     * Obtiene el número de estrellas del hotel.
     * @return int con el numero de estrellas.
     */
    public int getEstrellas(){
        
        return this.estrellas;
    }
    
     /**
     * Obtiene el nombre del hotel.
     * @retun String con el nombre del hotel
     */
    public String getNombre(){
    
        return this.nombre;
    }
    
    /*Funcion que retorna la ciudad donde se encuentra el hotel*/
     /**
     * retorna la ciudad donde se encuentra del hotel.
     * @retun String con el nombre de la ciudad.
     */
    public String getCiudad(){
    
        return this.ciudad;
    }
    
     /**
     * Obtiene el precio del hotel.
     * @retun double con el precio del hotel
     */
    public double getPrecio(){
        
        return this.precio;
    }
    
    /**
     * Obtiene toda la informacion del hotel.
     * @retun String con los datos del hotel
     */
    public String getInformacion(){
    
        String infoHotel = "Nombre: "+ getNombre() +
                "\nEstrellas: " + getEstrellas() +
                "\nCiudad: " + getCiudad() +
                "\nPrecio: " + getPrecio();
        
        return infoHotel;
    } 
}
