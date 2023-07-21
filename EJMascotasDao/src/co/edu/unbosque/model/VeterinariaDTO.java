package co.edu.unbosque.model;

import java.io.File;
import java.util.ArrayList;

public class VeterinariaDTO {
	
	private ArrayList<Mascota> mascotas;
	private MascotaDAO mascotaDAO;
		
	public VeterinariaDTO() {
		mascotas = new ArrayList<Mascota>();
		mascotaDAO = new MascotaDAO();				
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
	
}
