/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package civitas;
import java.util.ArrayList;

// Tipos de casillas del juego
enum TipoCasilla {
    CALLE,
    SORPRESA,
    DESCANSO
}

// Tipo  de cartas sorpresas del juego
enum TipoSorpresa {
    PAGARCOBRAR,
    PORCASAHOTEL
}

enum EstadosJuego {
  INICIO_TURNO,
  DESPUES_AVANZAR,
  DESPUES_COMPRAR,
  DESPUES_GESTIONAR
}





/**
 *
 * @author jmnavas
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1- Llamar 100 veces a quienEmpieza siendo 4 jugadores
        // y calcular cuantas veces se obtiene cada uno de los valores.
        
       /*
        int jugador = 0;
        int[] cont = {0, 0, 0, 0};
        
        for(int i=0; i<100; i++){
            jugador = Dado.getInstance().quienEmpieza(4);
            cont[jugador] += 1;
        }
        System.out.println("Jugador 1: " + cont[0]);
        System.out.println("Jugador 2: " + cont[1]);
        System.out.println("Jugador 3: " + cont[2]);
        System.out.println("Jugador 4: " + cont[3]);
       */
        
        // 2- comprobar modo debug del dado usando tirar()
       
      /* 
        for(int i=0;i<20;i++){
            if(i==10){
                Dado.getInstance().setDebug(true);
            }
            System.out.print("Valor dado: ");
            System.out.println(Dado.getInstance().tirar());
        }
      */
//      3- Prueba al menos una vez el método getUltimoResultado() de Dado

//      System.out.println(Dado.getInstance().getUltimoResultado());

//      4- Muestra al menos un valor de cada tipo enumerado

//      System.out.println(TipoCasilla.CALLE);

//      5- Crea un objeto Tablero y haz las siguientes pruebas
//         añade algunas calles al tablero, obtén dichas casillas
//         y muestra su estado por consola usando el método toString de la
//         clase Casilla.

        Tablero tablero = new Tablero();
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Paseo del Prado");
        nombres.add("Plaza lavapiés");
        nombres.add("Calle Serrano");
        nombres.add("Paseo del Prado");
        for(int i=0; i<nombres.size(); i++){
            tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,
                nombres.get(i),
                i*50.0f,
                500.0f,
                100.0f));
        }

//      6- Crea algunos bucles sobre la totalidad de las calles para
//         calcular y mostrar cuál es la calle más cara, la más
//         barata y el precio medio de las calles.
//      
    }
    
}
