package main;

import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AthleteFormPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String formato_fecha = "dd/MM/yyyy"; // formato de fecha

	private JFormattedTextField codeTextField;
	private JTextField nombreBox;
	private JFormattedTextField nacimientoTextField;
	private JRadioButton male,female;
	private JComboBox<String> paisesComboBox;
	
	public AthleteFormPanel()
	{
		//para que los componenetes se organicen verticalmente
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel jCodigo = new JLabel("Código ");
		codeTextField = new JFormattedTextField(new DecimalFormat("#######"));
		codeTextField.setColumns(3);
		codeTextField.setAlignmentX(LEFT_ALIGNMENT);
		
		JPanel panelCodigo = new JPanel();
		panelCodigo.add(jCodigo);
		panelCodigo.add(codeTextField);
		panelCodigo.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		JLabel jNombre = new JLabel("Nombre ");
		nombreBox = new JTextField(10);
		
		JPanel panelNombre = new JPanel();
		panelNombre.add(jNombre);
		panelNombre.add(nombreBox);
		panelNombre.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		JPanel generoPanel = new JPanel();
		male = new JRadioButton("hombre");
		female = new JRadioButton("mujer");
		
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(male);
		grupoBotones.add(female);
		
		generoPanel.add(male);
		generoPanel.add(female);
		
		JPanel nacimientoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nacimiento = new JLabel("Nacimiento: ");
		
		DateFormat formatoFecha = new SimpleDateFormat(formato_fecha);
		nacimientoTextField = new JFormattedTextField(formatoFecha);
		
		nacimientoTextField.setColumns(6);
		nacimientoTextField.setHorizontalAlignment(JTextField.CENTER);
		
		nacimientoPanel.add(nacimiento);
		nacimientoPanel.add(nacimientoTextField);
		
		
		JPanel panelPais = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel paises = new JLabel("Pais: ");
		String[] listapaises = new String[] {"españa","alemania","francia","noruega"};
		paisesComboBox = new JComboBox(listapaises);
		panelPais.add(paises);
		panelPais.add(paisesComboBox);
		
		this.add(panelCodigo);
		this.add(panelNombre);
		this.add(nacimientoPanel);
		this.add(panelPais);
		
		Border borde = BorderFactory.createTitledBorder("Atleta");
		this.setBorder(borde);
	}
	
	public static void main(String[] args) {
		AthleteFormPanel testForm = new AthleteFormPanel();

		// creamos una ventana de prueba para visualizar el panel
		JFrame jFrame = new JFrame("Ventana de prueba");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(testForm);

		jFrame.pack();
		jFrame.setVisible(true);
	}

}
