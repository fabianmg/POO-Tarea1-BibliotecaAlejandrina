package acceso;
import logicaDeNegocios.*;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;

import logicaDeNegocios.Personas;
import java.awt.SystemColor;

public class VentanaPrincipal extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	Biblioteca biblio = new Biblioteca();
	
	public VentanaPrincipal() {
	/*	setBorder(null);
		getContentPane().setBackground(SystemColor.textHighlight);
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		JLabel lblBibliotecaAlejandrina = DefaultComponentFactory.getInstance().createTitle("Biblioteca Alejandrina");
		lblBibliotecaAlejandrina.setFont(new Font("MV Boli", Font.BOLD, 18));
		lblBibliotecaAlejandrina.setBounds(206, 11, 241, 41);
		getContentPane().add(lblBibliotecaAlejandrina);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 81, 168, 215);
		getContentPane().add(scrollPane);
		
		
		DefaultListModel<String> model1 = new DefaultListModel<String>();

		ArrayList<Libros> LPrestados = new ArrayList<Libros>();
		
		LPrestados= biblio.getLibrosPrestado();
		
		for (int i = 0; i< LPrestados.size(); i++){
			
			model1.addElement(LPrestados.get(i).getTitulo());
			
			
		}
		
		JList listLibrosPrestados = new JList(model1);
		scrollPane.setViewportView(listLibrosPrestados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(223, 81, 168, 215);
		getContentPane().add(scrollPane_1);
		
		
		DefaultListModel<String> model2 = new DefaultListModel<String>();

		ArrayList<Revistas> PPrestados = new ArrayList<Revistas>();  //revistas
		
		PPrestados= biblio.getRevistasPrestado();
		
		for (int i = 0; i< PPrestados.size(); i++)
			model2.addElement(PPrestados.get(i).getTitulo());
		
		JList listPelisPrestadas = new JList(model2);
		scrollPane_1.setViewportView(listPelisPrestadas);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(412, 81, 168, 215);
		getContentPane().add(scrollPane_2);
		
		
		DefaultListModel<String> model3 = new DefaultListModel<String>();

		ArrayList<Peliculas> RPrestados = new ArrayList<Peliculas>(); //pelis
		
		RPrestados= biblio.getPeliculasPrestado();
		
		for (int i = 0; i< RPrestados.size(); i++)
			model3.addElement(RPrestados.get(i).getTitulo());
		
		
		JList listRevistasPrestadas = new JList(model3);
		scrollPane_2.setViewportView(listRevistasPrestadas);
		
		JLabel lblLibrosPrestados = new JLabel("Libros Prestados:");
		lblLibrosPrestados.setBounds(37, 56, 147, 14);
		getContentPane().add(lblLibrosPrestados);
		
		JLabel lblPeliculasPrestadas = new JLabel("Peliculas Prestadas:");
		lblPeliculasPrestadas.setBounds(223, 56, 136, 14);
		getContentPane().add(lblPeliculasPrestadas);
		
		JLabel lblRevistasPrestadas = new JLabel("Revistas Prestadas:");
		lblRevistasPrestadas.setBounds(412, 56, 136, 14);
		getContentPane().add(lblRevistasPrestadas);
*/
	}
}
