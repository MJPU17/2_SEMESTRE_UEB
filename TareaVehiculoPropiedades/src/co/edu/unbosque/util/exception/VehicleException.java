package co.edu.unbosque.util.exception;

import java.util.Properties;

public class VehicleException extends Exception{
	
	private int error;
	private Properties properties;
	
	public VehicleException(int error,Properties properties) {
		super();
		this.error=error;
		this.properties=properties;
	}
	
	@Override
	public String getMessage() {
		switch (error) {
		case 1:{
			return properties.getProperty("translator.vehicleexception.one");
		}
		case 2:{
			return properties.getProperty("translator.vehicleexception.two");
		}
		case 3:{
			return properties.getProperty("translator.vehicleexception.three");
		}
		case 4:{
			return properties.getProperty("translator.vehicleexception.four");
		}
		}
		return properties.getProperty("translator.vehicleexception.default");
	}
}
