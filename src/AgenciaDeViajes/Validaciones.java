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

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author ruzbe
 */
public class Validaciones {
    
    /**
     * valida que la fecha no este vacia, que no sea superior a la actual y que se escriba adecuadamente 
     * @param LocalDate fecha
     * @return Boolean validando si esta correcto
     */
    public static Boolean validarFecha(LocalDate fecha) {
        LocalDate fechaAhora = LocalDate.now();
        try {
            if (fecha == null) {
                JOptionPane.showMessageDialog(null, "La fecha de viaje no puede estar vacía", "error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (fechaAhora.isAfter(fecha)) {
                JOptionPane.showMessageDialog(null, "La fecha de viaje debe ser superior a la fecha actual", "error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            String mensaje = "Error al convertir fecha"
                    + "\nformato 'yyyy-MM-dd'";
            JOptionPane.showMessageDialog(null, mensaje, "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /** 
     * valida si el campo de cedula no esta vacio
     * @param cedula
     * @return Boolean validando si esta correcto
     */
    public static Boolean validarCedula(String cedula) {
        if (cedula.equals("")) {
            JOptionPane.showMessageDialog(null, "La cédula no puede estar vacía", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * valida si el hotel ha sido seleccionado
     * @param nombreHotel
     * @return boolean validando si es correcto
     */
    public static Boolean validarHotel(String nombreHotel) {
        if (nombreHotel.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccinar un Hotel", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * valida si la aerolinea esta seleccionada 
     * @param nombreAerolinea
     * @return boolean validando si es correcto 
     */
    public static Boolean validarAerolinea(String nombreAerolinea) {
        if (nombreAerolinea.equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione una aerolínea", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * valida si el vuelo tiene origen y destino diferentes
     * @param ciudadOrigen
     * @param ciudadDestino
     * @return boolean validando si es correcto 
     */
    public static Boolean validarVuelo(String ciudadOrigen, String ciudadDestino) {
        if (ciudadOrigen.equals(ciudadDestino)) {
            JOptionPane.showMessageDialog(null, "La ciudad origen y destino no pueden ser la misma", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * valida si el valor maximo es mayor que el minimo
     * @param valMin
     * @param valMax
     * @return booleando diciendo si es correcto
     */
    public static Boolean validarMaxMin(int valMin, int valMax) {
        if (valMin > valMax) {
            JOptionPane.showMessageDialog(null, "El valor maximo no puede ser menor al valor minimo", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
