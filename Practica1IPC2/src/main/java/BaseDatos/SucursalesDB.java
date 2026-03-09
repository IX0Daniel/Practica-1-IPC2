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
public class SucursalesDB {
    
    public ListaObjetos<ObjetoBaseDato> obtenerSucursales() {
        ListaObjetos<ObjetoBaseDato> lista = new ListaObjetos<>();

        String sql = "SELECT id_sucursal, nombre FROM sucursal";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.agregarElemento(new ObjetoBaseDato(
                    rs.getInt("id_sucursal"),
                    rs.getString("nombre")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    
}
