package logicaDeNegocios;

 
public class Personas {
 
    // Atributos
               
    //Datos 
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;
    private String email;
    private String telefono;
    private String tipo; // estudiante, colega, familiar
    private int contPersonas = 0;
    
    //Constructores
    public Personas() {
           
    }
               
    public Personas(String nombre, String apellidoUno, String apellidoDos, 
    		String email, String telefono, String tipo, int contPersonas )
    {
            this.nombre = nombre;
            this.apellidoUno = apellidoUno;
            this.apellidoDos = apellidoDos;
            this.email = email;
            this.telefono = telefono;
            this.setTipo(tipo);
            this.contPersonas = contPersonas;
    }
               
 
 
    public int getContPersonas() {
		return contPersonas;
	}

	public void setContPersonas(int contPersonas) {
		this.contPersonas = contPersonas;
	}

	public String getNombre() {
            return nombre;
    }
 
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }
 
    public String getApellidoUno() {
            return apellidoUno;
    }
 
    public void setApellidoUno(String apellidoUno) {
            this.apellidoUno = apellidoUno;
    }
 
    public String getApellidoDos() {
            return apellidoDos;
    }
 
    public void setApellidoDos(String apellidoDos) {
            this.apellidoDos = apellidoDos;
    }
 
    public String getEmail() {
            return email;
    }
 
    public String setEmail(String email) {
            return this.email = email;
    }
 
    public String getTelefono() {
            return telefono;
    }
 
    public void setTelefono(String telefono) {
            this.telefono = telefono;
    }
 
    public String getTipo() {
            return tipo;
    }
 
    public void setTipo(String tipo) {
            this.tipo = tipo;
    }

	
	
 
 
               
               
    //Metodos

               
               
 
}