package co.edu.unbosque.model;

public class AprendizSena extends Empleado{
	
	protected final float factorSalario;
	
	public AprendizSena() {
		super();
		factorSalario=(float) 0.50;
	}
	
	public AprendizSena(long id,String nombre,long celular,int edad) {
		super(id, nombre, celular, edad);
		factorSalario=(float)0.50;
	}

	@Override
	public long calcularSueldo(int diastrab) {
		long sueldo=0;
		if(diastrab>=30) {
			sueldo=(long) (1100000*factorSalario);
		}else if(diastrab<30){
			sueldo=(long) (1100000*factorSalario-20000);
		}
		return sueldo;
	}

}
