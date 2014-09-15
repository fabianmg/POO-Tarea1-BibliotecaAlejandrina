/*Descripcion: Esta es la clase principal de la intefaz Grafica
 * Autores: Fabian Monge Garcia & Ariel Montero Monestel
 * Fecha de creacion:20/08/2014
*/
package acceso;
import logicaDeNegocios.*;  

import java.lang.NullPointerException;
import java.util.Vector;
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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.sun.imageio.stream.CloseableDisposerRecord;
import com.sun.media.sound.ModelOscillator;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

import java.awt.Color;

public class AccesoBiblioteca extends JFrame {
	

	private JPanel contentPane;
	private JTable table;

	DefaultTableModel modelo = new DefaultTableModel();;

	static JDesktopPane escritorio;
	String [] Datos ;
	


	
	
	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() 
		{
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

	public AccesoBiblioteca() {
		setResizable(false);
		setTitle("Biblioteca Alejandrina");

/**/
		//setIconImage(Toolkit.getDefaultToolkit().getImage(AccesoBiblioteca.class.getResource("/imgs/1409913899_book-32.png")));

		setIconImage(Toolkit.getDefaultToolkit().getImage("./src/imgs/Book.png"));// -.-
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 482);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JDesktopPane escritorio = new JDesktopPane();
		escritorio.setBounds(10, 11, 774, 398);
		contentPane.add(escritorio);
		VentanaPrincipal VP = new VentanaPrincipal();
		VP.getContentPane().setBackground(Color.LIGHT_GRAY);
		escritorio.add(VP);
		VP.setVisible(true);
		try {
			VP.setMaximum(true);
		} catch (PropertyVetoException e2) {
			
			e2.printStackTrace();
		}
		
		//Creacion del menu principal con todos sus items
		
		JMenuBar menuPrincipal = new JMenuBar(); 
		setJMenuBar(menuPrincipal);
		
		
		JMenu menuAgregar = new JMenu("Agregar");
		menuAgregar.setIcon(new ImageIcon("./src/imgs/add2.png"));//O.o'
		menuPrincipal.add(menuAgregar);
		
		JMenuItem agregarPersona = new JMenuItem("Persona"); 
		agregarPersona.setIcon(new ImageIcon("./src/imgs/Persona2.png"));
		agregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				//Evento que llama a la ventana Agregar Persona
				VentanaAgregarPersonas VAP = new VentanaAgregarPersonas(); //Crea la ventana de agregar personas dentro del escritorio
				escritorio.add(VAP);
				VAP.setVisible(true);
				try {
					VAP.setMaximum(true);
				} catch (PropertyVetoException e1) {
					
					e1.printStackTrace();
				}
							
			}
		});
		menuAgregar.add(agregarPersona);
		
		JMenuItem agregarLibro = new JMenuItem("Libro");
		agregarLibro.setIcon(new ImageIcon("./src/imgs/newbook.png"));
		menuAgregar.add(agregarLibro);
		
		JMenu mnOtro = new JMenu("Otro");
		mnOtro.setIcon(new ImageIcon("./src/imgs/Other-32.png"));
		menuAgregar.add(mnOtro);
		
		JMenuItem mntmPelicula = new JMenuItem("Pelicula");
		mntmPelicula.setIcon(new ImageIcon("./src/imgs/Movie-32.png"));
		mntmPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Evento que llama a la ventana Agregar Persona
				VentanaAgregarPelicula VAPeli = new VentanaAgregarPelicula();
				escritorio.add(VAPeli);
				VAPeli.setVisible(true);
				try {
					VAPeli.setMaximum(true);
				} catch (PropertyVetoException e) {
					
					e.printStackTrace();
				}
			}
		});
		mnOtro.add(mntmPelicula);
		
		JMenuItem mntmRevista = new JMenuItem("Revista");
		mntmRevista.setIcon(new ImageIcon("./src/imgs/1410524012_magazine.png"));
		mntmRevista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Evento que llama a la ventana Agregar Revista
				VentanaAgregarRevista VAR = new VentanaAgregarRevista();
				escritorio.add (VAR);
				VAR.setVisible(true);
				try {
					VAR.setMaximum(true);
				} catch (PropertyVetoException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		mnOtro.add(mntmRevista);
		agregarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Evento que llama a la ventana Agregar Libro
				VentanaAgregarLibro VAL = new VentanaAgregarLibro();
				escritorio.add(VAL);
				VAL.setVisible(true);
				try {
					VAL.setMaximum(true);
				} catch (PropertyVetoException e1) {
				
					e1.printStackTrace();
				}
				

	
				
				}
			});
		
		JMenu menuEdicion = new JMenu("Consulta");
		menuEdicion.setIcon(new ImageIcon("./src/imgs/Edicion.png"));
		menuPrincipal.add(menuEdicion);
		
		JMenuItem edicionPersona = new JMenuItem(" Persona");
		edicionPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Evento que llama a la ventana Consultar Personas
				VentanaConsultaPersonas VEP = new VentanaConsultaPersonas();
				escritorio.add(VEP);
				VEP.setVisible(true);
				try {
					VEP.setMaximum(true);
				} catch (PropertyVetoException e1) {
					
					e1.printStackTrace();
				}
				
				}
		});
		
		edicionPersona.setIcon(new ImageIcon("./src/imgs/1409913839_icon-person-32.png"));
		menuEdicion.add(edicionPersona);
		
		JMenuItem mntmLibro = new JMenuItem("Libro");
		mntmLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Evento que llama a la ventana Consultar Libros
				VentanaConsultaLibros VCL = new VentanaConsultaLibros();
				escritorio.add(VCL);
				VCL.show();
				try {
					VCL.setMaximum(true);
				} catch (PropertyVetoException e) {
				
					e.printStackTrace();
				}
			}
		});
		mntmLibro.setIcon(new ImageIcon("./src/imgs/1409913899_book-32.png"));
		menuEdicion.add(mntmLibro);
		
		JMenu mnOtro_1 = new JMenu("Otro");
		mnOtro_1.setIcon(new ImageIcon("./src/imgs/Other-32.png"));
		menuEdicion.add(mnOtro_1);
		
		JMenuItem mntmPelicula_1 = new JMenuItem("Pelicula");
		mntmPelicula_1.addActionListener(new ActionListener() {
			// Evento que llama a la ventana Consultar Peliculas
			public void actionPerformed(ActionEvent arg0) {
				VentanaConsultarPeliculas VCPelis = new VentanaConsultarPeliculas();
				escritorio.add(VCPelis);
				VCPelis.setVisible(true);
				try {
					VCPelis.setMaximum(true);
				} catch (PropertyVetoException e) {
					
					e.printStackTrace();
				}
			}
		});
		mntmPelicula_1.setIcon(new ImageIcon("./src/imgs/Movie-32.png"));
		mnOtro_1.add(mntmPelicula_1);
		
		JMenuItem mntmRevista_1 = new JMenuItem("Revista");
		mntmRevista_1.addActionListener(new ActionListener() {
			// Evento que llama a la ventana Consultar Revistas
			
			public void actionPerformed(ActionEvent arg0) {
				VentanaConsultaRevista VCR = new VentanaConsultaRevista();
				escritorio.add(VCR);
				VCR.setVisible(true);
				try {
					VCR.setMaximum(true);
				} catch (PropertyVetoException e) {
					
					e.printStackTrace();
				}
			}
		});
		mntmRevista_1.setIcon(new ImageIcon("./src/imgs/1410524012_magazine.png"));
		mnOtro_1.add(mntmRevista_1);
		
		JMenu mnControl = new JMenu("Control");
		mnControl.setIcon(new ImageIcon("./src/imgs/Control.png"));
		menuPrincipal.add(mnControl);
		
		JMenuItem mntmDeLibrosPrestados = new JMenuItem("Prestar Libro");
		mntmDeLibrosPrestados.addActionListener(new ActionListener() {
			// Evento que llama a la ventana Prestar Libro
			
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrestarLibro VPL = new VentanaPrestarLibro();
				escritorio.add(VPL);
				VPL.setVisible(true);
				try {
					VPL.setMaximum(true);
				} catch (PropertyVetoException e) {
			
					e.printStackTrace();
				}
				
			}
		});
		mntmDeLibrosPrestados.setIcon(new ImageIcon("./src/imgs/LibrosPrestados.png"));
		mnControl.add(mntmDeLibrosPrestados);
		
		JMenu mnOtro_2 = new JMenu("Otro");
		mnOtro_2.setIcon(new ImageIcon("./src/imgs/Other-32.png"));
		mnControl.add(mnOtro_2);
		
		JMenuItem mntmPrestarPelicula = new JMenuItem("Prestar Pelicula");
		mntmPrestarPelicula.addActionListener(new ActionListener() {
			
			//Evento que llama a la ventana Prestar Pelicula
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrestarPelicula VPP =new VentanaPrestarPelicula();
				escritorio.add(VPP);
				VPP.show();
				try {
					VPP.setMaximum(true);
				} catch (PropertyVetoException e) {
					
					e.printStackTrace();
				}
			}
		});
		mntmPrestarPelicula.setIcon(new ImageIcon("./src/imgs/Movie-32.png"));
		mnOtro_2.add(mntmPrestarPelicula);
		
		JMenuItem mntmPrestarRevista = new JMenuItem("Prestar Revista");
		mntmPrestarRevista.addActionListener(new ActionListener() {
			//Evento que llama a la ventana Prestar Revista
			
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrestarRevista VPR = new VentanaPrestarRevista();
				escritorio.add(VPR);
				VPR.show();
				try {
					VPR.setMaximum(true);
				} catch (PropertyVetoException e) {
					
					e.printStackTrace();
				}
			}
		});
		mntmPrestarRevista.setIcon(new ImageIcon("./src/imgs/1410524012_magazine.png"));
		mnOtro_2.add(mntmPrestarRevista);
		
		JMenu menuParametros = new JMenu("Parametros");
		menuParametros.setIcon(new ImageIcon("./src/imgs/1409913507_params-32.png"));
		menuPrincipal.add(menuParametros);
		
		JMenuItem mntmEditarParametros = new JMenuItem("Editar Parametros");
		mntmEditarParametros.addActionListener(new ActionListener() {
			//Evento que llama a la ventana Parametros
			public void actionPerformed(ActionEvent arg0) {
				VentanaParametros VP = new VentanaParametros();
				escritorio.add(VP);
				VP.setVisible(true);
				try {
					VP.setMaximum(true);
				} catch (PropertyVetoException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		menuParametros.add(mntmEditarParametros);
		
			
		

	
	}
}
