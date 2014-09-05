package acceso;
import logicaDeNegocios.*;  

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class AccesoBiblioteca extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
<<<<<<< HEAD
		///code temnp////////////
			//  public void GuardarPersona(String nombre, String apellido1, String apellido2, String telefono, String email,String  tipo ) throws IOException
=======
>>>>>>> origin/master
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
		setBounds(100, 100, 600, 441);
		
		JMenuBar menuPrincipal = new JMenuBar();
		setJMenuBar(menuPrincipal);
		
		JMenu menuAgregar = new JMenu("Agregar");
		menuPrincipal.add(menuAgregar);
		
		JMenuItem agregarPersona = new JMenuItem("Persona");
		agregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				
			}
		});
		menuAgregar.add(agregarPersona);
		
		JMenuItem agregarLibro = new JMenuItem("Libro");
		menuAgregar.add(agregarLibro);
		
		JMenu menuConsultar = new JMenu("Consultar");
		menuPrincipal.add(menuConsultar);
		
		JMenuItem mntmPorPersona = new JMenuItem("Por Persona");
		menuConsultar.add(mntmPorPersona);
		
		JMenuItem mntmPorLibro = new JMenuItem("Por Libro");
		menuConsultar.add(mntmPorLibro);
		
		JMenu menuParametros = new JMenu("Parametros");
		menuPrincipal.add(menuParametros);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane escritorio = new JDesktopPane();
		escritorio.setBounds(0, 0, 584, 381);
		contentPane.add(escritorio);
		
		JInternalFrame ventanaAgregarNombres = new JInternalFrame("Agregar Nombres");
		ventanaAgregarNombres.setBounds(0, 0, 584, 381);
	}
}
