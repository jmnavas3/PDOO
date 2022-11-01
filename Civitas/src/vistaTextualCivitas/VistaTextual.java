package vistaTextualCivitas;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * NOTA: se ha cambiado la visibilidad de algunos métodos del modelo para
 * poder realizar consultas desde la vista y mostrar los datos.
 * 
 * @author jmnavas
 */
public class VistaTextual implements Vista {
  
  private static String separador = "=====================";
  private Scanner in;
  CivitasJuego juegoModel;
  private int iPropiedad;
  private int iGestion;
  
  
  
  
// ************ proporcionado por profesores ******************
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
           
  public void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  
  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  
  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

  
  // **********************  implementado ***************************
  

  public void actualiza () {
      Jugador jugadorActual = juegoModel.getJugadorActual();
      int iCasillaActual = jugadorActual.getCasillaActual();
      Casilla casillaActual = juegoModel.getTablero().getCasilla(iCasillaActual);
      
      System.out.println(separador + "\nJugador: " + jugadorActual + "\nCae en casilla: " + casillaActual );
      
      if (juegoModel.finalDelJuego()) {
          int i = 1;
          System.out.println(separador + "\nFIN DEL JUEGO\n" + separador + "\nResultados:\n");
          for ( Jugador j: juegoModel.getJugadores() ) {
              System.out.println( "\n" + i++ + "º : " + j);
          }
      }
  }
  
  
  public Respuesta comprar () {
      int opcion = menu("¿COMPRAR CALLE?", new ArrayList<>(Arrays.asList("NO","SI")) );
      return Respuesta.values()[opcion];
  }
  
  
  public OperacionInmobiliaria elegirOperacion () {
      int opcion = menu("ELEGIR OPERACION" , new ArrayList<>(Arrays.asList("CONSTRUIR CASA","CONSTRUIR HOTEL", "TERMINAR")) );
      return OperacionInmobiliaria.values()[opcion];
  }
  
  
  public int elegirPropiedad () {
      Jugador jugadorActual = juegoModel.getJugadorActual();
      ArrayList<String> num = new ArrayList<>();
      
      for (int i = 1; i <= jugadorActual.getPropiedades().size(); i++)
          num.add(i+"ª");
      
      int opcion = menu("¿A QUE PROPIEDAD APLICAR?", num );
      
      return opcion;
  }
  
  
  public void mostrarEventos () {
      while (Diario.getInstance().eventosPendientes())
          System.out.println(Diario.getInstance().leerEvento());
  }
  
  
  public void mostrarSiguienteOperacion (OperacionJuego operacion) {
      System.out.println("SIGUIENTE OPERACION: "+operacion.toString());
  }
  
  
}
