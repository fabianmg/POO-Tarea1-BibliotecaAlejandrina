package acceso;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaAgregarLibro extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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

	/**
	 * Create the frame.
	 */
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
		
		textField = new JTextField();
		textField.setBounds(155, 81, 175, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 130, 200, 14);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 179, 200, 14);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(155, 224, 200, 14);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 271, 200, 14);
		getContentPane().add(textField_4);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(506, 220, 200, 50);
		getContentPane().add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(506, 286, 200, 50);
		getContentPane().add(btnCancelar);
		
		JButton btnAgregarPortada = new JButton("Agregar Portada");
		btnAgregarPortada.setBounds(506, 79, 200, 50);
		getContentPane().add(btnAgregarPortada);
		
		JLabel lblAgregarLibro = DefaultComponentFactory.getInstance().createTitle("Agregar Libro");
		lblAgregarLibro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgregarLibro.setBounds(131, 35, 164, 27);
		getContentPane().add(lblAgregarLibro);

	}
}
