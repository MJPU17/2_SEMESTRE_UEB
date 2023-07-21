package co.edu.unbosque.model;

public interface OperacionesDAO {
	
	public abstract void crear(String llave,AnimalDTO animal);
	public abstract void actualizar(String anombre,String nnombre,AnimalDTO animal);
	public abstract void eliminar(String llave);
	public abstract String mostrar();

}
