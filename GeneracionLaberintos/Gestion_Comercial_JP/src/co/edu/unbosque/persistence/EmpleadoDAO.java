package co.edu.unbosque.persistence;

import java.util.TreeMap;

import co.edu.unbosque.model.EmpleadoDTO;

public class EmpleadoDAO implements OperacionesDAO{
	
	private TreeMap<Long, EmpleadoDTO> lempleados;
	
	public EmpleadoDAO() {
		lempleados=new  TreeMap<>();
	}

	public TreeMap<Long, EmpleadoDTO> getLempleados() {
		return lempleados;
	}

	public void setLempleados(TreeMap<Long, EmpleadoDTO> lempleados) {
		this.lempleados = lempleados;
	}

	@Override
	public void crear(Object llave, EmpleadoDTO empleado) {
		lempleados.put((Long)llave, empleado);
		
	}

	@Override
	public void actualizar(Object allave, Object nllave, EmpleadoDTO empleado) {
		lempleados.remove((Long)allave);
		lempleados.put((Long)nllave, empleado);
		
	}

	@Override
	public void eliminar(Object llave) {
		lempleados.remove((Long)llave);
		
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder("\n");
		for(EmpleadoDTO empleado: lempleados.values()) {
			sb.append(empleado.toString()).append("\n");
		}
		return sb.toString();
	}
	
}
