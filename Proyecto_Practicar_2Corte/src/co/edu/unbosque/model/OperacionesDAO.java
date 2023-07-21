package co.edu.unbosque.model;

public interface OperacionesDAO {
	
	public abstract void crear(Object obj);
	public abstract void eliminar(int index);
	public abstract void actualizar(int index,Object obj);
	public abstract String mostrar(boolean bool);
	
}
