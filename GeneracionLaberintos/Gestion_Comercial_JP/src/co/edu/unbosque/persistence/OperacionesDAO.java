package co.edu.unbosque.persistence;

import co.edu.unbosque.model.EmpleadoDTO;

public interface OperacionesDAO {
	
	public abstract void crear(Object llave,EmpleadoDTO empleado);
	public abstract void actualizar(Object allave,Object nllave ,EmpleadoDTO empleado);
	public abstract void eliminar(Object llave);
	public abstract String mostrar();

}
