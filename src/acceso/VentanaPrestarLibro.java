package acceso;

import java.awt.EventQueue;

import logicaDeNegocios.*;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.Choice;
import java.awt.Button;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class VentanaPrestarLibro extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrestarLibro frame = new VentanaPrestarLibro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Biblioteca biblio = new Biblioteca();
	public VentanaPrestarLibro() {
		setTitle("Prestar Libro");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JButton btnPrestarLibro = new JButton("Prestar Libro");
		btnPrestarLibro.setBounds(440, 282, 140, 34);
		getContentPane().add(btnPrestarLibro);
		
		
		
		
		
		JScrollPane scrollPersona = new JScrollPane();
		scrollPersona.setBounds(26, 23, 193, 254);
		getContentPane().add(scrollPersona);
		
		DefaultListModel<String> model1 = new DefaultListModel<String>();

		ArrayList<Personas> personas = new ArrayList<Personas>();
		
		personas= biblio.getPersonas();
		
		for (int i = 0; i< personas.size(); i++){
			
			model1.addElement(personas.get(i).getNombre());
			
			
		}
		
		JList<String> listPersona = new JList<String>();
		scrollPersona.setViewportView(listPersona);
		listPersona.setModel(model1);
		
		
		
		
		
		JScrollPane scrollLibro = new JScrollPane();
		scrollLibro.setBounds(272, 23, 193, 254);
		getContentPane().add(scrollLibro);
		
		
		DefaultListModel<String> model2 = new DefaultListModel<String>();

		ArrayList<Libros> libros = new ArrayList<Libros>();
		
		libros= biblio.getLibros();
		
		for (int i = 0; i< libros.size(); i++){
			
			model2.addElement(libros.get(i).getTitulo());
			
			
		}
			
		
		JList<String> listLibro = new JList<String>();
		scrollLibro.setViewportView(listLibro);
		listLibro.setModel(model2);

	}	
	
}
