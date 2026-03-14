package Paneles;



import BaseDatos.UsuarioDB;
import Listas.ListaObjetos;
import Main.PanelVisual;
import Sistema.PanelUsuariosExistentes;
import Usuarios.ObjetoBaseDato;
import Usuarios.Usuario;
import Usuarios.UsuarioSuperAdmin;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author dz
 */
public class PanelSuperAdmin extends javax.swing.JPanel implements PanelVisual{

    /**
     * Creates new form PanelSuperAdmin
     */
    private Usuario usuario;
    
    
    public PanelSuperAdmin(Usuario usuario) {
        initComponents();
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagen/return.png"));
        imagen = new ImageIcon(imagen.getImage().getScaledInstance((44), (44), Image.SCALE_SMOOTH));
        botonMenu.setIcon(imagen);
        
        this.usuario = usuario;
        agregarUsuarios();
        
        
        nombreSUperAdmin.setText(usuario.getNombre());
        
        
        botonRegistrar.addActionListener(eventoUsuarios);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        campoContraseña = new javax.swing.JTextField();
        campoNOmbre = new javax.swing.JTextField();
        campoCorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboRol = new javax.swing.JComboBox<>();
        comboSucursal = new javax.swing.JComboBox<>();
        botonRegistrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonMenu = new javax.swing.JButton();
        scrollUsuarios = new javax.swing.JScrollPane();
        contenedorUsuarios = new javax.swing.JPanel();
        nombreSUperAdmin = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(613, 228));
        jPanel1.setMinimumSize(new java.awt.Dimension(613, 228));

        campoContraseña.setBackground(new java.awt.Color(255, 255, 255));

        campoNOmbre.setBackground(new java.awt.Color(255, 255, 255));

        campoCorreo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Contraseña");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Correo");

        ComboRol.setBackground(new java.awt.Color(255, 255, 255));

        comboSucursal.setBackground(new java.awt.Color(255, 255, 255));

        botonRegistrar.setBackground(new java.awt.Color(0, 255, 204));
        botonRegistrar.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        botonRegistrar.setText("Registrar");
        botonRegistrar.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Sucursal");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Rol");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNOmbre, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboSucursal, 0, 149, Short.MAX_VALUE)
                            .addComponent(ComboRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNOmbre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        botonMenu.setBackground(new java.awt.Color(153, 255, 255));
        botonMenu.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        botonMenu.setForeground(new java.awt.Color(0, 0, 0));
        botonMenu.setText("Menu");
        botonMenu.setBorder(null);
        botonMenu.setMargin(new java.awt.Insets(0, 0, 0, 0));

        scrollUsuarios.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollUsuarios.setMaximumSize(new java.awt.Dimension(719, 243));
        scrollUsuarios.setMinimumSize(new java.awt.Dimension(719, 243));

        contenedorUsuarios.setBackground(new java.awt.Color(204, 255, 255));
        contenedorUsuarios.setMaximumSize(new java.awt.Dimension(717, 241));
        contenedorUsuarios.setMinimumSize(new java.awt.Dimension(717, 241));
        contenedorUsuarios.setLayout(new javax.swing.BoxLayout(contenedorUsuarios, javax.swing.BoxLayout.Y_AXIS));
        scrollUsuarios.setViewportView(contenedorUsuarios);

        nombreSUperAdmin.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        nombreSUperAdmin.setForeground(new java.awt.Color(0, 0, 0));
        nombreSUperAdmin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreSUperAdmin.setText("Usuarios:");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Usuarios:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreSUperAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(botonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreSUperAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ObjetoBaseDato> ComboRol;
    private javax.swing.JButton botonMenu;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField campoContraseña;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextField campoNOmbre;
    private javax.swing.JComboBox<Usuarios.ObjetoBaseDato> comboSucursal;
    private javax.swing.JPanel contenedorUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreSUperAdmin;
    private javax.swing.JScrollPane scrollUsuarios;
    // End of variables declaration//GEN-END:variables


    
    public void agregarEventoBotonRegistrar(ActionListener evento){
        botonRegistrar.addActionListener(evento);
                
    
    }
    
    
    
    private ActionListener eventoUsuarios = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            contenedorUsuarios.removeAll();
            agregarUsuarios();
            
        }
    };

    public void correoInvalido(String mensajeError){
        
        JOptionPane.showMessageDialog(null, mensajeError); 
    }
         
    
    public void agregarEventoRegresarMenu(ActionListener evento){
        botonMenu.addActionListener(evento);                    
    }
    
    private void agregarUsuarios(){
        ListaObjetos<UsuarioSuperAdmin> usuariosExistentes = new UsuarioDB().listarUsuarios();
        
        
        for(int i = 0; i < usuariosExistentes.getTamaño(); i++){
            add(Box.createVerticalStrut(10));
            UsuarioSuperAdmin usuario = (UsuarioSuperAdmin) usuariosExistentes.seleccionarNodo(i).getObjeto();
            
            
            PanelUsuariosExistentes panelUsuario = new PanelUsuariosExistentes(usuario);
            contenedorUsuarios.add(panelUsuario);
        }
        
        
        
        revalidate();
        repaint();
    }
    
    
    
    

    //GETTERS
    
    public String getNombre(){
        return campoNOmbre.getText();
    }
    public String getContraseña(){
        return campoContraseña.getText();    
    }
    public String getCorreo(){
        return campoCorreo.getText();
    }
    public String getSucursal(){
        return (String) comboSucursal.getSelectedItem();
    }

    public JComboBox<ObjetoBaseDato> getComboRol() {
        return ComboRol;
    }

    public JComboBox<ObjetoBaseDato> getComboSucursal() {
        return comboSucursal;
    }
    
}