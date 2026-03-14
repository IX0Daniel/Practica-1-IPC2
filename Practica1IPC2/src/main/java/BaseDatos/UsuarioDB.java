package BaseDatos;

import Listas.ListaObjetos;
import Usuarios.ObjetoBaseDato;
import Usuarios.Usuario;
import Usuarios.UsuarioSuperAdmin;
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
    
    public void subirNivel(int idUsuario) {

        String sql = """
            UPDATE jugador
            SET nivel = nivel + 1
            WHERE id_usuario = ?
        """;

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    
    
    public ListaObjetos<UsuarioSuperAdmin> listarUsuarios() {

        ListaObjetos<UsuarioSuperAdmin> lista = new ListaObjetos<>();

        String sql = """
                     
            SELECT
            u.id_usuario,
            u.nombre,
            u.correo,
            u.password,
            r.nombre AS rol,
            s.nombre AS sucursal
            FROM usuario u
            JOIN rol r ON u.id_rol = r.id_rol
            LEFT JOIN sucursal s ON u.id_sucursal = s.id_sucursal;
         
        """;

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                UsuarioSuperAdmin user = new UsuarioSuperAdmin(      
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("password"),
                    rs.getString("rol"),
                    rs.getString("sucursal")
                );

                lista.agregarElemento(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


}
