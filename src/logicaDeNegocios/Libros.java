package logicaDeNegocios;

public class Libros {
	
	private String titulo;
	private String autor;
	private String editorial;
	private String edicion;
    private String imangen; // url - foto de portada
    private String calificacion; //calificación en *. ***** = bueno, * = muy malo 
	
	public Libros() {
	}

	public Libros(String titulo, String autor, String editorial,
			String edicion, String imangen, String calificacion)
	{	
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
		this.imangen = imangen;
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
		autor = autor;
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

	public String getImangen() {
		return imangen;
	}

	public void setImangen(String imangen) {
		this.imangen = imangen;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	
	
}

