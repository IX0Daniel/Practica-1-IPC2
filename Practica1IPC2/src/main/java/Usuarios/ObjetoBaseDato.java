package Usuarios;

/**
 *
 * @author dz
 */


/*
ESTA CLASE SIRVE PARA CUANDO SE NECESITA GUARDAR UN OBJETO DE UNA BASE 
DE DATOS Y CONTIENE UN ID Y NOMBRE, SIRVE PARA QUE OTROS OBJETOS CON MÁS
ATRIBUTOS PUEDAN HEREDAR

pd: no se me ocurrió un mejor nombre para el objeto
*/

public class ObjetoBaseDato {

    private int id;
    private String nombre;

    public ObjetoBaseDato(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    

    
    
    @Override
    public String toString() {
        return nombre;
    }
}
