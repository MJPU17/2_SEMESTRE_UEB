package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
	
	private static Scanner lector;
	private static File archivo;
	
	public FileHandler() {}
	
	public static String leerArchivo(String filename) {
		StringBuilder sb=new StringBuilder();
		archivo=new File("src/co/edu/unbosque/model/persistence/"+filename);
		try {
			lector=new Scanner(archivo);
			while (lector.hasNext()) {
				sb.append(lector.nextLine()+"\n");
			}
			lector.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Error de permisos.");
			e.printStackTrace();
		}
		return sb.toString();
	}
}
