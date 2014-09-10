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
		scrollPane1.setBounds(10, 11, 539, 261);
		getContentPane().add(scrollPane1);
		
		table1 = new JTable(tableModel);
		scrollPane1.setViewportView(table1);
		//agregarDatos();
		table1.setCellSelectionEnabled(true);
		
		JButton btnEliminarSeleccionado = new JButton("Eliminar Seleccionado");
		btnEliminarSeleccionado.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\DeleteSelectedBook.png"));
		btnEliminarSeleccionado.setBounds(578, 238, 170, 41);
		getContentPane().add(btnEliminarSeleccionado);
		
		JButton btnNewButton = new JButton("Eliminar Todo");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916363_Cancel.png"));
		btnNewButton.setBounds(578, 290, 170, 41);
		getContentPane().add(btnNewButton);
		

		String datosLibro[]= new String[8];
		
		

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		Biblioteca biblio = new Biblioteca();
		
		ArrayList<Libros> Libros = new ArrayList<Libros>();
		
		Libros = biblio.getLibros();
		
		for (int i = 0; i < biblio.getLibros().size(); i++) {
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
