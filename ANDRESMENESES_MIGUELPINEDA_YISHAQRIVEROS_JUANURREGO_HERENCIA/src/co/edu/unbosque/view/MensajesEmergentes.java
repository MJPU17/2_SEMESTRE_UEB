package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MensajesEmergentes {
	
	public MensajesEmergentes() {
	}
	
	public static void mensajeError(JFrame vista,String mensaje) {
		JOptionPane.showMessageDialog(vista, mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	
	public static int mensajeVerificar(JFrame vista,String mensaje){
		return JOptionPane.showConfirmDialog(vista, mensaje);
	}

}
