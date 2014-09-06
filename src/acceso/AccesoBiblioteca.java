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
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class AccesoBiblioteca extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		///code temnp////////////
			//  public void GuardarPersona(String nombre, String apellido1, String apellido2, String telefono, String email,String  tipo ) throws IOException

		Biblioteca biblio = new Biblioteca();
		
		
		
		biblio.AgregarPersona("Fabian","Monge","Garcia","2222-2222","fmonge@fabian.com","familia");
		//biblio.AgregarLibro ("titulo", "autor", "editorial","3d", "imagen", "***");
		//biblio.AgregarLibro ("1titulo1", "1autor1", "1editorial1","13d1", "1imagen1", "1***1");
		//biblio.AgregarPersona("Naibaf","Gamon","Garge","8888-8888","otro@email.es","estudiante");
		biblio.AgregarPersona("hFabiahn","hMonge","Garcia","2222-2222","fmonge@fabian.com","familia");
		//biblio.leerPersona();
		//biblio.getEditoriales();
		 biblio.EditarLibros(0,3 , 4);
		
		////////////////////////
	/*	EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					AccesoBiblioteca frame = new AccesoBiblioteca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	} 

	/**
	 * Create the frame.
	 */
	public AccesoBiblioteca() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\Book.png"));// -.-
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 482);
		
		JMenuBar menuPrincipal = new JMenuBar();
		setJMenuBar(menuPrincipal);
		
		JMenu menuAgregar = new JMenu("Agregar");
		menuAgregar.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\add2.png"));//O.o'
		menuPrincipal.add(menuAgregar);
		
		JMenuItem agregarPersona = new JMenuItem("Persona");
		agregarPersona.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\Persona2.png"));
		agregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame ventanaAgregarNombres = new JInternalFrame("Agregar Nombres");
				ventanaAgregarNombres.setBounds(0, 0, 584, 381);
				JDesktopPane escritorio = new JDesktopPane();
				escritorio.setBounds(0, 0, 794, 422);
				contentPane.add(escritorio);
				JInternalFrame internalFrame = new JInternalFrame("");
				internalFrame.setBorder(null);
				internalFrame.setBounds(0, 0, 794, 422);
				escritorio.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				
				textField = new JTextField();
				textField.setBounds(202, 134, 180, 20);
				internalFrame.getContentPane().add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(202, 176, 180, 20);
				internalFrame.getContentPane().add(textField_1);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(202, 219, 180, 20);
				internalFrame.getContentPane().add(textField_2);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(202, 267, 180, 20);
				internalFrame.getContentPane().add(textField_3);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(202, 312, 180, 20);
				internalFrame.getContentPane().add(textField_4);
				
				JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("Nombre:");
				lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNombre.setBounds(29, 135, 92, 14);
				internalFrame.getContentPane().add(lblNombre);
				
				JLabel lblPrimerApellido = DefaultComponentFactory.getInstance().createLabel("Primer Apellido:");
				lblPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblPrimerApellido.setBounds(29, 176, 106, 17);
				internalFrame.getContentPane().add(lblPrimerApellido);
				
				JLabel lblSegundoApellido = DefaultComponentFactory.getInstance().createLabel("Segundo Apellido:");
				lblSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblSegundoApellido.setBounds(29, 213, 117, 29);
				internalFrame.getContentPane().add(lblSegundoApellido);
				
				JLabel lblCorreoElectronico = DefaultComponentFactory.getInstance().createLabel("Correo Electronico:");
				lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCorreoElectronico.setBounds(29, 273, 141, 14);
				internalFrame.getContentPane().add(lblCorreoElectronico);
				
				JLabel lblNumeroDeTelefono = DefaultComponentFactory.getInstance().createLabel("Numero de Telefono:");
				lblNumeroDeTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNumeroDeTelefono.setBounds(29, 318, 141, 14);
				internalFrame.getContentPane().add(lblNumeroDeTelefono);
				
				JLabel lblAgregarPersona = DefaultComponentFactory.getInstance().createTitle("Agregar Persona");
				lblAgregarPersona.setFont(new Font("Tahoma", Font.BOLD, 21));
				lblAgregarPersona.setBounds(268, 24, 185, 49);
				internalFrame.getContentPane().add(lblAgregarPersona);
				
				JButton btnNewButton = new JButton("Agregar");
				btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\add2.png"));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnNewButton.setBounds(606, 253, 117, 49);
				internalFrame.getContentPane().add(btnNewButton);
				
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916363_Cancel.png"));
				btnCancelar.setBounds(606, 323, 117, 49);
				internalFrame.getContentPane().add(btnCancelar);
				
				JLabel label = DefaultComponentFactory.getInstance().createLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916608_icon-person-add-128.png"));
				label.setBounds(591, 72, 141, 154);
				internalFrame.getContentPane().add(label);
				internalFrame.setVisible(true);

				
			}
		});
		menuAgregar.add(agregarPersona);
		
		JMenuItem agregarLibro = new JMenuItem("Libro");
		agregarLibro.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\newbook.png"));
		menuAgregar.add(agregarLibro);
		agregarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame ventanaAgregarLibros = new JInternalFrame("Agregar Libros");
				ventanaAgregarLibros.setBounds(0, 0, 584, 381);
				JDesktopPane escritorio = new JDesktopPane();
				escritorio.setBounds(0, 0, 794, 422);
				contentPane.add(escritorio);
				JInternalFrame internalFrame = new JInternalFrame("");
				internalFrame.setBorder(null);
				internalFrame.setBounds(0, 0, 794, 422);
				escritorio.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				
				textField = new JTextField();
				textField.setBounds(202, 134, 180, 20);
				internalFrame.getContentPane().add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(202, 176, 180, 20);
				internalFrame.getContentPane().add(textField_1);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(202, 219, 180, 20);
				internalFrame.getContentPane().add(textField_2);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(202, 267, 180, 20);
				internalFrame.getContentPane().add(textField_3);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(202, 312, 180, 20);
				internalFrame.getContentPane().add(textField_4);
				
				JLabel lblTitulo = DefaultComponentFactory.getInstance().createLabel("Titulo:");
				lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblTitulo.setBounds(29, 135, 92, 14);
				internalFrame.getContentPane().add(lblTitulo);
				
				JLabel lblAutor = DefaultComponentFactory.getInstance().createLabel("Autor:");
				lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblAutor.setBounds(29, 176, 106, 17);
				internalFrame.getContentPane().add(lblAutor);
				
				JLabel lblEditorial= DefaultComponentFactory.getInstance().createLabel("Editorial:");
				lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblEditorial.setBounds(29, 213, 117, 29);
				internalFrame.getContentPane().add(lblEditorial);
				
				JLabel lblEdicion = DefaultComponentFactory.getInstance().createLabel("Edicion:");
				lblEdicion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblEdicion.setBounds(29, 273, 141, 14);
				internalFrame.getContentPane().add(lblEdicion);
				
				JLabel lblCalificacion= DefaultComponentFactory.getInstance().createLabel("Calificacion en Estrellas(*):");
				lblCalificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCalificacion.setBounds(29, 318, 141, 14);
				internalFrame.getContentPane().add(lblCalificacion);
				
				JLabel lblAgregarLibro = DefaultComponentFactory.getInstance().createTitle("Agregar Libro");
				lblAgregarLibro.setFont(new Font("Tahoma", Font.BOLD, 21));
				lblAgregarLibro.setBounds(268, 24, 185, 49);
				internalFrame.getContentPane().add(lblAgregarLibro);
				
				JButton btnNewButton = new JButton("Agregar");
				btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\add2.png"));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnNewButton.setBounds(591, 253, 117, 49);
				internalFrame.getContentPane().add(btnNewButton);
				
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916363_Cancel.png"));
				btnCancelar.setBounds(591, 324, 117, 49);
				internalFrame.getContentPane().add(btnCancelar);
				
				JLabel label = DefaultComponentFactory.getInstance().createLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916995_book_sans_add-128.png"));
				label.setBounds(591, 72, 141, 154);
				internalFrame.getContentPane().add(label);
				internalFrame.setVisible(true);
	
				
				}
			});
		
		JMenu menuConsultar = new JMenu("Consultar");
		menuConsultar.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409913748_question_mark-32.png"));
		menuPrincipal.add(menuConsultar);
		
		JMenuItem mntmPorPersona = new JMenuItem("Por Persona");
		mntmPorPersona.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409913839_icon-person-32.png"));
		menuConsultar.add(mntmPorPersona);
		
		JMenuItem mntmPorLibro = new JMenuItem("Por Libro");
		mntmPorLibro.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409913899_book-32.png"));
		menuConsultar.add(mntmPorLibro);
		
		JMenu menuParametros = new JMenu("Parametros");
		menuParametros.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409913507_params-32.png"));
		menuPrincipal.add(menuParametros);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

				
		
		
		
	
	}
}
