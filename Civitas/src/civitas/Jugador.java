/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author jmnavas
 */
public class Jugador implements Comparable<Jugador> {
// *********************************************************************
// *************************  ATRIBUTOS DE CLASE ****************************
// *********************************************************************
    
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    private int          casillaActual;
    protected static int HotelesMax = 4;
    private String       nombre;
    protected static float PasoPorSalida = 1000.0f;
    private boolean      puedeComprar;
    private float        saldo;
    private static float SaldoInicial = 7500.0f;
    
    
    
    
    
    
// *********************************************************************
// *************************  MÉTODOS CLASE ****************************
// *********************************************************************
    
    


    int cantidadCasasHoteles ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    public int compareTo ( Jugador otro ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean comprar ( Casilla titulo ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean construirCasa ( int ip ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean construirHotel ( int ip ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean enBancarrota ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    private boolean existeLaPropiedad ( int ip ) {
        throw new UnsupportedOperationException("No implementado");
    }

    private static int getCasasMax ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    static int getCasasPorHotel ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    int getCasillaActual ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    private static int getHotelesMax ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    protected String getNombre ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    private static float getPremioPasoSalida ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    // revisar
    protected Casilla getPropiedades ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean getPuedeComprar ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    protected float getSaldo ( ) {
        throw new UnsupportedOperationException("No implementado");
    }


    //constructores
    Jugador ( String nombre ) {

    }

    protected Jugador ( Jugador otro ) {

    }
    //-----

    
    boolean modificarSaldo ( float cantidad ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean moverACasilla ( int numCasilla ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean paga ( float cantidad ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean pagaAlquiler ( float cantidad ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean pasaPorSalida ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean puedeComprarCasilla ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    private boolean puedoEdificarCasa ( Casilla propiedad ) {
        throw new UnsupportedOperationException("No implementado");
    }

    private boolean puedoEdificarHotel ( Casilla propiedad ) {
        throw new UnsupportedOperationException("No implementado");
    }

    private boolean puedoGastar ( float precio ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean recibe ( float cantidad ) {
        throw new UnsupportedOperationException("No implementado");
    }

    boolean tieneAlgoQueGestionar ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    @Override
    public String toString( ) {
        return "\nHola :3 ";
    }

    
    
    
    
    
    
}
