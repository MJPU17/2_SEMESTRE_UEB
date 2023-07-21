package co.edu.unbosque.model;

import java.util.ArrayList;

public class JefeZona extends Empleado{
	
	private String zona;
	private ArrayList<Long> listav;
	
	public JefeZona() {
		super();
		zona="";
		listav=new ArrayList<>();
	}
	
	public JefeZona(long cedula,String nombre,String cargo,long salario,String zona) {
		super(cedula, nombre, cargo, salario);
		this.zona=zona;
	}
	
	public boolean containsID(long n_id) {
		for(Long id: listav) {
			if(id==n_id) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarVendedor(long id) {
		listav.add(id);
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public String getZona() {
		return zona;
	}

	public ArrayList<Long> getListav() {
		return listav;
	}

	public void setListav(ArrayList<Long> listav) {
		this.listav = listav;
	}

	
	
	
	
}
