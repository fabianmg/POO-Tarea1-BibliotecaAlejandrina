package acceso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.SystemColor;

public class Password extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password frame = new Password();
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
	public Password() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(46, 107, 70, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(46, 156, 76, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.textHighlight);
		passwordField.setBounds(127, 147, 98, 23);
		contentPane.add(passwordField);
		
		JTextPane textUsuario = new JTextPane();
		textUsuario.setBackground(SystemColor.textHighlight);
		textUsuario.setBounds(126, 98, 98, 23);
		contentPane.add(textUsuario);
		
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(SystemColor.textHighlight);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = "";
				
				char[]contrasenia= passwordField.getPassword();
				for (int x = 0; x<contrasenia.length; x++){
					pass+= contrasenia[x];
					
				}
				String nombreUsuario = "Admin";
				if ( textUsuario.getText().equals(nombreUsuario) && pass.equals(pass) ){
					
					AccesoBiblioteca AB = new AccesoBiblioteca();
					AB.setVisible(true);
				
					
					textUsuario.setText("");
					passwordField.setText("");
					
					
				}
				else{
					
						JOptionPane.showMessageDialog(null, "Contrasena y Usuario Incorrectos");
						textUsuario.setText("");
						passwordField.setText("");
						
					}
				}
				
				
				
				
				/*
				String pass = "";
				char[] password = passwordField.getPassword();
				for (int x = 0; x<password.length; x++){
					pass+= password[x];
					
				}
				JOptionPane.showMessageDialog(null, pass);
				*/
			
		});
		btnIngresar.setBounds(82, 225, 170, 41);
		contentPane.add(btnIngresar);
		
		JLabel lblIngresarAlSistema = DefaultComponentFactory.getInstance().createTitle("Ingresar Al Sistema");
		lblIngresarAlSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngresarAlSistema.setBounds(92, 11, 177, 50);
		contentPane.add(lblIngresarAlSistema);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblUsuario, textUsuario, lblContrasea, passwordField, btnIngresar, lblIngresarAlSistema}));
		
	
	}
}
