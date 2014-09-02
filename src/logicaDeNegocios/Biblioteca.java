package logicaDeNegocios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Biblioteca {

    private static String rutaLibros = "./libros.poo";
    private static String rutaPersonas = "./personas.poo";
    
	public Biblioteca() {
	}
	
	private Personas persona = null;

    File archivo = null;
    FileReader lectura = null;
    BufferedReader bufferLectura = null;
    JFrame frame = new JFrame();


    
    
    
    //(String nombre, String apellidoUno, String apellidoDos, String email, String telefono) 
    public void  leerPersona()
    {
		File archivo = new File (rutaPersonas);
    	try
    	{
    		// Apertura del fichero y creacion de BufferedReader para poder
    		//hacer una lectura comoda (disponer del metodo readLine()).
    		
    		ArrayList<Personas> arrayPersonas = new ArrayList<Personas>(1);
    		
    		if (archivo.exists())
    		{			
	    		lectura = new FileReader (archivo);
	    		bufferLectura = new BufferedReader(lectura);
	    		
	    		String linea;
	    		while((linea=bufferLectura.readLine())!=null)    			
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
		//return persona;      
    }
    
    /*
     * Mae
     * Para esta tarea (biblioteca alejandrina) no hace falta modificar el txt.
     * cuando hay modificaciones de personas y/o libros solo modificaremos el 
     * arreglo de obj.... 
     */
    public void GuardarPersona(String nombre, String apellido1, String apellido2, String telefono, String email,String  tipo ) throws IOException
    {
    	FileWriter escribir = null;
    	PrintWriter pw = null;
    	try
    	{		
    		escribir = new FileWriter(rutaPersonas,true);
    		pw = new PrintWriter(escribir);
    		pw.println("Nueva_persona");
    		pw.println(nombre);
    		pw.println(apellido1);
    		pw.println(apellido2);
    		pw.println(telefono);
    		pw.println(email);
    		pw.println(tipo);
    		
    		JOptionPane.showMessageDialog(frame, "Los datos de "+ nombre +" se guardaron correctamente.");                		
    		
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

    public void GuardarLibro(String titulo, String autor, String editorial, String imagen, String calificacion) throws IOException
    {
    	FileWriter escribir = null;
    	PrintWriter pw = null;
    	try
    	{		
    		escribir = new FileWriter(rutaLibros,true);
    		pw = new PrintWriter(escribir);
    		
    		pw.println("Nuevo_libro:");
    		pw.println(titulo);
    		pw.println(autor);
    		pw.println(editorial);
    		pw.println(imagen);
    		pw.println(calificacion);
    		
    		JOptionPane.showMessageDialog(frame, "Los datos del libro "+ titulo +" se guardaron correctamente.");                		
    		
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
   

}
	