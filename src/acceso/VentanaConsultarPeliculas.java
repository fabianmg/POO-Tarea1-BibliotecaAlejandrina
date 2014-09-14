package acceso;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Choice;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logicaDeNegocios.Biblioteca;
import logicaDeNegocios.Libros;
import logicaDeNegocios.Peliculas;
import javax.swing.JScrollPane;

public class VentanaConsultarPeliculas extends JInternalFrame {
	private JTable table1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultarPeliculas frame = new VentanaConsultarPeliculas();
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
	public VentanaConsultarPeliculas() {
		
		String col[] = {"ID","Titulo","Direccion", "Genero", "Calificacion",  "Veces Prestado", "Disponibilidad" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		
		setTitle("Consultar Peliculas");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JButton btnEliminarSeleccionado = new JButton("Eliminar Seleccionado");
		btnEliminarSeleccionado.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\DeleteSelectedBook.png"));
		btnEliminarSeleccionado.setBounds(578, 238, 170, 41);
		getContentPane().add(btnEliminarSeleccionado);
		
		JButton btnEliminarTodo = new JButton("Eliminar Todo");
		btnEliminarTodo.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916363_Cancel.png"));
		btnEliminarTodo.setBounds(578, 290, 170, 41);
		getContentPane().add(btnEliminarTodo);
		
		JLabel lblMostrarPor = DefaultComponentFactory.getInstance().createLabel("Mostrar Por:");
		lblMostrarPor.setBounds(588, 35, 92, 14);
		getContentPane().add(lblMostrarPor);
		
		Choice choiceMostrarPor = new Choice();
		choiceMostrarPor.setBounds(588, 55, 146, 20);
		choiceMostrarPor.addItem("Todos");
		choiceMostrarPor.addItem("Prestados");
		choiceMostrarPor.addItem("Disponibles");
		choiceMostrarPor.addItem("Top mas Prestados" );
		choiceMostrarPor.addItem("Ultimos mas Prestados" );
		
		getContentPane().add(choiceMostrarPor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 539, 261);
		getContentPane().add(scrollPane);
		
		table1 = new JTable(tableModel);
		scrollPane.setViewportView(table1);
		
String datosPelicula[]= new String[7];
		
		

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		Biblioteca biblio = new Biblioteca();
		
		ArrayList<Peliculas> Peliculas = new ArrayList<Peliculas>();
		
		String seleccionado = choiceMostrarPor.getSelectedItem();
		
		
		try{		
		if ( seleccionado == ""){Peliculas = biblio.getPeliculas();}
		if (seleccionado =="") {Peliculas = biblio.getPeliculasDisponible();}
	    if (seleccionado ==""){Peliculas = biblio.getPeliculasPrestado();}
		else {Peliculas = biblio.getPeliculas();}
		}
		finally{}
		System.out.println(seleccionado);
		for (int i = 0; i < Peliculas.size(); i++) {
		datosPelicula[0] = Integer.toString(Peliculas.get(i).getContPeliculas());
		datosPelicula[1] = Peliculas.get(i).getTitulo();
		datosPelicula[2] = Peliculas.get(i).getDireccion();
		datosPelicula[3] = Peliculas.get(i).getGenero();
		datosPelicula[4] = Peliculas.get(i).getCalificacion();
		datosPelicula[5] = Integer.toString(Peliculas.get(i).getCantVecesPrestado());
		datosPelicula[6] = Peliculas.get(i).getDisponibilidad();
		tableModel.addRow(datosPelicula);
		

	}

		

	}
}
