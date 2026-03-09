package Usuarios;

public class Usuario extends ObjetoBaseDato{


    private int idRol;
    private String rol;
    private ObjetoBaseDato sucursal;

    public Usuario(int id, String nombre, int idRol, String rol, ObjetoBaseDato sucursal) {
        super(id, nombre);
        
        this.idRol = idRol;
        this.rol = rol;
        this.sucursal = sucursal;
    }
    
    
    

    public int getIdRol() {
        return idRol;
    }

    public String getRol() {
        return rol;
    }

    public ObjetoBaseDato getSucursal() {
        return sucursal;
    }

    
}