package co.edu.unbosque.model;

public interface OperacionesDAO {
	
	 public abstract void crear(String nombre,Object obj);
	 public abstract void eliminar(String nombre);
	 public abstract void actualizar (String nombre,String nuevo_nombre,Object obj);
	 public abstract String mostrar();

}
