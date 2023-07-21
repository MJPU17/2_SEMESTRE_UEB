package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PopUpMessages {
	
	public PopUpMessages() {
	}
	
	public static int confirmMessage(JFrame view,String message) {
		return JOptionPane.showConfirmDialog(view, message);
	}
	
	public static void errorMessage(JFrame view, String message) {
		JOptionPane.showMessageDialog(view, message,"ERROR",JOptionPane.ERROR_MESSAGE);
	}

}
