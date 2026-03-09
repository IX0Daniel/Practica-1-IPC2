package BaseDatos;

import Listas.ListaObjetos;
import Usuarios.Ingrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author dz
 */
public class IngredienteBD {
    
    
    public ListaObjetos<Ingrediente> obtenerProductosActivos(int idSucursal) {

        ListaObjetos<Ingrediente> lista = new ListaObjetos<>();

        String sql = """
            SELECT prod.id_producto, prod.nombre, inv.cantidad
            FROM inventario inv
            JOIN producto prod ON inv.id_producto = prod.id_producto
            WHERE inv.id_sucursal = ?
            AND inv.estado = 1
            AND inv.cantidad > 0         
                     
                     
        """;

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idSucursal);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                lista.agregarElemento(new Ingrediente(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    
    
    public ListaObjetos<Ingrediente> generarPedido(ListaObjetos<Ingrediente> productos) {

        Random aleatorio = new Random();
        ListaObjetos<Ingrediente> pedido = new ListaObjetos<>();

        int totalProductos = productos.getTamaño();

        // ESCOGER MÍNIMO UN INGREDIENTE, Y COMO MÁXIMO TODOS :v
        int cantidadIngredientes = aleatorio.nextInt(totalProductos) + 1;

        // ESCOGER ALEATORIAMENTE LOS INGREDIENTES
        
        
        for (int i = 0; i < cantidadIngredientes; i++) {

            Ingrediente ingredienteTemporal = (Ingrediente) productos.seleccionarNodo(i).getObjeto();

            int maximo = Math.min(3, ingredienteTemporal.getCantidad());
            int cantidad = aleatorio.nextInt(maximo) + 1;

            Ingrediente ingrediente = new Ingrediente(ingredienteTemporal.getId(), ingredienteTemporal.getNombre(), cantidad);

            pedido.agregarElemento(ingrediente);
        }

        return pedido;
    }
    
    
    
    
}
