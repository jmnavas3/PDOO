/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;
/**
 *
 * @author jmnavas
 */
public class Tablero {
    
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    
    
    
    
    
    public Tablero(){
        casillas = new ArrayList<>();
        casillas.add(new Casilla(TipoCasilla.DESCANSO, "salida",50.0f,100.0f,80.0f));
        porSalida = false;
    }
    
    
    private boolean correcto (int numCasilla){
        return (numCasilla < casillas.size());
    }

    
    // Los métodos que no tengan modificador de acceso tendrán por defecto
    // visibilidad de paquete
    boolean computarPasoPorSalida(){
        return porSalida=false;
    }
    
    
    void añadeCasilla(Casilla casilla){
        casillas.add(casilla);
    }
    
    
    public Casilla getCasilla(int numCasilla){
        if ( correcto(numCasilla) )
            return casillas.get(numCasilla);
        else
            return null;
    }
    
    
    public ArrayList <Casilla> getCasillas ( ) {
        return casillas;
    }
    
    
    // devuelve el índice de la siguiente casilla
    int nuevaPosicion(int actual, int tirada){
        actual += tirada;
        if( actual%20 != actual )
            porSalida = true;
        
        return actual%20;
    }
}
