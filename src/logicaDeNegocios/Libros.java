package logicaDeNegocios;

public class Libros {
	
	private String titulo;
	private String autor;
	private String editorial;
	private String edicion;
    private String imagen; // url - foto de portada
    private String calificacion; //calificación en *. ***** = muy bueno, * = muy malo 
    private int contLibros = 0; //id de libro // contador de libros
    private int diasPrestado = 0;
    private int consulador = 0;// Numero de veces Consultados
	


	public Libros() {
	}


	public Libros(String titulo, String autor, String editorial,
			String edicion, String imagen, String calificacion, int contLibros,
			int diasPrestado, int consulador) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
		this.imagen = imagen;
		this.calificacion = calificacion;
		this.contLibros = contLibros;
		this.diasPrestado = diasPrestado;
		this.consulador = consulador;
	}


	public int getConsulador() {
		return consulador;
	}

	public void setConsulador(int consulador) {
		this.consulador = consulador;
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

