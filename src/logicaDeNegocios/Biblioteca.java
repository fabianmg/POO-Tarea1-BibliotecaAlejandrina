package logicaDeNegocios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Biblioteca {

    private static String rutaLibros = "./libros.poo";
    private static String rutaLPrestados = "./l-Prestados.poo";
    private static String rutaPersonas = "./personas.poo";
    private static String rutaImagenLibro = "./fotosLibro/";
    private int contPersonas = 1; // inicia en 1. Si en libros hay un 0, no esta prestado
    								// si es != de 0, en numero que tenga correspode a la persona que lo tenga
    private int contLibros;
    
   
    private ArrayList<Personas> arrayPersonas = new ArrayList<Personas>(1);
    private ArrayList<Libros> arrayLibros = new ArrayList<Libros>(1);
    private ArrayList<Libros> arrayLibrosPrestados = new ArrayList<Libros>(1);
    
    
    
	public Biblioteca() {
		crearCarpetaImagenes();
	}
	

    File archivo = null;
    FileReader lectura = null;
    BufferedReader bufferLectura = null;
    JFrame frame = new JFrame();
  
    
    private void crearCarpetaImagenes()
    {
		File archivo = new File (rutaImagenLibro);

    	if(!archivo.exists())
    	{
    		archivo.mkdir();
    	}
    }
    
     public void  leerPersona()
    {
		File archivo = new File (rutaPersonas);
    	try
    	{
    		//arrayPersonas = null;
    		arrayPersonas.clear();
    		contPersonas = 0 ;
    		if (archivo.exists())
    		{			
	    		lectura = new FileReader (archivo);
	    		bufferLectura = new BufferedReader(lectura);
	    		
	    		while((bufferLectura.readLine())!=null)    			
	    		{	
	    			Personas obj = new Personas();
	    			obj.setContPersonas(Integer.parseInt(bufferLectura.readLine()));
	    			contPersonas++;
	    			obj.setNombre(bufferLectura.readLine());
	    			obj.setApellidoUno(bufferLectura.readLine());
	    			obj.setApellidoDos(bufferLectura.readLine());
	    			obj.setEmail(bufferLectura.readLine());
	    			obj.setTelefono(bufferLectura.readLine());
	    			obj.setTipo(bufferLectura.readLine());
	    			arrayPersonas.add(obj);				
	    		}

    		}else
        		JOptionPane.showMessageDialog(frame, "No existen datos. O cambio el archivo de ruta. (personas)");                		
    	}catch(Exception e){
    		e.printStackTrace();  
    	}finally
    	{
    		//  En el finally cerramos el fichero, para asegurarnos
    		// que se cierra tanto si todo va bien como si salta  una excepcion.
    		try
    		{
    			//if( null!= lectura )
        		if (archivo.exists())
    				lectura.close();
 
    		}catch (Exception e2)
    			{e2.printStackTrace();}
    	}
    }
    
    public void  leerLibro()
    {
		File archivo = new File (rutaLibros);
    	try
    	{
    		arrayLibros.clear();    
    		contLibros = 0;
    		if (archivo.exists())
    		{			
	    		lectura = new FileReader (archivo);
	    		bufferLectura = new BufferedReader(lectura);
	    		while((bufferLectura.readLine())!=null)    			
	    		{ 
	    			Libros obj = new Libros();   
	    			obj.setContLibros(Integer.parseInt(bufferLectura.readLine()));
	    			contLibros ++;
	    			obj.setTitulo(bufferLectura.readLine());
	    			obj.setAutor(bufferLectura.readLine());
	    			obj.setEditorial(bufferLectura.readLine());
	    			obj.setEdicion(bufferLectura.readLine());
	    			obj.setCalificacion(bufferLectura.readLine());
	    			obj.setImagen(bufferLectura.readLine());
	    			obj.setDiasPrestado(Integer.parseInt(bufferLectura.readLine()));
	    			arrayLibros.add(obj);				
	    		}

    		}else
        		JOptionPane.showMessageDialog(frame, "No existen datos. O cambio el archivo de ruta. (libros)");                		
    	}catch(Exception e){
    		e.printStackTrace();  
    	}finally
    	{
    		//  En el finally cerramos el fichero, para asegurarnos
    		// que se cierra tanto si todo va bien como si salta  una excepcion.
    		try
    		{
    			//if( null!= lectura )
        		if (archivo.exists())
    				lectura.close();
 
    		}catch (Exception e2)
    			{e2.printStackTrace();}
    	}
    }

    /*
     * Mae, Ariel
     * Para esta tarea (biblioteca alejandrina) no hace falta modificar el txt.
     * cuando hay modificaciones de personas y/o libros solo modificaremos el 
     * arreglo de obj.... 
     * Tampoco ocupamos poner los 3 packetes
     */
    
    public void AgregarPersona(String nombre, String apellido1, String apellido2, String telefono, String email,String  tipo ) throws IOException
    {
    	   Personas obj = new Personas(); 
    	   obj.setContPersonas(contPersonas++);
           obj.setNombre(nombre);
           obj.setApellidoUno(apellido1);
           obj.setApellidoDos(apellido2);
           obj.setEmail(email);
           obj.setTelefono(telefono);
           obj.setTipo(tipo);
           arrayPersonas.add(obj); 
           GuardarPersona(arrayPersonas); // no hace falta pasarle arrayPersonas. Es global!
    }
    
    public void AgregarLibro(String titulo, String autor, String editorial, String edicion, String imagen, String calificacion) throws IOException
    {
    	
    	Libros obj = new Libros();
    	obj.setContLibros(contLibros);
    	obj.setTitulo(titulo);
    	obj.setAutor(autor);
    	obj.setEdicion(edicion);
    	obj.setEditorial(editorial);
    	obj.setImangen(imagen);
    	obj.setCalificacion(calificacion);
    	obj.setImagen(rutaImagenLibro+contLibros+".jpg");
    	//obj.setDiasPrestado();
    	
    	contLibros++;
    	arrayLibros.add(obj);    	
    	GuardarLibro(arrayLibros);
    }
    
    private void GuardarPersona(ArrayList<Personas> arrayPersonas1) throws IOException
    {
    	FileWriter escribir = null;
    	PrintWriter pw = null;
    	try
    	{		
    		escribir = new FileWriter(rutaPersonas,false);
    		pw = new PrintWriter(escribir);
    		
    		for(Personas obj :  arrayPersonas1)
    		{
    			pw.println("===>nueva persona<===");
    			pw.println(obj.getContPersonas());
	    		pw.println(obj.getNombre());
	    		pw.println(obj.getApellidoUno());
	    		pw.println(obj.getApellidoDos());
	    		pw.println(obj.getEmail());
	    		pw.println(obj.getTelefono());
	    		pw.println(obj.getTipo());
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally 
    	{
    		try 
    		{ 
    				escribir.close();
    		} catch (Exception e2) 
    		{e2.printStackTrace();}
    	}
    }

    private void GuardarLibro(ArrayList<Libros> arrayLibros1) throws IOException
    {
    	FileWriter escribir = null;
    	PrintWriter pw = null;
    	try
    	{		
    		escribir = new FileWriter(rutaLibros,false);
    		pw = new PrintWriter(escribir);
    		
    		for(Libros obj: arrayLibros1)
    		{	
    			pw.println("===>nuevo libro<===");
    			pw.println(obj.getContLibros());
				pw.println(obj.getTitulo());
				pw.println(obj.getAutor());
				pw.println(obj.getEditorial());
				pw.println(obj.getEdicion());
				pw.println(obj.getCalificacion());
				pw.println(obj.getImagen());
				pw.println(obj.getDiasPrestado());
			}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally 
    	{
    		try 
    		{
    			// 	Nuevamente aprovechamos el finally para
    			//	asegurarnos que se cierra el fichero.
    			//if (null != escribir)
    				escribir.close();
    		} catch (Exception e2) 
    		{e2.printStackTrace();}
    	}
    }
  
    /*public boolean BuscarLibro(String titulo, String autor, String editorial) throws IOException
    {
    	try
    	{		
    		for(Libros obj: arrayLibros)
    		{	
				
    			if(obj.getTitulo().equals(titulo)) 
    			{
    				if(obj.getAutor().equals(autor))
    				{
    						if(obj.getEditorial().equals(editorial))
    						{
    							JOptionPane.showMessageDialog(frame, "Libro ya existe.");
    							return true;
    						}
    				}else
    					{
    						JOptionPane.showMessageDialog(frame, "Libro ya existe, con diferente editorial.");
    						return true;
    					}
    					
    			}else
    				return false;	 
			}                		
    	} catch (Exception e) {
    		e.printStackTrace();
    	} 
		return false;
    }*/
    
    public void EditarPersonas(String nombre, String apellido1, String apellido2, String telefono, String email,String  tipo, int id)
    { 
    	try
    	{		    			
    		leerPersona();
    		// algo feo :/
    		ArrayList<Personas> arrayTempPersonas = new ArrayList<Personas>(1);
    		for(Personas obj: arrayPersonas)
    		{	
    			if(obj.getContPersonas() == id)
    			{
    				obj.setNombre(nombre);
    				obj.setApellidoUno(apellido1);
    				obj.setApellidoDos(apellido2);
    				obj.setTelefono(telefono);
    				obj.setEmail(email);
    				obj.setTipo(tipo);
    				
    		    	
    				arrayTempPersonas.add(obj);
    			}else
    				arrayTempPersonas.add(obj);		
			}
    		arrayPersonas = arrayTempPersonas;
    		GuardarPersona(arrayPersonas);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void EditarLibros(String titulo, String autor, String editorial, String imagen, String calificacion,int dias, int id, int idPersona) throws IOException
    {
    	// Para aparta o prestar un libro editar idPersona.
    	try
    	{		    			
    		leerLibro();
    		ArrayList<Libros> arrayTempLibros = new ArrayList<Libros>(1);
    		for(Libros obj: arrayLibros)
    		{	
    			if(obj.getContLibros() == id)
    			{
    				obj.setTitulo(titulo);
    		    	obj.setAutor(autor);
    		    	obj.setEditorial(editorial);
    		    	obj.setCalificacion(calificacion);
    		    	obj.setImangen(imagen);
    		    	obj.setDiasPrestado(dias);
    		    	arrayTempLibros.add(obj);
    			}else
    				arrayTempLibros.add(obj);		
			}
    		arrayLibros = arrayTempLibros;
    		GuardarLibro(arrayLibros);
    		// Editar el txt de libros prestados!! 
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
	}

    public ArrayList<Personas> getPersonas()
    {
		return arrayPersonas;
    }
    public ArrayList<Libros> getLibros()
    {
		return arrayLibros;
    }
 
    private boolean EstaEnLista(String palabra, ArrayList<String> lista)
    {
    	if(lista!=null)
    	{
    		for(String dato: lista)
    	
	    	{
	    		if(dato == palabra)
	    		{
	    			return true;
	    		}
	    	}
    	}	
		return false;
    }
    
    public ArrayList<String> getEditoriales()  
    { 
    	ArrayList<String> editorial = new ArrayList<String>(1);///////////!
    	String palabra ="";    	    		
    		leerLibro();   
    		for(Libros str: arrayLibros)
    		{	
    			palabra = str.getEditorial();
    			if(!EstaEnLista(palabra, editorial))
    				editorial.add(palabra);
    			//else
    				//editorial.add("no hay datos");
			} 
    		return editorial;	
    }
	
    public ArrayList<String> getAutores()  
    {
    	ArrayList<String> autor =  new ArrayList<String>(1);				///////////!
    	String palabra ="";    	    		
    		leerLibro();   
    		
    		for(Libros str: arrayLibros)
    		{	
    			palabra = str.getAutor();
    			if(!EstaEnLista(palabra, autor))
    				autor.add(palabra);
    			//else
    				//autor.add("no hay datos");
			} 
    		
    		return autor;	
    }

  
    
    
     
}
