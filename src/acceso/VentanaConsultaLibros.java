package acceso;

import java.awt.EventQueue;
import java.util.ArrayList;

import logicaDeNegocios.*;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logicaDeNegocios.Biblioteca;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Choice;

import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.sun.javafx.scene.paint.GradientUtils.Parser;

import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.Button;
import java.io.IOException;

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
		
		Biblioteca biblio = new Biblioteca();

		
		String col[] = {"ID","Titulo","Autor", "Editorial", "Edicion", "Calificacion", "Veces Prestado", "Disponibilidad" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		setTitle("Consultar Libros");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 86, 539, 261);
		getContentPane().add(scrollPane1);
		
		table1 = new JTable(tableModel);
		scrollPane1.setViewportView(table1);
	
		table1.setCellSelectionEnabled(true);
		
		Choice chDisp = new Choice();
				
		chDisp.setBounds(78, 29, 118, 20);
		chDisp.addItem("Todos");
		chDisp.addItem("Prestados");
		chDisp.addItem("Disponibles");
		chDisp.addItem("Top mas prestados" );
		chDisp.addItem("Ultimos mas prestados" );
		chDisp.addItem("Autor" );
		chDisp.addItem("Editorial" );

		
		Choice chAutor = new Choice();
		chAutor.setBounds(250, 29, 109, 20);
		getContentPane().add(chAutor);
		
		

		ArrayList<String> lista  =  new ArrayList<String>();
		lista = biblio.getAutores();	
		getContentPane().add(chAutor);
		
		for(String aut: lista)
		{		
			chAutor.addItem(aut);
		}

		
		Choice chEditorial = new Choice();
		chEditorial.setBounds(427, 29, 122, 20);
		getContentPane().add(chEditorial);
		
		

		lista = biblio.getEditoriales();	
		getContentPane().add(chEditorial);
		
		Label label_1 = new Label("Disponibilidad:");
		label_1.setBounds(10, 35, 72, 14);
		getContentPane().add(label_1);
		
		chDisp.setBounds(98, 29, 108, 20);
		getContentPane().add(chDisp);
		
		for(String edi: lista)
		{		
			chEditorial.addItem(edi);
		}
		
		
		
		
		JLabel lblMostrarPor = DefaultComponentFactory.getInstance().createLabel("Mostrar Por:");
		lblMostrarPor.setBounds(10, 11, 60, 14);
		getContentPane().add(lblMostrarPor);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
	/*	public void jtabla(Libro ArrayList<Libros>(1))
		{
			tableModel.setRowCount(0);
			table1 = new JTable(tableModel);
			DefaultTableModel tableModel = new DefaultTableModel(col, 0);
			table1 = new JTable(tableModel);
			scrollPane1.setViewportView(table1);
			table1.setCellSelectionEnabled(true);
			
		}*/
		
		btnMostrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				try
				{	
					
					tableModel.setRowCount(0);
					table1 = new JTable(tableModel);
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					table1 = new JTable(tableModel);
					scrollPane1.setViewportView(table1);
					table1.setCellSelectionEnabled(true);
					

					//scrollPane1.setViewportView(table1);
					//table1.setCellSelectionEnabled(true);
					
					String datosLibro[]= new String[8];
					
					//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST
					
					
					ArrayList<Libros> Libros = new ArrayList<Libros>();
					
					String seleccionado = chDisp.getSelectedItem();
					System.out.println(seleccionado);
					
				    if (seleccionado =="Autor"){
				    	
				    	seleccionado = chAutor.getSelectedItem();
				    	Libros = biblio.getLibros4Autor(seleccionado);
					    
				    }else
					if (seleccionado =="Editorial"){
						seleccionado = chEditorial.getSelectedItem();
						Libros = biblio.getLibros4Editoriales(seleccionado);
					}else
					if ( seleccionado == "Todos"){Libros = biblio.getLibros();}else
					if (seleccionado =="Prestados") {Libros = biblio.getLibrosPrestado();}else
				    if (seleccionado =="Disponibles"){Libros = biblio.getLibrosDisponible();}else
				    if (seleccionado =="Top mas Prestados"){Libros = biblio.getLibrosDisponible();}else
				    if (seleccionado =="Ultimos mas prestados"){Libros = biblio.getLibrosDisponible();}
					else {Libros = biblio.getLibrosPrestado();}
					
					
					for (int i = 0; i < Libros.size(); i++)
					{
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
				}catch (Exception e2)
	                {e2.printStackTrace();}
				{
					
				}
				
			}
		
		


		});
		btnMostrar.setBounds(458, 52, 91, 23);
		getContentPane().add(btnMostrar);
		
			
		Label lblBusquedaPor = new Label("Autor:");
		lblBusquedaPor.setBounds(212, 29, 32, 20);
		getContentPane().add(lblBusquedaPor);
		
		
		
		Label label = new Label("Editorial:");
		label.setBounds(370, 29, 51, 20);
		getContentPane().add(label);
		
		Label label_2 = new Label("Editar selecci\u00F3n");
		label_2.setBounds(565, 279, 122, 14);
		getContentPane().add(label_2);
		
		TextField txtCambio = new TextField();
		txtCambio.setText("Nuevo dato..");
		txtCambio.setBounds(566, 299, 109, 20);
		getContentPane().add(txtCambio);
		
		

		
		Button btnEditar = new Button("Editar");
		btnEditar.addActionListener(new ActionListener() {
			int x;
			int y;
			Object dato;
			int id = 0;
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					String titulo = "";
					String autor = "";
					String edicion = "";
					String editorial = "";
					String imagen = "";
					
					int dias = 0;
					String calificacion= "";
					//private String rutaImagen = "";
				
					x = table1.getSelectedColumn();				
					y = table1.getSelectedRow();
					//    public void EditarLibros(String titulo, String autor, String editorial, String imagen, String calificacion, int id) throws IOException
					
					dato = table1.getValueAt(y, x).toString();
					
					if(x!=1)
					{
						titulo = table1.getValueAt(y, 1).toString();
					}else
						titulo = txtCambio.getText();
					
					if(x!=2)
					{
						autor = table1.getValueAt(y, 2).toString();
					}else
						autor = txtCambio.getText();
					
					if(x!=3)
					{
						editorial = table1.getValueAt(y, 3).toString();
					}else
						editorial = txtCambio.getText();

					if(x!=4)
					{
						edicion = table1.getValueAt(y, 4).toString();
					}else
						edicion = txtCambio.getText();
					if(x!=5)
					{
						calificacion = table1.getValueAt(y, 4).toString();
					}else
						calificacion = txtCambio.getText();
						//}else 
							//JOptionPane.showMessageDialog(null, "Eliga un rango de 1 a 5.");
					if(x== 6 || x == 7)
						JOptionPane.showMessageDialog(null, "No puede editar este parametro");
					
					//dias = Integer.parseInt(table1.getValueAt(y, 4).toString());
					
					id = Integer.parseInt(table1.getValueAt(y, 0).toString());
					
					String ho = dato.toString();
					System.out.println(ho);
					System.out.println(id);
					
					biblio.EditarLibros(titulo, autor, editorial, edicion, imagen, calificacion,id);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				
				
			}
		});
		btnEditar.setBounds(568, 325, 70, 22);
		getContentPane().add(btnEditar);
		

		


	

	}
}
