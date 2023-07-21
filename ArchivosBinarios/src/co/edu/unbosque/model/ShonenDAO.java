package co.edu.unbosque.model;

import java.util.TreeMap;

import co.edu.unbosque.model.persitence.FileHandler;

public class ShonenDAO implements OperacionesDAO{
	
	private TreeMap<String, ShonenDTO> lshonens;
	
	public ShonenDAO() {
		try {
			lshonens=cargarDesdeArchivo();
		}catch (Exception e) {
			lshonens=new TreeMap<>();
		}
	}
	
	@Override
	public void crear(String llave, AnimeDTO anime) {
		lshonens.put(llave, (ShonenDTO)anime);
	}

	@Override
	public void actualizar(String llave, AnimeDTO anime) {
		lshonens.replace(llave, (ShonenDTO)anime);
	}

	@Override
	public void eliminar(String llave) {
		lshonens.remove(llave);
	}
	
	public TreeMap<String, ShonenDTO> cargarDesdeArchivo(){
		TreeMap<String, AnimeDTO> animes=(TreeMap<String, AnimeDTO>)FileHandler.leerSerializado("anime.jpuc");
		//TreeMap<String, AnimeDTO> animes=new TreeMap<>();
		TreeMap<String, ShonenDTO> shonens=new TreeMap<>();
		for(AnimeDTO anime : animes.values()) {
			if(anime instanceof ShonenDTO) {
				shonens.put(anime.getNombre(), (ShonenDTO)anime);
			}
		}
		return shonens;
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(ShonenDTO shonen : lshonens.values()) {
			sb.append("\n____________________________________________\n");
			sb.append(shonen.toString());
		}
		return sb.toString();
	}

	public TreeMap<String, ShonenDTO> getLshonens() {
		return lshonens;
	}

	public void setLshonens(TreeMap<String, ShonenDTO> lshonens) {
		this.lshonens = lshonens;
	}

}
