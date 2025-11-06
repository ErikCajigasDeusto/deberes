package gui.main;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] parametrizado= new String[]{"A1","A2","A3","A4","A5","A6","A7","A8","A9","A10","A11","A12","A13","A14"
			,"B2","B3","B4","B5","B6","B7","B8","B9","B10","B11","B12","B13","B14"
			,"C2","C3","C4","C5","C6","C7","C8","C9","C10","C11","C12","C13","C14"};
	public MainWindow() {

		// Ejercicio GUI.2 – Componentes principales de la ventana
		

		JList<String> listadoAtletas = new JList<String>(parametrizado);
		
		//ajustando el ancho de las celdas de cada valor a 200
		listadoAtletas.setFixedCellWidth(200);
		
		JScrollPane desplegable = new JScrollPane(listadoAtletas);
		this.add(desplegable,BorderLayout.WEST);
		
		JTabbedPane paneles = new JTabbedPane();
		paneles.addTab("Datos", new JPanel());
		paneles.addTab("Medalla", new JPanel());
		
		this.add(paneles,BorderLayout.CENTER);
		// Ejercicio GUI.1
		
		// comportamiento por defecto al cerrar la aplicacion
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JJ.OO.Paris 2024");
		this.setSize(640, 480);
		// poner a null para centralo en la pantalla
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
