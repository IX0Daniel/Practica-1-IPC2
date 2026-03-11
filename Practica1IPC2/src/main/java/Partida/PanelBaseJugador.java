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
    private PanelResultados panelResultados;
    
    private ControlPartida controlPartida;
    
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
    
    public void cambiarPanelResultados(){
        panelResultados = new PanelResultados(controlPartida.getDatosPartida());
        add(panelResultados, "resultados");
        layout.show(this, "resultados");
        remove(panelPartidaJUgador);
        
        panelPartidaJUgador = null;
        controlPartida = null;
    }
    
    public void cambiarPanelPartida(){
        panelPartidaJUgador = new PanelPartida(usuario);
        controlPartida = new ControlPartida(panelPartidaJUgador, usuario, () -> this.cambiarPanelResultados());
        add(panelPartidaJUgador, "partida");
        layout.show(this, "partida");
        
    }

    public void cambiarPanelMenu(){ 
        layout.show(this, "menu");
        remove(panelResultados);

        
        panelResultados = null;
    }
    
    
    
    
    

    
    public void agregarEventoRergresarMenu(ActionListener evento) {
        panelMenu.eventoRegresarMenu(evento);
    }
   
 
    public PanelPartida getPanelPartidaJUgador() {
        return panelPartidaJUgador;
    }

    
}
