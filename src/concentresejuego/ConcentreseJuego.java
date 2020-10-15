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
    boolean casillaDestapada;
    boolean parCasillasDestapadas;
    int casillaDestapada1X;
    int casillaDestapada1Y;
    int casillaDestapada2X;
    int casillaDestapada2Y;
    int juegosTotales;
    int juegosGanados;
    String estadisticas;

    public ConcentreseJuego() {
        juegosTotales = 0;
        juegosGanados = 0;
    }

    public void iniciarJuego() {
        vidas = 3;
        fallos = 0;
        aciertos = 0;
        matrizDestapar = new boolean[4][4];
        casillaDestapada = false;

        int imagen = 8;
        Random aleatorio = new Random();
        ArrayList<Integer> elementosColocados = new ArrayList<Integer>();
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                do {
                    imagen = 1 + aleatorio.nextInt(8);
                } while (elementosColocados.indexOf(imagen) != elementosColocados.lastIndexOf(imagen));
                elementosColocados.add(imagen);
                matriz[x][y] = imagen;
            }
        }
    }

    /**
     *
     * @param x fila en la matriz
     * @param y columna en la matriz
     */
    public void destaparCasilla(int x, int y) {
        if (!matrizDestapar[x][y]) { //ejecuta si la casilla esta en false (sin revelar)
            matrizDestapar[x][y] = true;
            if (casillaDestapada) { //verifica si ya se ha destapado otra casilla
                casillaDestapada2X = x;
                casillaDestapada2Y = y;
                parCasillasDestapadas = true;
            } else {
                casillaDestapada = true;
                casillaDestapada1X = x;
                casillaDestapada1Y = y;
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

    public void compararCasillas() {
        if (matriz[casillaDestapada1X][casillaDestapada1Y] == matriz[casillaDestapada2X][casillaDestapada2Y]) { //si tienen la misma imagen, quedan reveladas
            matrizDestapar[casillaDestapada1X][casillaDestapada1Y] = true;
            matrizDestapar[casillaDestapada2X][casillaDestapada2Y] = true;
            aciertos++;
        } else { //se voltean las dos casillas
            matrizDestapar[casillaDestapada1X][casillaDestapada1Y] = false;
            matrizDestapar[casillaDestapada2X][casillaDestapada2Y] = false;
            vidas--;
            fallos++;
        }
        casillaDestapada = false;
        parCasillasDestapadas = false;
    }

    public boolean getParCasillasDestapadas() {
        return parCasillasDestapadas;
    }

    public void destaparTodasCasillas() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                matrizDestapar[x][y] = true;
            }
        }
    }

    public void taparTodasCasillas() {
        matrizDestapar = new boolean[4][4];
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                matrizDestapar[x][y] = false;
            }
        }
    }

    public int getEstadoJuego() {
        if (vidas == 0) {
            juegosTotales++;
            return 0;
        }

        if (aciertos == 8) {
            juegosTotales++;
            juegosGanados++;
            return 1;
        }

        return 2;
    }

    public String mostrarAyuda() {
        return "CONCENTRESE\n" + "Saludos invocador, "
                + "Primero debe seleccionar la tematica del juego y presionar el botón de Iniciar Juego,\n"
                + "una vez inicie se le mostrara por un tiempo de cuatro (4) segundos la distribución de las cartas\n"
                + "dispondras de tres (3) intentos para encontrar todas las parejas de cartas" + "\n"
                + "Mucha suerte! c:";
    }

    public String mostrarEstadisticas() {
        if (juegosTotales != 0) {
            double porcentajeGanados = (double) juegosGanados / juegosTotales * 100;
            double porcentajePerdidos = (double) (juegosTotales - juegosGanados) / juegosTotales * 100;
            return "Estadisticas de Jugadas\n\n"
                    + "Cantidad de juegos realizados: " + juegosTotales + "\n"
                    + "Porcentaje de juegos ganados: " + String.format("%.1f", porcentajeGanados) + " %\n"
                    + "Porcentaje de juegos perdidos " + String.format("%.1f", porcentajePerdidos) + " %\n";
        } else {
            return "No se han completado partidas";
        }
    }
}
