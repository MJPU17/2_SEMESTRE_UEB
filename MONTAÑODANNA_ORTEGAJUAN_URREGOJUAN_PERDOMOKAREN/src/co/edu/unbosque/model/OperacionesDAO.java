package co.edu.unbosque.model;

public interface OperacionesDAO {
	
	public abstract void crear(Object llave,Object obj);
	public abstract void actualizar(Object allave,Object nllave, Object obj);
	public abstract void eliminar(Object llave);
	public abstract String mostrar();

}
