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
public class Casilla {
    
// *********************************************************************
// **********************  ATRIBUTOS CASILLA ***************************
// *********************************************************************
    
    private static final float FACTORALQUILERCALLE = 1.0f,
                               FACTORALQUILERCASA = 1.0f,
                               FACTORALQUILERHOTEL = 4.0f;
    
    private String      nombre;
    private TipoCasilla tipo;
    private int         numCasas,
                        numHoteles;
    
    private float precioCompra,
                  precioEdificar,
                  precioBaseAlquiler;

    
    
// *********************************************************************
// **********************  CONSTRUCTORES CASILLA ***********************
// *********************************************************************
    
    // casilla tipo DESCANSO
    public Casilla (
            TipoCasilla tipo,
            String      nombre )
    {
        
    }
    
    // casilla tipo CALLE
    public Casilla (
            TipoCasilla tipo,
            String titulo,
            float precioCompra,
            float precioEdificar,
            float precioBaseAlquiler )
    {
        this.tipo = tipo;
        this.nombre = titulo;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        this.numCasas = 0;
        this.numHoteles = 0;
    }
    
    // casilla tipo SORPRESA
    public Casilla (
            TipoCasilla   tipo,
            String        nombre,
            MazoSorpresas mazo)
    {
        
    }
    
    
    
    
    
    
    
// *********************************************************************
// *************************  MÉTODOS CLASE ****************************
// *********************************************************************
    
    boolean comprar ( Jugador jugador ) {
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean construirCasa ( Jugador jugador ) {
        throw new UnsupportedOperationException("No implementado");
    }
    
    boolean construirHotel ( Jugador jugador ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean derruirCasas ( int numero, Jugador jugador ) {
        throw new UnsupportedOperationException("No implementado");
    }

    public boolean esEsteElPropietario ( Jugador jugador ) {
        throw new UnsupportedOperationException("No implementado");
    }
        
    float getNumCasas ( ) {
        return this.numCasas;
    }
    
    float getNumHoteles ( ) {
        return this.numHoteles;
    }
    
    float getPrecioAlquilerCompleto () { 
        float precioAlquilerCompleto;
        precioAlquilerCompleto = this.numHoteles * FACTORALQUILERHOTEL;
        precioAlquilerCompleto = precioAlquilerCompleto + FACTORALQUILERCALLE +this.numCasas;
        precioAlquilerCompleto = precioAlquilerCompleto * this.precioBaseAlquiler;
        return precioAlquilerCompleto; 
    }
    
    float getPrecioCompra ( ) {
        return this.precioCompra;
    }
    
    float getEdificar ( ) {
        return this.precioEdificar;
    }
    
    void informe ( int iactual, ArrayList <Jugador> todos ) {
        throw new UnsupportedOperationException("No implementado");
    }
    
    private void init ( ) {
        
    }
    
    void recibeJugador ( int iactual, ArrayList <Jugador> todos) {
        
    }

    private void recibeJugador_calle ( int iactual, ArrayList <Jugador> todos) {
        
    }
    
    private void recibeJugador_sorpresa ( int iactual, ArrayList <Jugador> todos) {
        
    }
    
    public boolean tienePropietario ( ) {
        throw new UnsupportedOperationException("No implementado");
    }
    
    public void tramitarAlquiler ( Jugador jugador ) {
        throw new UnsupportedOperationException("No implementado");
    }
    
    @Override
    public String toString(){
        return getPrecioCompra() + "\n-Edificar: "
             + getEdificar() + "\n-Alquiler Base: "
             + getNumCasas() + "\tHoteles: " + getNumHoteles();
    }
    
}
