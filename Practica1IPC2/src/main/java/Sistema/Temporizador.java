package Sistema;

import Main.ContieneTemporizador;

public class Temporizador extends Thread{
    
    private ContieneTemporizador objetoInvocador;
    private int tiempoLimite;
    private int tiempo;
    private boolean continuarTimer = true;
    
    /*
    Se llama objeto invocador porque cualquier objeto que implemente 
    la interfaz "ContieneTemporizador" tendrá un método para cuando
    el timer termine, sin importar que tipo de objeto sea.
    */ 
    public Temporizador(int segundos, ContieneTemporizador objetoInvocador) {
        this.tiempoLimite = segundos;
        this.objetoInvocador = objetoInvocador;
    }
    
    
    
    @Override
    public void run() {
        
        
        
        do {
            try {
                
                Thread.sleep(1000);
                
                tiempo ++;
                
                objetoInvocador.temporizadorFinalizado();
                
                System.out.println("La pizza lleva " + tiempo+ " en el horno :VVvvvv:V:VV:V:V:");
            } catch (InterruptedException e) {
                System.out.println("ERROR");
                e.printStackTrace();
            }
            
            if(tiempo>= tiempoLimite){
                break;
            }
            
            
            
        } while (continuarTimer);
        
        continuarTimer = false;
        
    
    }

    public void setContinuarAnimacion(boolean continuarAnimacion) {
        this.continuarTimer = continuarAnimacion;
    }

    public boolean isContinuarTimer() {
        return continuarTimer;
    }

    public int getTiempo() {
        return tiempo;
    }
    
    
    
}
