package Paneles;

import Main.PanelInicioSesión;
import java.awt.CardLayout;

/**
 * @author dz
 */
public class PanelBase extends javax.swing.JPanel {

    private PanelPartida panelPartida;
    private PanelSuperAdmin panelSuperAdmin;
    private PanelInicioSesión panelLogin;
    private CardLayout layoutPanel;
    
    public PanelBase() {
        initComponents();
        
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 255, 102));
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
   
    public void setLayoutPanel(CardLayout layoutPanel) {
        this.layoutPanel = layoutPanel;
        
        setLayout(this.layoutPanel);
    }
    
    
    
            
    
    

}
