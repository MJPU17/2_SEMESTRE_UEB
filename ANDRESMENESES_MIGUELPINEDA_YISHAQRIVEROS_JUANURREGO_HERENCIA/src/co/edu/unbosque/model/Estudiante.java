package co.edu.unbosque.model;

public class Estudiante extends Persona{
	
	private String curso;
	
	public Estudiante() {
		super();
		curso="";
	}
	
	public Estudiante(String nombres ,String apellidos ,long num_ide, String est_civil,String curso) {
		super(nombres, apellidos, num_ide, est_civil);
		this.curso=curso;
	}
	
	@Override
	public String toString() {
		return "Nombres: "+getNombres()+"\n"+
               "Apellidos: "+getApellidos()+"\n"+
		       "Numero identificacion: "+getNum_ide()+"\n"+
               "Estado civil: "+getEst_civil()+"\n"+
		       "Curso: "+curso;
	}
	
	public void matriculacionCurso(String curso) {
		this.curso+=(","+curso);
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
