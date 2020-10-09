/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentresejuego;

import java.util.*;
import javax.swing.JOptionPane;

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
    boolean casillaDestapada;
    int casillaDestapadaX;
    int casillaDestapadaY;
    int juegosTotales;
    int juegosGanados;
    String estadisticas;

    public ConcentreseJuego() {

    }

    public void iniciarJuego() {
        vidas = 3;
        fallos = 0;
        aciertos = 0;
        matrizDestapar = new boolean[4][4];
        casillaDestapada = false;

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                matriz[x][y] = x + y;
            }
        }

        /*
        Random aleatorio = new Random();
        for (int numeroImagen = 1; numeroImagen <= 8; numeroImagen++) { //poner los 8 pares de imagenes
            for (int c = 1; c < 3; c++) { //guardar 2 veces el numero de la imagen en la matriz
                int randomX = aleatorio.nextInt(4);
                int randomY = aleatorio.nextInt(4);
                while (Validaciones.compararNumeroMatriz(matriz, randomX, randomY) == 0) { //verifica si esta vacio la posicion de la matriz
                    randomX = aleatorio.nextInt(4);
                    randomY = aleatorio.nextInt(4);
                }
                matriz[randomX][randomY] = numeroImagen;
            }
        }
         */
    }

    /**
     *
     * @param x
     * @param y
     */
    public void destaparCasilla(int x, int y) {
        if (!matrizDestapar[x][y]) { //ejecuta si la casilla esta en false (sin revelar)
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

    /**
     *
     * @param x fila en la matriz
     * @param y columna en la matriz
     * @return false - imagen si revelar, true - imagen revelada
     */
    public boolean estadoCasilla(int x, int y) {
        return matrizDestapar[x][y];
    }

    /**
     *
     * @param x fila en la matriz
     * @param y columna en la matriz
     * @return el numero de la imagen
     */
    public int imagenCasilla(int x, int y) {
        return matriz[x][y];
    }

    public void compararCasillas(int casillaX1, int casillaY1, int casillaX2, int casillaY2) {
        if (matriz[casillaX1][casillaY1] == matriz[casillaX2][casillaY2]) { //si tienen la misma imagen, quedan reveladas
            matrizDestapar[casillaX1][casillaY1] = true;
            matrizDestapar[casillaX2][casillaY2] = true;
            aciertos++;
            //verificarJuego();
        } else { //se voltean las dos casillas
            matrizDestapar[casillaX1][casillaY1] = false;
            matrizDestapar[casillaX2][casillaY2] = false;
            vidas--;
            fallos++;
            //verificarJuego();
        }
        casillaDestapada = false;
    }

    public void destaparTodasCasillas() {

    }

    public String verificarJuego() {
        if (vidas == 0) {
            return "DERROTA";
        }

        for (int i = 0; i > 3; i++) {
            for (int j = 0; i > 3; j++) {
                if (matrizDestapar[i][j] == false) {
                    return "DERROTA!!";
                }
            }
        }

        return "VICTORIA";
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
