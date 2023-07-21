package co.edu.unbosque.model;

public class Cuenta {
	private int codigo;
	private double saldo;
	private Persona titular;
	private int estado;

	public Cuenta (Persona persona, int codigo, int saldoinicial) {
		this.codigo = codigo;
		this.saldo = saldoinicial;
		this.titular = persona;
		this.estado = new EstadoCuenta().OPERATIVA;
		verificarInvariante();
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void ingreso(double cantidad) {
		this.saldo += cantidad;
	}
	
	private void verificarInvariante() {
		assert this.titular != null : "El titular no puede ser nulo";
		assert this.codigo != 0 : "el código debe ser diferente de cero";
		assert this.saldo >=0 : "El saldo debe ser mayor que cero";
	}
	
}
