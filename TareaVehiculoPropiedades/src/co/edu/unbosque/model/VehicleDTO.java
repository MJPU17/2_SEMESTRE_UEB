package co.edu.unbosque.model;

import java.io.Serializable;

public class VehicleDTO implements Serializable{

	private static final long serialVersionUID = 9160086447423958703L;
	private String plaque;
	private String brand;
	private String model;
	private String color;
	
	public VehicleDTO() {
		plaque="";
		brand="";
		model="";
		color="";
	}

	public VehicleDTO(String plaque, String brand, String model, String color) {
		this.plaque = plaque;
		this.brand = brand;
		this.model = model;
		this.color = color;
	}

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
