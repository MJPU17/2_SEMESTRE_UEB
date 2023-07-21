package co.edu.unbosque.model;

import java.util.Objects;
import java.util.TreeMap;

import co.edu.unbosque.model.persistence.FileHandler;

public class VehicleDAO implements OperacionesDAO{
	
	private TreeMap<String, VehicleDTO> lvehicles;
	
	public VehicleDAO() {
		try {
			if(!Objects.isNull(FileHandler.leerSerializado("vehicle.mjpu"))) {
				lvehicles=cargarDesdeArchivo();
			}
			else {
				lvehicles=new TreeMap<>();
			}
		}
		catch (Exception e) {
			lvehicles=new TreeMap<>();
			e.printStackTrace();
		}
	}

	@Override
	public void create(VehicleDTO vehicle) {
		lvehicles.put(vehicle.getPlaque(), vehicle);
		guardarEnArchivo();
	}

	@Override
	public void update(String aplaque, String nplaque, VehicleDTO vehicle) {
		lvehicles.remove(aplaque);
		lvehicles.put(nplaque, vehicle);
		guardarEnArchivo();
		
	}

	@Override
	public void remove(String plaque) {
		lvehicles.remove(plaque);
		guardarEnArchivo();
	}

	public TreeMap<String, VehicleDTO> getLvehicles() {
		return lvehicles;
	}

	public void setLvehicles(TreeMap<String, VehicleDTO> lvehicles) {
		this.lvehicles = lvehicles;
	}
	
	public TreeMap<String, VehicleDTO> cargarDesdeArchivo(){
		return (TreeMap<String, VehicleDTO>)FileHandler.leerSerializado("vehicle.mjpu");
	}
	
	public void guardarEnArchivo() {
		FileHandler.escribirSerializado("vehicle.mjpu", lvehicles);
	}

}
