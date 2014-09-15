package logicaDeNegocios;

public class Libros {
	
	//Atributos
	private String titulo;
	private String autor;
	private String editorial;
	private String edicion;
    private String imagen; // url - foto de portada
    private String calificacion; //calificación en *. // ***** = muy bueno,  * = muy malo 
    private int contLibros = 0; //id de libro // contador del total libros
    private int diasPrestado = 0;
    private int cantVecesPrestado = 0;// Numero de veces que ha sido prestado
    private String disponibilidad = "0"; // Si es =  0, no esta prestado
	// si es != de 0, el numero correspode al id de la persona que lo tenga
    
	

    //Constructores
	public Libros() {
	}


	public Libros(String titulo, String autor, String editorial,
			String edicion, String imagen, String calificacion, int contLibros,
			int diasPrestado, int cantVecesPrestado, String disponibilidad) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
		this.imagen = imagen;
		this.calificacion = calificacion;
		this.contLibros = contLibros;
		this.diasPrestado = diasPrestado;
		this.cantVecesPrestado = cantVecesPrestado;
		this.disponibilidad = disponibilidad;
	}


	//getters and setters
	public String getDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	public int getCantVecesPrestado() {
		return cantVecesPrestado;
	}

	public void setCantVecesPrestado(int cantVecesPrestado) {
		this.cantVecesPrestado = cantVecesPrestado;
	}
	
	public int getDiasPrestado() {
		return diasPrestado;
	}

	public void setDiasPrestado(int diasPrestado) {
		this.diasPrestado = diasPrestado;
	}

	public int getContLibros() {
		return contLibros;
	}

	public void setContLibros(int contLibros) {
		this.contLibros = contLibros;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
		this.autor = autor; //
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

	public void setImangen(String imangen) {
		this.imagen = imangen;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	
	
}