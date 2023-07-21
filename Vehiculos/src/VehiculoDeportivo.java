
public class VehiculoDeportivo extends Vehiculo {
	
	private int cilindraje;

	public VehiculoDeportivo(String placa, String marca, String modelo, int cilindraje) {
		super(placa, marca, modelo);
		this.cilindraje = cilindraje;
	}
	@Override
	public String mostrarDatos() {
		String datos = super.mostrarDatos() + cilindraje;	
		return datos;
	}	

	public int getcilindraje() {
		return cilindraje;
	}

	public void setcilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	

}
