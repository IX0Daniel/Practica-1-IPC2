package Sistema;

import Partida.PanelBaseJugador;
import java.awt.event.ActionListener;

/**
 * @author dz
 */
public class ControlUsuarioJugador {
   
    private PanelBaseJugador panelBaseJugador;

    public ControlUsuarioJugador(PanelBaseJugador panelBaseJugador) {
        this.panelBaseJugador = panelBaseJugador;
    }
    
    public void eventoBotonJugarPartida(ActionListener evento){
        panelBaseJugador.agregarEventoregresarMenu(evento);
    }
    
}