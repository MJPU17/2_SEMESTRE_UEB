package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MensajesEmergentes {
	
	public static void MensajeInformacion(JFrame vista, String mensaje) {
		JOptionPane.showMessageDialog(vista, mensaje);
	}
	
	public static void MensajeError(JFrame vista,String mensaje) {
		JOptionPane.showMessageDialog(vista, mensaje, "ERROR",JOptionPane.ERROR_MESSAGE);
	}
	
}
