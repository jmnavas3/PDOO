/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorCivitas;
import civitas.*;
import vistaTextualCivitas.*;

/**
 *
 * @author jmnavas
 */
public class Controlador {
    
    private CivitasJuego juego;
    private Vista vista;
    
    
    
    Controlador (CivitasJuego juego, VistaTextual vista) {
        this.juego = juego;
        this.vista = vista;
    }
    
    
    public void juega () {
        OperacionJuego operacionActual;
        OperacionInmobiliaria gestion;
        while ( !juego.finalDelJuego() )
        {
            
            vista.actualiza();
            
            vista.pausa();
            
            operacionActual = juego.siguientePaso();
            
            vista.mostrarSiguienteOperacion(operacionActual);
            
            if (operacionActual != OperacionJuego.values()[0]) //pasar turno
                vista.mostrarEventos();
            

            if (!juego.finalDelJuego()) {
                
                if ( operacionActual == OperacionJuego.COMPRAR ) {
                    if (vista.comprar() == Respuesta.SI && juego.comprar()){
                        juego.siguientePasoCompletado(operacionActual);
                    }
                }
                else if ( operacionActual == OperacionJuego.GESTIONAR ) {
                    
                    gestion = vista.elegirOperacion();
                    if (gestion != OperacionInmobiliaria.TERMINAR) {
                        GestionInmobiliaria gestPropiedad = new GestionInmobiliaria(gestion, vista.elegirPropiedad());
                        switch (gestion) {
                            case CONSTRUIR_CASA:
                                juego.construirCasa(gestPropiedad.getPropiedad());
                                break;
                            case CONSTRUIR_HOTEL:
                                juego.construirHotel(gestPropiedad.getPropiedad());
                                break;
                        }
                    }
                    else {
                        juego.siguientePasoCompletado(operacionActual);
                    }
                
                }
            }
        } //while
        
        juego.ranking();
        vista.actualiza();
    }
    
    
    
}
