package logicaDeNegocios;

public class Libros {
	
	private String titulo;
	private String autor;
	private String editorial;
	private String edicion;
    private String imagen; // url - foto de portada
    private String calificacion; //calificación en *. ***** = muy bueno, * = muy malo 
  //private int contLibros = 0; //id de libro
	
	public Libros() {
	}

	public Libros(String titulo, String autor, String editorial,
			String edicion, String imangen, String calificacion)
	{	
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
		this.imagen = imangen;
		this.calificacion = calificacion;
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

