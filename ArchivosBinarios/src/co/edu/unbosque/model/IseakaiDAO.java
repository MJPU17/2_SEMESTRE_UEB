package co.edu.unbosque.model;

import java.util.TreeMap;

import co.edu.unbosque.model.persitence.FileHandler;

public class IseakaiDAO implements OperacionesDAO{
	
	private TreeMap<String, IsekaiDTO> lisekais;
	
	public IseakaiDAO() {
		try {
			lisekais=cargarDesdeArchivo();
		}catch (Exception e) {
			lisekais=new TreeMap<>();
		}
	}

	@Override
	public void crear(String llave, AnimeDTO anime) {
		lisekais.put(llave, (IsekaiDTO)anime);
	}

	@Override
	public void actualizar(String llave, AnimeDTO anime) {
		lisekais.replace(llave, (IsekaiDTO)anime);
	}

	@Override
	public void eliminar(String llave) {
		lisekais.remove(llave);
	}

	@Override
	public String mostrar() {
		StringBuilder sb= new StringBuilder();
		for(IsekaiDTO isekai : lisekais.values()) {
			sb.append("\n___________________________________\n");
			sb.append(isekai.toString());
		}
		return sb.toString();
	}
	
	public TreeMap<String, IsekaiDTO> cargarDesdeArchivo(){
		TreeMap<String, AnimeDTO> animes=(TreeMap<String, AnimeDTO>)FileHandler.leerSerializado("anime.jpuc");
		//TreeMap<String, AnimeDTO> animes=new TreeMap<>();
		TreeMap<String, IsekaiDTO> isekais=new TreeMap<>();
		for(AnimeDTO anime : animes.values()) {
			if(anime instanceof IsekaiDTO) {
				isekais.put(anime.getNombre(), (IsekaiDTO)anime);
			}
		}
		return isekais;
	}

	public TreeMap<String, IsekaiDTO> getLisekais() {
		return lisekais;
	}

	public void setLisekais(TreeMap<String, IsekaiDTO> lisekais) {
		this.lisekais = lisekais;
	}

}
