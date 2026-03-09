package BaseDatos;

import Usuarios.ObjetoBaseDato;
import Usuarios.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dz
 */
public class UsuarioDB {
    
    public Usuario login(String correo, String password) {

        String sql = """
                     
            SELECT 
                usr.id_usuario,
                usr.nombre,
                usr.id_rol,
                rl.nombre AS rol,
                suc.id_sucursal,
                suc.nombre AS sucursal
            FROM usuario usr
            JOIN rol rl ON usr.id_rol = rl.id_rol
            LEFT JOIN sucursal suc ON usr.id_sucursal = suc.id_sucursal
            WHERE usr.correo = ? AND usr.password = ?;         
        
        """;

        try (Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                ObjetoBaseDato sucursal = null;

                int idSucursal = rs.getInt("id_sucursal");

                if (!rs.wasNull()) {
                    sucursal = new ObjetoBaseDato(
                            idSucursal,
                            rs.getString("sucursal")
                    );
                }

                
                return new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getInt("id_rol"),
                        rs.getString("rol"), 
                        sucursal
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public int obtenerNivelJugador(int idUsuario) {

        String sql = "SELECT nivel FROM jugador WHERE id_usuario = ?";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("nivel");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
