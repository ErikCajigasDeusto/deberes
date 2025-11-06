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
	@Override
	
	//normalmente en estos casos la funcion devolvera una jlavel
	public Component getListCellRendererComponent(JList<?> list,
	Object value, int index, boolean isSelected, boolean hasFocus) {
	// modificamos el comportamiento por defecto del renderer del JList
		
		Component componente = super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		
		//por defecto el componente sera una jlabel por eso podemos convertirlo
		JLabel label = (JLabel) componente;
		
		//lo podemos convertir porque desde un principio esto solo lo usaremos con objetos de clase athlete
		Athlete atleta = (Athlete)value;
		
		label.setText(atleta.getName());
		
		
		return label;
	}
}