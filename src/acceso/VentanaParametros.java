package acceso;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logicaDeNegocios.Biblioteca;

public class VentanaParametros extends JInternalFrame {
	private JTextField textDiasPrestamo;
	private JTextField textDiasTolerancia;
	private JTextField textDiasAlerta;
	private JTextField textTopMasPrestados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaParametros frame = new VentanaParametros();
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
	
	public VentanaParametros() {
		setTitle("Parametros");
		setBounds(10, 11, 774, 398);
		getContentPane().setLayout(null);
		
		textDiasPrestamo = new JTextField();
		textDiasPrestamo.setBounds(129, 135, 149, 20);
		getContentPane().add(textDiasPrestamo);
		textDiasPrestamo.setColumns(10);
		
		textDiasTolerancia = new JTextField();
		textDiasTolerancia.setBounds(129, 193, 149, 20);
		getContentPane().add(textDiasTolerancia);
		textDiasTolerancia.setColumns(10);
		
		textDiasAlerta = new JTextField();
		textDiasAlerta.setEditable(false);
		textDiasAlerta.setText("Dias De Prestamo+Dias De Tolerancia");
		textDiasAlerta.setBounds(129, 252, 149, 20);
		getContentPane().add(textDiasAlerta);
		textDiasAlerta.setColumns(10);
		
		JPanel panelVerde = new JPanel();
		panelVerde.setBackground(Color.GREEN);
		panelVerde.setBounds(299, 135, 17, 20);
		getContentPane().add(panelVerde);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(299, 193, 17, 20);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(299, 252, 17, 20);
		getContentPane().add(panel_1);
		
		JLabel lblDiasDePrestamo = DefaultComponentFactory.getInstance().createLabel("Dias De Prestamo:");
		lblDiasDePrestamo.setBounds(20, 141, 112, 14);
		getContentPane().add(lblDiasDePrestamo);
		
		JLabel lblDiasDeTolerancia = new JLabel("Dias De Tolerancia:");
		lblDiasDeTolerancia.setBounds(20, 196, 112, 17);
		getContentPane().add(lblDiasDeTolerancia);
		
		JLabel lblDiasDeAlerta = DefaultComponentFactory.getInstance().createLabel("Dias De Alerta:");
		lblDiasDeAlerta.setBounds(20, 258, 112, 14);
		getContentPane().add(lblDiasDeAlerta);
		
		textTopMasPrestados = new JTextField();
		textTopMasPrestados.setBounds(129, 303, 149, 20);
		getContentPane().add(textTopMasPrestados);
		textTopMasPrestados.setColumns(10);
		
		JLabel lblTopMasPrestados = DefaultComponentFactory.getInstance().createLabel("Top Mas Prestados:");
		lblTopMasPrestados.setBounds(10, 306, 112, 14);
		getContentPane().add(lblTopMasPrestados);
		
		JButton btnAjustar = new JButton("");
		btnAjustar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int topMasPrestados = Integer.parseInt(textTopMasPrestados.getText()); 
				int diasPrestamo =Integer.parseInt(textDiasPrestamo.getText());
				int diasTolerancia = Integer.parseInt(textDiasTolerancia.getText());
				int diasAlerta = diasPrestamo + diasTolerancia;
				
				biblio.parametroDiasDePrestamo=diasPrestamo;
				biblio.parametroDiasDeTolerancia=diasTolerancia;
				biblio.parametroDiasDeAlerta =diasAlerta;
				biblio.parametroTopMasPrestado=topMasPrestados;
				
				JOptionPane.showMessageDialog(null,"Parametros Guardados correctamente");
				textDiasAlerta.setEditable(false);
				textDiasPrestamo.setEditable(false);
				textDiasTolerancia.setEditable(false);
				textTopMasPrestados.setEditable(false);
			}
		});
		btnAjustar.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\save32.png"));
		btnAjustar.setBounds(588, 275, 89, 55);
		getContentPane().add(btnAjustar);
		
		JLabel lblAjusteDeParametros = DefaultComponentFactory.getInstance().createTitle("Ajuste de Parametros");
		lblAjusteDeParametros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAjusteDeParametros.setBounds(259, 30, 190, 44);
		getContentPane().add(lblAjusteDeParametros);
		
		JButton btnAjustarParametros = new JButton("");
		btnAjustarParametros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textDiasAlerta.setEditable(true);
				textDiasPrestamo.setEditable(true);
				textDiasTolerancia.setEditable(true);
				textTopMasPrestados.setEditable(true);
				
			}
		});
		btnAjustarParametros.setIcon(new ImageIcon("C:\\Users\\Ariel\\Documents\\GitHub\\POO-Tarea1-BibliotecaAlejandrina\\src\\imgs\\tools32.png"));
		btnAjustarParametros.setBounds(588, 193, 89, 55);
		getContentPane().add(btnAjustarParametros);

	}
}
