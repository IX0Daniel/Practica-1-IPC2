package Main;

import BaseDatos.UsuarioDB;
import Paneles.PanelBase;
import Paneles.PanelPartida;
import Paneles.PanelSuperAdmin;
import Partida.PanelBaseJugador;
import Sistema.ControlPartida;
import Sistema.ControlSuperAdmin;
import Sistema.ControlUsuarioJugador;
import Usuarios.Usuario;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.MenuComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author dz
 */
public class ControlPanelBase {
    
    
    private PanelBase panelBase;
    private CardLayout layoutPanel;
    
    //PANELES
    private PanelPartida panelPartida;
    private PanelInicioSesión panelLogin;
    //private PanelSuperAdmin panelSuper;
    
    //CONTROLADORES
    private ControlSuperAdmin controlSuper;
    private ControlUsuarioJugador controlJugador;

    public ControlPanelBase(PanelBase panelBase) {
        this.panelBase = panelBase;
        panelInicial();
    }
    
    private void panelInicial(){
    
        //panelPartida = new PanelPartida()
        //new ControlPartida(panelPartida, player);
        //add(panelPartida, "partida");
        
        //panelSuperAdmin = new PanelSuperAdmin();
        //new ControlSuperAdmin(panelSuperAdmin);
        //add(panelSuperAdmin, "super");
        
        layoutPanel = new CardLayout();
        panelBase.setLayoutPanel(layoutPanel);
        
        panelLogin = new PanelInicioSesión();
        panelBase.add(panelLogin, "login");
        panelLogin.agregarEventoInicioSesion(e -> validarUsuario());
    
    }

    private void validarUsuario() {
        String[] datosUsuario = panelLogin.getUsuario();
        
        
        Usuario usuario = new UsuarioDB().login(datosUsuario[0], datosUsuario[1]);
        if (usuario == null) { 
            panelLogin.errorInicioSesion();
            return;
        }
        
        System.out.println("Inicio de sesión correcto :Vvv:v.v.:V:V");
        
        
        switch (usuario.getIdRol()) {

            
            //SUPERADMIN
            case 1:
                
                PanelSuperAdmin panelSuper = new PanelSuperAdmin(usuario);
                panelBase.add(panelSuper, "super");
                controlSuper = new ControlSuperAdmin(panelSuper);
                
                layoutPanel.show(panelBase, "super");
                panelSuper.agregarEventoRegresarMenu(e -> mostrarPanelLogin(panelSuper));
                
                break;
                
            //ADMINISTRADOR    
            case 2:
                break;

            //JUGADOR    
            case 3:
                
                PanelBaseJugador panelJugador = new PanelBaseJugador(usuario);
                panelBase.add(panelJugador, "player");
                controlJugador = new ControlUsuarioJugador(panelJugador);
                
                layoutPanel.show(panelBase, "player");
                panelJugador.agregarEventoregresarMenu(e -> mostrarPanelLogin(panelJugador));
                
                break;
        }
        
    }

    private void mostrarPanelLogin(PanelVisual panelSuper) {
        panelLogin.limpiarCampos();
        layoutPanel.show(panelBase, "login");
        
        panelBase.remove((Component) panelSuper);
        
    
    }
    
    
    
    
}
