package co.edu.unbosque.model;

import java.util.TreeMap;

public class Facultad {
	
	private TreeMap<Long, Profesor> lprofesores;
	private TreeMap<Long, Personal_servicio> lpersonales_servicios;
	private TreeMap<Long, Estudiante> lestudiantes;
	private TreeMap<Long, Empleado> lempleados;
	
	public Facultad() {
		lprofesores=new TreeMap<>();
		lpersonales_servicios=new TreeMap<>();
		lestudiantes=new TreeMap<>();
		lempleados=new TreeMap<>();
	}
	
	public void darAlta(Profesor a) {
		lprofesores.put(a.getNum_ide(), a);
		lempleados.put(a.getNum_ide(), a);
	}
	
	public void darAlta(Personal_servicio b) {
		lpersonales_servicios.put(b.getNum_ide(), b);
		lempleados.put(b.getNum_ide(), b);
	}
	
	public void darAlta(Estudiante c) {
		lestudiantes.put(c.getNum_ide(), c);
	}
	
	public void darBaja(Long dni) {
		if(lprofesores.containsKey(dni)&&lempleados.containsKey(dni)) {
			lprofesores.remove(dni);
			lempleados.remove(dni);
		}
		else if(lpersonales_servicios.containsKey(dni)&&lempleados.containsKey(dni)) {
			lpersonales_servicios.remove(dni);
			lempleados.remove(dni);
		}
		else if(lestudiantes.containsKey(dni)) {
			lestudiantes.remove(dni);
		}
	}
	
	public boolean comprobarDNI(Long dni) {
		if(lprofesores.containsKey(dni)||lpersonales_servicios.containsKey(dni)||lestudiantes.containsKey(dni)) {
			return true;
		}
		return false;
	}
	
	public Persona obtenerPersona(Long dni) {
		if(lestudiantes.containsKey(dni)) {
			return lestudiantes.get(dni);
		}
		else if(lprofesores.containsKey(dni)) {
			return lprofesores.get(dni);
		}
		else if(lpersonales_servicios.containsKey(dni)) {
			return lpersonales_servicios.get(dni);
		}
		return null;
	}
	
	
	public String[][] tablaEstudiantes() {
		String[][] testudiantes=new String[lestudiantes.size()+1][5];
		String[] datos= {"DNI","Nombres","Apellidos","Estado civil","Curso"};
		testudiantes[0]=datos;
		int i=1;
		for(Long dni: lestudiantes.keySet()) {
			testudiantes[i][0]=""+lestudiantes.get(dni).getNum_ide();
			testudiantes[i][1]=""+lestudiantes.get(dni).getNombres();
			testudiantes[i][2]=""+lestudiantes.get(dni).getApellidos();
			testudiantes[i][3]=""+lestudiantes.get(dni).getEst_civil();
			testudiantes[i][4]=""+lestudiantes.get(dni).getCurso();
			i++;
		}
		return testudiantes;
	}
	
	public String[][] tablaProfesores(){
		String[][] tprofesores=new String[lprofesores.size()+1][7];
		String[] datos= {"DNI","Nombres","Apellidos","Estado civil","Incorporacion","Despacho","Departamento"};
		tprofesores[0]=datos;
		int i=1;
		for(Long dni: lprofesores.keySet()) {
			tprofesores[i][0]=""+lprofesores.get(dni).getNum_ide();
			tprofesores[i][1]=""+lprofesores.get(dni).getNombres();
			tprofesores[i][2]=""+lprofesores.get(dni).getApellidos();
			tprofesores[i][3]=""+lprofesores.get(dni).getEst_civil();
			tprofesores[i][4]=""+lprofesores.get(dni).getAno_incorp();
			tprofesores[i][5]=""+lprofesores.get(dni).getNum_desp();
			tprofesores[i][6]=""+lprofesores.get(dni).getDepartamento();
			i++;
		}
		return tprofesores;
	}
	
	public String[][] tablaPersonalServicio(){
		String[][] tservicio=new String[lpersonales_servicios.size()+1][7];
		String[] datos= {"DNI","Nombres","Apellidos","Estado civil","Incorporacion","Despacho","Seccion"};
		tservicio[0]=datos;
		int i=1;
		for(Long dni: lpersonales_servicios.keySet()) {
			tservicio[i][0]=""+lpersonales_servicios.get(dni).getNum_ide();
			tservicio[i][1]=""+lpersonales_servicios.get(dni).getNombres();
			tservicio[i][2]=""+lpersonales_servicios.get(dni).getApellidos();
			tservicio[i][3]=""+lpersonales_servicios.get(dni).getEst_civil();
			tservicio[i][4]=""+lpersonales_servicios.get(dni).getAno_incorp();
			tservicio[i][5]=""+lpersonales_servicios.get(dni).getNum_desp();
			tservicio[i][6]=""+lpersonales_servicios.get(dni).getSeccion();
			i++;
		}
		return tservicio;
	}
	
	public String[][] tablaEmpleados(){
		String[][] templados=new String[lempleados.size()+1][5];
		String[] datos= {"DNI","Nombres","Apellidos","Cargo","Sueldo"};
		templados[0]=datos;
		int i=1;
		for(Long dni: lempleados.keySet()) {
			templados[i][0]=""+lempleados.get(dni).getNum_ide();
			templados[i][1]=""+lempleados.get(dni).getNombres();
			templados[i][2]=""+lempleados.get(dni).getApellidos();
			templados[i][4]=""+lempleados.get(dni).getSueldo();
			if(lprofesores.containsKey(dni)) {
				templados[i][3]="Profesor";
			}else {
				templados[i][3]="Personal servicio";
			}
			i++;
		}
		return templados;
	}

	public TreeMap<Long, Profesor> getLprofesores() {
		return lprofesores;
	}

	public void setLprofesores(TreeMap<Long, Profesor> lprofesores) {
		this.lprofesores = lprofesores;
	}

	public TreeMap<Long, Personal_servicio> getLpersonales_servicios() {
		return lpersonales_servicios;
	}

	public void setLpersonales_servicios(TreeMap<Long, Personal_servicio> lpersonales_servicios) {
		this.lpersonales_servicios = lpersonales_servicios;
	}

	public TreeMap<Long, Estudiante> getLestudiantes() {
		return lestudiantes;
	}

	public void setLestudiantes(TreeMap<Long, Estudiante> lestudiantes) {
		this.lestudiantes = lestudiantes;
	}

	public TreeMap<Long, Empleado> getLempleados() {
		return lempleados;
	}

	public void setLempleados(TreeMap<Long, Empleado> lempleados) {
		this.lempleados = lempleados;
	}

}
