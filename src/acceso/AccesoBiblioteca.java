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

public class AccesoBiblioteca extends JFrame {

	private JPanel contentPane;
	private JTable table;

	DefaultTableModel modelo = new DefaultTableModel();;

	JDesktopPane escritorio;
	String [] Datos ;
	
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEditorial;
	private JTextField textEdicion;
	private JTextField textCalificacion;
	private JTextField txtNombre;
	private JTextField textPrimerApellido;
	private JTextField textSegundoApellido;
	private JTextField textCorreoElectronico;
	private JTextField textNumeroDeTelefono;
	private JTextField textColumna;
	private JTextField textAgregarDatoNuevo;
	private JTextField textFila;

	
	
	public static void main(String[] args) throws IOException {
		/*
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
		*/
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

/**/
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\Book.png"));

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\Book.png"));// -.-
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 482);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JDesktopPane escritorio = new JDesktopPane();
		escritorio.setBounds(10, 11, 774, 398);
		contentPane.add(escritorio);
		
		JMenuBar menuPrincipal = new JMenuBar();
		setJMenuBar(menuPrincipal);
		
		
		JMenu menuAgregar = new JMenu("Agregar");
		menuAgregar.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\add2.png"));//O.o'
		menuPrincipal.add(menuAgregar);
		
		JMenuItem agregarPersona = new JMenuItem("Persona");
		agregarPersona.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\Persona2.png"));
		agregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				
				VentanaAgregarPersonas VAP = new VentanaAgregarPersonas(); //Crea la ventana de agregar personas dentro del escritorio
				escritorio.add(VAP);
				VAP.setVisible(true);
				try {
					VAP.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			/*	JInternalFrame ventanaAgregarNombres = new JInternalFrame("Agregar Nombres");
				ventanaAgregarNombres.setBounds(10, 11, 774, 398);
				escritorio.add(ventanaAgregarNombres);
				ventanaAgregarNombres.setVisible(true);;
				ventanaAgregarNombres.getContentPane().setLayout(null);// Agregar el contenido al Internal Frame (JLabel,text,etc)
				try {
					ventanaAgregarNombres.setMaximum(true);
				} catch (PropertyVetoException e1) {
					
					e1.printStackTrace();
				}

				
				JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("Nombre:");
				lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNombre.setBounds(29, 135, 92, 14);
				ventanaAgregarNombres.getContentPane().add(lblNombre);
				
				JLabel lblPrimerApellido = DefaultComponentFactory.getInstance().createLabel("Primer Apellido:");
				lblPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblPrimerApellido.setBounds(29, 176, 106, 17);
				ventanaAgregarNombres.getContentPane().add(lblPrimerApellido);
				
				JLabel lblSegundoApellido = DefaultComponentFactory.getInstance().createLabel("Segundo Apellido:");
				lblSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblSegundoApellido.setBounds(29, 213, 117, 29);
				ventanaAgregarNombres.getContentPane().add(lblSegundoApellido);
				
				JLabel lblCorreoElectronico = DefaultComponentFactory.getInstance().createLabel("Correo Electronico:");
				lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCorreoElectronico.setBounds(29, 273, 141, 14);
				ventanaAgregarNombres.getContentPane().add(lblCorreoElectronico);
				
				JLabel lblNumeroDeTelefono = DefaultComponentFactory.getInstance().createLabel("Numero de Telefono:");
				lblNumeroDeTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNumeroDeTelefono.setBounds(29, 318, 141, 14);
				ventanaAgregarNombres.getContentPane().add(lblNumeroDeTelefono);
				
				JLabel lblAgregarPersona = DefaultComponentFactory.getInstance().createTitle("Agregar Persona");
				lblAgregarPersona.setFont(new Font("Tahoma", Font.BOLD, 21));
				lblAgregarPersona.setBounds(268, 24, 185, 49);
				ventanaAgregarNombres.getContentPane().add(lblAgregarPersona);
				
				JButton btnAgregar = new JButton("Agregar");
				btnAgregar.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\add2.png"));
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Datos= new String[5];
						
						Datos[0] = txtNombre.getText();
						
						Datos[1] = textPrimerApellido.getText();
						
						Datos[2] = textSegundoApellido.getText();
						
						Datos[3] = textCorreoElectronico.getText();
						Datos[4] = textNumeroDeTelefono.getText();
						txtNombre.setText(null);
						textPrimerApellido.setText(null);
						textSegundoApellido.setText(null);
						textCorreoElectronico.setText(null);
						textNumeroDeTelefono.setText(null);

						
						
					}
				});
				btnAgregar.setBounds(606, 253, 117, 49);
				ventanaAgregarNombres.getContentPane().add(btnAgregar);
				
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916363_Cancel.png"));
				btnCancelar.setBounds(606, 323, 117, 49);
				ventanaAgregarNombres.getContentPane().add(btnCancelar);
				
				JLabel label = DefaultComponentFactory.getInstance().createLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916608_icon-person-add-128.png"));
				label.setBounds(577, 73, 146, 169);
				ventanaAgregarNombres.getContentPane().add(label);
				
				txtNombre = new JTextField();
				
				txtNombre.setBounds(164, 134, 223, 20);
				ventanaAgregarNombres.getContentPane().add(txtNombre);
				txtNombre.setColumns(10);
				
				textPrimerApellido = new JTextField();
				textPrimerApellido.setBounds(164, 176, 223, 17);
				ventanaAgregarNombres.getContentPane().add(textPrimerApellido);
				textPrimerApellido.setColumns(10);
				
				textSegundoApellido = new JTextField();
				textSegundoApellido.setBounds(164, 219, 223, 14);
				ventanaAgregarNombres.getContentPane().add(textSegundoApellido);
				textSegundoApellido.setColumns(10);
				
				textCorreoElectronico = new JTextField();
				textCorreoElectronico.setBounds(164, 272, 223, 15);
				ventanaAgregarNombres.getContentPane().add(textCorreoElectronico);
				textCorreoElectronico.setColumns(10);
				
				textNumeroDeTelefono = new JTextField();
				textNumeroDeTelefono.setBounds(164, 317, 223, 15);
				ventanaAgregarNombres.getContentPane().add(textNumeroDeTelefono);
				textNumeroDeTelefono.setColumns(10);
				*/	
				
			}
		});
		menuAgregar.add(agregarPersona);
		
		JMenuItem agregarLibro = new JMenuItem("Libro");
		agregarLibro.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\newbook.png"));
		menuAgregar.add(agregarLibro);
		agregarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaAgregarLibro VAL = new VentanaAgregarLibro();
				escritorio.add(VAL);
				VAL.setVisible(true);
				try {
					VAL.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/*JInternalFrame ventanaAgregarLibros = new JInternalFrame("Agregar Libros");
				ventanaAgregarLibros.setBounds(0, 0, 774, 398);
				escritorio.add(ventanaAgregarLibros);
				ventanaAgregarLibros.getContentPane().setLayout(null);
				try {
					ventanaAgregarLibros.setMaximum(true);
				} catch (PropertyVetoException e1) {				
					e1.printStackTrace();
				}
				
				JLabel lblTitulo = DefaultComponentFactory.getInstance().createLabel("Titulo:");
				lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblTitulo.setBounds(27, 134, 92, 14);
				ventanaAgregarLibros.getContentPane().add(lblTitulo);
				
				JLabel lblAutor = DefaultComponentFactory.getInstance().createLabel("Autor:");
				lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblAutor.setBounds(27, 175, 106, 17);
				ventanaAgregarLibros.getContentPane().add(lblAutor);
				
				JLabel lblEditorial= DefaultComponentFactory.getInstance().createLabel("Editorial:");
				lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblEditorial.setBounds(27, 212, 117, 29);
				ventanaAgregarLibros.getContentPane().add(lblEditorial);
				
				JLabel lblEdicion = DefaultComponentFactory.getInstance().createLabel("Edicion:");
				lblEdicion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblEdicion.setBounds(27, 272, 141, 14);
				ventanaAgregarLibros.getContentPane().add(lblEdicion);
				
				JLabel lblCalificacion= DefaultComponentFactory.getInstance().createLabel("Calificacion en Estrellas(*):");
				lblCalificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCalificacion.setBounds(27, 317, 161, 14);
				ventanaAgregarLibros.getContentPane().add(lblCalificacion);
				
				JLabel lblAgregarLibro = DefaultComponentFactory.getInstance().createTitle("Agregar Libro");
				lblAgregarLibro.setFont(new Font("Tahoma", Font.BOLD, 21));
				lblAgregarLibro.setBounds(266, 23, 185, 49);
				ventanaAgregarLibros.getContentPane().add(lblAgregarLibro);
				
				JButton btnAgregarLibro = new JButton("Agregar");
				btnAgregarLibro.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\add2.png"));
				btnAgregarLibro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnAgregarLibro.setBounds(589, 218, 117, 49);
				ventanaAgregarLibros.getContentPane().add(btnAgregarLibro);
				
				JButton btnCancelarLibro = new JButton("Cancelar");
				btnCancelarLibro.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409916363_Cancel.png"));
				btnCancelarLibro.setBounds(589, 297, 117, 49);
				ventanaAgregarLibros.getContentPane().add(btnCancelarLibro);
				
				JButton btnAgregarFoto = new JButton("");
				btnAgregarFoto.setToolTipText("dvsx\r\n");
				btnAgregarFoto.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409918134_32-128.png"));
				btnAgregarFoto.setBounds(556, 66, 161, 128);
				ventanaAgregarLibros.getContentPane().add(btnAgregarFoto);
				
				textTitulo = new JTextField();
				textTitulo.setBounds(201, 135, 250, 15);
				ventanaAgregarLibros.getContentPane().add(textTitulo);
				textTitulo.setColumns(10);
				
				textAutor = new JTextField();
				textAutor.setBounds(201, 176, 250, 17);
				ventanaAgregarLibros.getContentPane().add(textAutor);
				textAutor.setColumns(10);
				
				textEditorial = new JTextField();
				textEditorial.setBounds(201, 221, 250, 14);
				ventanaAgregarLibros.getContentPane().add(textEditorial);
				textEditorial.setColumns(10);
				
				textEdicion = new JTextField();
				textEdicion.setBounds(201, 274, 250, 14);
				ventanaAgregarLibros.getContentPane().add(textEdicion);
				textEdicion.setColumns(10);
				
				textCalificacion = new JTextField();
				textCalificacion.setBounds(198, 319, 253, 14);
				ventanaAgregarLibros.getContentPane().add(textCalificacion);
				textCalificacion.setColumns(10);
				ventanaAgregarLibros.setVisible(true);


								*/
	
				
				}
			});
		
		JMenu menuEdicion = new JMenu("Edicion");
		menuEdicion.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\Edicion.png"));
		menuPrincipal.add(menuEdicion);
		
		JMenuItem edicionPersona = new JMenuItem(" Persona");
		edicionPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				

				JInternalFrame ventanaEdicionPersona = new JInternalFrame("Editar Personas");
				ventanaEdicionPersona.setBorder(null);
				ventanaEdicionPersona.setBounds(-11, -12, 785, 410);
				ventanaEdicionPersona.setVisible(true);
				escritorio.add(ventanaEdicionPersona);
				ventanaEdicionPersona.getContentPane().setLayout(null);
				try {
					ventanaEdicionPersona.setMaximum(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}

				
				
				modelo.addColumn("Nombre");
				modelo.addColumn("Primer Apellido");
				modelo.addColumn("Segundo Apellido");
				modelo.addColumn("Correo Electronico");
				modelo.addColumn("Numero de Telefono");
				
				table = new JTable();
				table.setColumnSelectionAllowed(true);
				table.setCellSelectionEnabled(true);
				table.setBounds(26, 80, 425, 132);
				table.setModel(modelo);
				modelo.addRow(Datos);
				
				
				/**/				
				ventanaEdicionPersona.getContentPane().add(table);
				
				JButton btnEditar = new JButton("Editar");
				btnEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int fila = Integer.parseInt(textFila.getText());
						int columna = Integer.parseInt(textColumna.getText());
						modelo.setValueAt(textAgregarDatoNuevo.getText(), fila, columna);
						textColumna.setText(null);
						textAgregarDatoNuevo.setText(null);
						textFila.setText(null);
					
					}
				});
				btnEditar.setBounds(572, 120, 142, 23);
				ventanaEdicionPersona.getContentPane().add(btnEditar);
				
				JButton btnEliminarSeleccionado = new JButton("Eliminar Seleccionado");
				btnEliminarSeleccionado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int filaseleccionada = table.getSelectedRow();
						if (filaseleccionada >=0) {
							modelo.removeRow(filaseleccionada);
						}
						JOptionPane.showMessageDialog(null, "No selecciono ningun elemento");
					}
				});
				btnEliminarSeleccionado.setBounds(572, 229, 142, 23);
				ventanaEdicionPersona.getContentPane().add(btnEliminarSeleccionado);
				
				JButton btnEliminarTodo = new JButton("Eliminar Todo");
				btnEliminarTodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int cantidadFilas = table.getRowCount();
						
						for(cantidadFilas-- ; cantidadFilas>=0 ; cantidadFilas--){
							modelo.removeRow(cantidadFilas);
							
							
						}
					}
				});
				btnEliminarTodo.setBounds(572, 275, 142, 23);
				ventanaEdicionPersona.getContentPane().add(btnEliminarTodo);
				
				JLabel lblFila = DefaultComponentFactory.getInstance().createTitle("Fila:");
				lblFila.setBounds(572, 30, 32, 14);
				ventanaEdicionPersona.getContentPane().add(lblFila);
				
				JLabel lblColumna = DefaultComponentFactory.getInstance().createLabel("Columna:");
				lblColumna.setBounds(572, 55, 45, 14);
				ventanaEdicionPersona.getContentPane().add(lblColumna);
				
				JLabel lblNuevo = DefaultComponentFactory.getInstance().createLabel("Nuevo:");
				lblNuevo.setBounds(572, 80, 88, 14);
				ventanaEdicionPersona.getContentPane().add(lblNuevo);
				
				textColumna = new JTextField();
				textColumna.setBounds(628, 55, 32, 14);
				ventanaEdicionPersona.getContentPane().add(textColumna);
				textColumna.setColumns(10);
				
				
				textAgregarDatoNuevo = new JTextField();
				textAgregarDatoNuevo.setBounds(628, 80, 88, 14);
				ventanaEdicionPersona.getContentPane().add(textAgregarDatoNuevo);
				textAgregarDatoNuevo.setColumns(10);
				
				
				textFila = new JTextField();
				textFila.setBounds(627, 30, 32, 14);
				ventanaEdicionPersona.getContentPane().add(textFila);
				textFila.setColumns(10);
				
				JLabel lblEditar = DefaultComponentFactory.getInstance().createTitle("Editar");
				lblEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblEditar.setBounds(260, 11, 62, 48);
				ventanaEdicionPersona.getContentPane().add(lblEditar);
								



								


				
					
			}
		});
		
		edicionPersona.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409913839_icon-person-32.png"));
		menuEdicion.add(edicionPersona);
		
		JMenuItem edicionLibro = new JMenuItem(" Libro");
		edicionLibro.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409913899_book-32.png"));
		menuEdicion.add(edicionLibro);
		
		JMenu menuParametros = new JMenu("Parametros");
		menuParametros.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\1409913507_params-32.png"));
		menuPrincipal.add(menuParametros);
		/***/
			
		

	
	}
}
