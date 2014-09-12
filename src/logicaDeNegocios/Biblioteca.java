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
import javax.xml.bind.ParseConversionEvent;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import sun.dc.path.PathError;



public class Biblioteca {

    private static String rutaLibros = "./libros.poo";
    private static String rutaLPrestados = "./LibrosPrestados.poo";
    private static String rutaPeliculas = "./Peliculas.poo";
    private static String rutaPPrestados = "./PeliculasPrestadas.poo";
    private static String rutaRevista = "./revista.poo";
    private static String rutaRPrestados = "./RevistaPrestados.poo";
    
    
    private static String rutaPersonas = "./personas.poo";
    private static String rutaImagenLibro = "./fotosLibro/";
    private static String rutaImagenPelicula = "./fotosPelicula/";
    private static String rutaImagenRevista = "./fotosRevista/";
    private int contPersonas = 1; // inicia en 1. 
    								// si es != de 0, en numero que tenga correspode a la persona que lo tenga
    private int contLibros;
    private int contPeliculas;
    private int contRevistas;
    
    private ArrayList<Personas> arrayPersonas = new ArrayList<Personas>(1);
    private ArrayList<Libros> arrayLibros = new ArrayList<Libros>(1);
    private ArrayList<Libros> arrayLibrosPrestados = new ArrayList<Libros>(1);
    private ArrayList<Libros> arrayLibrosDisponibles = new ArrayList<Libros>(1);
    private ArrayList<Peliculas> arrayPeliculas = new ArrayList<Peliculas>(1);
    private ArrayList<Peliculas> arrayPeliculasPrestadas = new ArrayList<Peliculas>(1);
    private ArrayList<Peliculas> arrayPeliculasDisponibles = new ArrayList<Peliculas>(1);
    private ArrayList<Revistas> arrayRevistas = new ArrayList<Revistas>(1);
    private ArrayList<Revistas> arrayRevistasPrestadas = new ArrayList<Revistas>(1);
    private ArrayList<Revistas> arrayRevistasDisponibles = new ArrayList<Revistas>(1);
    
    
    
	public Biblioteca() {
		crearCarpetaImagenesLibro();
		crearCarpetaImagenesPelicula();
		crearCarpetaImagenesRevista();
	}
	

    File archivo = null;
    FileReader lectura = null;
    BufferedReader bufferLectura = null;
    JFrame frame = new JFrame();
  
    
    private void crearCarpetaImagenesLibro()
    {
		File archivo = new File (rutaImagenLibro);

    	if(!archivo.exists())
    	{
    		archivo.mkdir();
    	}
    }
    
    private void crearCarpetaImagenesPelicula()
    {
		File archivo = new File (rutaImagenPelicula);

    	if(!archivo.exists())
    	{
    		archivo.mkdir();
    	}
    }
    
    private void crearCarpetaImagenesRevista()
    {
		File archivo = new File (rutaImagenRevista);

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
    		arrayPersonas.clear();
    		contPersonas = 1 ;
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
	    			obj.setDisponibilidad(bufferLectura.readLine());
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

    public void  leerPelicula()
    {
		File archivo = new File (rutaPeliculas);
    	try
    	{
    		arrayPeliculas.clear();    
    		contPersonas = 0;
    		if (archivo.exists())
    		{			
	    		lectura = new FileReader (archivo);
	    		bufferLectura = new BufferedReader(lectura);
	    		while((bufferLectura.readLine())!=null)    			
	    		{ 
	    			Peliculas objP = new Peliculas();   
	    			objP.setContPeliculas(Integer.parseInt(bufferLectura.readLine()));
	    			contLibros ++;
	    			objP.setTitulo(bufferLectura.readLine());
	    			objP.setDireccion(bufferLectura.readLine());
	    			objP.setGenero(bufferLectura.readLine());
	    			objP.setImagen(bufferLectura.readLine());
	    			objP.setCalificacion(bufferLectura.readLine());
	    			objP.setDiasPrestado(Integer.parseInt(bufferLectura.readLine()));
	    			objP.setDisponibilidad(bufferLectura.readLine());
	    			arrayPeliculas.add(objP);				
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
    
    public void  leerRevista()
    {
        File archivo = new File (rutaRevista);
        try
        {
            arrayRevistas.clear();    
            contRevistas = 0;
            if (archivo.exists())
            {           
                lectura = new FileReader (archivo);
                bufferLectura = new BufferedReader(lectura);
                while((bufferLectura.readLine())!=null)             
                { 
                    Revistas obj = new Revistas();   
                    obj.setContRevistas(Integer.parseInt(bufferLectura.readLine()));
                    contRevistas ++;
                    obj.setTitulo(bufferLectura.readLine());
                    obj.setAutor(bufferLectura.readLine());
                    obj.setEditorial(bufferLectura.readLine());
                    obj.setEdicion(bufferLectura.readLine());
                    obj.setCalificacion(bufferLectura.readLine());
                    obj.setImagen(bufferLectura.readLine());
                    obj.setDiasPrestado(Integer.parseInt(bufferLectura.readLine()));
                    obj.setDisponibilidad(bufferLectura.readLine());
                    arrayRevistas.add(obj);               
                }

            }else
                JOptionPane.showMessageDialog(frame, "No existen datos. O cambio el archivo de ruta. (Revistas)");                        
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

    
    
        
    public void AgregarPersona(String nombre, String apellido1, String apellido2, String telefono, String email,String  tipo ) throws IOException
    {
    	   leerPersona();
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
    	leerLibro();
    	Libros obj = new Libros();
    	obj.setContLibros(contLibros);
    	obj.setTitulo(titulo);
    	obj.setAutor(autor);
    	obj.setEdicion(edicion);
    	obj.setEditorial(editorial);
    	obj.setImangen(imagen);
    	obj.setCalificacion(calificacion);
    	obj.setImagen(rutaImagenLibro+contLibros+".jpg");
    	obj.setDiasPrestado(0);
    	obj.setDisponibilidad("0");
    	
    	contLibros++;
    	arrayLibros.add(obj);    	
    	GuardarLibro(arrayLibros);
    }
    
    public void AgregarRevista(String titulo, String autor, String editorial, String edicion, String imagen, String calificacion) throws IOException
    {
        leerRevista();
        Revistas obj = new Revistas();
        obj.setContRevistas(contRevistas);
        obj.setTitulo(titulo);
        obj.setAutor(autor);
        obj.setEdicion(edicion);
        obj.setEditorial(editorial);
        obj.setImagen(imagen);
        obj.setCalificacion(calificacion);
        obj.setImagen(rutaImagenRevista+contRevistas+".jpg");
        obj.setDiasPrestado(0);
        obj.setDisponibilidad("0");
        
        contRevistas++;
        arrayRevistas.add(obj);       
        GuardarRevista(arrayRevistas);
    }
    
    
    public void AgregarPelicula(String titulo, String direccion, String genero, String imagen, String calificacion) throws IOException
    {
    	leerPelicula();
    	Peliculas obj = new Peliculas();
    	obj.setContPeliculas(contPeliculas);
    	obj.setTitulo(titulo);
    	obj.setDireccion(direccion);
    	obj.setGenero(genero);
    	obj.setImagen(imagen);
    	obj.setCalificacion(calificacion);
    	obj.setImagen(rutaImagenLibro+contLibros+".jpg");
    	obj.setDiasPrestado(0);
    	obj.setDisponibilidad("0");
    	
    	contPeliculas++;
    	arrayPeliculas.add(obj);    	
    	GuardarPelicula(arrayPeliculas);
    }
    
    public void AgregarLibroPretado(int idLibro, int idPrsona)
    {
 	   try
 	   {
 		   leerLibro();
	 	   leerPersona();
	 	   
	 	   ///////////////////?????????????????????????
	 	   
 	   } catch (Exception e) {
   		e.printStackTrace();
	   }
	   	
 	   
    }
    
    public void AgregarRevistaPretada(int idRevista, int idPrsona)
    {
 	   try
 	   {
 		   leerRevista();
	 	   leerPersona();
	 	   
	 	   ///////////////////?????????????????????????
	 	   
 	   } catch (Exception e) {
   		e.printStackTrace();
	   }
	   	
 	   
    }
    
    public void AgregarPeliculaPretada(int idPelicula, int idPrsona)
    {
 	   try
 	   {
 		   leerPelicula();
	 	   leerPersona();
	 	   
	 	   ///////////////////?????????????????????????
	 	   
 	   } catch (Exception e) {
   		e.printStackTrace();
	   }
	   	
 	   
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
				pw.println(obj.getDisponibilidad());
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
  
    private void GuardarRevista(ArrayList<Revistas> arrayRevistas1) throws IOException
    {
        FileWriter escribir = null;
        PrintWriter pw = null;
        try
        {       
            escribir = new FileWriter(rutaRevista,false);
            pw = new PrintWriter(escribir);
            
            for(Revistas obj: arrayRevistas1)
            {   
                pw.println("===>Nueva Revista<===");
                pw.println(obj.getContRevistas());
                pw.println(obj.getTitulo());
                pw.println(obj.getAutor());
                pw.println(obj.getEditorial());
                pw.println(obj.getEdicion());
                pw.println(obj.getCalificacion());
                pw.println(obj.getImagen());
                pw.println(obj.getDiasPrestado());
                pw.println(obj.getDisponibilidad());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
        {
            try 
            {
                //  Nuevamente aprovechamos el finally para
                //  asegurarnos que se cierra el fichero.
                //if (null != escribir)
                    escribir.close();
            } catch (Exception e2) 
            {e2.printStackTrace();}
        }
    }
  
    
    private void GuardarPelicula(ArrayList<Peliculas> arrayPeliculas1) throws IOException
    {
    	FileWriter escribir = null;
    	PrintWriter pw = null;
    	try
    	{		
    		escribir = new FileWriter(rutaPeliculas,false);
    		pw = new PrintWriter(escribir);
    		
    		for(Peliculas obj: arrayPeliculas1)
    		{	
    			pw.println("===>nueva pelicula<===");
    			pw.println(obj.getContPeliculas());
				pw.println(obj.getTitulo());
				pw.println(obj.getDireccion());
				pw.println(obj.getGenero());
				pw.println(obj.getCalificacion());
				pw.println(obj.getImagen());
				pw.println(obj.getDiasPrestado());
				pw.println(obj.getDisponibilidad());
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
    
    public void EditarLibros(String titulo, String autor, String editorial, String imagen, String calificacion,int dias, int id) throws IOException
    {
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
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
	}
    
    public void EditarRevista(String titulo, String autor, String editorial, String imagen, String calificacion,int dias, int id) throws IOException
    {
        try
        {                       
            leerLibro();
            ArrayList<Revistas> arrayTempRevista = new ArrayList<Revistas>(1);
            for(Revistas obj: arrayRevistas)
            {   
                if(obj.getContRevistas() == id)
                {
                    obj.setTitulo(titulo);
                    obj.setAutor(autor);
                    obj.setEditorial(editorial);
                    obj.setCalificacion(calificacion);
                    obj.setImagen(imagen);
                    obj.setDiasPrestado(dias);
                    arrayTempRevista.add(obj);
                }else
                    arrayTempRevista.add(obj);       
            }
            arrayRevistas = arrayTempRevista;
            GuardarRevista(arrayRevistas); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void EditarPeliculas(String titulo, String direccion, String genero, String imagen, String calificacion,int dias, int id) throws IOException
    {
    	try
    	{		    			
    		leerPelicula();
    		ArrayList<Peliculas> arrayTempPeliculas= new ArrayList<Peliculas>(1);
    		for(Peliculas obj: arrayPeliculas)
    		{	
    			if(obj.getContPeliculas() == id)
    			{
    				obj.setTitulo(titulo);
    		    	obj.setDireccion(direccion);
    		    	obj.setGenero(genero);
    		    	obj.setImagen(imagen);
    		    	obj.setCalificacion(calificacion);
    		    	obj.setDiasPrestado(dias);
    		    	arrayTempPeliculas.add(obj);
    			}else
    				arrayTempPeliculas.add(obj);		
			}
    		arrayPeliculas = arrayTempPeliculas;
    		GuardarPelicula(arrayPeliculas); 
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
	}
    
    
    public void EditarLibros(int dias, int idLibro, int idPersona) throws IOException
    {
    	// Para aparta o prestar un libro editar idPersona. Si no dejarlo en 0
    	try
    	{		    			
    		leerLibro();
    		ArrayList<Libros> arrayTempLibros = new ArrayList<Libros>(1);
    		for(Libros obj: arrayLibros)
    		{	
    			if(obj.getContLibros() == idLibro)
    			{
    		    	obj.setDiasPrestado(dias);
    		    	obj.setDisponibilidad(Integer.toString(idPersona));
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
    
    public void EditarRevistas(int dias, int idRevista, int idPersona) throws IOException
    {
        // Para aparta o prestar un Revista editar idPersona. Si no dejarlo en 0
        try
        {                       
            leerRevista();
            ArrayList<Revistas> arrayTempRevistas = new ArrayList<Revistas>(1);
            for(Revistas obj: arrayRevistas)
            {   
                if(obj.getContRevistas() == idRevista)
                {
                    obj.setDiasPrestado(dias);
                    obj.setDisponibilidad(Integer.toString(idPersona));
                    arrayTempRevistas.add(obj);
                }else
                    arrayTempRevistas.add(obj);       
            }
            arrayRevistas = arrayTempRevistas;
            GuardarRevista(arrayRevistas);
            // Editar el txt de Revistas prestados!! 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void EditarPeliculas(int dias, int idPelicula, int idPersona) throws IOException
    {
    	// Para aparta o prestar un Pelicula editar idPersona. Si no dejarlo en 0
    	try
    	{		    			
    		leerPelicula();
    		ArrayList<Peliculas> arrayTempPeliculas = new ArrayList<Peliculas>(1);
    		for(Peliculas obj: arrayPeliculas)
    		{	
    			if(obj.getContPeliculas() == idPelicula)
    			{
    		    	obj.setDiasPrestado(dias);
    		    	obj.setDisponibilidad(Integer.toString(idPersona));
    		    	arrayTempPeliculas.add(obj);
    			}else
    				arrayTempPeliculas.add(obj);		
			}
    		arrayPeliculas = arrayTempPeliculas;
    		GuardarPelicula(arrayPeliculas);
    		// Editar el txt de Peliculas prestados!! 
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
	}


    public ArrayList<Personas> getPersonas()
    {
    	leerPersona();
		return arrayPersonas;
    }
  
    public ArrayList<Libros> getLibros()
    {
    	leerLibro();
		return arrayLibros;
    }

    public ArrayList<Peliculas> getPeliculas()
    {
    	leerPelicula();
		return arrayPeliculas;
    }
    
    public ArrayList<Revistas> getRevistas()
    {
    	leerRevista();
		return arrayRevistas;
    }
    
    private String getNombrePersona(int idPersona)
    {
		String nombre = "";

      	try
    	{		    			
      		leerPersona();
    		for(Personas obj: arrayPersonas)
    		{	
    			if(obj.getContPersonas() == idPersona)
    			{	
    				nombre = obj.getNombre();
    				return nombre;
    			}			
			}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return nombre;
    	
    }
    
    public int getIDLibro(String Titulo)
    {		    			
		leerLibro();
		for(Libros obj: arrayLibros)
		{	
			if(obj.getTitulo().equals(Titulo))
						
			{	
				return obj.getContLibros();
			}			
		}   	
		return 0;
    }
    
    public int getIDPelicula(String Titulo)
    {                       
        leerPelicula();
        for(Peliculas obj: arrayPeliculas)
        {   
            if(obj.getTitulo().equals(Titulo))
                        
            {   
                return obj.getContPeliculas();
            }           
        }       
        return 0;
    }
    
    public int getIDRevista(String Titulo)
    {                       
        leerRevista();
        for(Revistas obj: arrayRevistas)
        {   
            if(obj.getTitulo().equals(Titulo))
                        
            {   
                return obj.getContRevistas();
            }           
        }       
        return 0;
    }
    
    
  
    public ArrayList<Libros> getLibrosPrestado()
    {
        	try
        	{		    			
        		leerLibro();
        		ArrayList<Libros> librosPrestados = new ArrayList<Libros>(1);
        		ArrayList<Libros> librosArrayTemp = arrayLibros;
        		String nombre = "";
        		int idPersona = 0;
        		
        		for(Libros obj: librosArrayTemp)
        		{	
        			if(!obj.getDisponibilidad().equals(0))
        			{
        				idPersona = Integer.parseInt(obj.getDisponibilidad());
        				nombre = getNombrePersona(idPersona);
        				obj.setDisponibilidad(nombre);
        				librosPrestados.add(obj);
        			}			
    			}
        		librosArrayTemp.clear();
        		return librosPrestados;
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
			return arrayLibros;
    }
    
    
    public ArrayList<Peliculas> getPeliculasPrestado()
    {
            try
            {                       
                leerLibro();
                ArrayList<Peliculas> peliculasPrestados = new ArrayList<Peliculas>(1);
                ArrayList<Peliculas> peliculasArrayTemp = arrayPeliculas;
                String nombre = "";
                int idPersona = 0;
                
                for(Peliculas obj: peliculasArrayTemp)
                {   
                    if(!obj.getDisponibilidad().equals(0))
                    {
                        idPersona = Integer.parseInt(obj.getDisponibilidad());
                        nombre = getNombrePersona(idPersona);
                        obj.setDisponibilidad(nombre);
                        peliculasPrestados.add(obj);
                    }           
                }
                peliculasArrayTemp.clear();
                return peliculasPrestados;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayPeliculas;
    }
    
    public ArrayList<Revistas> getRevistasPrestado()
    {
            try
            {                       
                leerLibro();
                ArrayList<Revistas> RevistasPrestados = new ArrayList<Revistas>(1);
                ArrayList<Revistas> RevistasArrayTemp = arrayRevistas;
                String nombre = "";
                int idPersona = 0;
                
                for(Revistas obj: RevistasArrayTemp)
                {   
                    if(!obj.getDisponibilidad().equals(0))
                    {
                        idPersona = Integer.parseInt(obj.getDisponibilidad());
                        nombre = getNombrePersona(idPersona);
                        obj.setDisponibilidad(nombre);
                        RevistasPrestados.add(obj);
                    }           
                }
                RevistasArrayTemp.clear();
                return RevistasPrestados;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayRevistas;
    }
    
    
    
    public ArrayList<Libros> getLibrosDisponible()
	{
	    	try
	    	{		    			
	    		leerLibro();
	    		ArrayList<Libros> librosDisponibles = new ArrayList<Libros>(1);
	    		ArrayList<Libros> librosArrayTemp = arrayLibros;
	    		
	    		
	    		for(Libros obj: librosArrayTemp)
	    		{	
	    			if(obj.getDisponibilidad().equals("0"))
	    			{
	    				
	    				librosDisponibles.add(obj);
	    			}			
				}
	    		librosArrayTemp.clear();
	    		return librosDisponibles;
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
			return arrayLibros;
	}
    
    public ArrayList<Revistas> getRevistasDisponible()
    {
            try
            {                       
                leerRevista();
                ArrayList<Revistas> RevistasDisponibles = new ArrayList<Revistas>(1);
                ArrayList<Revistas> RevistasArrayTemp = arrayRevistas;
                
                
                for(Revistas obj: RevistasArrayTemp)
                {   
                    if(obj.getDisponibilidad().equals("0"))
                    {
                        
                        RevistasDisponibles.add(obj);
                    }           
                }
                RevistasArrayTemp.clear();
                return RevistasDisponibles;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayRevistas;
    }
    
    public ArrayList<Peliculas> getPeliculasDisponible()
    {
            try
            {                       
                leerLibro();
                ArrayList<Peliculas> peliculasDisponibles = new ArrayList<Peliculas>(1);
                ArrayList<Peliculas> peliculasArrayTemp = arrayPeliculas;
                
                
                for(Peliculas obj: peliculasArrayTemp)
                {   
                    if(obj.getDisponibilidad().equals("0"))
                    {
                        
                        peliculasDisponibles.add(obj);
                    }           
                }
                peliculasArrayTemp.clear();
                return peliculasDisponibles;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayPeliculas;
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

    
    public ArrayList<Personas> getTIpo(String tipo)   
    {
    	/*Retorna arrayList de personas del tipo elegido, (colega, familiar o estudiante*/
    	ArrayList<Personas> lista =  new ArrayList<Personas>();
    	String palabra ="";    	    		
    		leerPersona();   
    		for(Personas str: arrayPersonas)
    		{	
    			palabra = str.getTipo();
    			if(palabra == tipo)
    				lista.add(str);
			} 
    		return lista;	
    }


    public ArrayList<Libros> getLibros4Editoriales(String editorial)  
    { 
    	ArrayList<Libros> libros4editorial = new ArrayList<Libros>(1);
    	String palabra ="";    	    		
    		leerLibro();   
    		
    		for(Libros obj: arrayLibros)
    		{	
    			palabra = obj.getEditorial();
    			if(palabra.equals(editorial))
    				libros4editorial.add(obj);
			} 
    		return libros4editorial;	
    }
    
    public ArrayList<Libros> getLibros4Autor(String autor)  
    { 
    	ArrayList<Libros> libros4Autor = new ArrayList<Libros>(1);
    	String palabra ="";    	    		
    		leerLibro();   
    		for(Libros obj: arrayLibros)
    		{	
    			palabra = obj.getAutor();
    			if(palabra.equals(autor))
    				libros4Autor.add(obj);
			} 
    		return libros4Autor;	
    }

    
    
     
}
