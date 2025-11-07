package domain;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MedalsModel extends AbstractTableModel{

private static final long serialVersionUID = 1L;
	
	private String[] columnHeaders = new String[] { "Metal", "Fecha", "Disciplina" };
	private List<Medal> medals; // referencia a la lista de medallas
	
	public MedalsModel() {
		this.medals= Collections.emptyList();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return medals.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnHeaders.length;
	}
	
	@Override
	public String getColumnName(int column) {
		// devolvemos el nombre de la columna indicada
		return columnHeaders[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Medal m = medals.get(rowIndex);
		switch (columnIndex) {
			case 0: 
					return m.getMetal();
			
			case 1: 
					return m.getMedalDate();
			case 2: 
					return m.getDiscipline();
			default: 
					return null;
		}
	}
	
	public void updateMedals(List<Medal> medals) {
		this.medals = medals;

		// se repintara la tabla
		fireTableDataChanged();
	}
	
	/**
	 * el ? permitira utilizar la funcion como si tuviera un template 
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// indica el tipo de cada columna de datos puede ser usado por renderers o editors
		switch (columnIndex) {
		
			case 0: 
				return Medal.Metal.class;
				
			case 1: 
				return LocalDate.class;
				
			case 2: 
				return String.class;
				
			default: 
				return null;
		}
	}
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		
		// fila modificada
		Medal m = medals.get(rowIndex); 
		switch (columnIndex) {
		case 0:
			m.setMetal((Medal.Metal) value);
			break;
		case 1:
			m.setMedalDate((LocalDate) value);
			break;
		case 2:
			m.setDiscipline((String) value);
			break;
		}
	}
	
	//funcion para añadir medallas segun la longitud de la lista de medallas
	public void addMedal(Medal medal) {
		medals.add(medal);
		
       fireTableRowsInserted(medals.size() - 1, medals.size() - 1);
    }

}
