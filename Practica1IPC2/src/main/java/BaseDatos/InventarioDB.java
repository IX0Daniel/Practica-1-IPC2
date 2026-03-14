package BaseDatos;

import Listas.ListaObjetos;
import Usuarios.Ingrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author dz
 */
public class InventarioDB {
    
    public void actualizarInventario(int idSucursal, ListaObjetos<Ingrediente> ingredientes) {

        String sql = """
            UPDATE inventario
            SET cantidad = cantidad - ?
            WHERE id_sucursal = ?
            AND id_producto = ?
        """;

        try (Connection conn = ConexionDB.getConexion()) {

            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                
                for(int i = 0; i< ingredientes.getTamaño(); i++){
                    
                    Ingrediente ingredienteCiclo = (Ingrediente) ingredientes.seleccionarNodo(i).getObjeto();
                    
                    ps.setInt(1, ingredienteCiclo.getCantidad());
                    ps.setInt(2, idSucursal);
                    ps.setInt(3, ingredienteCiclo.getId());

                    ps.executeUpdate();
                    
                }

                conn.commit();

            } catch (SQLException e) {

                conn.rollback(); 
                throw e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
}
