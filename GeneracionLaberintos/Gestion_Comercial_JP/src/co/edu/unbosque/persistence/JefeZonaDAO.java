package co.edu.unbosque.persistence;

import java.util.TreeMap;

import co.edu.unbosque.model.EmpleadoDTO;
import co.edu.unbosque.model.JefeZonaDTO;

public class JefeZonaDAO implements OperacionesDAO{
	
	private TreeMap<String, JefeZonaDTO> ljefezona;
	
	public JefeZonaDAO() {
		ljefezona=new TreeMap<>();
	}

	public TreeMap<String, JefeZonaDTO> getLjefezona() {
		return ljefezona;
	}

	public void setLjefezona(TreeMap<String, JefeZonaDTO> ljefezona) {
		this.ljefezona = ljefezona;
	}

	@Override
	public void crear(Object llave, EmpleadoDTO empleado) {
		ljefezona.put((String)llave, (JefeZonaDTO)empleado);
	}

	@Override
	public void actualizar(Object allave, Object nllave, EmpleadoDTO empleado) {
		ljefezona.remove((String)allave);
		ljefezona.put((String)nllave, (JefeZonaDTO)empleado);
		
	}

	@Override
	public void eliminar(Object llave) {
		ljefezona.remove((String)llave);
		
	}

	@Override
	public String mostrar() {
		StringBuilder sb=new StringBuilder("\n");
		for(JefeZonaDTO jefe: ljefezona.values()) {
			sb.append(jefe.toString()).append("\n");
		}
		return sb.toString();
	}

}
