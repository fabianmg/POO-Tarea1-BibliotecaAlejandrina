package acceso;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import logicaDeNegocios.Biblioteca;
import logicaDeNegocios.Peliculas;
import logicaDeNegocios.Personas;
import logicaDeNegocios.Revistas;

import javax.swing.JList;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaPrestarRevista extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrestarRevista frame = new VentanaPrestarRevista();
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
	private JTable tableRevista;
	public VentanaPrestarRevista() {
	
		setTitle("Prestar Revista");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JLabel lblPersonas = DefaultComponentFactory.getInstance().createLabel("Personas");
		lblPersonas.setBounds(27, 28, 92, 14);
		getContentPane().add(lblPersonas);
		
		JLabel lblRevistas = DefaultComponentFactory.getInstance().createLabel("Revistas");
		lblRevistas.setBounds(264, 29, 92, 14);
		getContentPane().add(lblRevistas);
		
		
		String colR[] = {"ID","Titulo","Autor", "Editorial", "Edicion"};
		DefaultTableModel tableModelR = new DefaultTableModel(colR, 0);
		
		String colPer[] = {"ID","Nombre","Primer Apellido", "Segundo Apellido"};
		DefaultTableModel tableModelPer = new DefaultTableModel(colPer, 0);
		
		String datos[] = new String[5];//ARRAY DE 6

		//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 

		
		
		ArrayList<Revistas> Revistas= new ArrayList<Revistas>(1);
		Revistas= biblio.getRevistasDisponible();
		
		for (int i = 0; i < Revistas.size(); i++) {

	        datos[0] = Integer.toString(Revistas.get(i).getContRevistas());
	        datos[1] = Revistas.get(i).getTitulo();
	        datos[2] = Revistas.get(i).getAutor();
	        datos[3] = Revistas.get(i).getEditorial();
	        datos[4] = Revistas.get(i).getEdicion();
	        tableModelR.addRow(datos);
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

		
		tablePersonas = new JTable(tableModelPer);
		scrollPane.setViewportView(tablePersonas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(323, 53, 302, 197);
		getContentPane().add(scrollPane_1);
		
		tableRevista = new JTable(tableModelR);
		scrollPane_1.setViewportView(tableRevista);
		
		JButton btnPrestar = new JButton("Prestar");
		btnPrestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x;
			    int y;
			    
			    int xR;
			    int yR;
			    
				   x = tablePersonas.getSelectedColumn();				
				   y = tablePersonas.getSelectedRow();
				   
				   xR= tableRevista.getSelectedColumn();
				   yR = tableRevista.getSelectedRow();
				   
				   
				   String idPersona= (String) tablePersonas.getValueAt(y,0);
				   System.out.println(idPersona);
				   String idRevista= (String) tableRevista.getValueAt(yR,0);
				   System.out.println("Id Rev: "+idRevista);
			
				   JOptionPane.showMessageDialog(null, "Revista Prestado Correctamente!");
			}
		});
		btnPrestar.setBounds(548, 288, 200, 50);
		getContentPane().add(btnPrestar);
		
	}
}
