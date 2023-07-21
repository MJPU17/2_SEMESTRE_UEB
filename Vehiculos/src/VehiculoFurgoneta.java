
public class VehiculoFurgoneta extends Vehiculo {
	
	private int carga;

	public VehiculoFurgoneta(String placa, String marca, String modelo, int carga) {
		super(placa, marca, modelo);
		this.carga = carga;
	}

	@Override
	public String mostrarDatos() {
		String datos = super.mostrarDatos() + carga;	
		return datos;
	}	
	
	public int getcarga() {
		return carga;
	}

	public void setcarga(int carga) {
		this.carga = carga;
	}
	
	

}
