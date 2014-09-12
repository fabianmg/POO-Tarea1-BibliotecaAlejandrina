package acceso;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextField;

import java.awt.Choice;

import javax.swing.JButton;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

import logicaDeNegocios.Biblioteca;

public class VentanaAgregarPelicula extends JInternalFrame {
	private String titulo= "";
	private String direccion= "";
	private String genero= "";
    private String imagen= ""; 
    private String calificacion = ""; 
    private String DireccionImagen = "";
    private JTextField textTitulo;
    private JTextField textDireccion;
    private JTextField textCalificacion;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarPelicula frame = new VentanaAgregarPelicula();
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
	public VentanaAgregarPelicula() {
		setTitle("Nueva Pelicula");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JLabel lblAgregarPelicula = DefaultComponentFactory.getInstance().createTitle("Agregar Pelicula");
		lblAgregarPelicula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgregarPelicula.setBounds(131, 35, 164, 27);
		getContentPane().add(lblAgregarPelicula);
		
		JLabel lblTitulo = DefaultComponentFactory.getInstance().createLabel("Titulo:");
		lblTitulo.setBounds(41, 85, 92, 14);
		getContentPane().add(lblTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(141, 82, 159, 20);
		getContentPane().add(textTitulo);
		textTitulo.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(141, 132, 159, 20);
		getContentPane().add(textDireccion);
		
		textCalificacion = new JTextField();
		textCalificacion.setColumns(10);
		textCalificacion.setBounds(141, 237, 159, 20);
		getContentPane().add(textCalificacion);
		
		JLabel lblGenero = DefaultComponentFactory.getInstance().createLabel("Genero:");
		lblGenero.setBounds(41, 192, 92, 14);
		getContentPane().add(lblGenero);
		
		JLabel lblDireccion = DefaultComponentFactory.getInstance().createLabel("Direccion:");
		lblDireccion.setBounds(41, 138, 92, 14);
		getContentPane().add(lblDireccion);
		
		JLabel lblCalificacion = DefaultComponentFactory.getInstance().createLabel("Calificacion(1-5):");
		lblCalificacion.setBounds(41, 243, 92, 14);
		getContentPane().add(lblCalificacion);
		
		Choice choiceGenero = new Choice();
		choiceGenero.setBounds(141, 192, 159, 20);
		getContentPane().add(choiceGenero);
		
		choiceGenero.add("Comedia");
		choiceGenero.add("Drama");
		choiceGenero.add("Accion");
		choiceGenero.add("Ciencia Ficcion");
		choiceGenero.add("Terror");
		choiceGenero.add("Otro");
		
		Panel panelImage = new Panel();
		panelImage.setBounds(506, 12, 200, 197);
		getContentPane().add(panelImage);
		
		JButton btnAgregarimagen = new JButton("");
		btnAgregarimagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JFileChooser fc = new JFileChooser();
					int resultado = fc.showOpenDialog(null);
					
					
					if(resultado ==JFileChooser.APPROVE_OPTION){
						File file =fc.getSelectedFile();
						cargarImagen(DireccionImagen);
						DireccionImagen = file.getPath();
					}
					
				
			}
			public void cargarImagen (String f){
				
				panelImage.removeAll();
				ImageIcon imagen = new ImageIcon(f);
				JLabel etiqueta= new JLabel(imagen);
				panelImage.add(etiqueta);
				etiqueta.setBounds(0,0,200,200);
			}
		
		});
		btnAgregarimagen.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1410339029_icon-image-32.png"));
		btnAgregarimagen.setBounds(447, 165, 40, 44);
		getContentPane().add(btnAgregarimagen);
		
		
	
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {

			Biblioteca biblio = new Biblioteca();
			public void actionPerformed(ActionEvent arg0){
				
				
				try{
					if (true){
						
						titulo = textTitulo.getText(); 
						direccion = textDireccion.getText();
						genero= choiceGenero.getSelectedItem();
						calificacion = textCalificacion.getText();
						
						biblio.AgregarPelicula(titulo, direccion, genero, imagen, calificacion);
						
						textTitulo.setText("");
						textDireccion.setText("");
						textCalificacion.setText("");
						panelImage.removeAll();
						
						JOptionPane.showMessageDialog(null, "Pelicula Agregada Correctamente.");
					}else
						JOptionPane.showConfirmDialog(null,"");
						
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				
			}
		});
		
		btnAgregar.setBounds(506, 220, 200, 50);
		getContentPane().add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textTitulo.setText("");
				textCalificacion.setText("");
				textDireccion.setText("");
				
			}
		});
		btnCancelar.setBounds(506, 286, 200, 50);
		getContentPane().add(btnCancelar);
		
	}
}
