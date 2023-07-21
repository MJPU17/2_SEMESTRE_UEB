package co.edu.unbosque.model;

import java.util.TreeMap;

import co.edu.unbosque.model.persitence.FileHandler;

public class RomanceDAO implements OperacionesDAO{
	
	private TreeMap<String, RomanceDTO> lromances;
	
	public RomanceDAO() {
		try {
			lromances=cargarDesdeArchivo();
		}catch (Exception e) {
			lromances=new TreeMap<>();
		}
	}

	@Override
	public void crear(String llave, AnimeDTO anime) {
		lromances.put(llave, (RomanceDTO)anime);
	}

	@Override
	public void actualizar(String llave, AnimeDTO anime) {
		lromances.replace(llave, (RomanceDTO)anime);
		
	}

	@Override
	public void eliminar(String llave) {
		lromances.remove(llave);
	}
	
	public TreeMap<String, RomanceDTO> cargarDesdeArchivo(){
		TreeMap<String, AnimeDTO> animes=(TreeMap<String, AnimeDTO>)FileHandler.leerSerializado("anime.jpuc");
		//TreeMap<String, AnimeDTO> animes=new TreeMap<>();
		TreeMap<String, RomanceDTO> romances=new TreeMap<>();
		for(AnimeDTO anime : animes.values()) {
			if(anime instanceof RomanceDTO) {
				romances.put(anime.getNombre(), (RomanceDTO)anime);
			}
		}
		return romances;
	}

	@Override
	public String mostrar() {
		StringBuilder sb = new StringBuilder();
		for(RomanceDTO romance : lromances.values() ) {
			sb.append("\n______________________________\n");
			sb.append(romance.toString());
		}
		return sb.toString();
	}

	public TreeMap<String, RomanceDTO> getLromances() {
		return lromances;
	}

	public void setLromances(TreeMap<String, RomanceDTO> lromances) {
		this.lromances = lromances;
	}

}
