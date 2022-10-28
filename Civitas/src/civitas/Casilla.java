/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author jmnavas
 */
public class Casilla {
    
// *****  ATRIBUTOS CIVITAS *****
    private TipoCasilla tipo; // calle|sorpresa|descanso
    private String nombre;
    private int numCasas, numHoteles;
    
    float FACTORALQUILERCALLE = 1.0f,
          FACTORALQUILERCASA = 1.0f,
          FACTORALQUILERHOTEL = 4.0f;
    
    private float precioCompra,
                  precioEdificar,
                  precioBaseAlquiler;

    private String propietario;

    // se añade static para que sea un atributo de clase
    static private int MAX_CASAS = 2;
    
//    Constructor para la casilla tipo CALLE
    public Casilla (
            TipoCasilla unTipo,
            String unNombre,
            float unPrecioCompra,
            float unPrecioEdificar,
            float unPrecioBaseAlquiler )
    {
        this.tipo = unTipo;
        this.nombre = unNombre;
        this.precioCompra = unPrecioCompra;
        this.precioEdificar = unPrecioEdificar;
        this.precioBaseAlquiler = unPrecioBaseAlquiler;
        this.numCasas = 0;
        this.numHoteles = 0;
    }
    
    //se añade static para que sea un método de clase, si no, es de instancia
    static void setMAX_CASAS(int nuevo){
        MAX_CASAS = nuevo;
    }
    
    public String getNombre (){ return this.nombre; }
    public String getPropietario (){ return this.propietario; }
    public float getPrecioCompra () { return this.precioCompra; }
    public float getEdificar () { return this.precioEdificar; }
    public float getPrecioBase () { return this.precioBaseAlquiler; }
    public float getNumCasas () { return this.numCasas; }
    public float getNumHoteles () { return this.numHoteles; }
    
    public float getPrecioAlquilerCompleto () { 
        float precioAlquilerCompleto;
        precioAlquilerCompleto = this.numHoteles * FACTORALQUILERHOTEL;
        precioAlquilerCompleto = precioAlquilerCompleto + FACTORALQUILERCALLE +this.numCasas;
        precioAlquilerCompleto = precioAlquilerCompleto * this.precioBaseAlquiler;
        return precioAlquilerCompleto; 
    }
    
    public boolean construirCasa (){
        this.numCasas++;
        return true;
    }
    
    public boolean construirHotel (){
        this.numHoteles++;
        return true;
    }
    
    @Override
    public String toString(){
        return getNombre() + ".\nPrecios\n-Compra: "
             + getPrecioCompra() + "\n-Edificar: "
             + getEdificar() + "\n-Alquiler Base: "
             + getPrecioBase() + "\n\nCasas: "
             + getNumCasas() + "\tHoteles: " + getNumHoteles();
    }
    
}
