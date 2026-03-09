package Listas;

/**
 *
 * @author Daniel
 */
public class NodoLista <Objeto>{
    
    private Objeto objeto;
    
    private NodoLista siguienteNodo;

    public NodoLista(Objeto objeto) {
        this.objeto = objeto;
        siguienteNodo = null;
        
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public NodoLista getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoLista siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
    
    
    
    
    
}
