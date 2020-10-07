/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concentresejuego;

/**
 *
 * @author villa
 */
public class Validaciones {

    /**
     * revisa si hay un numero en la posicion de la matriz, y devuelve -1 si
     * esta vacio
     *
     * @param matriz
     * @param x fila en la matriz
     * @param y columna en la matriz
     * @return -1 si en la posicion de la matriz esta vacio
     */
    public static int compararNumeroMatriz(int matriz[][], int x, int y) {
        try {
            int aux = matriz[x][y];
            return 0;
        } catch (NullPointerException npe) {
            return -1;
        }
    }
}
