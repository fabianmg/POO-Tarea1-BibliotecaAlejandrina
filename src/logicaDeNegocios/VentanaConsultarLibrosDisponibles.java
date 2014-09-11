package logicaDeNegocios;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaConsultarLibrosDisponibles extends JInternalFrame {
	private JTable tableDisponible;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultarLibrosDisponibles frame = new VentanaConsultarLibrosDisponibles();
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
	public VentanaConsultarLibrosDisponibles() {
		String col[] = {"ID","Titulo","Autor", "Editorial", "Edicion", "Calificacion", "Veces Prestado", "Disponibilidad" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 51, 402, 208);
		getContentPane().add(scrollPane);
		
		tableDisponible = new JTable();
		scrollPane.setViewportView(tableDisponible);
		
String datosLibro[]= new String[8];
		
		

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		Biblioteca biblio = new Biblioteca();
		
		ArrayList<Libros> Libros = new ArrayList<Libros>();
		
		Libros = biblio.getLibrosDisponible();
		
		for (int i = 0; i < biblio.getLibrosDisponible().size(); i++) {
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


