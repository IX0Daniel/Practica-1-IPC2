package Sistema;

import Listas.ListaObjetos;
import Usuarios.Ingrediente;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author dz
 */
public class Pedido {
    
        
    private int idPedido;
    private ListaObjetos<Ingrediente> ingredientes;
    private LocalDateTime fechaPedido;
    private String estado;
    
    public Pedido(ListaObjetos<Ingrediente> ingredientes, int idPedido, LocalDateTime fechaPedido) {
        this.ingredientes = ingredientes;
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        estado = "PENDIENTE";
    }

    
    
    
    public ListaObjetos<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    
    
    
    
}
