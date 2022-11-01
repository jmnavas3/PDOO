/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.lang.Float;
import java.util.ArrayList;
/**
 *
 * @author jmnavas
 */
public class Jugador implements Comparable<Jugador> {
// *********************************************************************
// *************************  ATRIBUTOS DE CLASE ***********************
// *********************************************************************
    
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    protected static int HotelesMax = 4;
    protected static float PasoPorSalida = 1000.0f;
    private static float SaldoInicial = 7500.0f;

    private int          casillaActual;
    private String       nombre;
    private boolean      puedeComprar;
    private float        saldo;

    private ArrayList<Casilla> propiedades;
    
    
    
    
    
    
// *********************************************************************
// *************************  MÉTODOS CLASE ****************************
// *********************************************************************
    
    


    int cantidadCasasHoteles ( ) {
        int casasHoteles = 0;
        for(Casilla i: propiedades){
            casasHoteles += i.getNumCasas() + i.getNumHoteles();
        }
        return casasHoteles;
    }

    public int compareTo ( Jugador otro ) {
        return Float.compare(getSaldo(), otro.getSaldo());
    }

    boolean comprar ( Casilla titulo ) {
        boolean result = false;

        if(puedeComprar){
            float precio = titulo.getPrecioCompra();

            if (puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + this + " compra la propiedad " + titulo);
                puedeComprar = false;
            }
        } else {
            Diario.getInstance().ocurreEvento("EL jugador "+this+" no tiene saldo para comprar la propiedad "+titulo);
        }

        return result;
    }

    boolean construirCasa ( int ip ) {
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        
        if ( existe )
        {
            Casilla propiedad = propiedades.get(ip);
            boolean puedoEdificar = puedoEdificarCasa(propiedad);

            if (puedoEdificar){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("EL jugador "+this+" construye casas en la propiedad "+ip);
            }
        }
        return result;
    }

    boolean construirHotel ( int ip ) {
        boolean result = false;

        if ( existeLaPropiedad(ip) )
        {
            Casilla propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);

            if (puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador "+this+" construye hotel en la propiedad "+ip);
            }
            

        }


        return result;
    }

    boolean enBancarrota ( ) {
        return (saldo < 0);
    }

    private boolean existeLaPropiedad ( int ip ) {
        if (propiedades.size() > ip)
            return true;
        return false;
    }

    private static int getCasasMax ( ) {
        return CasasMax;
    }

    static int getCasasPorHotel ( ) {
        return CasasPorHotel;
    }

    int getCasillaActual ( ) {
        return casillaActual;
    }

    private static int getHotelesMax ( ) {
        return HotelesMax;
    }

    protected String getNombre ( ) {
        return nombre;
    }

    private static float getPremioPasoSalida ( ) {
        return PasoPorSalida;
    }

    protected ArrayList<Casilla> getPropiedades ( ) {
        if (tieneAlgoQueGestionar())
            return propiedades;
        return null;
    }

    boolean getPuedeComprar ( ) {
        throw new UnsupportedOperationException("No implementado");
    }

    protected float getSaldo ( ) {
        throw new UnsupportedOperationException("No implementado");
    }


    //constructores
    Jugador ( String nombre ) {
        this.nombre = nombre;
        propiedades = new ArrayList<Casilla>();
        saldo = SaldoInicial;
    }

    protected Jugador ( Jugador otro ) {
        this.nombre = otro.nombre;
        this.propiedades = otro.propiedades;
        this.saldo = otro.saldo;
    }
    //-----

    
    boolean modificarSaldo ( float cantidad ) {
        saldo += cantidad;
        Diario.getInstance().ocurreEvento("SALDO MODIFICADO: " + cantidad + ". TOTAL: " + saldo);
        return true;
    }

    boolean moverACasilla ( int numCasilla ) {
        casillaActual = numCasilla;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("Jugador " + nombre + " en casilla " + casillaActual);
        return true;
    }

    boolean paga ( float cantidad ) {
        return modificarSaldo( (-1*cantidad) );
    }

    boolean pagaAlquiler ( float cantidad ) {
        return paga(cantidad);
    }

    boolean pasaPorSalida ( ) {
        recibe(getPremioPasoSalida());
        Diario.getInstance().ocurreEvento("Jugador " + nombre + " pasa por salida");
        return true;
    }

    boolean puedeComprarCasilla ( ) {
        puedeComprar = true;
        return puedeComprar;
    }

    private boolean puedoEdificarCasa ( Casilla propiedad ) {
        if(puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumCasas() < getCasasMax())
            return true;
        return false;
    }

    private boolean puedoEdificarHotel ( Casilla propiedad ) {
        if(puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < getHotelesMax() && 
           propiedad.getNumCasas() >= CasasPorHotel)
            return true;
        return false;
    }

    private boolean puedoGastar ( float precio ) {
        if(saldo < precio)
            return false;
        return true;
    }

    boolean recibe ( float cantidad ) {
        return modificarSaldo(cantidad);
    }

    boolean tieneAlgoQueGestionar ( ) {
        if(propiedades.isEmpty())
            return false;
        return true;
    }

    @Override
    public String toString( ) {
        return nombre;
    }

    
    
    
    
    
    
}
