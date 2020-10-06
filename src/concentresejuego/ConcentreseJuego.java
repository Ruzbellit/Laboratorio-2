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
    boolean casillaDestapada = false;
    int casillaDestapadaX;
    int casillaDestapadaY;
    int juegosTotales;
    int juegosGanados;
    String estadisticas;

    public void iniciarJuego(){
        
    }
    
    public void destaparCasilla(int x, int y) {
        if(casillaDestapada){
            compararCasillas(casillaDestapadaX, casillaDestapadaY, x, y);
        }else{
            casillaDestapadaX = x;
            casillaDestapadaY = y;
            matrizDestapar[x][y] = true;
        }
    }

    public void compararCasillas(int casillaX1, int casillaY1, int casillaX2, int casillaY2) {
        if (matriz[casillaX1][casillaY1] == matriz[casillaX2][casillaY2]) {
            matrizDestapar[casillaX1][casillaY1] = true;
            matrizDestapar[casillaX2][casillaY2] = true;
            aciertos ++;
            //verificarJuego();
        }else{
            vidas --;
            fallos --;
            //verificarJuego();
        }
    }

}
