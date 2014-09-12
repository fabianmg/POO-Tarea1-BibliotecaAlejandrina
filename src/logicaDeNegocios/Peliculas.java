package logicaDeNegocios;

public class Peliculas {
	
	private String titulo;
	private String direccion;
	private String genero;
    private String imagen; // url - foto de portada
    private String calificacion; //calificación en *. // ***** = muy bueno,  * = muy malo 
    private int contPeliculas = 0; //id de libro // contador del total libros
    private int diasPrestado = 0;
    private int cantVecesPrestado = 0;// Numero de veces que ha sido prestado
    private String disponibilidad = "0"; // Si es =  0, no esta prestado
	// si es != de 0, el numero correspode al id de la persona que lo tenga
    
	


	public Peliculas() {
	}



    public Peliculas(String titulo, String direccion, String genero, String imagen, String calificacion, int contPeliculas,
            int diasPrestado, int cantVecesPrestado, String disponibilidad) {
        super();
        this.titulo = titulo;
        this.direccion = direccion;
        this.genero = genero;
        this.imagen = imagen;
        this.calificacion = calificacion;
        this.contPeliculas = contPeliculas;
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



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
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



	public int getContPeliculas() {
		return contPeliculas;
	}



	public void setContPeliculas(int contLibros) {
		this.contPeliculas= contLibros;
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