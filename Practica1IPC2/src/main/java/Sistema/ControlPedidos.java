package Sistema;

import BaseDatos.PedidoDB;
import BaseDatos.UsuarioDB;
import Main.ContieneTemporizador;
import PanelPartida.PanelPedidos;
import Partida.PanelPedidoAceptado;
import Partida.SubPanelIngredientes;
import Partida.InformacionPedido;
import Usuarios.Ingrediente;
import Usuarios.Usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author dz
 */
public class ControlPedidos{
    
    
    private PanelPedidoAceptado panelPedidos;
    private Pedido pedido;
    private Usuario player;
    private Runnable actualizarPuntos;
    
    public ControlPedidos(PanelPedidoAceptado panelPedidos, Pedido pedido, Usuario player) {
        this.panelPedidos = panelPedidos;
        this.pedido = pedido;
        this.player = player;
        
        int tiempo = 50 - ((new UsuarioDB().obtenerNivelJugador(player.getId())-1)*10);
        
        panelPedidos.colocarTiempoLimite(tiempo);
        crearIngredientes();
        iniciarTimer(tiempo);
        
        panelPedidos.colocarTiempoLimite(tiempo);
        
        pedido.setEstado("RECIBIDO");
    }
    
    
    private void crearIngredientes(){
    
        pedido.getIngredientes();

        for(int i = 0; i < pedido.getIngredientes().getTamaño(); i++){
            Ingrediente ingrediente = (Ingrediente) pedido.getIngredientes().seleccionarNodo(i).getObjeto();
        
            
            SubPanelIngredientes panelAgregarINgredientes = panelPedidos.agregarIngredientes(ingrediente);
            
            panelAgregarINgredientes.agregarEventoSpinner(e -> validarIngredientes(panelAgregarINgredientes, ingrediente));
            
            panelAgregarINgredientes.agregarEventoBoton(e -> eliminarIngrediente(panelAgregarINgredientes) );            
        
        }
    }
    
    private void eliminarIngrediente(SubPanelIngredientes panelAgregarINgredientes){
    
            panelPedidos.eliminarComponente(panelAgregarINgredientes);
            verificarPasos();
    }
    
    private void validarIngredientes(SubPanelIngredientes panelAgregarINgredientes, Ingrediente ingrediente){
    
        pedido.setEstado("PREPARANDO");
        
        if((int) panelAgregarINgredientes.getSpinnerCantidad().getValue() == ingrediente.getCantidad()){    
            panelAgregarINgredientes.activarBoton(true, new Color(153,255,153));
        
        }else{
            panelAgregarINgredientes.activarBoton(false, new Color(255,153,153));
        }
    
    }
    
    
    public void verificarPasos(){
        if(panelPedidos.getContenedorIngredientes().getComponentCount() == 0){
            
            pedido.setEstado("HORNEANDO");
            
            panelPedidos.activarHorno(true);
            panelPedidos.eventoBotonHornear(e -> timerHorneando());
        }
    }
    
    
    
    
    private void timerHorneando(){
    
        hornoEncendido = true;
        tiempoFinal = (new UsuarioDB().obtenerNivelJugador(player.getId())* 5);
        panelPedidos.configurarBarraDeProgreso(tiempoFinal);
        panelPedidos.activarHorno(false);
                
            
    }
    
    
    private int tiempoTranscurrido = 0;
    private int tiempoHorneando = 0;
    private boolean hornoEncendido = false;
    private int tiempoFinal;
    private Timer timer;

    private void iniciarTimer(int tiempoLimite){
        
       
        
        timer = new Timer(1000, (ActionEvent e) -> {

            tiempoTranscurrido ++;

            panelPedidos.actualizarTiempo(tiempoTranscurrido);

            if (hornoEncendido) {
                pedido.setEstado("HORNEANDO");
                new PedidoDB().actualizarEstadoPedido(pedido.getIdPedido(), pedido.getEstado());
                tiempoHorneando ++;

                panelPedidos.actualizarBarraHorno(tiempoHorneando);


                if (tiempoHorneando >= tiempoFinal) {
                    hornoEncendido = false;

                    activarEntrega();

                }
            }
                
            /*
                ESTE IF ES PARA CUANDO EL TIEMPO LÍMITE DEL TURNO SE ACABA
                SI UNA POZZA ESTÁ EN EL HORNO, EL TIMER DE ESTE SE DETENDRÁ
                pd: no era necesario desactivar el horno
            */
            
            if(tiempoTranscurrido >= tiempoLimite){

                /*if(hornoEncendido){
                    hornoEncendido = false;
                }*/
                
                panelPedidos.pedidoNoEntregado();
                detenerTimer();
            }
        });

        timer.start();
    
    }
 
    private void activarEntrega() {
        panelPedidos.activarEntrega();
        
    }
         
    
    public void detenerTimer(){
    
        timer.stop();
    }
    
    
}
