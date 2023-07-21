package co.edu.unbosque.model;

public abstract class Empleado extends Persona{
	
	private int ano_incorp;
	private int num_desp;
	private long sueldo;
	
	public Empleado() {
		super();
		ano_incorp=0;
		num_desp=0;
		sueldo=0;
	}
	
	public Empleado(String nombres, String apellidos, long num_ide, String est_civil, int ano_incorp, int num_desp) {
		super(nombres, apellidos, num_ide, est_civil);
		this.ano_incorp=ano_incorp;
		this.num_desp=num_desp;
		this.sueldo=0;
	}

	@Override
	public abstract String toString();
	
	public abstract void calcularSueldo();

	public int getAno_incorp() {
		return ano_incorp;
	}

	public void setAno_incorp(int ano_incorp) {
		this.ano_incorp = ano_incorp;
	}

	public int getNum_desp() {
		return num_desp;
	}


	public void setNum_desp(int num_desp) {
		this.num_desp = num_desp;
	}

	public long getSueldo() {
		return sueldo;
	}

	public void setSueldo(long sueldo) {
		this.sueldo = sueldo;
	}

}
