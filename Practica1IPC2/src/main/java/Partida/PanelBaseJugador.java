package Partida;

import Main.PanelVisual;
import Paneles.PanelPartida;
import Sistema.ControlPartida;
import Usuarios.Usuario;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

/**
 * @author dz
 */
public class PanelBaseJugador extends javax.swing.JPanel implements PanelVisual{

    private CardLayout layout;
    
    private Usuario usuario;
    private PanelMenuJugador panelMenu;
    private PanelPartida panelPartidaJUgador;

    public PanelBaseJugador(Usuario usuario) {
        this.usuario = usuario;
        
        
        initComponents();
        agregarPaneles();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
    private void agregarPaneles(){
    
        layout = new CardLayout();
        setLayout(layout);
        
        panelMenu = new PanelMenuJugador(usuario);
        add(panelMenu, "menu");
        
        panelMenu.eventoIniciarPartida(e -> cambiarPanelPartida());

    }
    

    
    public void cambiarPanelPartida(){
        panelPartidaJUgador = new PanelPartida(usuario);
        new ControlPartida(panelPartidaJUgador, usuario);
        add(panelPartidaJUgador, "partida");
        layout.show(this, "partida");
        
    }
    public void cambiarPanelMenu(){ 
        layout.show(this, "menu");
        remove(panelPartidaJUgador);        
        panelPartidaJUgador = null;
    }

    
    public void agregarEventoregresarMenu(ActionListener evento) {
        panelMenu.eventoRegresarMenu(evento);
    }
   
 
    public PanelPartida getPanelPartidaJUgador() {
        return panelPartidaJUgador;
    }

    
}
