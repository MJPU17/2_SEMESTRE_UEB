package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Mascota;

public class MascotaDAO {
	
	private Archivo archivo;

	public MascotaDAO(Archivo archivo) {
		this.archivo = archivo;
	}

	// CRUD
	public String verMascotas(ArrayList<Mascota> mascotas) {
		String texto = "";
		for (int i = 0; i < mascotas.size(); i++) {
			texto = texto.concat(mascotas.get(i) + "\n");
		}
		return texto;
	}

	public Mascota buscarMascota(String nombre, ArrayList<Mascota> mascotas) {
		Mascota encontrado = null;
		
		if (!mascotas.isEmpty()) {
			for (int i = 0; i < mascotas.size(); i++) {
				if (mascotas.get(i).getNombre().equals(nombre)) {
					encontrado = mascotas.get(i);
				}
			}
		}
		
		return encontrado;
	}

	public boolean agregarMascota(String nombre, String tipo, ArrayList<Mascota> mascotas, File file) {

		Mascota nuevo = new Mascota(nombre, tipo);

		if (buscarMascota(nombre, mascotas) == null) {
			mascotas.add(nuevo);
			archivo.escribirEnArchivo(mascotas, file);
			return true;
		} else {
			return false;
		}

	}

	public boolean eliminarMascota(String nombre, ArrayList<Mascota> mascotas, File file) {
		boolean resp=false;
		try {
			Mascota e = buscarMascota(nombre, mascotas);
			if(e!=null) {
				mascotas.remove(e);
				file.delete();
				file.createNewFile();
				archivo.escribirEnArchivo(mascotas, file);
				resp= true;
			}
			return resp;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return resp;

	}
}
