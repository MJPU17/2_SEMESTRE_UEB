package co.edu.unbosque.persistence;

import java.util.TreeMap;

import co.edu.unbosque.model.EmpleadoDTO;
import co.edu.unbosque.model.VendedorDTO;

public class VendedorDAO implements OperacionesDAO{
	
	private TreeMap<Long, VendedorDTO> lvendedores;
	
	public VendedorDAO() {
		lvendedores=new TreeMap<>();
	}

	public TreeMap<Long, VendedorDTO> getLvendedores() {
		return lvendedores;
	}

	public void setLvendedores(TreeMap<Long, VendedorDTO> lvendedores) {
		this.lvendedores = lvendedores;
	}

	@Override
	public void crear(Object llave, EmpleadoDTO empleado) {
		lvendedores.put((Long)llave, (VendedorDTO)empleado);
		
	}

	@Override
	public void actualizar(Object allave, Object nllave, EmpleadoDTO empleado) {
		lvendedores.remove((Long)allave);
		lvendedores.put((Long)nllave, (VendedorDTO)empleado);
		
	}

	@Override
	public void eliminar(Object llave) {
		lvendedores.remove((Long)llave);
		
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder("\n");
		for(VendedorDTO vendedor: lvendedores.values()) {
			sb.append(vendedor.toString()).append("\n");
		}
		return sb.toString();
	}

}
