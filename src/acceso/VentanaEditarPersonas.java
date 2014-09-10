package acceso;
import logicaDeNegocios.*;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VentanaEditarPersonas extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEditarPersonas frame = new VentanaEditarPersonas();
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
	public VentanaEditarPersonas() {
		
		
		String col[] = {"ID","Nombre","Primer Apellido", "Segundo Apellido", "Email", "Telefono", "Tipo"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        														// El Argumento 0 es el numero de filas.
		setTitle("Editar Personas");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 539, 261);
		getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		//agregarDatos();
		table.setCellSelectionEnabled(true);
		
		JButton btnEliminarSeleccionado = new JButton("Eliminar Seleccionado");
		btnEliminarSeleccionado.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\DeleteSelected.png"));
		btnEliminarSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminarSeleccionado.setBounds(578, 238, 170, 41);
		getContentPane().add(btnEliminarSeleccionado);
		
		JButton btnEliminarTodo = new JButton("Eliminar Todo");
		btnEliminarTodo.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916363_Cancel.png"));
		btnEliminarTodo.setBounds(578, 290, 170, 41);
		getContentPane().add(btnEliminarTodo);
	
		//*DefaultTableModel modelo = (DefaultTableModel)table.getModel();


		
		//JTable table = new JTable(tableModel);

		String datos[] = new String[7];//ARRAY DE 6

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		Biblioteca biblio = new Biblioteca();
		
		ArrayList<Personas> Personas= new ArrayList<Personas>(1);
		Personas = biblio.getPersonas();
		
		for (int i = 0; i < biblio.getPersonas().size(); i++) {



		datos[0] = Integer.toString(biblio.getPersonas().get(i).getContPersonas());
		datos[1] = Personas.get(i).getNombre();
		datos[2] = Personas.get(i).getApellidoUno();
		datos[3] = Personas.get(i).getApellidoDos();
		datos[4] = Personas.get(i).getEmail();
		datos[5] = Personas.get(i).getTelefono();
		datos[6] = Personas.get(i).getTipo();
		tableModel.addRow(datos);
		}
		}
	}