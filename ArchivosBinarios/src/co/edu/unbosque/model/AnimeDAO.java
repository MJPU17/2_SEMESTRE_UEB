package co.edu.unbosque.model;

import java.util.Objects;
import java.util.TreeMap;

import co.edu.unbosque.model.persitence.FileHandler;

public class AnimeDAO implements OperacionesDAO{
	
	private TreeMap<String, AnimeDTO> lanimes;
	
	public AnimeDAO() {
		try {
			if(Objects.isNull((TreeMap<String, AnimeDTO>)FileHandler.leerSerializado("anime.jpuc"))) {
				lanimes=new TreeMap<>();
			}
			else {
				lanimes=(TreeMap<String, AnimeDTO>)FileHandler.leerSerializado("anime.jpuc");
			}
		}catch (Exception e) {
			lanimes=new TreeMap<>();
		}
		
	}
	@Override
	public void crear(String llave, AnimeDTO anime) {
		lanimes.put(llave, anime);
		guardarArchivo();
	}

	@Override
	public void actualizar(String llave, AnimeDTO anime) {
		lanimes.replace(llave, anime);
		guardarArchivo();
	}

	@Override
	public void eliminar(String llave) {
		lanimes.remove(llave);
		guardarArchivo();
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		for(AnimeDTO anime : lanimes.values()) {
			sb.append("\n______________________________________________________\n");
			if(anime instanceof ShonenDTO) sb.append("Genero: Shonen").append("\n");
			else if(anime instanceof RomanceDTO) sb.append("Genero: Romance").append("\n");
			else if(anime instanceof IsekaiDTO) sb.append("Genero: Isekai").append("\n");
			sb.append(anime.toString());
		}
		return sb.toString();
	}
	
	public void guardarArchivo() {
		FileHandler.escribirSerializado("anime.jpuc", lanimes);
	}
	public TreeMap<String, AnimeDTO> getLanimes() {
		return lanimes;
	}
	public void setLanimes(TreeMap<String, AnimeDTO> lanimes) {
		this.lanimes = lanimes;
	}

}
