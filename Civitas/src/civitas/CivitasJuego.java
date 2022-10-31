/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jmnavas
 */
public class CivitasJuego {
    
    private int indiceJugadorActual;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private GestorEstados gestor;
    private EstadosJuego estado;
    private MazoSorpresas mazo;
    
    
    
    
    // constructor
    public CivitasJuego ( ArrayList <String> nombres, boolean debug ) {
        jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < nombres.size(); i++){
            jugadores.add(new Jugador(nombres.get(i)));
        }

        estado = gestor.estadoInicial();

        Dado.getInstance().setDebug(debug);

        indiceJugadorActual = Dado.getInstance().quienEmpieza(nombres.size());

        mazo = new MazoSorpresas(debug);

        tablero = new Tablero();
        inicializaTablero(mazo);

        inicializaMazoSorpresas();
    }
    

    private void avanzaJugador( ) {
        throw new UnsupportedOperationException("No implementado");
    }
    

    public boolean comprar ( ) {
        throw new UnsupportedOperationException("No implementado");
    }
    

    public OperacionJuego siguientePaso ( ) {
        throw new UnsupportedOperationException("No implementado");
    }
    

    public boolean construirCasa ( int ip ) {
		if ( getJugadorActual().construirCasa(ip) )
			return true;
		return false;
	}
    
    
    public boolean construirHotel ( int ip ) {
		if ( getJugadorActual().construirHotel(ip) )
			return true;
		return false;
    }
    
    
    private void contabilizarPasosPorSalida ( ) {
        if (tablero.computarPasoPorSalida())
			getJugadorActual().pasaPorSalida();
    }
    
    
    public boolean finalDelJuego ( ) {
		boolean bancarrota = false;
		for (int i = 0; i < jugadores.size() && !bancarrota; i++)
			if ( jugadores.get(i).enBancarrota() )
				bancarrota = true;

		return bancarrota;
	}
    
    
    public int getIndiceJugadorActual ( ) {        
		return indiceJugadorActual;
	}
    
    
    public Jugador getJugadorActual ( ) {        
		return jugadores.get(indiceJugadorActual);
	}
    
    
    public ArrayList <Jugador> getJugadores ( ) {
		return jugadores;
	}
    
    
    public Tablero getTablero ( ) {
		return tablero;
	}
    
    
	// 6 cartas PAGARCOBRAR ; 4 cartas PORCASAHOTEL
    private void inicializaMazoSorpresas ( ) {
		int valor = 100;
        for ( int i = 0; i < 5; i++){
			mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "ganas/pierdes", valor));
			mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "cobras/pagas", valor));
			valor *= -1;
		}
    }
    
    
    private void inicializaTablero ( MazoSorpresas mazo ) {
		tablero.añadeCasilla(new Casilla(TipoCasilla.DESCANSO, "SALIDA"));
		for (int i = 1; i < 20; i++){
			if(i%4 == 0)
				tablero.añadeCasilla(new Casilla(TipoCasilla.SORPRESA, "SORPRESA", mazo));
			else
				tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE, "calle " + i, i*100.0f, i*50.0f, i*20.0f));
		}

    }
    
    
    private void pasarTurno ( ) {
        indiceJugadorActual++;
		indiceJugadorActual %= jugadores.size();
    }
    
    
    private ArrayList <Jugador> ranking ( ) {
		Collections.sort(jugadores);
		return jugadores;
	}
    
    
    public void siguientePasoCompletado ( OperacionJuego operacion ) {
        gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }
    
}
