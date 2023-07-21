package co.edu.unbosque.model;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.MascotaDAO;

public class VeterinariaDTO {
	
	private ArrayList<Mascota> mascotas;
	private MascotaDAO mascotaDAO;
	private File file = new File("data/informacion.dat");
	private Archivo archivo;
	
	public VeterinariaDTO() {
		mascotas = new ArrayList<Mascota>();
		archivo = new Archivo(file);
		mascotaDAO = new MascotaDAO(archivo);		
		mascotas = archivo.leerArchivo(file);		
	}

	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(ArrayList<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public MascotaDAO getMascotaDAO() {
		return mascotaDAO;
	}

	public void setMascotaDAO(MascotaDAO mascotaDAO) {
		this.mascotaDAO = mascotaDAO;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}
	
}
