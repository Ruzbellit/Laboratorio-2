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
    public static int compararNumeroMatriz(int matriz[][], int x, int y, int numero){
        try{
            if(matriz[x][y] == numero){
                return 0;
            }else{
                return 0;
            }
        }catch(NullPointerException npe){
            return -1;
        }
    }
}
