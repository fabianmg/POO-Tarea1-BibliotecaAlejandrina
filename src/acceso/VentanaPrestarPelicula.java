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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	private JTable tablePersona;
	private JTable tablePelis;
	
	
	public VentanaPrestarPelicula() {
		setTitle("Prestar Pelicula");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		

		
		JLabel lblPersonas = DefaultComponentFactory.getInstance().createLabel("Personas");
		lblPersonas.setBounds(10, 29, 92, 14);
		getContentPane().add(lblPersonas);
		
		JLabel lblPelicula = DefaultComponentFactory.getInstance().createLabel("Pelicula");
		lblPelicula.setBounds(323, 29, 92, 14);
		getContentPane().add(lblPelicula);
		
		String colPelis[] = {"ID","Titulo","Direccion", "Genero", "Calificacion"};
		DefaultTableModel tableModelPelis = new DefaultTableModel(colPelis, 0);
		
		String colPer[] = {"ID","Nombre","Primer Apellido", "Segundo Apellido"};
		DefaultTableModel tableModelPer = new DefaultTableModel(colPer, 0);
		
		String datos[] = new String[5];//ARRAY DE 6

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		
		
		ArrayList<Peliculas> Peliculas= new ArrayList<Peliculas>(1);
		Peliculas = biblio.getPeliculas();
		
		for (int i = 0; i < Peliculas.size(); i++) {



		datos[0] = Integer.toString(Peliculas.get(i).getContPeliculas());
		datos[1] = Peliculas.get(i).getTitulo();
		datos[2] = Peliculas.get(i).getDireccion();
		datos[3] = Peliculas.get(i).getGenero();
		datos[4] = Peliculas.get(i).getImagen();
		tableModelPelis.addRow(datos);
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
		tableModelPer .addRow(datosP);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 302, 197);
		getContentPane().add(scrollPane);
		
		
		tablePersona = new JTable(tableModelPer );
		scrollPane.setViewportView(tablePersona);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(323, 53, 302, 197);
		getContentPane().add(scrollPane_1);
		
		tablePelis = new JTable(tableModelPelis);
		scrollPane_1.setViewportView(tablePelis);
		
		JButton btnPrestar = new JButton("Prestar");
		btnPrestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			    int x;
			    int y;
			              
			    int xL;
			    int yL;
			                
			    x = tablePersona.getSelectedColumn();               
			    y = tablePersona.getSelectedRow();
			                   
			    xL= tablePelis.getSelectedColumn();
			    yL = tablePelis.getSelectedRow();
			                   
			                   
			    String idPersona= (String) tablePersona.getValueAt(y,0);
			    System.out.println(idPersona);
			    String idPelicula= (String) tablePelis.getValueAt(yL,0);
			    System.out.println("Id Pelicula: "+idPelicula);
			            
			    JOptionPane.showMessageDialog(null, "Pelicula Prestado Correctamente!");
			            
				
				
			}
		});
		btnPrestar.setBounds(548, 288, 200, 50);
		getContentPane().add(btnPrestar);
		
	}
}
