package gui.main;

import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DateTableCellRenderer extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private DateTimeFormatter dateTimeFormatter;
	
	/** Constructor que recibe el formato de fecha a utilizar el objeto
	 */
	public DateTableCellRenderer(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;		
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		JLabel jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		//seteamos la fecha usando el value ya que lo qie cogeremeos sera siempre de formato LocalDate
		jLabel.setText(dateTimeFormatter.format((LocalDate) value));
		
		// especificamos la orientacion texto a la derecha en el JLabel
		jLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		return jLabel;
	}

}
