package co.edu.unbosque.model;

public class Personal_servicio extends Empleado{
	
	private String seccion;
	
	public Personal_servicio() {
		super();
		seccion="";
	}
	
	public Personal_servicio(String nombres, String apellidos, long num_ide, String est_civil, int ano_incorp, int num_desp, String seccion) {
		super(nombres, apellidos, num_ide, est_civil, ano_incorp, num_desp);
		this.seccion=seccion;
	}

	@Override
	public String toString() {
		return "Nombres: "+getNombres()+"\n"+
		       "Apellidos: "+getApellidos()+"\n"+
			   "Numero identificacion: "+getNum_ide()+"\n"+
		       "Estado civil: "+getEst_civil()+"\n"+
			   "Año incorporacion: "+getAno_incorp()+"\n"+
		       "Numero despacho: "+getNum_desp()+"\n"+
		       "Sueldo: "+getSueldo()+"\n"+
			   "Seccion: "+seccion;
	}
	
	@Override
	public void calcularSueldo() {
		long sueldo=1000000;
		if(getEst_civil().equals("Casado/a")) {
			sueldo+=(5*sueldo/100);
		}
		setSueldo(sueldo);
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	

}
