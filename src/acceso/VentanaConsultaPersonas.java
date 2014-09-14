package acceso;
import logicaDeNegocios.*;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
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

import java.awt.Button;
import java.awt.TextField;
import java.awt.Label;

public class VentanaConsultaPersonas extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultaPersonas frame = new VentanaConsultaPersonas();
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
	public VentanaConsultaPersonas() {
		
		Biblioteca bilbio = new Biblioteca();
		
		setToolTipText("");
		
		
		String col[] = {"ID","Nombre","Primer Apellido", "Segundo Apellido", "Email", "Telefono", "Tipo"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        														// El Argumento 0 es el numero de filas.
		setTitle("Consultar Personas");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 58, 539, 261);
		getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		//agregarDatos();
		table.setCellSelectionEnabled(true);
		
		TextField txtCambio = new TextField();
		txtCambio.setText("Nuevo dato..");
		txtCambio.setBounds(577, 257, 109, 20);
		getContentPane().add(txtCambio);
		
		
		Button btnEditar = new Button("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre;
				String apellido1;
			    String apellido2;
			    String email;
			    String telefono;
			    String tipo;
				
			    int x;
			    int y;
			    x = table.getSelectedColumn();				
				y = table.getSelectedRow();
			
				//   EditarPersonas(String nombre, String apellido1, String apellido2, String telefono, String email,String  tipo, int id
				
				//dato = tatableble1.getValueAt(y, x).toString();
				
				if(x!=1)
				{
					nombre = table.getValueAt(y, 1).toString();
				}else
					nombre = txtCambio.getText();
				
				if(x!=2)
				{
					apellido1 = table.getValueAt(y, 2).toString();
				}else
					apellido1 = txtCambio.getText();
				
				if(x!=3)
				{
					apellido2 = table.getValueAt(y, 3).toString();
				}else
					apellido2 = txtCambio.getText();

				if(x!=4)
				{
					email = table.getValueAt(y, 4).toString();
				}else
					email = txtCambio.getText();
				if(x!=5)
				{
					telefono = table.getValueAt(y, 5).toString();
				}else
					telefono = txtCambio.getText();
				if(x==6)
				{
					tipo = txtCambio.getText();
					if(tipo.equals("Colega") || tipo.equals("Familiar") || tipo.equals("Estudiante"))
						{tipo = txtCambio.getText();}else
						{JOptionPane.showMessageDialog(null, "Datos no validos. Eliga:\nColega-Familiar-Estudiante");
					tipo = table.getValueAt(y, 6).toString();}	
				}else
					tipo = table.getValueAt(y, 6).toString();
				int id = Integer.parseInt(table.getValueAt(y, 0).toString());
				
				bilbio.EditarPersonas(nombre, apellido1, apellido2, telefono, email, tipo, id);
			}
		});
		btnEditar.setBounds(579, 283, 70, 22);
		getContentPane().add(btnEditar);
		
		
		
		Label label = new Label("Editar selecci\u00F3n");
		label.setBounds(576, 237, 122, 14);
		getContentPane().add(label);
	
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