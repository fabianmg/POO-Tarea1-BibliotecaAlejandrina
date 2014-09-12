package acceso;

import java.awt.EventQueue;
import java.util.ArrayList;

import logicaDeNegocios.*;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logicaDeNegocios.Biblioteca;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Choice;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;

public class VentanaConsultaLibros extends JInternalFrame {
	private JTable table1;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultaLibros frame = new VentanaConsultaLibros();
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
	public VentanaConsultaLibros() {
		
		String col[] = {"ID","Titulo","Autor", "Editorial", "Edicion", "Calificacion", "Veces Prestado", "Disponibilidad" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		setTitle("Consultar Libros");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 55, 539, 261);
		getContentPane().add(scrollPane1);
		
		table1 = new JTable(tableModel);
		scrollPane1.setViewportView(table1);
	
		table1.setCellSelectionEnabled(true);
		
		JButton btnEliminarSeleccionado = new JButton("Eliminar Seleccionado");
		btnEliminarSeleccionado.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\DeleteSelectedBook.png"));
		btnEliminarSeleccionado.setBounds(578, 238, 170, 41);
		getContentPane().add(btnEliminarSeleccionado);
		
		JButton btnEliminarTodo = new JButton("Eliminar Todo");
		btnEliminarTodo.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916363_Cancel.png"));
		btnEliminarTodo.setBounds(578, 290, 170, 41);
		getContentPane().add(btnEliminarTodo);
		
		Choice choiceMostrarPor = new Choice();
		
		choiceMostrarPor.setBounds(588, 55, 146, 20);
		choiceMostrarPor.addItem("Todos");
		choiceMostrarPor.addItem("Prestados");
		choiceMostrarPor.addItem("Disponibles");
		choiceMostrarPor.addItem("Top "+" mas Prestados" );
		choiceMostrarPor.addItem("Ultimos mas Prestados" );
		getContentPane().add(choiceMostrarPor);
		
		
		JLabel lblMostrarPor = DefaultComponentFactory.getInstance().createLabel("Mostrar Por:");
		lblMostrarPor.setBounds(588, 35, 92, 14);
		getContentPane().add(lblMostrarPor);
		

String datosLibro[]= new String[8];
		
		

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		Biblioteca biblio = new Biblioteca();
		
		ArrayList<Libros> Libros = new ArrayList<Libros>();
		
		String seleccionado = choiceMostrarPor.getSelectedItem();
		
		
		try{		
		if ( seleccionado == ""){Libros = biblio.getLibros();}
		if (seleccionado =="") {Libros = biblio.getLibrosPrestado();}
	    if (seleccionado ==""){Libros = biblio.getLibrosDisponible();}
		else {Libros = biblio.getLibrosPrestado();}
		}
		finally{}
		System.out.println(seleccionado);
		for (int i = 0; i < Libros.size(); i++) {
		datosLibro[0] = Integer.toString(Libros.get(i).getContLibros());
		datosLibro[1] = Libros.get(i).getTitulo();
		datosLibro[2] = Libros.get(i).getAutor();
		datosLibro[3] = Libros.get(i).getEditorial();
		datosLibro[4] = Libros.get(i).getEdicion();
		datosLibro[5] = Libros.get(i).getCalificacion();
		datosLibro[6] = Integer.toString(Libros.get(i).getCantVecesPrestado());
		datosLibro[7] = Libros.get(i).getDisponibilidad();
		tableModel.addRow(datosLibro);
		

	}

	}
}
