package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

public class FileHandler {
	
	private static File file;
	private static Scanner reader;
	private static PrintWriter writer;
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;
	
	public FileHandler() {}
	
	public static String leerArchivo(String filename) {
		StringBuilder sb=new StringBuilder();
		file=new File("src/co/edu/unbosque/model/persistence/"+filename);
		try {
			reader=new Scanner(file);
			while(reader.hasNextLine()) {
				sb.append(reader.nextLine()).append("\n");
			}
			reader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo.");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("No tiene los permisos para acceder al archivo.");
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void escribirArchivo(String filename, String content) {
		file=new File("src/co/edu/unbosque/model/persistence/"+filename);
		try {
			writer=new PrintWriter(file);
			writer.print(content);
			writer.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo.");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("No tiene los permisos para acceder al archivo.");
			e.printStackTrace();
		}
	}
	
	public static Object leerSerializado(String filename) {
		try {
			ois=new ObjectInputStream(new FileInputStream("src/co/edu/unbosque/model/persistence/"+filename));
			Object obj=ois.readObject();
			ois.close();
			return obj;
		}
		catch (FileNotFoundException e) {
			System.err.println("El archivo no se ha encontrado.");	
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Error al leer el archivo(serializado).");
			
		} catch (ClassNotFoundException e) {
			System.err.println("Error al leer clase del archivo(serializado).");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void escribirSerializado(String filename, Object obj) {
		try {
			oos=new ObjectOutputStream(new FileOutputStream("src/co/edu/unbosque/model/persistence/"+filename));
			oos.writeObject(obj);
			oos.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("El archivo no se ha encontrado.");	
		}
		catch (IOException e) {
			System.err.println("Error al serialisar el objeto");
		}
	}
	
	public static Properties cargarPropiedades(String filename) {
		file=new File("src/co/edu/unbosque/util/"+filename);
		Properties properties=new Properties();
		try {
			properties.load(new FileInputStream(file));
		}
		catch (IOException e) {
			System.err.println("Error al gargar archivo propiedades.");
			e.printStackTrace();
		}
		return properties;
	}
	
}
