package Main;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Dz
 */
public class PanelInicioSesión extends javax.swing.JPanel {

    
    public PanelInicioSesión() {
        
        
        initComponents();
        
        diseño();
        
        revalidate();
        repaint();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCOntenedor = new javax.swing.JPanel();
        iconoAdministrador = new javax.swing.JLabel();
        ingresarUsuario = new javax.swing.JTextField();
        botonAcceder = new javax.swing.JButton();
        IngresarContraseña = new javax.swing.JTextField();
        iconoUsuario = new javax.swing.JLabel();
        iconoContraseña = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setMaximumSize(new java.awt.Dimension(820, 670));
        setMinimumSize(new java.awt.Dimension(820, 670));
        setPreferredSize(new java.awt.Dimension(820, 670));

        panelCOntenedor.setBackground(new java.awt.Color(153, 255, 204));
        panelCOntenedor.setLayout(null);

        iconoAdministrador.setBackground(new java.awt.Color(153, 255, 204));
        iconoAdministrador.setOpaque(true);
        panelCOntenedor.add(iconoAdministrador);
        iconoAdministrador.setBounds(160, 70, 105, 105);

        ingresarUsuario.setBackground(new java.awt.Color(153, 255, 204));
        ingresarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        ingresarUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ingresarUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        panelCOntenedor.add(ingresarUsuario);
        ingresarUsuario.setBounds(121, 202, 190, 30);

        botonAcceder.setBackground(new java.awt.Color(255, 255, 255));
        botonAcceder.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        botonAcceder.setForeground(new java.awt.Color(0, 0, 0));
        botonAcceder.setText("Acceder");
        botonAcceder.setBorder(null);
        panelCOntenedor.add(botonAcceder);
        botonAcceder.setBounds(180, 300, 80, 30);

        IngresarContraseña.setBackground(new java.awt.Color(153, 255, 204));
        IngresarContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IngresarContraseña.setForeground(new java.awt.Color(0, 0, 0));
        IngresarContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IngresarContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        panelCOntenedor.add(IngresarContraseña);
        IngresarContraseña.setBounds(120, 250, 190, 30);

        iconoUsuario.setBackground(new java.awt.Color(153, 255, 204));
        iconoUsuario.setOpaque(true);
        panelCOntenedor.add(iconoUsuario);
        iconoUsuario.setBounds(90, 200, 30, 30);

        iconoContraseña.setBackground(new java.awt.Color(153, 255, 204));
        iconoContraseña.setOpaque(true);
        panelCOntenedor.add(iconoContraseña);
        iconoContraseña.setBounds(90, 250, 30, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(panelCOntenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(panelCOntenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IngresarContraseña;
    private javax.swing.JButton botonAcceder;
    private javax.swing.JLabel iconoAdministrador;
    private javax.swing.JLabel iconoContraseña;
    private javax.swing.JLabel iconoUsuario;
    private javax.swing.JTextField ingresarUsuario;
    private javax.swing.JPanel panelCOntenedor;
    // End of variables declaration//GEN-END:variables

    
    
    private void diseño(){
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagen/acceso.png"));
        imagen = new ImageIcon(imagen.getImage().getScaledInstance((105), (105), Image.SCALE_SMOOTH));
        iconoAdministrador.setIcon(imagen);
        
        imagen = new ImageIcon(getClass().getResource("/imagen/user.png"));
        imagen = new ImageIcon(imagen.getImage().getScaledInstance((30), (30), Image.SCALE_SMOOTH));
        iconoUsuario.setIcon(imagen);
        
        
        imagen = new ImageIcon(getClass().getResource("/imagen/password.png"));
        imagen = new ImageIcon(imagen.getImage().getScaledInstance((30), (30), Image.SCALE_SMOOTH));
        iconoContraseña.setIcon(imagen);
    
    }
    
    
    public void agregarEventoInicioSesion(ActionListener eventoBoton){
        botonAcceder.addActionListener(eventoBoton);
        
    }
    public void errorInicioSesion(){
        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
     
    }
         
    
    
    public void limpiarCampos() {
        ingresarUsuario.setText("");
        IngresarContraseña.setText("");
    }
    
    
    
    //GETTERS
    
    public String[] getUsuario(){
        String[] usuario = new String[]{ingresarUsuario.getText(), IngresarContraseña.getText()};
        return usuario;
    }


}
