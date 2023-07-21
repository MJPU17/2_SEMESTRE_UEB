package co.edu.unbosque.view;

import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.unbosque.util.exception.VehicleException;

public class PopUpMessages {
	
	public PopUpMessages() {}
	
	public static String readOptions (String message,Object option[]) {
		Object dato=JOptionPane.showInputDialog(null,message,"Vehicle CRUD",JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
		return dato.toString();
	}
	
	public static void errorMessage(JFrame view,String message) {
		JOptionPane.showMessageDialog(view, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static boolean errorPlaque(JFrame view,String plaque,Properties properties) {
		try {
			if(!plaque.contains("-")||plaque.replaceAll("[^-]", "").length()>1)throw new VehicleException(1, properties);
			String[] parts=plaque.split("-");
			if(parts[0].matches(".*[^A-Za-z].*")||parts[1].matches(".*[^0-9].*")||parts[0].length()!=3||parts[1].length()!=3)throw new VehicleException(1, properties);
			return false;
		}
		catch (VehicleException e) {
			JOptionPane.showMessageDialog(view, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	public static boolean errorBrand(JFrame view,String brand,Properties properties) {
		try {
			if(brand.matches(".*[^A-Za-z ].*"))throw new VehicleException(2, properties);
			if(!brand.matches(".*[^ ].*")||brand.length()==0)throw new VehicleException(2, properties);
			return false;
		}
		catch (VehicleException e) {
			JOptionPane.showMessageDialog(view, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	public static boolean errorModel(JFrame view,String model,Properties properties) {
		try {
			if(model.matches(".*[^A-Za-z0-9 ].*"))throw new VehicleException(3, properties);
			if(!model.matches(".*[^ ].*")||model.length()==0)throw new VehicleException(3, properties);
			return false;
		}
		catch (VehicleException e) {
			JOptionPane.showMessageDialog(view, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	public static boolean errorColor(JFrame view,String color,Properties properties) {
		try {
			if(color.matches(".*[^A-Za-z ].*"))throw new VehicleException(4, properties);
			if(!color.matches(".*[^ ].*")||color.length()==0)throw new VehicleException(4, properties);
			return false;
		}
		catch (VehicleException e) {
			JOptionPane.showMessageDialog(view, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	public static int confirmMessage(String mensaje,JFrame vista) {
		return JOptionPane.showConfirmDialog(vista, mensaje);
	}

}
