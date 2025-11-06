package gui.main;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import domain.Athlete;
import domain.Athlete.Genre;
import main.AthleteFormPanel;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private String[] parametrizado = new String[] { "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11",
//			"A12", "A13", "A14", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12", "B13", "B14",
//			"C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "C14" };
	
	private List<Athlete> muestrarioAtletas = List.of(
			new Athlete(1, "Tonelaje, Ofelia", Genre.FEMALE, "españa", LocalDate.of(1990, 12, 15)),
			new Athlete(2, "Probeta, Bacterio", Genre.MALE, "alemania", LocalDate.of(1995, 5, 20)),
			new Athlete(3, "nada, Paco", Genre.MALE, "francia", LocalDate.of(1993, 1, 30)),
			new Athlete(4, "todo, Pepe", Genre.MALE, "noruega", LocalDate.of(1994, 3, 29)),
			new Athlete(5, "Rompetecho, Emilio", Genre.FEMALE, "españa", LocalDate.of(1998, 7, 9))
		);
	
	private JList<Athlete> jListAtletas;
	private List<String> countries = List.of("españa", "alemania", "francia", "noruega");
	private AthleteFormPanel athleteform;
	DefaultListModel<Athlete> modeloAtletas;
	
	public MainWindow() {


		// Ejercicio GUI.3 – Añadiendo un menú de aplicación
		creador_de_Menu();
		// Ejercicio GUI.2 – Componentes principales de la ventana

		
		//creando el modelo de los atletas
		modeloAtletas = new DefaultListModel<Athlete>();
		modeloAtletas.addAll(muestrarioAtletas);
		
		jListAtletas = new JList<Athlete>(modeloAtletas);
		
		// ajustando el ancho de las celdas de cada valor a 200
		jListAtletas.setFixedCellWidth(200);
		jListAtletas.setCellRenderer(new AthleteListCellRenderer());
		
		jListAtletas.addListSelectionListener(e -> {
			// solamente vamos a procesar el último evento de la selección en el JList
			// esto evita procesar dos veces cada selección de items
			if (!e.getValueIsAdjusting()) {
				// obtenemos el atleta seleccionado del JList
				Athlete selectedAthlete = jListAtletas.getSelectedValue();
				// lo mostramos en el formulario de la derecha
				athleteform.setAthlete(selectedAthlete);
			}
			});

		JScrollPane desplegable = new JScrollPane(jListAtletas);
		this.add(desplegable, BorderLayout.WEST);

		JTabbedPane paneles = new JTabbedPane();
		
		//añadiendo el formulario a la pestaña
		athleteform = new AthleteFormPanel(countries);
		athleteform.setEditable(false);
		paneles.addTab("Datos", athleteform);
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
		
		nuevo.addActionListener(evento -> {
			NewAthleteDialog newAthleteDialog = new NewAthleteDialog(countries);
			int result = newAthleteDialog.showDialog(this);
			if (result == JOptionPane.OK_OPTION) {
				// si el usuario ha pulsado la opción guardar
				// obtenemos el nuevo atleta y lo añadimos a la lista de atletas
				try {
					modeloAtletas.addElement(newAthleteDialog.getAhtlete());
				} catch (FormDataNotValid e) {
					// no hacemos nada porque sabemos que el atleta debe
					// ser válido en este punto
				}
			}
		});
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
