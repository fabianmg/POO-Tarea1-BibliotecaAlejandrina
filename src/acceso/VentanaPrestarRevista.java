package acceso;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import logicaDeNegocios.Biblioteca;
import logicaDeNegocios.Personas;
import logicaDeNegocios.Revistas;

import javax.swing.JList;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrestarRevista extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrestarRevista frame = new VentanaPrestarRevista();
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
	
	private JTextField textRevistaAPrestar;
	private JTextField textPrestarA;
	public VentanaPrestarRevista() {
	
		setTitle("Prestar Revista");
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
			//System.out.println(personas.get(i).getNombre());
			
			
		}
				
		JList<String> listPersona = new JList<String>();
		listPersona.setModel(model1);
		scrollPersona.setViewportView(listPersona);
		
		JScrollPane scrollRevista = new JScrollPane();
		scrollRevista.setBounds(265, 54, 193, 254);
		getContentPane().add(scrollRevista);

		DefaultListModel<String> model2 = new DefaultListModel<String>();

		ArrayList<Revistas> revistas = new ArrayList<Revistas>();
		
		revistas= biblio.getRevistas();
		
		for (int i = 0; i< revistas.size(); i++){
			
			model2.addElement(revistas.get(i).getTitulo());
			//System.out.println(revistas.get(i).getTitulo());
			
		}
		
		JList<String> listRevista = new JList<String>();
		listRevista.setModel(model2);
		scrollRevista.setViewportView(listRevista);
		
		
		JLabel lblRevista = DefaultComponentFactory.getInstance().createLabel("Revista:");
		lblRevista.setBounds(520, 64, 50, 21);
		getContentPane().add(lblRevista);
		
		JLabel lblPrestarA = DefaultComponentFactory.getInstance().createLabel("Prestar a:");
		lblPrestarA.setBounds(520, 116, 65, 21);
		getContentPane().add(lblPrestarA);
		
		textRevistaAPrestar = new JTextField();
		textRevistaAPrestar.setBounds(582, 58, 127, 27);
		getContentPane().add(textRevistaAPrestar);
		textRevistaAPrestar.setColumns(10);
		
		textPrestarA = new JTextField();
		textPrestarA.setBounds(582, 110, 127, 27);
		getContentPane().add(textPrestarA);
		textPrestarA.setColumns(10);
		
		JButton btnPrestarRevista = new JButton("Prestar Revista");
		btnPrestarRevista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String personaEscogida = listPersona.getSelectedValue();
				String revistaEscogido = listRevista.getSelectedValue();
				
				System.out.println(personaEscogida);
				System.out.println(revistaEscogido);
				
				int iDLibro = biblio.getIDLibro(revistaEscogido);
				
				System.out.println(iDLibro);
				
				
				JOptionPane.showMessageDialog(null, "Revista Prestada Correctamente");
				textPrestarA.setText("");
				textRevistaAPrestar.setText("");
			
			}
		});
		btnPrestarRevista.setBounds(582, 167, 140, 34);
		getContentPane().add(btnPrestarRevista);
		
		JButton btnagregar = new JButton(">>Agregar");
		btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnPrestarRevista.setEnabled(true);
				String personaEscogida = listPersona.getSelectedValue();
				String libroEscogido = listRevista.getSelectedValue();
				
				if(personaEscogida.equals(null) && libroEscogido.equals(null)){
				JOptionPane.showMessageDialog(null, "Seleccione la revista y la persona a quien desea agregar primero");
				}
				textPrestarA.setText(personaEscogida);
				textRevistaAPrestar.setText(libroEscogido);
				
			}
		});
		btnagregar.setBounds(468, 274, 102, 34);
		getContentPane().add(btnagregar);
		
		JLabel lblPersonas = DefaultComponentFactory.getInstance().createLabel("Personas");
		lblPersonas.setBounds(27, 28, 92, 14);
		getContentPane().add(lblPersonas);
		
		JLabel lblRevistas = DefaultComponentFactory.getInstance().createLabel("Revistas");
		lblRevistas.setBounds(264, 29, 92, 14);
		getContentPane().add(lblRevistas);
		
	}
}
