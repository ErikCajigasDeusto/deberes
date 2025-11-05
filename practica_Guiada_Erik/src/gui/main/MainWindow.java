package gui.main;

import javax.swing.JFrame;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainWindow()
	{
		//comportamiento por defecto al cerrar la aplicacion
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JJ.OO.Paris 2024");
		this.setSize(640,480);
		//poner a null para centralo en la pantalla
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
