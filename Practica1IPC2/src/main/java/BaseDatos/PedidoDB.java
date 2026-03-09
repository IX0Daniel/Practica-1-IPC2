package BaseDatos;

import Listas.ListaObjetos;
import Usuarios.Ingrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author dz
 */
public class PedidoDB {
    
    
    
    
    public int guardarPedido(int idUsuario, String estado, ListaObjetos<Ingrediente> ingredientes) {

        String sqlPedido = """
        INSERT INTO pedido (id_usuario, estado)
        VALUES (?, ?)
        """;
        
        int idPedido = 0;

        String sqlDetalle = """
        INSERT INTO pedido_detalle (id_pedido, id_producto, cantidad)
        VALUES (?, ?, ?)
        """;

        try (Connection conn = ConexionDB.getConexion()) {

            conn.setAutoCommit(false); 

            try (PreparedStatement psPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {

                psPedido.setInt(1, idUsuario);
                psPedido.setString(2, estado);

                psPedido.executeUpdate();

                ResultSet rs = psPedido.getGeneratedKeys();

                if (rs.next()) {
                    idPedido = rs.getInt(1);
                }
            }

            try (PreparedStatement psDetalle = conn.prepareStatement(sqlDetalle)) {

              
                for(int i = 0; i< ingredientes.getTamaño(); i++){
                    
                    Ingrediente ingredienteCiclo = (Ingrediente) ingredientes.seleccionarNodo(i).getObjeto();
                    
                    psDetalle.setInt(1, idPedido);
                    psDetalle.setInt(2, ingredienteCiclo.getId());
                    psDetalle.setInt(3, ingredienteCiclo.getCantidad());

                    psDetalle.executeUpdate();
                }
            }
            conn.commit(); // confirmar todo

        } catch (SQLException e) {

            e.printStackTrace();
        }
        
        return idPedido;
                
    }
    
    public void actualizarEstadoPedido(int idPedido, String nuevoEstado) {

        String sql = """
            UPDATE pedido
            SET estado = ?
            WHERE id_pedido = ?
        """;

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoEstado);
            ps.setInt(2, idPedido);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
