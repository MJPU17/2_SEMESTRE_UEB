package co.edu.unbosque.model;

public interface OperacionesDAO {
	
	public abstract void crear(String nombre,Object obj);
	public abstract void actualizar(String nombre,Object obj);
	public abstract void eliminar(String nombre);

}
