package co.edu.unbosque.model;

public class Profesor extends Empleado{

	private String departamento;
	
	public Profesor() {
		super();
		departamento="";
	}
	
	public Profesor(String nombres ,String apellidos ,long num_ide, String est_civil,int ano_incorp, int num_desp,String departamento) {
		super(nombres, apellidos, num_ide, est_civil, ano_incorp, num_desp);
		this.departamento=departamento;
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
			   "Departamento: "+departamento;
	}
	
	@Override
	public void calcularSueldo() {
		long sueldo=6000000;
		if(getAno_incorp()<2000) {
			sueldo+=(8*sueldo/100);
		}
		setSueldo(sueldo);
	}

	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
