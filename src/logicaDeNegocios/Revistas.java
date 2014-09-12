package logicaDeNegocios;

public class Revistas {
	
	private String titulo;
	private String autor;
	private String editorial;
	private String edicion;
    private String imagen; // url - foto de portada
    private String calificacion; //calificación en *. // ***** = muy bueno,  * = muy malo 
    private int contRevistas = 0; //id de libro // contador del total libros
    private int diasPrestado = 0;
    private int cantVecesPrestado = 0;// Numero de veces que ha sido prestado
    private String disponibilidad = "0"; // Si es =  0, no esta prestado
	// si es != de 0, el numero correspode al id de la persona que lo tenga
    
    public Revistas(){
    	
    }
    
    public Revistas (String titulo, String autor, String editorial,
			String edicion, String imagen, String calificacion, int contLibros,
			int diasPrestado, int cantVecesPrestado, String disponibilidad) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
		this.imagen = imagen;
		this.calificacion = calificacion;
		this.contRevistas = contLibros;
		this.diasPrestado = diasPrestado;
		this.cantVecesPrestado = cantVecesPrestado;
		this.disponibilidad = disponibilidad;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public int getContRevistas() {
		return contRevistas;
	}

	public void setContRevistas(int contLibros) {
		this.contRevistas= contLibros;
	}

	public int getDiasPrestado() {
		return diasPrestado;
	}

	public void setDiasPrestado(int diasPrestado) {
		this.diasPrestado = diasPrestado;
	}

	public int getCantVecesPrestado() {
		return cantVecesPrestado;
	}

	public void setCantVecesPrestado(int cantVecesPrestado) {
		this.cantVecesPrestado = cantVecesPrestado;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
    
    
    
    
    
}
