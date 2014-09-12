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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

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
		
		
		
		
		
		
		JScrollPane scrollPersona = new JScrollPane();
		scrollPersona.setBounds(27, 54, 193, 254);
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
		scrollLibro.setBounds(265, 54, 193, 254);
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
		
		
				
		JLabel lblLibro = DefaultComponentFactory.getInstance().createLabel("Libro:");
		lblLibro.setBounds(520, 64, 50, 21);
		getContentPane().add(lblLibro);
		
		JLabel lblPrestarA = DefaultComponentFactory.getInstance().createLabel("Prestar a:");
		lblPrestarA.setBounds(520, 116, 65, 21);
		getContentPane().add(lblPrestarA);
		
		JTextPane textLibroAPrestar = new JTextPane();
		textLibroAPrestar.setEditable(false);
		textLibroAPrestar.setBounds(582, 58, 127, 27);
		getContentPane().add(textLibroAPrestar);
		
		JTextPane textPrestarA = new JTextPane();
		textPrestarA.setBounds(582, 110, 127, 27);
		getContentPane().add(textPrestarA);
		
		
		JButton btnPrestarLibro = new JButton("Prestar Libro");
		btnPrestarLibro.setEnabled(false);
		btnPrestarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String personaEscogida = listPersona.getSelectedValue();
				String libroEscogido = listLibro.getSelectedValue();
				
				System.out.println(personaEscogida);
				System.out.println(libroEscogido);
				
				int iDLibro = biblio.getIDLibro(libroEscogido);
				
				System.out.println(iDLibro);
				
				
				JOptionPane.showMessageDialog(null, "Libro Prestado Correctamente");
				textPrestarA.setText("");
				textLibroAPrestar.setText("");
			}
		});
		btnPrestarLibro.setForeground(SystemColor.textHighlight);
		btnPrestarLibro.setBackground(SystemColor.activeCaptionBorder);
		btnPrestarLibro.setBounds(582, 167, 140, 34);
		getContentPane().add(btnPrestarLibro);
		
		
		JButton btnAgregar = new JButton(">>Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPrestarLibro.setEnabled(true);
				String personaEscogida = listPersona.getSelectedValue();
				String libroEscogido = listLibro.getSelectedValue();
				
				if(personaEscogida.equals(null) && libroEscogido.equals(null)){
				JOptionPane.showMessageDialog(null, "Seleccione el libro y la persona a quien desea agregar primero");
				}
				textPrestarA.setText(personaEscogida);
				textLibroAPrestar.setText(libroEscogido);
				
				
				
			}
		});
		btnAgregar.setBounds(468, 274, 102, 34);
		getContentPane().add(btnAgregar);
		
		JLabel lblPersonas = DefaultComponentFactory.getInstance().createLabel("Personas");
		lblPersonas.setBounds(27, 28, 92, 14);
		getContentPane().add(lblPersonas);
		
		JLabel lblLibros = DefaultComponentFactory.getInstance().createLabel("Libros");
		lblLibros.setBounds(264, 29, 92, 14);
		getContentPane().add(lblLibros);

	}	
}
