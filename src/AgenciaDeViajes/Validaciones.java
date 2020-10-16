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

    public static Boolean validarCedula(String cedula) {
        if (cedula.equals("")) {
            JOptionPane.showMessageDialog(null, "La cédula no puede estar vacía", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
