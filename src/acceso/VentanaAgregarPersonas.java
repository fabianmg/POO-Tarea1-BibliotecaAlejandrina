package acceso;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logicaDeNegocios.*;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.io.IOException;


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
	
	private String nombre = "";
	private String apellido1 = "";
	private String apellido2 = "";
	private String email = "";
	private String tel = "";
	private String tipo = "";
	/**
	 * Create the frame.
	 */
	public VentanaAgregarPersonas() {
		
		
		setTitle("Nueva Persona");
		setBounds(10, 11, 344, 478);
		getContentPane().setLayout(null);
		
		JLabel lblPrimerApellido = DefaultComponentFactory.getInstance().createLabel("Primer Apellido");
		lblPrimerApellido.setBounds(37, 125, 92, 14);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("Nombre");
		lblNombre.setBounds(37, 89, 92, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblSegundoApellido = DefaultComponentFactory.getInstance().createLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(37, 162, 92, 14);
		getContentPane().add(lblSegundoApellido);
		
		JLabel lblCorreoElectronico = DefaultComponentFactory.getInstance().createLabel("Correo Electronico");
		lblCorreoElectronico.setBounds(37, 198, 92, 14);
		getContentPane().add(lblCorreoElectronico);
		
		JLabel lblTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono");
		lblTelefono.setBounds(37, 234, 92, 14);
		getContentPane().add(lblTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(155, 86, 159, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(155, 122, 159, 20);
		getContentPane().add(textApellido1);
		
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(155, 159, 159, 20);
		getContentPane().add(textApellido2);
		
		textCorreoElectronico = new JTextField();
		textCorreoElectronico.setColumns(10);
		textCorreoElectronico.setBounds(155, 195, 159, 20);
		getContentPane().add(textCorreoElectronico);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10); 
		textTelefono.setBounds(155, 231, 159, 20);
		getContentPane().add(textTelefono);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(37, 268, 46, 14);
		getContentPane().add(lblTipo);
		
		Choice chTipo = new Choice();
		chTipo.setBounds(155, 268, 159, 20);
		getContentPane().add(chTipo);

		chTipo.add("Colega");
		chTipo.add("Familiar");
		chTipo.add("Estudiante");
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() 
		{	
			Biblioteca biblio = new Biblioteca();
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					if(true)
					{
						nombre = txtNombre.getText();
						apellido1 = textApellido1.getText();
						apellido2 = textApellido2.getText();
						email = textCorreoElectronico.getText();
						tel = textTelefono.getText();
						tipo = chTipo.getSelectedItem();
							biblio.AgregarPersona(nombre, apellido1, apellido2, tel, email, tipo);
							txtNombre.setText("");
							textApellido1.setText("");
							textApellido2.setText("");
							textCorreoElectronico.setText("");
							textTelefono.setText("");
							// txtNombre. focus						
					}else
						JOptionPane.showConfirmDialog(null,"");
					
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnAgregar.setBounds(166, 324, 148, 31);
		getContentPane().add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 324, 148, 31);
		getContentPane().add(btnCancelar);
		
		JLabel lblAgregarPersona = DefaultComponentFactory.getInstance().createTitle("Agregar Persona");
		lblAgregarPersona.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgregarPersona.setBounds(79, 26, 129, 37);
		getContentPane().add(lblAgregarPersona);
		
		
			
	}
}

