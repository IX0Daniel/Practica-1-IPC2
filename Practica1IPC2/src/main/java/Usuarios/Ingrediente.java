package Usuarios;

/**
 *
 * @author dz
 */
public class Ingrediente extends ObjetoBaseDato{
    
    
    private int cantidad;
    
    public Ingrediente(int id, String nombre, int cantidad) {
        super(id, nombre);
        
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
