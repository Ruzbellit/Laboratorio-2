/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentresejuego;

import java.util.*;

/**
 *
 * @author ruzbe
 */
public class ConcentreseJuego {

    int vidas;
    int fallos;
    int aciertos;
    int matriz[][] = new int[4][4];
    boolean matrizDestapar[][];
    boolean casillaDestapada = false;
    int casillaDestapadaX;
    int casillaDestapadaY;
    int juegosTotales;
    int juegosGanados;
    String estadisticas;

    public void iniciarJuego() {
        matrizDestapar = new boolean[4][4];
        for (int numeroImagen = 1; numeroImagen <= 8; numeroImagen++) {
            for (int c = 1; c < 3; c++) {
                int randomX = 0;
                int randomY = 0;
                while(Validaciones.compararNumeroMatriz(matriz, randomX, randomY, numeroImagen) != -1){
                    
                }

            }
        }

    }

    public void destaparCasilla(int x, int y) {
        if (!matrizDestapar[x][y]) {
            matrizDestapar[x][y] = true;
            if (casillaDestapada) { //verifica si ya se ha destapado otra casilla
                compararCasillas(casillaDestapadaX, casillaDestapadaY, x, y);
            } else {
                casillaDestapada = true;
                casillaDestapadaX = x;
                casillaDestapadaY = y;
            }
        }

    }

    public void compararCasillas(int casillaX1, int casillaY1, int casillaX2, int casillaY2) {
        if (matriz[casillaX1][casillaY1] == matriz[casillaX2][casillaY2]) {
            matrizDestapar[casillaX1][casillaY1] = true;
            matrizDestapar[casillaX2][casillaY2] = true;
            aciertos++;
            //verificarJuego();
        } else {
            matrizDestapar[casillaX1][casillaY1] = false;
            matrizDestapar[casillaX2][casillaY2] = false;
            vidas--;
            fallos++;
            //verificarJuego();
        }
    }

    public void destaparTodasCasillas() {

    }

    public String mostrarAyuda() {
        return "CONCENTRCE" + "\n" + "Saludos invocador, "
                + "Primero debe seleccionar la tematica del juego y presionar el botón de Iniciar Juego, "
                + "una vez inicie se le mostrara por un tiempo de cuatro (4) segundos la distribución de las cartas "
                + "dispondra de tres (3) intentos para encontrar todas las parejas de cartas" + "\n"
                + "Mucha suerte! c:";
    }

    public String mostrarEstadisticas() {
        return "Estadisticas de Jugadas\n" + "\n"
                + "Cantidad de juegos realizados: " + juegosTotales + "\n"
                + "Porcentaje de juegos ganados: " + ((juegosGanados / juegosTotales) * 100) + "%\n"
                + "Porcentaje de juegos perdidos " + (((juegosTotales - juegosGanados) / juegosTotales) * 100) + "%\n";

    }

}
