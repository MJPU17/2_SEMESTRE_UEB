package co.edu.unbosque.model;

public class Practicante extends Empleado{
	
	protected final float factorSalario;
	
	public Practicante() {
		super();
		factorSalario=(float)0.75;
	}
	
	public Practicante(long id,String nombre,long celular,int edad) {
		super(id, nombre, celular, edad);
		factorSalario=(float)0.75;
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
