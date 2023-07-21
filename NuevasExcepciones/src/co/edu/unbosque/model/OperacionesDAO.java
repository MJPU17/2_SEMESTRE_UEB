package co.edu.unbosque.model;

public interface OperacionesDAO {
	
	public abstract void crear(String nombre,PaisDTO pais);
	public abstract void actualizar(String anombre,String nnombre,PaisDTO pais);
	public abstract void eliminar(String nombre);
	public abstract String mostrar();
}
