package acceso;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import logicaDeNegocios.Biblioteca;

public class VentanaAgregarRevista extends JInternalFrame {
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEdicion;
	private JTextField textEditorial;
	private JTextField textCalificacion;
	private Panel panelImagen;
	
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
					VentanaAgregarRevista frame = new VentanaAgregarRevista();
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
	public VentanaAgregarRevista() {
		setTitle("Nueva Revista");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JLabel lblAgregarRevista = DefaultComponentFactory.getInstance().createTitle("Agregar Revista");
		lblAgregarRevista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgregarRevista.setBounds(131, 35, 164, 27);
		
		getContentPane().add(lblAgregarRevista);
		
		JLabel lblTitulo = DefaultComponentFactory.getInstance().createLabel("Titulo:");
		lblTitulo.setBounds(53, 87, 92, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblAutor = DefaultComponentFactory.getInstance().createLabel("Autor:");
		lblAutor.setBounds(53, 130, 92, 14);
		getContentPane().add(lblAutor);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Edicion:");
		lblNewJgoodiesLabel.setBounds(53, 179, 92, 14);
		getContentPane().add(lblNewJgoodiesLabel);
		
		JLabel lblEditorial = DefaultComponentFactory.getInstance().createLabel("Editorial:");
		lblEditorial.setBounds(53, 224, 92, 14);
		getContentPane().add(lblEditorial);
		
		JLabel lblCalificacion = DefaultComponentFactory.getInstance().createLabel("Calificacion:");
		lblCalificacion.setBounds(53, 271, 92, 14);
		getContentPane().add(lblCalificacion);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(155, 84, 159, 20);
		getContentPane().add(textTitulo);
		textTitulo.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBounds(155, 124, 159, 20);
		getContentPane().add(textAutor);
		
		textEdicion = new JTextField();
		textEdicion.setColumns(10);
		textEdicion.setBounds(155, 173, 159, 20);
		getContentPane().add(textEdicion);
		
		textEditorial = new JTextField();
		textEditorial.setColumns(10);
		textEditorial.setBounds(155, 218, 159, 20);
		getContentPane().add(textEditorial);
		
		textCalificacion = new JTextField();
		textCalificacion.setColumns(10);
		textCalificacion.setBounds(155, 265, 159, 20);
		getContentPane().add(textCalificacion);
		

		panelImagen = new Panel();
		panelImagen.setBounds(506, 12, 200, 197);
		getContentPane().add(panelImagen);
		
		
		
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
							
							biblio.AgregarRevista(Titulo, Autor, Editorial, Edicion, DireccionImagen, Calificacion);
							
							textTitulo.setText("");
							textAutor.setText("");
							textEdicion.setText("");
							textEditorial.setText("");
							textCalificacion.setText("");
							panelImagen.removeAll();
							
							JOptionPane.showMessageDialog(null, "Revista Agregada Correctamente.");
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
				textAutor.setText("");
				textTitulo.setText("");
				textCalificacion.setText("");
				textEdicion.setText("");
				textEditorial.setText("");
			
			}
		});
		btnCancelar.setBounds(506, 286, 200, 50);
		getContentPane().add(btnCancelar);
		
		
		JButton btnAgregarPortada = new JButton("");
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
		});
		
		

		btnAgregarPortada.setBounds(447, 165, 40, 44);
		getContentPane().add(btnAgregarPortada);
		btnAgregarPortada.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1410339029_icon-image-32.png"));
	}
		public void cargarImagen (String f){
			
			panelImagen.removeAll();
			ImageIcon imagen = new ImageIcon(f);
			JLabel etiqueta= new JLabel(imagen);
			panelImagen.add(etiqueta);
			etiqueta.setBounds(0,0,200,200);
			
		
		
	}
}
