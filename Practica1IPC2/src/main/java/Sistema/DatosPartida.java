package Sistema;

import Listas.ListaObjetos;
import Usuarios.Usuario;

/**
 *
 * @author dz
 */
public class DatosPartida {
    
    private int tiempo;
    private int pedidosCompletados;
    private Usuario player;
    private ListaObjetos<Pedido> pedidos;
    private int puntos;

    public DatosPartida(Usuario player) {
        this.player = player;
        pedidos = new ListaObjetos<>();
    }

    
    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getPedidosCompletados() {
        return pedidosCompletados;
    }

    public void setPedidosCompletados(int pedidosCompletados) {
        this.pedidosCompletados = pedidosCompletados;
    }

    public Usuario getIdPlayer() {
        return player;
    }

    public void setIdPlayer(Usuario player) {
        this.player = player;
    }

    public ListaObjetos<Pedido> getPedidos() {
        return pedidos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    
}
