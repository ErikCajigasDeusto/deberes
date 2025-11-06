package gui.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import domain.Medal;
import domain.Medal.Metal;

public class MetalTableCellRenderer extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Medal.Metal, Color> metalColors = Map.of(
			Metal.GOLD, new Color(255, 215, 0),
			Metal.SILVER, new Color(165, 169, 180),
			Metal.BRONZE, new Color(205, 127, 50)
		);

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// los componentes obtenidos de las celdas siempre seran de tipo jlabel
			JLabel jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			
			Metal metal = (Metal) value;
			//usando el mapa especificaremos el color con la funcion get
			jLabel.setForeground(metalColors.get(metal));
			jLabel.setFont(jLabel.getFont().deriveFont(Font.BOLD));
			
			return jLabel;
		}

}
