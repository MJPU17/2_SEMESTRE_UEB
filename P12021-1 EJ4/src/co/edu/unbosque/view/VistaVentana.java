package co.edu.unbosque.view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class VistaVentana {
	
	
	public VistaVentana() {
		
	}
	
	public void mostrarInformacion( String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Informaci�n" , JOptionPane.INFORMATION_MESSAGE);
	}
	
	public int leerDato(String mensaje) {
		String aux = JOptionPane.showInputDialog(null, mensaje , "Solicitud de Informaci�n" , JOptionPane.QUESTION_MESSAGE);
		int n = Integer.parseInt(aux);
		return n;
	}

	
}
