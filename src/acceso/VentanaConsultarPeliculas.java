package acceso;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Choice;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logicaDeNegocios.Biblioteca;
import logicaDeNegocios.Libros;
import logicaDeNegocios.Peliculas;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;

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
	Biblioteca biblio = new Biblioteca();	
	public VentanaConsultarPeliculas() {
		
		String col[] = {"ID","Titulo","Direccion", "Genero", "Calificacion",  "Veces Prestado", "Disponibilidad" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		
		setTitle("Consultar Peliculas");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JLabel lblMostrarPor = DefaultComponentFactory.getInstance().createLabel("Mostrar Por:");
		lblMostrarPor.setBounds(240, 50, 60, 14);
		getContentPane().add(lblMostrarPor);
		
		Choice choiceMostrarPor = new Choice();
		choiceMostrarPor.setBounds(306, 44, 146, 20);
		choiceMostrarPor.addItem("Todos");
		choiceMostrarPor.addItem("Prestados");
		choiceMostrarPor.addItem("Disponibles");
		choiceMostrarPor.addItem("Top mas Prestados" );
		//choiceMostrarPor.addItem("Ultimos mas Prestados" );
		
		getContentPane().add(choiceMostrarPor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 539, 261);
		getContentPane().add(scrollPane);
		
		table1 = new JTable(tableModel);
		scrollPane.setViewportView(table1);
		table1.setAutoCreateRowSorter(true);	

			


		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try{
				
				tableModel.setRowCount(0);
				table1 = new JTable(tableModel);
				DefaultTableModel tableModel = new DefaultTableModel(col, 0);
				table1 = new JTable(tableModel);
				scrollPane.setViewportView(table1);
				table1.setCellSelectionEnabled(true);
				table1.setAutoCreateRowSorter(true);
				
				
				
				String datosPelicula[]= new String[7];

				Biblioteca biblio = new Biblioteca();				
				ArrayList<Peliculas> Peliculas = new ArrayList<Peliculas>();				
				String seleccionado = choiceMostrarPor.getSelectedItem();				
				scrollPane.setBounds(10, 70, 539, 261);
				getContentPane().add(scrollPane);
				table1 = new JTable(tableModel);
				scrollPane.setViewportView(table1);
				
				
			if ( seleccionado == "Todos"){Peliculas = biblio.getPeliculas();}
			if (seleccionado =="Disponibles") {Peliculas = biblio.getPeliculasDisponible();}
		    if (seleccionado =="Prestados"){Peliculas = biblio.getPeliculasPrestado();}
		    if (seleccionado =="Top mas Prestados"){Peliculas = biblio.getPeliculasPrestado();}
		    if (seleccionado =="Ultimos mas Prestados"){Peliculas = biblio.getPeliculasPrestado();}
			//else {Peliculas = biblio.getPeliculas();}
		    System.out.println(seleccionado);
		    
			for (int i = 0; i < Peliculas.size(); i++)
			{
				datosPelicula[0] = Integer.toString(Peliculas.get(i).getContPeliculas());
				datosPelicula[1] = Peliculas.get(i).getTitulo();
				datosPelicula[2] = Peliculas.get(i).getDireccion();
				datosPelicula[3] = Peliculas.get(i).getGenero();
				datosPelicula[4] = Peliculas.get(i).getCalificacion();
				datosPelicula[5] = Integer.toString(Peliculas.get(i).getCantVecesPrestado());
				String dispo = Peliculas.get(i).getDisponibilidad();
				if(!dispo.equals("0"))
					dispo = biblio.getNombrePersona(Integer.parseInt(dispo));
				else 
					dispo = "Disponible";
				datosPelicula[6] = dispo;
				tableModel.addRow(datosPelicula);
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
			}
		});
		btnMostrar.setBounds(458, 44, 91, 23);
		getContentPane().add(btnMostrar);
		
		Label label = new Label("Editar selecci\u00F3n");
		label.setBounds(555, 263, 122, 14);
		getContentPane().add(label);
		
		TextField txtCambio = new TextField();
		txtCambio.setText("Nuevo dato..");
		txtCambio.setBounds(556, 283, 109, 20);
		getContentPane().add(txtCambio);
		
		Button btnEditar = new Button("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					//	////////////////////////
		try
		{
			int id = 0;
			String titulo;
			String direccion;
		    String genero;
		    String i;
		    //String imagen;
		    String calificacion;
		    //int dias = 0;
		    int x;
		    int y;
		    x = table1.getSelectedColumn();				
			y = table1.getSelectedRow();
			table1.setAutoCreateRowSorter(true);


			System.out.println(x);
			System.out.println(y);
			//EditarPeliculas(String titulo, String direccion, String genero, String imagen, String calificacion,int dias, int id)
			if(x!=1)
			{
				titulo = table1.getValueAt(y, 1).toString();
			}else
				titulo = txtCambio.getText();
			
			if(x!=2)
			{
				direccion = table1.getValueAt(y, 2).toString();
			}else
				direccion = txtCambio.getText();
			
			if(x!=3)
			{
				genero = table1.getValueAt(y, 3).toString();
			}else
				genero = txtCambio.getText();

			if(x!=4)
			{
				calificacion = table1.getValueAt(y, 4).toString();
			}else
				calificacion = txtCambio.getText();
			
			if(x==6 ||  x==5)
			{
				JOptionPane.showMessageDialog(null, "No puede editar estos datos");	
			}
			id = Integer.parseInt(table1.getValueAt(y, 0).toString());
			
			biblio.EditarPeliculas(titulo, direccion, genero, calificacion, id);
			//biblio.EditarPeliculas(titulo, direccion, genero, imagen, calificacion, id);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//////////////////////////
			}
		});
		btnEditar.setBounds(558, 309, 70, 22);
		getContentPane().add(btnEditar);
		
		
		

	}
	}
//}

