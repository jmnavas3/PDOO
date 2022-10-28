/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;

/**
 * Sigue el patrón singleton (unica instancia creada dentro de la clase)
 * @author jmnavas
 */
public class Diario {
  static final private Diario instance = new Diario();
  
  private final ArrayList<String> eventos;
  
  static public Diario getInstance() {
    return instance;
  }

    public ArrayList<String> getEventos() {
        return eventos;
    }
  
  
  
  private Diario () {
    eventos = new ArrayList<>();
  }
  
  void ocurreEvento (String e) {
    eventos.add (e);
  }
  
  public boolean eventosPendientes () {
    return !eventos.isEmpty();
  }
  
  public String leerEvento () {
    String salida = "";
    if (!eventos.isEmpty()) {
      salida = eventos.remove(0);
    }
    return salida;
  }
}
