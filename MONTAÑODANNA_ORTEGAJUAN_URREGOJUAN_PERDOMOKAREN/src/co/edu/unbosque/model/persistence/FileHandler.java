package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {
	
	private static Scanner lector;
	private static PrintWriter escritor;
	private static File archivo;
	
	public FileHandler() {}
	
	public static String leerArchivo(String filename) {
		archivo=new File("src/co/edu/unbosque/model/persistence/"+filename);
		StringBuilder sb=new StringBuilder();
		try {
			lector=new Scanner(archivo);
			while(lector.hasNext()) {
				sb.append(lector.nextLine()+"\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe.");
		}
		catch (IOException e) {
			System.out.println("No tiene los permisos para acceder al archivo.");
		}
		return sb.toString();
	}
	
	public static void escribirArchivo(String filename,String content) {
		archivo=new File("src/co/edu/unbosque/model/persistence/"+filename);	
		try {
			if(!archivo.exists()) {
				archivo.createNewFile();
			}
			escritor=new PrintWriter(archivo);
			escritor.println(content);
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe.");
		}
		catch (IOException e) {
			System.out.println("No tiene los permisos para acceder al archivo.");
		}
	}

}
