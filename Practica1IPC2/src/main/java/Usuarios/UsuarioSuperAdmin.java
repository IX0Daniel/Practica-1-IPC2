package Usuarios;

/**
 * @author dz
 */
public class UsuarioSuperAdmin{
    
    private int id;
    private String nombre;
    private String correo;
    private String password;
    private String rol;
    private String sucursal;

    public UsuarioSuperAdmin(int id, String nombre, String correo, String password, String rol, String sucursal) {
        this.rol = rol;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
        this.sucursal = sucursal;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public String getSucursal() {
        return sucursal;
    }

  
  
     
    
    
    
    
}
