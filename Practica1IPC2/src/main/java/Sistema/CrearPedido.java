package Sistema;

import BaseDatos.IngredienteBD;
import BaseDatos.PedidoDB;
import Listas.ListaObjetos;
import Usuarios.Ingrediente;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author dz
 */
public class CrearPedido {
    
    private int idPedido;
    private Pedido pedidoGenerado;
    
    
    //private conectarBaseDato
    
    private void crearPedido(int idSucursal){
        
        ListaObjetos<Ingrediente> ingredientes;
        IngredienteBD listaIngredientes = new IngredienteBD();
        ingredientes = listaIngredientes.obtenerProductosActivos(idSucursal);
        ingredientes = listaIngredientes.generarPedido(ingredientes);
        
        LocalDateTime fecha = LocalDateTime.now();
        
        idPedido++; 
        pedidoGenerado = new Pedido(ingredientes, idPedido, fecha);
        
    
    }

    public Pedido getPedidoGenerado(int idSucursal) {
        crearPedido(idSucursal);
        return pedidoGenerado;
    }
    
    
    
    
    
}
