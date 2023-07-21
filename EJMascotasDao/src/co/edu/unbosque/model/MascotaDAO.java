package co.edu.unbosque.model;

import java.util.ArrayList;

public class MascotaDAO {
	

	public MascotaDAO() {
		
	}

	// CRUD
	public String verMascotas(ArrayList<Mascota> datos) {
		ArrayList<Mascota> mascotas = datos;
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

	public boolean agregarMascota(String nombre, String tipo, ArrayList<Mascota> mascotas) {

		Mascota nuevo = new Mascota(nombre, tipo);

		if (buscarMascota(nombre, mascotas) == null) {
			mascotas.add(nuevo);
			return true;
		} else {
			return false;
		}

	}

	public boolean eliminarMascota(String nombre, ArrayList<Mascota> mascotas) {
		boolean resp=false;
		Mascota e = buscarMascota(nombre, mascotas);
		if(e!=null) {
			mascotas.remove(e);
			resp= true;
		}
		return resp;
	}
	
	public boolean modificarMascota(String nombre, String tipo, ArrayList<Mascota> mascotas) {
		boolean resp=false;
		Mascota e = buscarMascota(nombre, mascotas);
		if(e!=null) {
			mascotas.remove(e);
			e.setTipo(tipo);
			mascotas.add(e);
			resp= true;
		}
		return resp;
	}
}
