package co.edu.unbosque.model;

public interface OperacionesDAO {
	
	public abstract void crear(String llave,AnimeDTO anime);
	public abstract void actualizar(String llave,AnimeDTO anime);
	public abstract void eliminar(String llave);
	public abstract String mostrar();
	
}
