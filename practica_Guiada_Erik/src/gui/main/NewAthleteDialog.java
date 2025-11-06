package gui.main;

import java.awt.BorderLayout;
import java.awt.Window;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.Athlete;
import main.AthleteFormPanel;

public class NewAthleteDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int result = JOptionPane.CANCEL_OPTION; // resultado del diálogo
	
	private AthleteFormPanel formularioP; // panel del formulario
	
	
	/**
	 * Constructor que recibe la ventana que ha creado el diálogo
	 * @param countries lista de países para el selector del formulario
	 */
	public NewAthleteDialog(List<String> countries) {
		
		// de esta forma se establece el dialogo a modal
		this.setModal(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Nuevo atleta");
		
		formularioP = new AthleteFormPanel(countries);
		this.add(formularioP, BorderLayout.CENTER); // al centro del diálogo
		
		//creacion de los botones
		JPanel bottomPanel = new JPanel();
		
		// cierra el diálogo y establece 
		JButton save = new JButton("Guardar");
		bottomPanel.add(save);
		JButton cancelar = new JButton("Cancelar");
		bottomPanel.add(cancelar);
		
		// accion que se ejecutara al activar el boton save
		save.addActionListener(event -> {
				
			try {
				// si no hay fallos
				formularioP.getAthlete();			
				result = JOptionPane.OK_OPTION;
				dispose(); // funcion que cerrar la ventana de dialogo
			} catch (FormDataNotValid e) {
				// en caso de erros
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		// el botón de cancelar únicamente cierra el diálogo
		cancelar.addActionListener(e -> dispose() );
		
		// añadimos los botones a la parte inferior del diálogo
		add(bottomPanel, BorderLayout.SOUTH);
		
		// agrupa todo lo de la ventana actual
		pack();
	}

	/**
	 * Muestra el diálogo con el formulario del nuevo atleta.
	 * @return el resultado de la operación.
	 */
	public int showDialog(Window parent) {
		setLocationRelativeTo(parent);
		setVisible(true);
		return result;
	}
	
	/**
	 *funcion para obtener el atleta creado con el formulario
	 * @return el athleta creado a partir de los datos del formulario
	 */
	public Athlete getAhtlete() throws FormDataNotValid {
		return formularioP.getAthlete();
	}
}
