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

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
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
    private static String rutaParametros = "./Parametros.poo"; 
    private int contPersonas = 1; // inicia en 1. 
    								// si es != de 0, en numero que tenga correspode a la persona que lo tenga
    private int contLibros;
    private int contPeliculas;
    private int contRevistas;
    public int parametroTopMasPrestado;
    public int parametroDiasDePrestamo;
    public int parametroDiasDeTolerancia;
    public int parametroDiasDeAlerta;

    
    
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
    private Array arrayParametros = new Array(null);
    
    
	public Biblioteca() {
		crearCarpetaImagenesLibro();
		crearCarpetaImagenesPelicula();
		crearCarpetaImagenesRevista();
	}
	

    File archivo = null;
    FileReader lectura = null;
    BufferedReader bufferLectura = null;
    JFrame frame = new JFrame();
  
    
    
    // Crea las carpetas en donde se guardaran las imágenes
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
    
    
    
    //Lectura de los "txt" , para cargarlos en los ArrayList
    public void  leerPersona()
    {
		
    	try
    	{
    		File archivo = new File (rutaPersonas);//inicializa el construsctor
    					//de flujo de entrada y salida para procesar un fichero 
    		arrayPersonas.clear();// limpia el arrayPersonas
    		contPersonas = 1 ;
    		
    		if (archivo.exists()) // Si el archivo en donde se guardan
    		{						// las Personsa existen
	    		lectura = new FileReader (archivo);  // carga el txt en Lectuta 
	    		bufferLectura = new BufferedReader(lectura); 
	    		//bufferLectura.readLine() lee una linea de txt cargando en 
	    		// Lectura y pasa a la siguiente
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
	    			obj.setCantVecesPrestado(Integer.parseInt(bufferLectura.readLine()));
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
	    			contPeliculas ++;
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
    
    // Agregar los datos que recibe al arrayList correspondiente
    public void AgregarPersona(String nombre, String apellido1, String apellido2, String telefono, String email,String  tipo ) throws IOException
    {
    		// Agrega los datos recibidos al arrayList de Personas
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
           GuardarPersona(arrayPersonas);//Guarda los datos que recibio 
           // no hace falta pasarle arrayPersonas. Es global!
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
    	obj.setCantVecesPrestado(0);
    	
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
    	obj.setImagen(rutaImagenPelicula+contPeliculas+".jpg");
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
    
    public void AgregarRevistaPrestada(int idRevista, int idPrsona)
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
    
    public void AgregarPeliculaPrestada(int idPelicula, int idPrsona)
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
    
  
    
    // Guarda  los arrayList en texto plano.
    
    private void GuardarParametro(int diasPrestados,int tolerancia, int alerta, int masPrestados) throws IOException
    {
        FileWriter escribir = null;
        PrintWriter pw = null;
        try
        {       
            escribir = new FileWriter(rutaParametros,false);
            pw = new PrintWriter(escribir);

                pw.println("===>nuevos Parametros<===");
                pw.println(diasPrestados);
                pw.println(tolerancia);
                pw.println(alerta);
                pw.println(masPrestados);
           
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
				pw.println(obj.getCantVecesPrestado());				
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
    		contPeliculas = 0;     		
    		
    		for(Peliculas obj: arrayPeliculas1)
    		{	
    			pw.println("===>nueva pelicula<===");
    			pw.println(contPeliculas++);
				pw.println(obj.getTitulo());
				pw.println(obj.getDireccion());
				pw.println(obj.getGenero());
				pw.println(obj.getImagen());
				pw.println(obj.getCalificacion());
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
    
    
    //Edita los arrayList con los valores recibidos y luego los guarda
       
    
   
    public void EditarPersonas(String nombre, String apellido1, String apellido2, String telefono, String email,String  tipo, int id)
    {
    	// Edita la info de la persona segun el id recibido
    	try
    	{		    			
    		leerPersona();
    
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
    				
    				arrayTempPersonas.add(obj);//se agregan los datos actualizados
    			}else
    				arrayTempPersonas.add(obj);	// ceteris paribus 	
			}
    		arrayPersonas = arrayTempPersonas;
    		GuardarPersona(arrayPersonas);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    //    public void EditarLibros(String titulo, String autor, String editorial, String imagen, String calificacion,int dias, int id) throws IOException
    public void EditarLibros(String titulo, String autor, String editorial, String edicion ,String imagen, String calificacion, int id) throws IOException
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
    		    	obj.setEdicion(edicion);
    		    	obj.setCalificacion(calificacion);
    		    	obj.setImangen(imagen);
    		    	//obj.setDiasPrestado(dias);
    		    	arrayTempLibros.add(obj);// agregan nuevos datos
    			}else
    				arrayTempLibros.add(obj);//	ceteris paribus	
			}
    		arrayLibros = arrayTempLibros;
    		GuardarLibro(arrayLibros); 
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
	}
    
    //public void EditarRevista(String titulo, String autor, String editorial,String edicion, String imagen, String calificacion,int dias, int id) throws IOException
    public void EditarRevista(String titulo, String autor, String editorial,String edicion, String calificacion,int dias, int id) throws IOException
    {
        try
        {                       
            leerRevista();
            ArrayList<Revistas> arrayTempRevista = new ArrayList<Revistas>(1);
            for(Revistas obj: arrayRevistas)
            {   
                if(obj.getContRevistas() == id)
                {
                    obj.setTitulo(titulo);
                    obj.setAutor(autor);
                    obj.setEditorial(editorial);
                    obj.setEdicion(edicion);
                    obj.setCalificacion(calificacion);
                    //obj.setImagen(imagen);
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
    
    //public void EditarPeliculas(String titulo, String direccion, String genero, String imagen, String calificacion,int id) throws IOException
    public void EditarPeliculas(String titulo, String direccion, String genero, String calificacion,int id) throws IOException
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
    		    	//obj.setImagen(imagen);
    		    	obj.setCalificacion(calificacion);
    		    	//obj.setDiasPrestado(dias);
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
    	// Para aparta o prestar un libro editar idPersona.
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
    		    	int i = obj.getCantVecesPrestado();
    		    	obj.setCantVecesPrestado(i+1);
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
    				arrayTempPeliculas.add(obj);//ceteris paribus		
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
    	// retoran el arrayPersonas
    	leerPersona();
		return arrayPersonas;
    }
  
    public ArrayList<Libros> getLibros()
    {
    	// retorna arrayLibros;
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
    
  
    public String getNombrePersona(int idPersona)
    {
		// Optener el nombre de una persona por el id
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
		// Optener el id de un  por el titulo// borrar
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
    	// retorna el id de una pelicula
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
    	//retorna el id de una revista
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
    	// Retorna un ArrayList con los libros prestados  
    	leerLibro();
		ArrayList<Libros> librosPrestados = new ArrayList<Libros>(1);
		ArrayList<Libros> librosArrayTemp = arrayLibros;	
    	try
        	{		    			
        		
        		String nombre = "";
        		int idPersona = 0;
        		
        		for(Libros obj: librosArrayTemp)
        		{	
        			//si es 0, esta disponible
        			if(!obj.getDisponibilidad().equals("0")) 
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
    	return librosPrestados;
    }       
    public ArrayList<Peliculas> getPeliculasPrestado()
    {
    	// retorna una arrayList con las pelicuas prestadas
    	 ArrayList<Peliculas> peliculasPrestados = new ArrayList<Peliculas>(1);
         ArrayList<Peliculas> peliculasArrayTemp = arrayPeliculas;
    	
            try
            {                       
                leerPelicula();
               
                String nombre = "";
                int idPersona = 0;
                
                for(Peliculas obj: peliculasArrayTemp)
                {   
                    if(!(obj.getDisponibilidad().equals("0")))
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
            return peliculasPrestados;
    }   
    public ArrayList<Revistas> getRevistasPrestado()
    {
    	
    	// retorna una arrayList con las revistas prestadas

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
    	// retorna una arrayList con los libros disponibles

    	leerLibro();
		ArrayList<Libros> librosDisponibles = new ArrayList<Libros>(1);
		ArrayList<Libros> librosArrayTemp = arrayLibros;
    	try
	    	{		    				    			    			    		
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
	    	}return librosDisponibles;
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
    	// retorna una arrayList con las pelicuas disponibles 
    	   leerPelicula();
           ArrayList<Peliculas> peliculasDisponibles = new ArrayList<Peliculas>(1);
           ArrayList<Peliculas> peliculasArrayTemp = arrayPeliculas;    
    	try
            {                       
             
                
                
                for(Peliculas obj: peliculasArrayTemp)
                {   
                    if(obj.getDisponibilidad().equals("0"))
                    	peliculasDisponibles.add(obj);
                    {
                    }           
                }
                peliculasArrayTemp.clear();
                return peliculasDisponibles;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return peliculasDisponibles;
    }
    
    private boolean EstaEnLista(String palabra, ArrayList<String> lista)
    {
    	// recibe un string, una lista y dice si el 
    	// string esta en la lista
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
    	// Retorna un arrayList con todas las editoriales 
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
    	// Retorna un arrayList con todos los autores  de los libros
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
    
    public ArrayList<String> getAutoresDeRevista()
        {
    	// Retorna un arrayList con todos los autores  de las Revistas
    	ArrayList<String> autor =  new ArrayList<String>(1);				///////////!
    	String palabra ="";    	    		
    		leerRevista();   
    		
    		for(Revistas str: arrayRevistas)
    		{	
    			palabra = str.getAutor();
    			if(!EstaEnLista(palabra, autor))
    				autor.add(palabra);
			} 
    		
    		return autor;	
    }

    public ArrayList<String>  getEditorialesDeRevistas()
    {
    	// Retorna un arrayList con todas las editoriales de las revitas
    	ArrayList<String> editorial = new ArrayList<String>(1);
    	String palabra ="";    	    		
    		leerRevista();   
    		
    		for(Revistas str: arrayRevistas)
    		{	
    			palabra = str.getEditorial();
    			
    			if(!EstaEnLista(palabra, editorial))
    				editorial.add(palabra);
			} 
    		return editorial;	
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
    	//retorna todos los libros de una misma editorial
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
    	//retorna todos los libros de un mismo autor

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

    public ArrayList<Revistas> getRevistas4Editoriales(String editorial)  
    { 
    	//retorna todos los revistas de una misma editorial

    	ArrayList<Revistas> libros4editorial = new ArrayList<Revistas>(1);
    	String palabra ="";    	    		
    		leerLibro();   
    		
    		for(Revistas obj: arrayRevistas)
    		{	
    			palabra = obj.getEditorial();
    			if(palabra.equals(editorial))
    				libros4editorial.add(obj);
			} 
    		return libros4editorial;	
    }
    
    public ArrayList<Revistas> getRevistas4Autor(String autor)  
    { 
    	//retorna todos las revistas de un mismo a autor

    	ArrayList<Revistas> libros4Autor = new ArrayList<Revistas>(1);
    	String palabra ="";    	    		
    		leerLibro();   
    		for(Revistas obj: arrayRevistas)
    		{	
    			palabra = obj.getAutor();
    			if(palabra.equals(autor))
    				libros4Autor.add(obj);
			} 
    		return libros4Autor;	
    }
    
     
}
