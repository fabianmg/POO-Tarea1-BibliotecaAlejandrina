package acceso;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregarPersonas extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textCorreoElectronico;
	private JTextField textTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarPersonas frame = new VentanaAgregarPersonas();
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
	public VentanaAgregarPersonas() {
		setTitle("Nueva Persona");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JLabel lblPrimerApellido = DefaultComponentFactory.getInstance().createLabel("Primer Apellido");
		lblPrimerApellido.setBounds(54, 139, 92, 14);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("Nombre");
		lblNombre.setBounds(54, 89, 92, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblSegundoApellido = DefaultComponentFactory.getInstance().createLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(54, 197, 92, 14);
		getContentPane().add(lblSegundoApellido);
		
		JLabel lblCorreoElectronico = DefaultComponentFactory.getInstance().createLabel("Correo Electronico");
		lblCorreoElectronico.setBounds(54, 246, 92, 14);
		getContentPane().add(lblCorreoElectronico);
		
		JLabel lblTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono");
		lblTelefono.setBounds(54, 291, 92, 14);
		getContentPane().add(lblTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(167, 89, 154, 14);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(167, 139, 154, 14);
		getContentPane().add(textApellido1);
		
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(167, 197, 154, 14);
		getContentPane().add(textApellido2);
		
		textCorreoElectronico = new JTextField();
		textCorreoElectronico.setColumns(10);
		textCorreoElectronico.setBounds(167, 246, 154, 14);
		getContentPane().add(textCorreoElectronico);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10); 
		textTelefono.setBounds(167, 291, 154, 14);
		getContentPane().add(textTelefono);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				if(nombre == ""){
					System.out.println("vacio");
				}
			}
		});
		btnAgregar.setBounds(512, 216, 200, 50);
		getContentPane().add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(512, 291, 200, 50);
		getContentPane().add(btnCancelar);
		
		JLabel lblAgregarPersona = DefaultComponentFactory.getInstance().createTitle("Agregar Persona");
		lblAgregarPersona.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgregarPersona.setBounds(276, 23, 129, 37);
		getContentPane().add(lblAgregarPersona);

	}
}
