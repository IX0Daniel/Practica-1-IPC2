package Sistema;

import BaseDatos.CrearUsuario;
import BaseDatos.RolDB;
import BaseDatos.SucursalesDB;
import Listas.ListaObjetos;
import Paneles.PanelSuperAdmin;
import Usuarios.ObjetoBaseDato;
import java.awt.event.ActionListener;

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
        String correo = panelSuperAdmin.getCorreo();
        String password = panelSuperAdmin.getContraseña();
        ObjetoBaseDato sucursal = (ObjetoBaseDato) panelSuperAdmin.getComboSucursal().getSelectedItem();

        
        if(nombre.equals("") || correo.equals("")|| password.equals("")){
        
            System.out.println("No se agregó");
            return;
        }
            
        
        
        new CrearUsuario().crearJugador(nombre, correo, password, sucursal.getId());
    }
    
    
    public void agregarEventoRegresarMenu(ActionListener evento){
        panelSuperAdmin.agregarEventoRegresarMenu(evento);
    }
    
    
    
}
