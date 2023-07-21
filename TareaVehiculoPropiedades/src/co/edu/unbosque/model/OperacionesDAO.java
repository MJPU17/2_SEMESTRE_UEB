package co.edu.unbosque.model;

public interface OperacionesDAO {
	
	public abstract void create(VehicleDTO vehicle);
	public abstract void update(String aplaque,String nplaque,VehicleDTO vehicle);
	public abstract void remove(String plaque);
	
}
