/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgenciaDeViajes;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author ruzbe
 */
public class Validaciones {
    

    public static Boolean validarFecha(String textoFecha) {
        LocalDate fechaAhora = LocalDate.now();
        try {
            LocalDate fecha = LocalDate.parse(textoFecha);
            if (fechaAhora.isAfter(fecha)) {
                JOptionPane.showMessageDialog(null, "La fecha de viaje debe ser superior a la fecha actual", "error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            String mensaje = "Error al convertir fecha"
                    + "formato 'yyyy-MM-dd'";
            JOptionPane.showMessageDialog(null, mensaje, "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Validar si hay vuelos disponibles con la aerolinea seleccionada, ciudad de origen y ciudad de destino

}
