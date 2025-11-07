package gui.main;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import domain.Athlete;

public class AthleteListCellRenderer extends DefaultListCellRenderer {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;


	private String text = ""; // text a resaltar en la celda

	/**
	 * Establece el texto que se resaltará en el JLabel
	 * 
	 * @param text texto a resaltar en el JLabel
	 */
	public void setHighLightedText(String text) {
		this.text = text;
	}

	// normalmente en estos casos la funcion devolvera una jlavel
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean hasFocus) {
		// modificamos el comportamiento por defecto del renderer del JList

		Component componente = super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);

		// por defecto el componente sera una jlabel por eso podemos convertirlo
		JLabel label = (JLabel) componente;

		// lo podemos convertir porque desde un principio esto solo lo usaremos con
		// objetos de clase athlete
		Athlete atleta = (Athlete) value;

		//aplicando un filtro
		if (!text.isBlank()) {
			// buscamos dónde empieza y termina el texto a resaltar sin importar mayúsculas y minúsculas
			String lowerCaseText = text.toLowerCase();
			String lowerCaseName = atleta.getName().toLowerCase();
			int start = lowerCaseName.indexOf(lowerCaseText);
			int end = start + text.length();
			
			// construimos el texto resaltado con fondo amarillo
			String highlightedText = "<html>" + atleta.getName().substring(0, start) + 
				"<span style='background-color: yellow;'>" + 
				atleta.getName().substring(start, end) + "</span>" +
				atleta.getName().substring(end) + "</html>";
			
			// establecemos el texto resaltado en el JLabel
			label.setText(highlightedText);
		} else {
			// si no hay texto a resaltar, establecemos el nombre del atleta sin cambios
			label.setText(atleta.getName());
		}
		return label;
	}
}