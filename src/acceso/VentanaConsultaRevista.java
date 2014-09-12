package acceso;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Choice;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import logicaDeNegocios.Biblioteca;
import logicaDeNegocios.Revistas;
import javax.swing.JScrollPane;

public class VentanaConsultaRevista extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultaRevista frame = new VentanaConsultaRevista();
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
	public VentanaConsultaRevista() {
		
		String col[] = {"ID","Titulo","Autor", "Editorial", "Edicion", "Calificacion", "Veces Prestado", "Disponibilidad" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);


		setTitle("Consultar Revista");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 539, 261);
		getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblMostrarPor = DefaultComponentFactory.getInstance().createLabel("Mostrar Por:");
		lblMostrarPor.setBounds(588, 35, 92, 14);
		getContentPane().add(lblMostrarPor);
		
		Choice choiceMostrarPor = new Choice();
		choiceMostrarPor.setBounds(588, 55, 146, 20);
		choiceMostrarPor.addItem("Todos");
		choiceMostrarPor.addItem("Prestados");
		choiceMostrarPor.addItem("Disponibles");
		choiceMostrarPor.addItem("Top "+" mas Prestados" );
		choiceMostrarPor.addItem("Ultimos mas Prestados" );
		getContentPane().add(choiceMostrarPor);
		
		
		
		JButton btnEliminarSeleccionado = new JButton("Eliminar Seleccionado");
		btnEliminarSeleccionado.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\DeleteSelectedBook.png"));
		btnEliminarSeleccionado.setBounds(578, 238, 170, 41);
		getContentPane().add(btnEliminarSeleccionado);
		
		JButton btnEliminarTodo = new JButton("Eliminar Todo");
		btnEliminarTodo.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916363_Cancel.png"));
		btnEliminarTodo.setBounds(578, 290, 170, 41);
		getContentPane().add(btnEliminarTodo);
		
		 String datosRevista[]= new String[8];
	        
	        

	        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

	        Biblioteca biblio = new Biblioteca();
	        
	        ArrayList<Revistas> Revistas = new ArrayList<Revistas>();
	        
	        String seleccionado = choiceMostrarPor.getSelectedItem();
	        
	        
	        try{        
	        if ( seleccionado == ""){Revistas = biblio.getRevistas();}
	        if (seleccionado =="") {Revistas = biblio.getRevistasPrestado();}
	        if (seleccionado ==""){Revistas = biblio.getRevistasDisponible();}
	        else {Revistas = biblio.getRevistas();}
	        }
	        finally{}
	        System.out.println(seleccionado);
	        for (int i = 0; i < Revistas.size(); i++) {
	        datosRevista[0] = Integer.toString(Revistas.get(i).getContRevistas());
	        datosRevista[1] = Revistas.get(i).getTitulo();
	        datosRevista[2] = Revistas.get(i).getAutor();
	        datosRevista[3] = Revistas.get(i).getEditorial();
	        datosRevista[4] = Revistas.get(i).getEdicion();
	        datosRevista[5] = Revistas.get(i).getCalificacion();
	        datosRevista[6] = Integer.toString(Revistas.get(i).getCantVecesPrestado());
	        datosRevista[7] = Revistas.get(i).getDisponibilidad();
	        tableModel.addRow(datosRevista);
	        

	    }

		
	}
}
