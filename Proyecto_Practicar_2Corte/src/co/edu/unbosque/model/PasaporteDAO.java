package co.edu.unbosque.model;

import java.util.LinkedList;
import java.util.Objects;

import co.edu.unbosque.model.persistence.FileHandler;

public class PasaporteDAO implements OperacionesDAO{
	
	LinkedList<PasaporteDTO> lpasaportes;

	public PasaporteDAO() {
		try {
			if(!Objects.isNull(FileHandler.leerSerializado("pasaportes.mjpu"))) {
				lpasaportes=cargarDesdeArchivo();
			}
			else {
				lpasaportes=new LinkedList<>();
			}
		}
		catch (Exception e) {
			lpasaportes=new LinkedList<>();
		}
	}

	@Override
	public void crear(Object obj) {
		lpasaportes.add((PasaporteDTO)obj);
		escribirArchivoAdmitidos();
		escribirArchivoRechazados();
		guardarEnArchivo();
	}

	@Override
	public void eliminar(int index) {
		lpasaportes.remove(index);
		escribirArchivoAdmitidos();
		escribirArchivoRechazados();
		guardarEnArchivo();
	}

	@Override
	public void actualizar(int index, Object obj) {
		lpasaportes.remove(index);
		lpasaportes.add(index, (PasaporteDTO)obj);
		escribirArchivoAdmitidos();
		escribirArchivoRechazados();
		guardarEnArchivo();
	}

	@Override
	public String mostrar(boolean bool) {
		StringBuilder sb=new StringBuilder();
		for(PasaporteDTO pas : lpasaportes) {
			sb.append("_____________________________\n");
			if(bool && pas.getPais().equals("Colombia"))sb.append(pas.toString());
			else if(!bool && !pas.getPais().equals("Colombia"))sb.append(pas.toString());
		}
		return sb.toString();
	}
	
	public boolean containsindex(int index) {
		for(int i=0;i<lpasaportes.size();i++) {
			if(i==index) {
				return true;
			}
		}
		return false;
	}
	
	public void guardarEnArchivo() {
		FileHandler.escribirSerializado("pasaportes.mjpu", lpasaportes);
	}
	
	public LinkedList<PasaporteDTO> cargarDesdeArchivo() {
		return (LinkedList<PasaporteDTO>)FileHandler.leerSerializado("pasaportes.mjpu");
	}
	
	public void escribirArchivoRechazados() {
		StringBuilder sb=new StringBuilder();
		for(PasaporteDTO pas : lpasaportes) {
			if(!pas.isAdmitido()) {
				sb.append(pas.getNombre()).append(";");
				sb.append(pas.getFnacimiento().toString()).append(";");
				sb.append(pas.getPais()).append("\n");
			}
		}
		 FileHandler.escribirArchivo("rechazados.csv", sb.toString());
	}
	
	public void escribirArchivoAdmitidos() {
		StringBuilder sb=new StringBuilder();
		for(PasaporteDTO pas : lpasaportes) {
			if(pas.isAdmitido()) {
				sb.append(pas.getNombre()).append(";");
				sb.append(pas.getFnacimiento().toString()).append(";");
				sb.append(pas.getPais()).append("\n");
			}
		}
		 FileHandler.escribirArchivo("admitidos.csv", sb.toString());
	}

	public LinkedList<PasaporteDTO> getLpasaportes() {
		return lpasaportes;
	}

	public void setLpasaportes(LinkedList<PasaporteDTO> lpasaportes) {
		this.lpasaportes = lpasaportes;
	}
	
	
}
