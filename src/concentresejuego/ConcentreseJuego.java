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
    
//<<<<<<< HEAD
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

    
//=======
    public String verificarJuego()
    {   
        if(vidas == 0)
        {
            return "DERROTA";
        }
        
        
        for(int i= 0; i>3; i++)
        {
            for(int j= 0; i>3; j++)
            {
               if (matrizDestapar[i][j] == false)
               {
                 return "DERROTA!!";  
               }
            }
        }
        
        return "VICTORIA";
    }
    
    
    
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

//>>>>>>> 6fe5b320b03eb42fbe14cb764b5ae77913b3fead
