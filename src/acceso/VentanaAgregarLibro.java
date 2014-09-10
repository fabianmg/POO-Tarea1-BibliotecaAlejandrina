package acceso;

import java.awt.EventQueue;

import logicaDeNegocios.*;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class VentanaAgregarLibro extends JInternalFrame {
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textCalificacion;
	private JTextField textEditorial;
	private JTextField textEdicion;
	private JPanel panelImagen;
	
	private String Titulo = "";
	private String Autor = "";
	private String Edicion = "";
	private String Editorial = "";
	private String Calificacion= "";
	private String DireccionImagen = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarLibro frame = new VentanaAgregarLibro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaAgregarLibro() {
		setTitle("Nuevo Libro");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = DefaultComponentFactory.getInstance().createLabel("Titulo:");
		lblTitulo.setBounds(53, 87, 92, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblAutor = DefaultComponentFactory.getInstance().createLabel("Autor:");
		lblAutor.setBounds(53, 130, 92, 14);
		getContentPane().add(lblAutor);
		
		JLabel lblEdicion = DefaultComponentFactory.getInstance().createLabel("Edicion:");
		lblEdicion.setBounds(53, 179, 92, 14);
		getContentPane().add(lblEdicion);
		
		JLabel lblEditorial = DefaultComponentFactory.getInstance().createLabel("Editorial:");
		lblEditorial.setBounds(53, 224, 92, 14);
		getContentPane().add(lblEditorial);
		
		JLabel lblCalificacion = DefaultComponentFactory.getInstance().createLabel("Calificacion: (1-5)");
		lblCalificacion.setBounds(53, 271, 92, 14);
		getContentPane().add(lblCalificacion);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(155, 84, 159, 20);
		getContentPane().add(textTitulo);
		textTitulo.setColumns(10);
		
		
		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBounds(155, 127, 159, 20);
		getContentPane().add(textAutor);
		 
		
		
		
		textCalificacion = new JTextField();
		textCalificacion.setColumns(10);
		textCalificacion.setBounds(155, 268, 159, 20);
		getContentPane().add(textCalificacion);
		
		textEditorial = new JTextField();
		textEditorial.setColumns(10);
		textEditorial.setBounds(155, 221, 159, 20);
		getContentPane().add(textEditorial);
		
		textEdicion = new JTextField();
		textEdicion.setColumns(10);
		textEdicion.setBounds(155, 173, 159, 20);
		getContentPane().add(textEdicion);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			
			Biblioteca biblio = new Biblioteca();
			public void actionPerformed(ActionEvent arg0){
				
				
				try{
					if (true){
						
						Titulo = textTitulo.getText(); 
						Autor = textAutor.getText();
						Edicion = textEdicion.getText();
						Editorial= textEditorial.getText();
						Calificacion = textCalificacion.getText();
						
						biblio.AgregarLibro(Titulo, Autor, Editorial, Edicion, DireccionImagen, Calificacion);
						
						textTitulo.setText("");
						textAutor.setText("");
						textEdicion.setText("");
						textEditorial.setText("");
						textCalificacion.setText("");
						panelImagen.removeAll();
						
						
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
		btnCancelar.setBounds(506, 286, 200, 50);
		getContentPane().add(btnCancelar);
		
		JLabel lblAgregarLibro = DefaultComponentFactory.getInstance().createTitle("Agregar Libro");
		lblAgregarLibro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgregarLibro.setBounds(131, 35, 164, 27);
		getContentPane().add(lblAgregarLibro);
		
		panelImagen = new JPanel();
		panelImagen.setBounds(506, 12, 200, 197);
		getContentPane().add(panelImagen);
		
		JButton btnAgregarPortada = new JButton("");
		btnAgregarPortada.setBounds(447, 165, 40, 44);
		getContentPane().add(btnAgregarPortada);
		btnAgregarPortada.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1410339029_icon-image-32.png"));
		btnAgregarPortada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				int resultado = fc.showOpenDialog(null);
				
				if(resultado ==JFileChooser.APPROVE_OPTION){
					File file =fc.getSelectedFile();
					cargarImagen(DireccionImagen);
					DireccionImagen = file.getPath();
				}
			}
		});}

		

		public void cargarImagen (String f){
			
			panelImagen.removeAll();
			ImageIcon imagen = new ImageIcon(f);
			JLabel etiqueta= new JLabel(imagen);
			panelImagen.add(etiqueta);
			etiqueta.setBounds(0,0,200,200);
			
		}
		
	
		
	}

