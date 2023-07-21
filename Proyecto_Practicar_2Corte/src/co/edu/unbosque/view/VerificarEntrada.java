package co.edu.unbosque.view;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.exceptions.PasaporteException;

public class VerificarEntrada {
	
	public VerificarEntrada() {}
	
	public static boolean comprobarNombre(String nombre,JFrame vista) {
		try {
			if(nombre.length()==0||!nombre.matches(".*[^ ].*")) throw new PasaporteException(6);
		    else if(nombre.matches(".*[^a-zA-Z ].*")) throw new PasaporteException(1);
			return true;
		}catch (PasaporteException e) {
			JOptionPane.showMessageDialog(vista, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	public static boolean comprobarFecha(LocalDate fecha,JFrame vista) {
		try {
			if(Objects.isNull(fecha)||fecha.isAfter(LocalDate.now())) throw new PasaporteException(2);
			return true;
		}catch (PasaporteException e) {
			JOptionPane.showMessageDialog(vista, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	public static boolean comprobarPais(String pais,JFrame vista) {
		HashSet<String>paises=new HashSet<>();
		paises.addAll(Arrays.asList(FileHandler.leerArchivo("paises.txt").split("\n")));
		try {
			if(!paises.contains(pais.trim()))throw new PasaporteException(3);
			return true;
		}catch (PasaporteException e) {
			JOptionPane.showMessageDialog(vista, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	public static boolean comprobarExtencion(String ruta,JFrame vista) {
		try {
			String extencion=ruta.substring(ruta.lastIndexOf(".")+1);
			if(extencion.equals("")) throw new PasaporteException(5);
			else if(!extencion.equalsIgnoreCase("jpg")&&!extencion.equalsIgnoreCase("jpeg")&&!extencion.equalsIgnoreCase("gif")&&!extencion.equalsIgnoreCase("png"))throw new PasaporteException(4);
			return true;
		}catch (PasaporteException e) {
			JOptionPane.showMessageDialog(vista, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	public static void mensajeError(String mensaje,JFrame vista) {
		JOptionPane.showMessageDialog(vista, mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	
	public static int mensajeVerificar(String mensaje,JFrame vista) {
		return JOptionPane.showConfirmDialog(vista, mensaje);
	}
}
