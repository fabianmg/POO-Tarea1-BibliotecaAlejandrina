package logicaDeNegocios;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.swing.JOptionPane;
 
public class Personas {
 
    // Atributos
               
    //Datos 
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;
    private String email;
    private String telefono;
    private String tipo; // estudiante, colega, familiar
 
    public Personas() {
           
    }
               
    public Personas(String nombre, String apellidoUno, String apellidoDos, 
    		String email, String telefono, String tipo )
    {
            this.nombre = nombre;
            this.apellidoUno = apellidoUno;
            this.apellidoDos = apellidoDos;
            this.email = email;
            this.telefono = telefono;
            this.setTipo(tipo);
    }
               
 
 
    public String getNombre() {
            return nombre;
    }
 
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }
 
    public String getApellidoUno() {
            return apellidoUno;
    }
 
    public void setApellidoUno(String apellidoUno) {
            this.apellidoUno = apellidoUno;
    }
 
    public String getApellidoDos() {
            return apellidoDos;
    }
 
    public void setApellidoDos(String apellidoDos) {
            this.apellidoDos = apellidoDos;
    }
 
    public String getEmail() {
            return email;
    }
 
    public String setEmail(String email) {
            return this.email = email;
    }
 
    public String getTelefono() {
            return telefono;
    }
 
    public void setTelefono(String telefono) {
            this.telefono = telefono;
    }
 
    public String getTipo() {
            return tipo;
    }
 
    public void setTipo(String tipo) {
            this.tipo = tipo;
    }

	
	
 
 
               
               
    //Metodos

               
               
 
}