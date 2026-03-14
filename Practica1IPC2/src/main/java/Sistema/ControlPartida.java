package Sistema;

import BaseDatos.IngredienteBD;
import BaseDatos.InventarioDB;
import BaseDatos.PedidoDB;
import BaseDatos.UsuarioDB;
import Paneles.PanelPartida;
import Partida.InformacionPedido;
import Partida.PanelBaseJugador;
import Partida.PanelPedidoAceptado;
import Usuarios.Sucursal;
import Usuarios.Usuario;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ControlPartida implements Controlador{
    
    private PanelPartida panelPartida;
    private CrearPedido creadorPedido;
    private Temporizador temporizador;
    private Usuario player;
    private Sucursal sucursal;
    private int tiempoTranscurrido;
    private PanelBaseJugador panelBase;
    
    
    private Runnable terminarTurno;
    private boolean turnoActivo;
    private DatosPartida datosPartida;
    
    private Controlador controlPedidos;
    
    
    public ControlPartida(PanelPartida panelPartida, Usuario player, Runnable terminarTurno, DatosPartida datosPartida){
        
        this.player = player;
        this.terminarTurno = terminarTurno;
        this.panelPartida = panelPartida;
        
       
        
        creadorPedido = new CrearPedido();
        
        //controlPedidos = new ControlPedidos(panelPartida.getPanelPedidos());        
        
        this.datosPartida = datosPartida;
        

        tiempoTurno();
    }
    
    
    private void colocarPedido(){
        System.out.println("Se va a indicar al panel ke inicie un pedido");
        
        //CONSTULTAR EN LA BASE DE DATOS LA CANTIDAD DE PRODUCTOS
        //escoger un número aleatorio entre el 25% y 100%
             
        //Objeto creadorPedidos que crea una lista de productos con una cantidad en especial
        
        Pedido pedido = creadorPedido.getPedidoGenerado(player.getSucursal().getId());        
        InformacionPedido pedidoCreado = panelPartida.getPanelPedidos().agregarPedido(pedido, e -> iniciarPedido(pedido));
    
    }
    
    
    //ACTUALIZAR PUNTOS
    private void actualizarPuntos(){
    
    
    }
    
    
    /*
        METODO PARA PEDIDOS ACEPTADOS
        
        DESDE AQUÍ SE DEBE ENVIAR EL MÉTODO AL CONTROL PEDIDOS PARA QUE AL PRESIONAR
        "ENTREGAR" SE LE INFORME AL "panelPartida" QUE ELIMINE EL PANEL jajalasfdlkadakjl
    */
    
    private Runnable evento;
    private void iniciarPedido(Pedido pedido){
        
        //SE AGREGA UN PANEL AL TABPANE CUANDO SE ACEPTA EL PEDIDO
        
        //SE GUARDA EL PEDIDO EN LA BASEDATO, Y SE MODIFICA EL INVENTARIO
        int idPedido = new PedidoDB().guardarPedido(player.getId(), pedido.getEstado(), pedido.getIngredientes());
        
        pedido.setIdPedido(idPedido);
        
        PanelPedidoAceptado pedidoAceptado = panelPartida.agregarPanelJugable(pedido);
        
        evento = new Runnable() {
            @Override
            public void run() {
                panelPartida.actualizarPuntos(pedido);
            }
        };
        
        ControlPedidos controlPanelAceptado = new ControlPedidos(pedidoAceptado, pedido, player);
        
        
        new InventarioDB().actualizarInventario(player.getSucursal().getId(), pedido.getIngredientes());
        pedidoAceptado.setEventoEntrega((ActionEvent e) -> eliminarPanelPedidoAceptado(pedidoAceptado, controlPanelAceptado, pedido));
        pedidoAceptado.setEventoCancelar((ActionEvent e) -> eliminarPanelPedidoAceptado(pedidoAceptado, controlPanelAceptado, pedido));
        
        datosPartida.getPedidos().agregarElemento(pedido);
        
    }
    
    private void eliminarPanelPedidoAceptado(PanelPedidoAceptado panelAceptado, ControlPedidos controlPanelAceptado, Pedido pedido){
        
        /*
            NO_ACEPTADO
            ACEPTADO
        
            PREPARANDO
            EN HORNO
            ENTREGADO
        
            NO_ENTREGADO
            RECHAZADO
            
        */
        
        //LA BASE DE DATOS SE ACTUALIZA HASTA EN ESTE PUNTO
        
        new PedidoDB().actualizarEstadoPedido(pedido.getIdPedido(), pedido.getEstado());
        panelPartida.eliminarPanelPedidoAceptado(panelAceptado);
        controlPanelAceptado.detenerTimer();
        evento.run();
        
    }
    
    
    
    
    private int tiempoCreacionPedidos;
    
    private void tiempoTurno(){
        
        
        //PARA CREAR UN PEDIDO INICIAL AL EMPEZAR LA PARTIDA
        colocarPedido();
        
        //CREA UN TEMPORIZADOR PARA EL TIEMPO ENTRE LA CREACIÓN DE CADA PEDIDO
        crearTiempoEntrePedidos();
        
        tiempoTranscurrido = 120;
        
        Timer tiempo = new Timer(1000, (ActionEvent ae) -> {         
            
            tiempoCreacionPedidos--;
            
            if(tiempoCreacionPedidos == 0){
                colocarPedido();
                crearTiempoEntrePedidos();
            }
            
            if(tiempoTranscurrido >= 1){
                tiempoTranscurrido--;
                panelPartida.mostrarTiempo(tiempoTranscurrido);
            }else{
                ((Timer) ae.getSource()).stop();
                
                //INDICAR AL PANEL BASE JUGADOR QUE CAMBIE AL PANEL RESULTADOS :vvvV:v:v:v:v
                terminarTurno.run();
            }
            
            
            //if(turnoActivo)
            
            
            
            
        });
        
        tiempo.start();
    
    }
    
    
    private void crearTiempoEntrePedidos(){
        int nivel = new UsuarioDB().obtenerNivelJugador(player.getId());
        tiempoCreacionPedidos = 18 - ((nivel-1)*6);
        
    
    
    }

    public DatosPartida getDatosPartida() {
        return datosPartida;
    }
    
    
    
}