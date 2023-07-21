package co.edu.unbosque.model;

import java.util.LinkedList;

public class JefeZonaDTO extends EmpleadoDTO{
	
	private String zona;
	private LinkedList<Long> lid_vendedores;
	
	public JefeZonaDTO() {
		super();
		zona="";
		lid_vendedores=new LinkedList<>();
	}

	public JefeZonaDTO(long cedula, String nombre, String cargo, long salario,String zona) {
		super(cedula, nombre, cargo, salario);
		this.zona = zona;
		this.lid_vendedores = new LinkedList<>();
	}
	
	public int indexVendedor(long cedula) {
		for(int i=0;i<lid_vendedores.size();i++) {
			if(lid_vendedores.get(i)==cedula) {
				return i;
			}
		}
		return -1;
	}
	
	public void eliminarVendedor(int index) {
		lid_vendedores.remove(index);
	}
	
	public void agregarVendedor(long cedula) {
		lid_vendedores.add(cedula);
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(super.toString());
		sb.append("Zona: ").append(zona).append("\n");
		sb.append("Vendeores a su cargo: ").append(lid_vendedores.size()).append("\n");
		return sb.toString();
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public LinkedList<Long> getLid_vendedores() {
		return lid_vendedores;
	}

	public void setLid_vendedores(LinkedList<Long> lid_vendedores) {
		this.lid_vendedores = lid_vendedores;
	}

}
