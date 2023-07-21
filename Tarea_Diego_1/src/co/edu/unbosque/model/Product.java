package co.edu.unbosque.model;

import java.util.Objects;

public class Product {
	
	private int id;
	private String name;
	private String brand;
	private double price;
	private String distribution;
	private int quantity;
	
	public Product(int id,String name,String brand,double price,String distribution,int quantity) {
		this.id=id;
		this.name=name;
		this.brand=brand;
		this.price=price;
		this.distribution=distribution;
		this.quantity=quantity;
	}
	
	public Product() {
		id=0;
		name="";
		brand="";
		price=0.0;
		distribution="";
		quantity=0;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDistribution() {
		return distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

}
