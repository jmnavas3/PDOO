/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.Random;

/**
 * Sigue el patrón singleton (unica instancia creada dentro de la propia clase)
 * Visibilidad de paquete
 * @author jmnavas
 */
public class Dado {

    private Random random;
    private int ultimoResultado;
    private boolean debug; //si esta activo, las tiradas seran siempre 1
    private static final Dado instance = new Dado();
    



    private Dado () {
        random = new Random();
        ultimoResultado = 1; // por defect. a 1 para no hacer nada en tirar()
        debug = false;
    }
    
    public static Dado getInstance () {
        return instance;
    }
    
    
    // random.nextInt(6) = [0-5]+1
    int tirar () {
        ultimoResultado = 1;
        if (!debug)
            ultimoResultado = random.nextInt(6) + 1;
        
        return ultimoResultado;
    }

    // n jugadores, el primer jugador tiene indice 0
    int quienEmpieza ( int n ) {
        return random.nextInt(n);
    }
    
    public void setDebug ( boolean d ) {
        debug = d;
        Diario.getInstance().ocurreEvento("Estado dado: " + d);
    }
    
    int getUltimoResultado () {
        return ultimoResultado;
    }
}
