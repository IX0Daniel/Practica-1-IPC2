package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dz
 */
public class CrearUsuario {
    
    public void crearJugador(String nombre, String correo, String password, int idSucursal) {

        String sqlUsuario = """
            INSERT INTO usuario (nombre, correo, password, id_rol, id_sucursal)
            VALUES (?, ?, ?, 3, ?)
        """;

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, password);
            ps.setInt(4, idSucursal);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idUsuario = rs.getInt(1);

                insertarJugador(idUsuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    private void insertarJugador(int idUsuario) {

        String sql = "INSERT INTO jugador (id_usuario, nivel) VALUES (?, 1)";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
