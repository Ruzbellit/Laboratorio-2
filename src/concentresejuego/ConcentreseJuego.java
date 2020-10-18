/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentresejuego;

import java.util.*;

/**
 * Clase que ejecuta la logica del juego Concentrese
 */
public class ConcentreseJuego {

    //Variables del estado del juego
    int vidas;
    int fallos;
    int aciertos;
    
    int matriz[][] = new int[4][4]; //Matriz que guarda un numero correpondiente a la imagen
    boolean matrizDestapar[][]; //Matriz que indica si la casilla esta tapada o destapada
    boolean casillaDestapada;   //Indica si ya se ha destapado 1 casilla
    boolean parCasillasDestapadas;  //Indica si ya se han destapado 2 casillas diferentes
    
    //Guarda las coordenadas en la matriz de las 2 casillas destapadas
    int casillaDestapada1X;
    int casillaDestapada1Y;
    int casillaDestapada2X;
    int casillaDestapada2Y;
    
    //Variables para el conteo de juegos completados
    int juegosTotales;
    int juegosGanados;

    /**
     * Inicializa el objeto y el conteo de los juegos totales y perdidos
     */
    public ConcentreseJuego() {
        juegosTotales = 0;
        juegosGanados = 0;
    }

    /**
     * Resetea a su estado inicial el juego y rellena la matriz con su correspondiente numero de imagen
     */
    public void iniciarJuego() {
        vidas = 3;
        fallos = 0;
        aciertos = 0;
        matrizDestapar = new boolean[4][4];
        casillaDestapada = false;

        int imagen = 1;
        Random aleatorio = new Random();
        ArrayList<Integer> elementosColocados = new ArrayList<Integer>();
        
        //Ciclo que recorre todas la coordenadas de la matriz donde se almacenan el numero correspondiente a la imagen
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                //Genera un numero aleatorio y compara en el Array si no esta repetido mas de 2 veces
                do {
                    imagen = 1 + aleatorio.nextInt(8);  //numero de imagen desde 1, hasta 8
                } while (elementosColocados.indexOf(imagen) != elementosColocados.lastIndexOf(imagen));
                
                elementosColocados.add(imagen); //Agregamos el numero al Array para poder verificar que no se repita mas de 2 veces
                matriz[x][y] = imagen;
            }
        }
    }

    /**
     * Recibe las coordenadas de la casilla a destapar y actualiza su valor en matrizDestapar
     * @param x fila en la matriz
     * @param y columna en la matriz
     */
    public void destaparCasilla(int x, int y) {
        if (!matrizDestapar[x][y]) { //Ejecuta si la casilla esta sin revelar (false)
            matrizDestapar[x][y] = true;
            if (casillaDestapada) { //Verifica si ya se ha destapado otra casilla
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
     * Verifica si la casilla esta tapada o destapada
     * @param x fila en la matriz
     * @param y columna en la matriz
     * @return false - imagen sin revelar, true - imagen revelada
     */
    public boolean estadoCasilla(int x, int y) {
        return matrizDestapar[x][y];
    }

    /**
     * Retorna el numero de la imagen correspondiente a las coordenadas de la casilla
     * @param x fila en la matriz
     * @param y columna en la matriz
     * @return el numero de la imagen
     */
    public int imagenCasilla(int x, int y) {
        return matriz[x][y];
    }

    /**
     * Compara las 2 casillas ya destapadas y las deja destapadas si son iguales, o las tapa si son diferentes, ademas que actualiza los parametros del juego
     */
    public void compararCasillas() {
        if (matriz[casillaDestapada1X][casillaDestapada1Y] == matriz[casillaDestapada2X][casillaDestapada2Y]) { //Si tienen la misma imagen, quedan destapadas
            matrizDestapar[casillaDestapada1X][casillaDestapada1Y] = true;
            matrizDestapar[casillaDestapada2X][casillaDestapada2Y] = true;
            aciertos++;
        } else { //Se tapan las dos casillas
            matrizDestapar[casillaDestapada1X][casillaDestapada1Y] = false;
            matrizDestapar[casillaDestapada2X][casillaDestapada2Y] = false;
            vidas--;
            fallos++;
        }
        casillaDestapada = false;
        parCasillasDestapadas = false;
    }

    /**
     * Verifica si ya se han seleccionado 2 casillas diferentes
     * @return true - si ya se ha seleccionado y destapado 2 casillas diferentes
     */
    public boolean getParCasillasDestapadas() {
        return parCasillasDestapadas;
    }

    /**
     * Pone en valor verdadero (true) a toda la matriz "matrizDestapar"
     * que corresponde a que todas las casillas estan destapadas
     */
    public void destaparTodasCasillas() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                matrizDestapar[x][y] = true;
            }
        }
    }

    /**
     * Pone en el valor inicial (false) a toda la matriz "matrizDestapar"
     * que corresponde a que todas las casillas estan tapadas
     */
    public void taparTodasCasillas() {
        matrizDestapar = new boolean[4][4];
    }

    /**
     * 
     * @return 0 - Si ya no quedan vidas (perdio el juego)
     * 1 - Si obtuvo los 8 acierto (gano el juego)
     * 2 - Continua con el juego
     */
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

    /**
     * Informacion acerca de como se debe jugar
     * @return Texto de ayuda sobre la jugabilidad del juego
     */
    public String mostrarAyuda() {
        return "CONCENTRESE\n" + "Saludos invocador, "
                + "Primero debe seleccionar la tematica del juego y presionar el botón de Iniciar Juego,\n"
                + "una vez inicie se le mostrara por un tiempo de cuatro (4) segundos la distribución de las cartas\n"
                + "dispondras de tres (3) intentos para encontrar todas las parejas de cartas" + "\n"
                + "Mucha suerte! c:";
    }

    /**
     * Informacion acerca de los juegos realizados mientras la aplicacion estuvo abierta
     * @return Texto sobre las estadisticas de los juegos ganados y perdidos
     */
    public String mostrarEstadisticas() {
        if (juegosTotales != 0) {   //Solo muestra las estadisticas si se ha completado almenos un juego
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
