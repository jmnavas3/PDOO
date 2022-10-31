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

    // *** Atributos asociaciones
    
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;
    private Jugador propietario;
    
    
// *********************************************************************
// **********************  CONSTRUCTORES CASILLA ***********************
// *********************************************************************
    
    // casilla tipo DESCANSO
    public Casilla (
            TipoCasilla tipo,
            String      nombre )
    {
        init();
        this.tipo = tipo;
        this.nombre = nombre;
    }
    
    // casilla tipo CALLE
    public Casilla (
            TipoCasilla tipo,
            String titulo,
            float precioCompra,
            float precioEdificar,
            float precioBaseAlquiler )
    {
        init();
        this.tipo = tipo;
        this.nombre = titulo;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    // casilla tipo SORPRESA
    public Casilla (
            TipoCasilla   tipo,
            String        nombre,
            MazoSorpresas mazo)
    {
        init();
        this.tipo = tipo;
        this.nombre = nombre;
        this.mazo = mazo;
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

    public int cantidadCasasHoteles ( ) {
        return numCasas+numHoteles;
    }

    boolean derruirCasas ( int numero, Jugador jugador ) {
        if(esEsteElPropietario(jugador) && numCasas <= numero){
            numCasas -= numero;
            return true;
        }
        return false;
    }

    public boolean esEsteElPropietario ( Jugador jugador ) {
        if (propietario.compareTo(jugador) == 0)
            return true;
        else
            return false;
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
        precioAlquilerCompleto += this.numCasas * FACTORALQUILERCASA;
        precioAlquilerCompleto += FACTORALQUILERCALLE;
        precioAlquilerCompleto *= this.precioBaseAlquiler;
        return precioAlquilerCompleto; 
    }
    
    float getPrecioCompra ( ) {
        return this.precioCompra;
    }
    
    float getPrecioEdificar ( ) {
        return this.precioEdificar;
    }
    
    void informe ( int actual, ArrayList <Jugador> todos ) {
        String nombreJ = todos.get(actual).getNombre();
        Diario.getInstance().ocurreEvento("Jugador " + nombreJ + " cae en " + toString());
    }
    
    private void init ( ) {
        this.numCasas = 0;
        this.numHoteles = 0;
        this.precioBaseAlquiler = 0.0f;
        this.precioCompra = 0.0f;
        this.precioEdificar = 0.0f;
    }
    
    void recibeJugador ( int iactual, ArrayList <Jugador> todos) {
        if(tipo == TipoCasilla.CALLE)
            recibeJugador_calle(iactual, todos);
        else if (tipo == TipoCasilla.SORPRESA)
            recibeJugador_sorpresa(iactual, todos);
        else if (tipo == TipoCasilla.DESCANSO)
            informe(iactual, todos);
    }

    private void recibeJugador_calle ( int iactual, ArrayList <Jugador> todos) {
        informe(iactual, todos);
        Jugador jugador = todos.get(iactual);

        if (!tienePropietario())
            jugador.puedeComprarCasilla();
        else
            tramitarAlquiler(jugador);
    }
    
    private void recibeJugador_sorpresa ( int iactual, ArrayList <Jugador> todos) {
        sorpresa = mazo.siguiente();
        informe(iactual, todos);
        sorpresa.aplicarAJugador(iactual, todos);

    }
    
    public boolean tienePropietario ( ) {
        if (propietario == null)
            return false;
        else
            return true;
    }
    
    public void tramitarAlquiler ( Jugador jugador ) {
        if (tienePropietario() && !esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(getPrecioAlquilerCompleto());
            propietario.recibe(getPrecioAlquilerCompleto());
        }
    }
    
    @Override
    public String toString(){
        String salida = "CASILLA " + nombre + " es de tipo " + tipo.toString();

        if ( tipo == TipoCasilla.CALLE ) {
            salida += "\nPRECIOS: \nCompra=" + precioCompra + " Alquiler=" + getPrecioAlquilerCompleto() + " Edificar=" + precioEdificar;
            
            if (tienePropietario()) {
                salida += "\nPERTENECE A " + propietario.getNombre();
                if(numCasas > 0) salida += "\nNº CASAS= " + numCasas;
                if(numHoteles > 0) salida += "\nNº HOTELES= " + numHoteles;
            }
        }

        
        return salida;
    }
    
    /* // RUN FILE
    public static void main (String[] args) {
        Casilla nueva = new Casilla(TipoCasilla.DESCANSO, "SALIDA");
        Casilla calle = new Casilla(TipoCasilla.CALLE, "plaza lavapies", 10.0f, 20.0f, 15.0f);
        
        System.out.println(nueva);
        System.out.println(calle);
    }
    */
}
