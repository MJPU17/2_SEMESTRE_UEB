package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

	private static Scanner sc;
	private static File archivo;
	private static PrintWriter pr;
	private static ObjectInputStream ois;
	private static ObjectOutputStream ous;

	public FileHandler() {
		// TODO Auto-generated constructor stub
	}

	public static String abrirArchivoDeTexto(String nombre_archivo) {

		// rutas relativas: empiezan desde la raiz del archivo actual.
		// rutas absolutas: empiezan desde la carpeta del disco.
		archivo = new File("src/co/edu/unbosque/model/persistence/" + nombre_archivo);

		StringBuilder contenido = new StringBuilder();
		try {

			sc = new Scanner(archivo);

			while (sc.hasNext()) {

				contenido.append(sc.nextLine() + "\n");

			}

		} catch (FileNotFoundException e) {

			System.out.println("Error de lectura: Archivo no encontrado");

			e.printStackTrace();

			try {
				archivo.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (IOException e1) {

			System.out.println("Error de lectura: Revise permisos");

			e1.printStackTrace();
		}

		return contenido.toString();
	}

	public static void escribirEnArchivo(String nombre_archivo, String contenido) {

		archivo = new File("src/co/edu/unbosque/model/persistence/" + nombre_archivo);

		try {

			pr = new PrintWriter(archivo);
			pr.println(contenido);
			pr.close();

		} catch (FileNotFoundException e) {

			System.out.println("Error de escritura: Archivo no encontrado");

			e.printStackTrace();

		} catch (IOException e1) {

			System.out.println("Error de escritura: Revise permisos");

			e1.printStackTrace();
		}
	}

	public static void escribirSerializado(String nom_archivo, Object o) {

		try {

			ous = new ObjectOutputStream(new FileOutputStream("src/co/edu/unbosque/model/persistence/" + nom_archivo));
			ous.writeObject(o);
			ous.close();

		} catch (FileNotFoundException e) {

			System.err.println("No se encontro el archivo (serializado escritura)");

		} catch (IOException e2) {

			System.err.println("Problemas al encontrar el archivo (serializado escritura), revise permisos");
		}

	}

	public static Object leerSerializado(String nom_archivo) {

		try {

			ois = new ObjectInputStream(new FileInputStream("src/co/edu/unbosque/model/persistence/" + nom_archivo));
			Object o = ois.readObject();
			ois.close();
			return o;

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.err.println("No se encontro el archivo (serializado lectura)");
		} catch (IOException e1) {
			System.err.println("Problemas al encontrar el archivo (serializado lectura), revise permisos");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;

	}

}
