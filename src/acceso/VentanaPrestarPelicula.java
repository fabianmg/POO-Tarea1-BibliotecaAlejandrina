package acceso;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import logicaDeNegocios.Biblioteca;
import logicaDeNegocios.Libros;
import logicaDeNegocios.Peliculas;
import logicaDeNegocios.Personas;

import java.awt.List;

import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.TextField;
import java.awt.Button;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;

public class VentanaPrestarPelicula extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrestarPelicula frame = new VentanaPrestarPelicula();
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
	private JTextField textPeliculaAPrestar;
	private JTextField textPrestarA;
	
	
	public VentanaPrestarPelicula() {
		setTitle("Prestar Pelicula");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPerson = new JScrollPane();
		scrollPerson.setBounds(27, 54, 193, 254);
		getContentPane().add(scrollPerson);
		
		DefaultListModel<String> model1 = new DefaultListModel<String>();

		ArrayList<Personas> personas = new ArrayList<Personas>();
		
		personas= biblio.getPersonas();
		
		for (int i = 0; i< personas.size(); i++){
			
			model1.addElement(personas.get(i).getNombre());
			
			
		}
		
		JList <String> listPersona = new JList<String>();
		scrollPerson.setViewportView(listPersona);
		listPersona.setModel(model1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(265, 54, 193, 254);
		getContentPane().add(scrollPane_1);
		
		DefaultListModel<String> model2 = new DefaultListModel<String>();

		ArrayList<Peliculas> peliculas = new ArrayList<Peliculas>();
		
		peliculas= biblio.getPeliculas();
		
		for (int i = 0; i< peliculas.size(); i++){
			
			model2.addElement(peliculas.get(i).getTitulo());
			
			
		}

		
		JList<String> listPelicula = new JList<String>(model2);
		scrollPane_1.setViewportView(listPelicula);
		
		JLabel lblPeliAPrestar = DefaultComponentFactory.getInstance().createLabel("Pelicula:");
		lblPeliAPrestar.setBounds(520, 64, 50, 21);
		getContentPane().add(lblPeliAPrestar);
		
		JLabel lblPrestarA = DefaultComponentFactory.getInstance().createLabel("Prestar a:");
		lblPrestarA.setBounds(520, 116, 65, 21);
		getContentPane().add(lblPrestarA);
		
		textPeliculaAPrestar = new JTextField();
		textPeliculaAPrestar.setEditable(false);
		textPeliculaAPrestar.setBounds(582, 58, 127, 27);
		getContentPane().add(textPeliculaAPrestar);
		textPeliculaAPrestar.setColumns(10);
		
		textPrestarA = new JTextField();
		textPrestarA.setEditable(false);
		textPrestarA.setBounds(582, 110, 127, 27);
		getContentPane().add(textPrestarA);
		textPrestarA.setColumns(10);
		
		JButton btnPrestarPelicula = new JButton("Prestar Pelicula");
		btnPrestarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String personaEscogida = listPersona.getSelectedValue();
				String libroEscogido = listPelicula.getSelectedValue();
				
				System.out.println(personaEscogida);
				System.out.println(libroEscogido);
				
				int iDLibro = biblio.getIDLibro(libroEscogido);
				
				System.out.println(iDLibro);
				
				
				JOptionPane.showMessageDialog(null, "Pelicula Prestada Correctamente");
				textPrestarA.setText("");
				textPeliculaAPrestar.setText("");
			
				
				
			}
		});
		btnPrestarPelicula.setBounds(582, 167, 140, 34);
		getContentPane().add(btnPrestarPelicula);
		
		JButton btnagregar = new JButton(">>Agregar");
		btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnPrestarPelicula.setEnabled(true);
				String personaEscogida = listPersona.getSelectedValue();
				String libroEscogido = listPelicula.getSelectedValue();
				
				if(personaEscogida.equals(null) && libroEscogido.equals(null)){
				JOptionPane.showMessageDialog(null, "Seleccione la Pelicula y la persona a quien desea agregar primero");
				}
				textPrestarA.setText(personaEscogida);
				textPeliculaAPrestar.setText(libroEscogido);
				
				
			}
		});
		btnagregar.setBounds(468, 274, 102, 34);
		getContentPane().add(btnagregar);
		
		JLabel lblPersonas = DefaultComponentFactory.getInstance().createLabel("Personas");
		lblPersonas.setBounds(27, 28, 92, 14);
		getContentPane().add(lblPersonas);
		
		JLabel lblPelicula = DefaultComponentFactory.getInstance().createLabel("Pelicula");
		lblPelicula.setBounds(264, 29, 92, 14);
		getContentPane().add(lblPelicula);
		
	}
}
