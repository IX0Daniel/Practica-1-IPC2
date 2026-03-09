package Paneles;

import PanelPartida.PanelPedidos;
import BaseDatos.IngredienteBD;
import BaseDatos.UsuarioDB;
import Partida.PanelPedidoAceptado;
import Sistema.Pedido;
import Usuarios.ObjetoBaseDato;
import Usuarios.Usuario;
import java.awt.event.ActionListener;

/**
 *
 * @author dz
 */
public class PanelPartida extends javax.swing.JPanel {

    private Usuario player;
    
    private PanelPedidos panelPedidos;
              
    
    
    /**
     * Creates new form SubPanelPartida
     * @param player
     */
    public PanelPartida(Usuario player) {
        
       
        
        this.player = player;
                
        
        initComponents();
        componentes();
        
        revalidate();
        repaint();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPedidos = new javax.swing.JScrollPane();
        contenedorPedidosAceptados = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelNivel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelTiempo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setMinimumSize(new java.awt.Dimension(950, 680));

        contenedorPedidos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contenedorPedidos.setMinimumSize(new java.awt.Dimension(220, 610));
        contenedorPedidos.setPreferredSize(new java.awt.Dimension(220, 610));

        contenedorPedidosAceptados.setBackground(new java.awt.Color(51, 255, 153));
        contenedorPedidosAceptados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenedorPedidosAceptados.setForeground(new java.awt.Color(0, 0, 0));
        contenedorPedidosAceptados.setFont(new java.awt.Font("CaskaydiaCove NFM SemiBold", 1, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Regresar");

        jLabel2.setOpaque(true);

        labelNombre.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(0, 0, 0));
        labelNombre.setText("Nombre Player");

        labelNivel.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        labelNivel.setForeground(new java.awt.Color(0, 0, 0));
        labelNivel.setText("Nivel; 0");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("SCORE: 10000");

        labelTiempo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        labelTiempo.setForeground(new java.awt.Color(0, 0, 0));
        labelTiempo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTiempo.setText("Tiempo Restante");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 466, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(153, 153, 153))))
                            .addComponent(contenedorPedidosAceptados, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(labelNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNivel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contenedorPedidosAceptados, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contenedorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane contenedorPedidos;
    private javax.swing.JTabbedPane contenedorPedidosAceptados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelNivel;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTiempo;
    // End of variables declaration//GEN-END:variables

    
    
    private void componentes(){
        
        panelPedidos = new PanelPedidos();
        contenedorPedidos.setViewportView(panelPedidos);
        
        labelNombre.setText(((ObjetoBaseDato) player).getNombre());
        labelNivel.setText("Nivel:" + Integer.toString(new UsuarioDB().obtenerNivelJugador(player.getId())));
        
        
    
    }
            
    public PanelPedidoAceptado agregarPanelJugable(Pedido pedido){
        PanelPedidoAceptado panelPreparacion; 
        panelPreparacion = new PanelPedidoAceptado(pedido);
        contenedorPedidosAceptados.add(panelPreparacion, "Pedido " + pedido.getIdPedido());
        System.out.println("???");
        revalidate();
        repaint();
        
        return panelPreparacion;
    }
    
    public void mostrarTiempo(int tiempo){
        labelTiempo.setText("Tiempo Restante: " + Integer.toString(tiempo));
        
        
    }

    public void eliminarPanelPedidoAceptado(PanelPedidoAceptado panelPedidoAceptado) {
        
        
        contenedorPedidosAceptados.remove(panelPedidoAceptado);
        
        revalidate();
        repaint();
    }
    
    
    
    
    public PanelPedidos getPanelPedidos() {
        return panelPedidos;
    }

    

    

}
