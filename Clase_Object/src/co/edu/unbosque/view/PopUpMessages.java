package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PopUpMessages {
	
	public static void errorMessage(JFrame view,String message) {
		JOptionPane.showMessageDialog(view, message,"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public static void informationMessage(JFrame view,String message) {
		JOptionPane.showMessageDialog(view, message);
	}
}
