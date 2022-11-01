/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controladorCivitas;
import civitas.*;
import java.util.ArrayList;
import vistaTextualCivitas.*;
/**
 * PROGRAMA PRINCIPAL P3
 * @author jmnavas
 */
public class JuegoTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList <String> jugadores = new ArrayList<>();
        jugadores.add("Paco");
        jugadores.add("Juan");
        jugadores.add("Laura");
        jugadores.add("Maria");
        
        
        CivitasJuego juego = new CivitasJuego(jugadores,false);
        VistaTextual vista = new VistaTextual(juego);
        Controlador controlador = new Controlador(juego,vista);
        
        controlador.juega();
        
    }
    
}
