//http://www.chuidiang.com/java/herramientas/javamail/EnviarMail.java.html Referenciade donde descargue el codigo.
//Librerias necesarias para la correcta funcion : http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-eeplat-419426.html#javamail-1.4.7-oth-JPR

package logicaDeNegocios;

import logicaDeNegocios.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnviarMail
{
	public static void enviarMail(String destinatario){
        try
       { 
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "alejandrinabiblioteca172@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("alejandrinabiblioteca172@gmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(destinatario)); //Sitio de destino del msj
            Biblioteca biblio2= new Biblioteca();
            message.setSubject("Recordatorio de la devolucion del libro"); //"Subject o motivo del correo"
            message.setText(
            		"Hola! se le recuerda que debe devolverme el libro (ID) " + biblio2.getIDLibro("Santa Biblia" )+ " pues ya pasaron los dias aceptables de prestamo \n Pase un buen dia!"); //Correo

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("alejandrinabiblioteca172@gmail.com", "alejandrina123"); //Aqui va el correo de donde se va a enviar y la contrasena
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
		

	
	
	
    public static void main(String[] args)
    {

    	enviarMail("arielmmonestel@gmail.com");
}





	
    }