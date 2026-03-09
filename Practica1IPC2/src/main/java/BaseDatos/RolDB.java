package BaseDatos;

import Listas.ListaObjetos;
import Usuarios.ObjetoBaseDato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dz
 */
public class RolDB {
    
    
    public ListaObjetos<ObjetoBaseDato> obtenerSucursales() {
        ListaObjetos<ObjetoBaseDato> lista = new ListaObjetos<>();

        String sql = "SELECT id_rol, nombre FROM rol";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet get = ps.executeQuery()) {

            while (get.next()) {
                lista.agregarElemento(new ObjetoBaseDato(
                    get.getInt("id_rol"),
                    get.getString("nombre")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
}
