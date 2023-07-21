


public class Principal {

	public static void main(String[] args) {
		
		Vehiculo misVehiculos[] = new Vehiculo[4];
		
		misVehiculos[0] = new Vehiculo("GH67","Ferrari","A89"); 
		misVehiculos[1]= new VehiculoTurismo("78HJ","Audi","H89",4);  
		misVehiculos[2]= new VehiculoDeportivo("89SD","BMW","I19",300);
		misVehiculos[3]= new VehiculoFurgoneta("65RT","Mazda","P13",5000);
		
		for(Vehiculo vehiculos: misVehiculos) {
			System.out.println(vehiculos.mostrarDatos());
			System.out.println("");
		}
	}

	
}
