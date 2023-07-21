package co.edu.unbosque.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	
	private static Scanner leer;
	private static PrintWriter escritor;
	private static File archivo;
	
	public FileHandler() {}
	
	public static String leerArchivoTexto(String filename) {
		
		archivo=new File("src/co/edu/unbosque/model/persistence/"+filename);
		
		StringBuilder sb=new StringBuilder();
		try {
			leer=new Scanner(archivo);
			while(leer.hasNext()) {
				sb.append(leer.nextLine()+"\n");
			}
		
		} 
		catch (FileNotFoundException e) {
			System.out.println("El archivo no exite.");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("No tiene los permisos requeridos para acceder al archivo.");
			e.printStackTrace();
		}
		leer.close();
		return sb.toString();
		
	}
	
	public static void escribirArchivoTexto(String filename,ArrayList<String>lines) {
		archivo=new File("src/co/edu/unbosque/model/persistence/"+filename);
		try {
			escritor=new PrintWriter(archivo);
			for(String line:lines) {
				escritor.print(line+"\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe.");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("No tiene los permisos requeridos para modificar el archivo.");
		}
		escritor.close();
	}

}
