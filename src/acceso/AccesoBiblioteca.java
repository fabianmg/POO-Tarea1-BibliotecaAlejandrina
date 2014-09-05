package acceso;
import logicaDeNegocios.*;  

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AccesoBiblioteca extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Biblioteca personas = new Biblioteca();
		
		
		//personas.AgregarPersona("Fabian","Monge","Garcia","2222-2222","fmonge@fabian.com","familia");
		//personas.AgregarLibro ("titulo", "autor", "editorial", "imagen", "***");
		
		//personas.AgregarPersona("Naibaf","Gamon","Garge","8888-8888","otro@email.es","estudiante");
		//personas.leerPersona();
		
		////////////////////////
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					AccesoBiblioteca frame = new AccesoBiblioteca();
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
	public AccesoBiblioteca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
