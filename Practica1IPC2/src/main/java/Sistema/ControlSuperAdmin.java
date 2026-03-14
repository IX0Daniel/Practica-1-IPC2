package Sistema;

import BaseDatos.CrearUsuario;
import BaseDatos.RolDB;
import BaseDatos.SucursalesDB;
import Listas.ListaObjetos;
import Paneles.PanelSuperAdmin;
import Usuarios.ObjetoBaseDato;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author dz
 */
public class ControlSuperAdmin {
    
    private PanelSuperAdmin panelSuperAdmin;
    private SucursalesDB sucursales;

    
    public ControlSuperAdmin(PanelSuperAdmin panelSuperAdmin) {
        this.panelSuperAdmin = panelSuperAdmin;
        
        cargarSucursales();
        panelSuperAdmin.agregarEventoBotonRegistrar(e -> guardarJugador());
    }
    
    
    private void cargarSucursales() {
        ListaObjetos<ObjetoBaseDato> sucursales = new SucursalesDB().obtenerSucursales();

        for (int i = 0; i < sucursales.getTamaño(); i++) {
            
            panelSuperAdmin.getComboSucursal().addItem((ObjetoBaseDato) sucursales.seleccionarNodo(i).getObjeto());
            
        }
        
        ListaObjetos<ObjetoBaseDato> roles = new RolDB().obtenerSucursales();

        //INICIA CON 1 PORQUE EL VALOR 0 ES DE EL SUPERADMIN
        for (int i = 1; i < roles.getTamaño(); i++) {
            panelSuperAdmin.getComboRol().addItem((ObjetoBaseDato) roles.seleccionarNodo(i).getObjeto());
        }
    }
    
    private void guardarJugador() {
        String nombre = panelSuperAdmin.getNombre();
        
        if(nombre.equals("") || nombre == null){
            panelSuperAdmin.correoInvalido( "Nombre inválido");
            return;
        }
        
        String correo = panelSuperAdmin.getCorreo();
        
        if(correo.equals("") || correo == null){
            panelSuperAdmin.correoInvalido( "Correo inválido");
            return;
        }
        
        String password = panelSuperAdmin.getContraseña();
        
        if(password.equals("") || password == null){
            panelSuperAdmin.correoInvalido( "Contraseña inválido");
            return;
        }
        
        ObjetoBaseDato sucursal = (ObjetoBaseDato) panelSuperAdmin.getComboSucursal().getSelectedItem();

        
        if(nombre.equals("") || correo.equals("")|| password.equals("")){
        
            System.out.println("No se agregó");
            return;
        }
            
        boolean jugadorCreado = new CrearUsuario().crearJugador(nombre, correo, password, sucursal.getId());
        
        if(jugadorCreado==false){
            panelSuperAdmin.correoInvalido( "Correo ya Registrado");
        }
        
    }
    
   
    
    
    public void agregarEventoRegresarMenu(ActionListener evento){
        panelSuperAdmin.agregarEventoRegresarMenu(evento);
    }
    
    
    
}
