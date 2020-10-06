/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentresejuego;

/**
 *
 * @author ruzbe
 */
public class ConcentreseJuego {

      int vidas;
      int fallos;
      int aciertos;
      int matriz[][] = new int[4][4];
      boolean matrizDestapar[][] = new boolean[4][4];
      boolean casillaDestapada = false ;
      int casillaDestapadaX;
      int casillaDestapadaY;
      int juegosTotales;
      int juegosGanados;
      String estadisticas;
      
    
    public String mostrarAyuda()
    {
        return "CONCENTRCE"+"\n"+"Saludos invocador, "
                + "Primero debe seleccionar la tematica del juego y presionar el botón de Iniciar Juego, "
                + "una vez inicie se le mostrara por un tiempo de cuatro (4) segundos la distribución de las cartas "
                + "dispondra de tres (3) intentos para encontrar todas las parejas de cartas"+"\n"
                +"Mucha suerte! c:";
    }
    
    public String mostrarEstadisticas()
    {
        return "Estadisticas de Jugadas\n"+"\n"
                +"Cantidad de juegos realizados: "+ juegosTotales +"\n"
                + "Porcentaje de juegos ganados: "+ ((juegosGanados/juegosTotales)*100) +"%\n"
                + "Porcentaje de juegos perdidos "+ (((juegosTotales - juegosGanados)/juegosTotales)*100) +"%\n"
                ;
                
    }
    
    
    
    
    
    
    
    
    
    
    
}   

