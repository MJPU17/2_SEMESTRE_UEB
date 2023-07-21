package co.edu.unbosque.model;

public class FiestaDTO {
	
	private long cedula;
	private int invitados;
	private int horas;
	
	public FiestaDTO() {
		cedula=0;
		invitados=0;
		horas=0;
	}

	public FiestaDTO(long cedula, int invitados, int horas) {
		this.cedula = cedula;
		this.invitados = invitados;
		this.horas = horas;
	}
	
	public long calcularPrecio() {
		long precio=0;
		if(invitados<=20) {
			precio+=1200000;
		}
		else if(invitados>=21&&invitados<=40) {
			precio+=2000000;
		}
		else if(precio>40) {
			precio+=3000000;
		}
		
		if(horas>=1&&horas<=3) {
			precio+=2000000;
		}
		else if(horas>=4&&horas<=6) {
			precio+=4000000;
		}
		else if(horas>=6) {
			precio+=5000000;
		}
		return precio;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Cedula contratante: ").append(cedula).append("\n");
		sb.append("Cantidad invitados: ").append(invitados).append("\n");
		sb.append("Horas: ").append(horas).append("\n");
		sb.append("Monto a cancelar: ").append(calcularPrecio()).append("\n");
		return sb.toString();
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public int getInvitados() {
		return invitados;
	}

	public void setInvitados(int invitados) {
		this.invitados = invitados;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

}
