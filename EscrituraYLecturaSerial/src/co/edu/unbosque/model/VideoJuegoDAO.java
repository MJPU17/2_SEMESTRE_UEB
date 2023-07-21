package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.FileHandler;

public class VideoJuegoDAO {

	private ArrayList<VideoJuegoDTO> listajuegos;

	public VideoJuegoDAO() {

		try {

			listajuegos = (ArrayList<VideoJuegoDTO>) FileHandler.leerSerializado("videojuegos.jazc");

		} catch (Exception e) {
			listajuegos = new ArrayList<>();
		}
		
	}

	public VideoJuegoDAO(ArrayList<VideoJuegoDTO > listajuegos) {
		super();
		this.listajuegos = listajuegos;
	}

	public ArrayList<VideoJuegoDTO> getListajuegos() {
		return listajuegos;
	}

	public void setListajuegos(ArrayList<VideoJuegoDTO> listajuegos) {
		this.listajuegos = listajuegos;
	}

	private ArrayList<VideoJuegoDTO> cargarDesdeArchivo() {

		ArrayList<VideoJuegoDTO> desde_archivo = new ArrayList<VideoJuegoDTO>();

		String contenido = FileHandler.abrirArchivoDeTexto("videojuego.csv");
		String[] filas = contenido.split("\n");
		for (String fila : filas) {

			String[] columnas = fila.split(";");
			String nombre = columnas[0];
			String consola = columnas[1];
			String rating = columnas[2];
			boolean multijugador;

			if (columnas[3].equalsIgnoreCase("si")) {
				multijugador = true;

			}

			else {

				multijugador = false;

			}

			desde_archivo.add(new VideoJuegoDTO(nombre, consola, rating, multijugador));
		}
		return desde_archivo;

	}

	private void escribirEnArchivo() {

		StringBuilder sb = new StringBuilder("");

		int index = listajuegos.size();

		for (VideoJuegoDTO v : listajuegos) {

			sb.append(v.getNombre() + ";");
			sb.append(v.getConsola() + ";");
			sb.append(v.getRating() + ";");
			sb.append((v.isEs_multijugador() ? "si" : "no"));
			if (index == 1) {

				continue;

			} else {

				index--;
				sb.append("\n");

			}
		}

		FileHandler.escribirEnArchivo("videojuego.csv", sb.toString());
		FileHandler.escribirSerializado("videojuegos.jazc", listajuegos);

	}

	public void crear(Object o) {

		listajuegos.add((VideoJuegoDTO) o);
		escribirEnArchivo();

	}

	public boolean eliminar(int index) {

		try {

			listajuegos.remove(index);
			escribirEnArchivo();
			return true;

		} catch (Exception e) {

			return false;

		}

	}

	public boolean actualizar(int index, Object o) {

		try {

			listajuegos.set(index, (VideoJuegoDTO) o);
			escribirEnArchivo();
			return true;

		} catch (Exception e) {

			return false;

		}

	}

	public String mostrar() {

		StringBuilder sb = new StringBuilder();

		int index = 1;

		for (VideoJuegoDTO vj : listajuegos) {

			sb.append("Videojuego " + index + "\n" + vj.toString() + "\n");
			index++;

		}

		return sb.toString();

	}

}
