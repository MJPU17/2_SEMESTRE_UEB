package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

public class PasaporteDTO implements Serializable{
	
	private static final long serialVersionUID = 5561801580049278064L;
	private String nombre;
	private LocalDate fnacimiento;
	private String pais;
	private String foto;
	private boolean admitido;
	
	public PasaporteDTO() {
		nombre="";
		fnacimiento=LocalDate.now();
		pais="";
		foto="";
		admitido=false;
	}

	public PasaporteDTO(String nombre, LocalDate fnacimiento, String pais, String foto) {
		super();
		this.nombre = nombre;
		this.fnacimiento = fnacimiento;
		this.pais = pais;
		this.foto = foto;
		this.admitido =generarAdmicion(pais);
	}
	
	public long calcularEdadAnios() {
		return ChronoUnit.YEARS.between(fnacimiento,LocalDate.now());
	}
	
	public long calcularEdadMeses() {
		return ChronoUnit.MONTHS.between(fnacimiento,LocalDate.now());
	}
	
	public long calcularEdadDias() {
		return ChronoUnit.DAYS.between(fnacimiento,LocalDate.now());
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Nombre: ").append(nombre).append("\n");
		sb.append("Fecha nacimiento: ").append(fnacimiento.toString()).append("\n");
		sb.append("Pais: ").append(pais).append("\n");
		return sb.toString();
	}
	
	public boolean generarAdmicion(String pais) {
		HashSet<String>rechazados=new HashSet<>();
		String[] aux= {"Rusia","Corea del norte","Guinea ecuatorial","Somalia","Australia"};
		rechazados.addAll(Arrays.asList(aux));
		if(rechazados.contains(pais)) {
			return false;
		}
		return true;
	}

	public String getNombre() {
		return nombre;
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean isAdmitido() {
		return admitido;
	}

	public void setAdmitido(boolean admitido) {
		this.admitido = admitido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
