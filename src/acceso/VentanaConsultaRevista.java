package acceso;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Choice;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import logicaDeNegocios.Biblioteca;
import logicaDeNegocios.Libros;
import logicaDeNegocios.Revistas;

import javax.swing.JScrollPane;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

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
		Biblioteca biblio = new Biblioteca();
		
		
		Choice chAutor = new Choice();
		chAutor.setBounds(204, 45, 101, 20);
		getContentPane().add(chAutor);
		
		ArrayList<String> lista  =  new ArrayList<String>();
		lista = biblio.getAutoresDeRevista();	
		getContentPane().add(chAutor);
		
		for(String aut: lista)
		{		
			chAutor.addItem(aut);
		}
		
		
		Choice chEditorial = new Choice();
		chEditorial.setBounds(358, 45, 92, 20);
		getContentPane().add(chEditorial);
		lista = biblio.getEditorialesDeRevistas();
				for(String aut: lista)
				{		
					chEditorial.addItem(aut);
				}
						
		
		
		String col[] = {"ID","Titulo","Autor", "Editorial", "Edicion", "Calificacion", "Veces Prestado", "Disponibilidad" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);


		setTitle("Consultar Revista");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 71, 539, 261);
		getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblMostrarPor = DefaultComponentFactory.getInstance().createLabel("Mostrar Por:");
		lblMostrarPor.setBounds(13, 45, 60, 20);
		getContentPane().add(lblMostrarPor);
		
		Choice choiceMostrarPor = new Choice();
		choiceMostrarPor.setBounds(79, 45, 85, 20);
		choiceMostrarPor.addItem("Todos");
		choiceMostrarPor.addItem("Prestados");
		choiceMostrarPor.addItem("Disponibles");
		choiceMostrarPor.addItem("Top mas Prestados" );
		choiceMostrarPor.addItem("Ultimos mas Prestados" );
		choiceMostrarPor.addItem("Editorial" );
		choiceMostrarPor.addItem("Autor" );
		getContentPane().add(choiceMostrarPor);
		
		Label label = new Label("Editar selecci\u00F3n");
		label.setBounds(558, 248, 122, 14);
		getContentPane().add(label);
		
		TextField txtCambio = new TextField();
		txtCambio.setText("Nuevo dato..");
		txtCambio.setBounds(559, 268, 109, 20);
		getContentPane().add(txtCambio);
		
		Button btnEditar = new Button("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////
				try
				{
					int id = 0;
					String titulo;
					String autor;
				    String editorial;
				    String edicion;
				    String imagen;
				    String calificacion;
				    int dias = 0;
				    int x;
				    int y;
				    x = table.getSelectedColumn();				
					y = table.getSelectedRow();
					
					System.out.println(x);
					System.out.println(y);
				
					
					//dato = tatableble1.getValueAt(y, x).toString();
					
					if(x!=1)
					{
						titulo = table.getValueAt(y, 1).toString();
					}else
						titulo = txtCambio.getText();
					
					if(x!=2)
					{
						autor = table.getValueAt(y, 2).toString();
					}else
						autor = txtCambio.getText();
					
					if(x!=3)
					{
						editorial = table.getValueAt(y, 3).toString();
					}else
						editorial = txtCambio.getText();
	
					if(x!=4)
					{
						edicion = table.getValueAt(y, 4).toString();
					}else
						edicion = txtCambio.getText();
					if(x!=5)
					{
						calificacion = table.getValueAt(y, 5).toString();
					}else
						calificacion = txtCambio.getText();
					if(x==6 || x ==7)
					{
						JOptionPane.showMessageDialog(null, "No puede editar estos datos");	
					}
					id = Integer.parseInt(table.getValueAt(y, 0).toString());
					
				  
						biblio.EditarRevista(titulo, autor, editorial,edicion,calificacion, dias, id);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//////////////////////////
				
				
			}
		});
		btnEditar.setBounds(561, 294, 70, 22);
		getContentPane().add(btnEditar);
		
		
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///////////
				try
				{	
					
					tableModel.setRowCount(0);
					table = new JTable(tableModel);
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					table = new JTable(tableModel);
					scrollPane.setViewportView(table);
					table.setCellSelectionEnabled(true);
					

					//scrollPane1.setViewportView(table1);
					//table1.setCellSelectionEnabled(true);
					
					String datosLibro[]= new String[8];
					
					//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST
					
					
					ArrayList<Revistas> revistas = new ArrayList<Revistas>();
					
					String seleccionado = choiceMostrarPor.getSelectedItem();
					System.out.println(seleccionado);
					
				    if (seleccionado =="Autor"){
				    	
				    	seleccionado = chAutor.getSelectedItem();
				    	revistas = biblio.getRevistas4Autor(seleccionado);
					    
				    }else
					if (seleccionado =="Editorial"){
						seleccionado = chEditorial.getSelectedItem();
						revistas = biblio.getRevistas4Editoriales(seleccionado);
					}else
					if ( seleccionado == "Todos"){revistas = biblio.getRevistas();}else
					if (seleccionado =="Prestados") {revistas = biblio.getRevistasPrestado();}else
				    if (seleccionado =="Disponibles"){revistas = biblio.getRevistasDisponible();}else
				    //if (seleccionado =="Top mas Prestados"){revistas = biblio.getr;}else
				    //if (seleccionado =="Ultimos mas prestados"){revistas = biblio.getLibrosDisponible();}else
					{revistas = biblio.getRevistas();}
					
					
					for (int i = 0; i < revistas.size(); i++)
					{
						datosLibro[0] = Integer.toString(revistas.get(i).getContRevistas());
						datosLibro[1] = revistas.get(i).getTitulo();
						datosLibro[2] = revistas.get(i).getAutor();
						datosLibro[3] = revistas.get(i).getEditorial();
						datosLibro[4] = revistas.get(i).getEdicion();
						datosLibro[5] = revistas.get(i).getCalificacion();
						datosLibro[6] = Integer.toString(revistas.get(i).getCantVecesPrestado());
						datosLibro[7] = revistas.get(i).getDisponibilidad();
						tableModel.addRow(datosLibro);
					}
				}catch (Exception e2)
	                {e2.printStackTrace();}
				{
					
				}
				
		
		
				///////////////////
			}
		});
		btnMostrar.setBounds(481, 46, 71, 19);
		getContentPane().add(btnMostrar);
		
		JLabel lblNewLabel = new JLabel("Autor:");
		lblNewLabel.setBounds(170, 46, 39, 14);
		getContentPane().add(lblNewLabel);
	
		
		Label label_1 = new Label("Editorial:");
		label_1.setBounds(310, 45, 42, 20);
		getContentPane().add(label_1);
		
		
		
		 String datosRevista[]= new String[8];

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
