package Listas;

/**
 * @author Daniel
 */
public class ListaObjetos <Objeto>{

    
    private NodoLista inicio;
    private int tamaño;
    private boolean colaIniciada;
    
    public void agregarElemento(Objeto objeto){
        
        
        if(isVacia()){
            inicio = new NodoLista(objeto);
            tamaño++;
            
            return;
        }
        
        NodoLista nodoTemporal;
        nodoTemporal = inicio;
        
        while(nodoTemporal.getSiguienteNodo() != null){
            nodoTemporal = nodoTemporal.getSiguienteNodo();
        
        }
        
        nodoTemporal.setSiguienteNodo(new NodoLista(objeto));
        tamaño++;
    
    
    }
    
    public NodoLista eliminarNodoInicial(){
        
        NodoLista nodoCosecha = inicio;
        
        inicio = inicio.getSiguienteNodo();
        
        tamaño--;
       
        return nodoCosecha;
        
    }
    
    public NodoLista usarNodoInicial(){
        return inicio;
    }
    
    public NodoLista seleccionarNodo(int indice){
        
        NodoLista nodoIterador;
        nodoIterador = inicio;
        
        if(tamaño == 1){
            return inicio;
        }
        
        for(int i = 0; i < indice; i ++){
            nodoIterador = nodoIterador.getSiguienteNodo();
        }
    
        return nodoIterador;
    
    }
    
   
    
    
    public void eliminarNodo(int indice) throws Excepciones{
        
        
        if(indice<0||indice>=tamaño){
            throw new Excepciones("El índice es inválido para la lista de objetos");
        }
        
        if (indice == 0) { 
            inicio = inicio.getSiguienteNodo();
        } else {
            
            NodoLista actual = inicio;
            
            for (int i = 0; i < indice -1 ; i++) {
                actual = actual.getSiguienteNodo();
            }
            
            if(actual.getSiguienteNodo().getSiguienteNodo() == null){
            
                actual.setSiguienteNodo(null);
            }else{
                actual.setSiguienteNodo(actual.getSiguienteNodo().getSiguienteNodo()); 
            }
            
            
        }
        tamaño--;
           
    }
    
 
    public boolean contiene(Object obj) {
        for (int i = 0; i < getTamaño(); i++) {
            if (seleccionarNodo(i).getObjeto() == obj) {
                return true;
            }
        }
        return false;
    }
    
        
    public void eliminar(Object obj) throws Excepciones {
        for (int i = 0; i < getTamaño(); i++) {
            if (seleccionarNodo(i).getObjeto() == obj) {
                
                eliminarNodo(i);
            }
        }
    }
    
    public boolean isVacia(){
        return inicio == null;
    }

    public int getTamaño(){
    
        return tamaño;
    
    }

    
}

