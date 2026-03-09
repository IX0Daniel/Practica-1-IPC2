package Main;

import BaseDatos.ConexionDB;
import java.sql.Connection;
import javax.swing.SwingUtilities;

/**
 * @author dz
 */

public class Main {
    
    public static void main(String[] args) {

        System.out.println("¿'-'-'?");

      
        try (Connection con = ConexionDB.getConexion()) {
            if (con != null) {
                System.out.println("Conexión REAL exitosa");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });

    }
    
}
