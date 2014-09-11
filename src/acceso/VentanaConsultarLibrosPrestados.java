package acceso;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logicaDeNegocios.Biblioteca;
import logicaDeNegocios.Libros;
import javax.swing.JScrollPane;

public class VentanaConsultarLibrosPrestados extends JInternalFrame {
	private JTable tablePrestados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultarLibrosPrestados frame = new VentanaConsultarLibrosPrestados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VentanaConsultarLibrosPrestados() {
		
		String col[] = {"ID","Titulo","Autor", "Editorial", "Edicion", "Calificacion", "Veces Prestado", "Disponibilidad" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		setTitle("Consultar Libros Prestados");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 539, 261);
		getContentPane().add(scrollPane);
		
		tablePrestados= new JTable(tableModel);
		scrollPane.setViewportView(tablePrestados);
	
		tablePrestados.setCellSelectionEnabled(true);
	
String datosLibro[]= new String[8];
		
		

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		Biblioteca biblio = new Biblioteca();
		
		ArrayList<Libros> Libros = new ArrayList<Libros>();
		
		Libros = biblio.getLibrosPrestado();
		
		for (int i = 0; i < biblio.getLibrosPrestado().size(); i++) {
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
