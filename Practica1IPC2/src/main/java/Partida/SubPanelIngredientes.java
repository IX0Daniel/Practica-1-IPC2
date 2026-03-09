package Partida;

import Usuarios.Ingrediente;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author dz
 */
public class SubPanelIngredientes extends javax.swing.JPanel {

    public SubPanelIngredientes(Ingrediente ingrediente) {
        initComponents();
        diseñoComponentes(ingrediente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarIngrediente = new javax.swing.JButton();
        spinnerCantidad = new javax.swing.JSpinner();
        nombreIngrediente = new javax.swing.JLabel();
        icono = new javax.swing.JLabel();
        cantidad = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(150, 150));
        setMinimumSize(new java.awt.Dimension(150, 150));
        setName(""); // NOI18N

        agregarIngrediente.setBackground(new java.awt.Color(204, 204, 204));
        agregarIngrediente.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        agregarIngrediente.setForeground(new java.awt.Color(0, 0, 0));
        agregarIngrediente.setText("Agregar");
        agregarIngrediente.setEnabled(false);

        nombreIngrediente.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        nombreIngrediente.setForeground(new java.awt.Color(51, 51, 51));
        nombreIngrediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreIngrediente.setText("Ingrediente");

        icono.setOpaque(true);

        cantidad.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        cantidad.setForeground(new java.awt.Color(255, 255, 255));
        cantidad.setText("x 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreIngrediente)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidad))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(agregarIngrediente)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreIngrediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarIngrediente;
    private javax.swing.JLabel cantidad;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel nombreIngrediente;
    private javax.swing.JSpinner spinnerCantidad;
    // End of variables declaration//GEN-END:variables

    private void diseñoComponentes(Ingrediente ingrediente){
        
        cantidad.setText("x "+Integer.toString(ingrediente.getCantidad()));
        nombreIngrediente.setText(ingrediente.getNombre());
                
       
    }
    
    
    
    public void agregarEventoBoton(ActionListener evento){        
        agregarIngrediente.addActionListener(evento);
    }
    
    public void activarBoton(boolean activar, Color colorBoton){
       agregarIngrediente.setEnabled(activar);
       
       
        if(activar){
       
            agregarIngrediente.setBackground(colorBoton);
       
        }
    
    }
    
    
    
    public void agregarEventoSpinner(ChangeListener evento){
        
        spinnerCantidad.addChangeListener(evento);
        
    
    }

    public JSpinner getSpinnerCantidad() {
        return spinnerCantidad;
    }
    
    
}
