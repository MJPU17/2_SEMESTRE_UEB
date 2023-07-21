
public class VehiculoTurismo extends Vehiculo {
	
	private int numeroPuertas;

	public VehiculoTurismo(String placa, String marca, String modelo, int numeroPuertas) {
		super(placa, marca, modelo);
		this.numeroPuertas = numeroPuertas;
	}
	
	@Override
	public String mostrarDatos() {
		String datos = super.mostrarDatos() + numeroPuertas;	
		return datos;
	}	

	public int getnumeroPuertas() {
		return numeroPuertas;
	}

	public void setnumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	
	

}
