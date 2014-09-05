package logicaDeNegocios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Biblioteca {

    private static String rutaLibros = "./libros.poo";
    private static String rutaLPrestados = "./l_Prestados.poo";
    private static String rutaPersonas = "./personas.poo";
   
    private ArrayList<Personas> arrayPersonas = new ArrayList<Personas>(1);
    private ArrayList<Libros> arrayLibros = new ArrayList<Libros>(1);
    private ArrayList<Libros> arrayLibrosPrestados = new ArrayList<Libros>(1);
    
    
    
	public Biblioteca() {
	}
	

    File archivo = null;
    FileReader lectura = null;
    BufferedReader bufferLectura = null;
    JFrame frame = new JFrame();
  
    
    public void  leerPersona()
    {
		File archivo = new File (rutaPersonas);
    	try
    	{
    		arrayPersonas = null;    		
    		if (archivo.exists())
    		{			
	    		lectura = new FileReader (archivo);
	    		bufferLectura = new BufferedReader(lectura);
	    		
	    		while((bufferLectura.readLine())!=null)    			
	    		{
	    			Personas obj = new Personas();    			
	    			obj.setNombre(bufferLectura.readLine());
	    			obj.setApellidoUno(bufferLectura.readLine());
	    			obj.setApellidoDos(bufferLectura.readLine());
	    			obj.setEmail(bufferLectura.readLine());
	    			obj.setTelefono(bufferLectura.readLine());
	    			obj.setTipo(bufferLectura.readLine());
	    			arrayPersonas.add(obj);				
	    		}

    		}else
        		JOptionPane.showMessageDialog(frame, "No existen datos. O cambio el archivo de ruta.");                		
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
		File archivo = new File (rutaPersonas);
    	try
    	{
    		arrayLibros = null;    		
    		if (archivo.exists())
    		{			
	    		lectura = new FileReader (archivo);
	    		bufferLectura = new BufferedReader(lectura);
	    		
	    		while((bufferLectura.readLine())!=null)    			
	    		{
	    			Personas obj = new Personas();    			
	    			obj.setNombre(bufferLectura.readLine());
	    			obj.setApellidoUno(bufferLectura.readLine());
	    			obj.setApellidoDos(bufferLectura.readLine());
	    			obj.setEmail(bufferLectura.readLine());
	    			obj.setTelefono(bufferLectura.readLine());
	    			obj.setTipo(bufferLectura.readLine());
	    			arrayPersonas.add(obj);				
	    		}

    		}else
        		JOptionPane.showMessageDialog(frame, "No existen datos. O cambio el archivo de ruta.");                		
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
           obj.setNombre(nombre);
           obj.setApellidoUno(apellido1);
           obj.setApellidoDos(apellido2);
           obj.setEmail(email);
           obj.setTelefono(telefono);
           obj.setTipo(tipo);
           arrayPersonas.add(obj); 
           GuardarPersona(arrayPersonas); // no hace falta pasarle arrayPersonas. Es global!
    }
    
    public void AgregarLibro(String titulo, String autor, String editorial, String imagen, String calificacion) throws IOException
    {
    	Libros obj = new Libros();
    	obj.setTitulo(titulo);
    	obj.setAutor(autor);
    	obj.setEditorial(editorial);
    	obj.setImangen(imagen);
    	obj.setCalificacion(calificacion);
    	arrayLibros.add(obj);    	
    	GuardarLibro(arrayLibros);
    }
    
    public void GuardarPersona(ArrayList<Personas> arrayPersonas1) throws IOException
    {
    	FileWriter escribir = null;
    	PrintWriter pw = null;
    	try
    	{		
    		escribir = new FileWriter(rutaPersonas,false);
    		pw = new PrintWriter(escribir);
    		
    		for(Personas obj :  arrayPersonas1)
    		{
	    		pw.println("==>Nueva_persona<==");
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

    public void GuardarLibro(ArrayList<Libros> arrayLibros1) throws IOException
    {
    	FileWriter escribir = null;
    	PrintWriter pw = null;
    	try
    	{		
    		escribir = new FileWriter(rutaLibros,false);
    		pw = new PrintWriter(escribir);
    		
    		for(Libros obj: arrayLibros1)
    		{	
				pw.println("Nuevo_libro:");
				pw.println(obj.getTitulo());
				pw.println(obj.getAutor());
				pw.println(obj.getEditorial());
				pw.println(obj.getImagen());
				pw.println(obj.getCalificacion());
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
    
   

}
	