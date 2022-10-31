/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;

/**
 * @author jmnavas
 */
public class Sorpresa {
    private String texto;
    private int    valor;
    private MazoSorpresas mazo;
    private TipoSorpresa tipo;
    
    
    void aplicarAJugador ( int actual, ArrayList <Jugador> todos ) {
        if ( tipo == TipoSorpresa.PAGARCOBRAR )
            aplicarAJugador_pagarCobrar(actual, todos);
        else if ( tipo == TipoSorpresa.PORCASAHOTEL)
            aplicarAJugador_porCasaHotel(actual, todos);
    }
    
    private void aplicarAJugador_pagarCobrar ( int actual, ArrayList <Jugador> todos ) {
        informe(actual, todos);
        todos.get(actual).modificarSaldo(valor);
    }
    
    private void aplicarAJugador_porCasaHotel ( int actual, ArrayList <Jugador> todos ) {
        informe(actual, todos);
        int casasHoteles = todos.get(actual).cantidadCasasHoteles();
        todos.get(actual).modificarSaldo(valor*casasHoteles);
    }
    
    private void informe ( int actual, ArrayList <Jugador> todos ) {
        Diario.getInstance().ocurreEvento("Aplicando sorpresa: " + texto + ". JUGADOR: " + todos.get(actual).getNombre());
    }
    
    Sorpresa ( TipoSorpresa tipo, String texto, int valor ) {
        this.tipo = tipo;
        this.texto = texto;
        this.valor = valor;
    }
    
    @Override
    public String toString ( ) {
        return texto;
    }
}
