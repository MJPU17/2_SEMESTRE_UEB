package co.edu.unbosque.model.persitence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.unbosque.model.AnimeDTO;

public class FileHandler {
	
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;
	private static File archivo;
	
	public FileHandler() {}
	
	public static void escribirSerializado(String filename, Object obj) {
		try {
			oos=new ObjectOutputStream(new FileOutputStream("src/co/edu/unbosque/model/persitence/"+filename));
			oos.writeObject(obj);
			oos.close();
		} 
		catch (FileNotFoundException e) {
			System.err.println("No se encontro el archivo(serializado).");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Problema al abrir el archivo(serializado), revise permisos.");
			e.printStackTrace();
		}
	}
	
	public static Object leerSerializado(String filename) {
		try {
			ois=new ObjectInputStream(new FileInputStream("src/co/edu/unbosque/model/persitence/"+filename));
			Object obj=ois.readObject();
			ois.close();
			return obj;
		}
		catch (FileNotFoundException e) {
			System.err.println("No se encontro el archivo(serializado/entrada).");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Problema al abrir el archivo(serializado/entrada), revise permisos.");
		}
		catch (ClassNotFoundException e) {
			System.err.println("Problema con conversion de clase.");
			e.printStackTrace();
		}
		return null;
	}

}
