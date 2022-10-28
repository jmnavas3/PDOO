/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Atributos de instancia privados
 * @author jmnavas
 */
public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada; //true: mazo barajado
    private int usadas; //cartas usadas
    private boolean debug; //true: no se baraja el mazo
    
//    valores por defecto
    private void init () {
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = 0;
    }
    
    MazoSorpresas ( boolean debug ) {
        this.debug = debug;
        init();
        if(this.debug) //se notifica en el diario
            Diario.getInstance().ocurreEvento("Estado mazo " + debug);
    }
    
    MazoSorpresas () {
        debug = false;
        init();
    }
    
    void alMazo ( Sorpresa s ) {
        if(!barajada){
            sorpresas.add(s);
        }
    }
    
    Sorpresa siguiente () {
        Sorpresa local;
        if( !barajada || usadas==sorpresas.size() ){
            Collections.shuffle(sorpresas); //barajar coleccion de objs.
            usadas = 0;
            barajada = true;
        }
        usadas += 1;
        local = sorpresas.get(0);
        // añadimos la primera carta al final y luego la quitamos del principio
        sorpresas.add(sorpresas.get(0));
        sorpresas.remove(0);
        
        return local;
    }
    
    
    
}
