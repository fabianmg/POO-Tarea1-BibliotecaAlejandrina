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

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	private JTable tablePersonas;
	private JTable tableLibros;
	public VentanaPrestarLibro() {
		setTitle("Prestar Libro");
		setBounds(10, 11, 774, 398);	
		getContentPane().setLayout(null);
		
		JLabel lblPersonas = DefaultComponentFactory.getInstance().createLabel("Personas");
		lblPersonas.setBounds(10, 29, 92, 14);
		getContentPane().add(lblPersonas);
		
		JLabel lblLibros = DefaultComponentFactory.getInstance().createLabel("Libros");
		lblLibros.setBounds(323, 29, 92, 14);
		getContentPane().add(lblLibros);
		
		String colL[] = {"ID","Titulo","Autor", "Editorial", "Edicion"};
		DefaultTableModel tableModelL = new DefaultTableModel(colL, 0);
		
		String colP[] = {"ID","Nombre","Primer Apellido", "Segundo Apellido"};
		DefaultTableModel tableModelP = new DefaultTableModel(colP, 0);
		
		String datos[] = new String[7];//ARRAY DE 6

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		Biblioteca biblio = new Biblioteca();
		
		ArrayList<Libros> Libros= new ArrayList<Libros>(1);
		Libros = biblio.getLibrosDisponible();
		
		for (int i = 0; i < biblio.getLibrosDisponible().size(); i++) {



		datos[0] = Integer.toString(biblio.getLibrosDisponible().get(i).getContLibros());
		datos[1] = Libros.get(i).getTitulo();
		datos[2] = Libros.get(i).getAutor();
		datos[3] = Libros.get(i).getEdicion();
		datos[4] = Libros.get(i).getEditorial();
		tableModelL.addRow(datos);
		}
		
		String datosP[] = new String[4];//ARRAY DE 6

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		//Biblioteca biblio = new Biblioteca();
		
		ArrayList<Personas> Personas= new ArrayList<Personas>(1);
		Personas = biblio.getPersonas();
		
		for (int i = 0; i < biblio.getPersonas().size(); i++) {



		datosP[0] = Integer.toString(biblio.getPersonas().get(i).getContPersonas());
		datosP[1] = Personas.get(i).getNombre();
		datosP[2] = Personas.get(i).getApellidoUno();
		datosP[3] = Personas.get(i).getApellidoDos();
		tableModelP.addRow(datosP);
		}
		
		
		JScrollPane scrollPersona = new JScrollPane();
		scrollPersona.setBounds(10, 53, 302, 197);
		getContentPane().add(scrollPersona);
		
		
		tablePersonas = new JTable(tableModelP);
		scrollPersona.setViewportView(tablePersonas);
		
		JScrollPane scrollLibro = new JScrollPane();
		scrollLibro.setBounds(323, 53, 302, 197);
		getContentPane().add(scrollLibro);
		
		tableLibros = new JTable(tableModelL);
		scrollLibro.setViewportView(tableLibros);
		
		JButton btnPrestar = new JButton("Prestar");
		btnPrestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
			    int y;
			    
			    int xR;
			    int yR;
			    
				   x = tablePersonas.getSelectedColumn();				
				   y = tablePersonas.getSelectedRow();
				   
				   xR= tableLibros.getSelectedColumn();
				   yR = tableLibros.getSelectedRow();
				   
				   
				   String idPersona= (String) tablePersonas.getValueAt(y,0);
				   System.out.println(idPersona);
				   String idLibro= (String) tableLibros.getValueAt(yR,0);
				   System.out.println("Id Libro: "+idLibro);
			
				   JOptionPane.showMessageDialog(null, "Libro Prestado Correctamente!");
	
			}
		});
		btnPrestar.setBounds(548, 288, 200, 50);
		getContentPane().add(btnPrestar);

	}	
}
