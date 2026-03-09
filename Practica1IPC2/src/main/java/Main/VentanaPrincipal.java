package Main;

import Paneles.PanelBase;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        configuracion();
        componentes();
    }

    private void configuracion(){

        setTitle("Practica 1 iPC2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setSize(840, 670);
        setSize(950, 680);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

    }
    private void componentes(){

        PanelBase panel = new PanelBase();
        setContentPane(panel);
        new ControlPanelBase(panel);
    }

}
