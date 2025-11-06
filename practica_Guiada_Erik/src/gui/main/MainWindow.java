package gui.main;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] parametrizado = new String[] { "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11",
			"A12", "A13", "A14", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12", "B13", "B14",
			"C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "C14" };

	public MainWindow() {


		
		// Ejercicio GUI.3 – Añadiendo un menú de aplicación
		creador_de_Menu();
		// Ejercicio GUI.2 – Componentes principales de la ventana

		JList<String> listadoAtletas = new JList<String>(parametrizado);

		// ajustando el ancho de las celdas de cada valor a 200
		listadoAtletas.setFixedCellWidth(200);

		JScrollPane desplegable = new JScrollPane(listadoAtletas);
		this.add(desplegable, BorderLayout.WEST);

		JTabbedPane paneles = new JTabbedPane();
		paneles.addTab("Datos", new JPanel());
		paneles.addTab("Medalla", new JPanel());

		this.add(paneles, BorderLayout.CENTER);
		// Ejercicio GUI.1

		// comportamiento por defecto al cerrar la aplicacion
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("JJ.OO.Paris 2024");
		this.setSize(640, 480);
		// poner a null para centralo en la pantalla
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//Ejercicio GUI.4 – Gestionando el cierre de la ventana
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			// se llama cuando el usuario intenta cerrar la ventana
				confirmacionSalida();
			}
		});
	}
	
	
	/**
	 * funcion que creara el menu desplegable
	 */
	private void creador_de_Menu()
	{
		JMenuBar barra = new JMenuBar();
		this.setJMenuBar(barra);
		
		JMenu menu = new JMenu("Menu");
		
		JMenuItem nuevo = new JMenuItem("Nuevo atleta");
		menu.add(nuevo);
		//para crear una linea entre los valores
		menu.addSeparator();
		
		JMenuItem importar = new JMenuItem("Importar");
		menu.add(importar);
		
		JMenuItem exportar = new JMenuItem("Exportar");
		menu.add(exportar);
		
		//para crear una linea entre los valores
		menu.addSeparator();
		
		JMenuItem salir = new JMenuItem("Salir");
		menu.add(salir);
		barra.add(menu);
	}
	
	/**
	 * funcion para crear un cuadro para confirma si se desea salir de la aplicacion
	 */
	private void confirmacionSalida()
	{
		int respuesta = JOptionPane.showConfirmDialog(MainWindow.this, "Seguro desea salir?", "S/N",JOptionPane.YES_NO_OPTION);
		
		if(respuesta==JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	
}
