package co.edu.unbosque.model;
import java.io.Serializable;
import co.edu.unbosque.view.*;
public class EstudianteDTO implements Serializable{
	private static final long serialVersionUID = 1095827248314682118L;
    long ID;
    String nombres;
    String apellidos;
    String programa;
    public EstudianteDTO()
    {
    }
    
    public EstudianteDTO(long i, String n, String a, String prog){
        ID = i;
        nombres = new String (n);
        apellidos = new String (a);
        programa= new String (prog);
    }
    public void setID(long i){
        ID = i;
    }
    public void setnombres(String n){
        nombres = n;
    }
    public void setapellidos(String a){
        apellidos = a;
    }
    public void setprograma(String prog){
        programa = prog;
    }
    public long getID(){
        return ID ;
    }
    public String getnombres(){
        return nombres;
    }
    public String getapellidos(){
        return apellidos;
    }
    public String getprograma(){
        return programa;
    }
    public String toString(){
        return ("ID:"+ID+" Nombres:"+nombres+" Apellidos:"+apellidos+" Programa:"+programa);
    }

    public EstudianteDTO CrearEstudianteDTO(){
        Consola con = new Consola();
        long i;
        String nom = new String();
        String ape = new String();
        char e;
        String prog = new String();
        
        con.mostrar_mensaje_line("Solicitud Datos del Estudiante");
        con.mostrar_mensaje("ID: ");
        i = con.capturar_enterolargo();
        con.mostrar_mensaje("Nombres: ");
        nom = con.capturar_cadena_larga();
       // nom = con.capturar_cadena_larga();
        con.mostrar_mensaje("Apellidos: ");
        ape = con.capturar_cadena_larga();
        con.mostrar_mensaje("Programa: ");
        prog = con.capturar_cadena_larga();
    //    prog = con.capturar_cadena_larga();
        EstudianteDTO est = new EstudianteDTO(i, nom, ape, prog);
        return est;
    }
    public EstudianteDTO LeerEstudianteDTO(){
        Consola con = new Consola();
        con.mostrar_mensaje_line("Solicitud Datos del Estudiante a Leer");
        con.mostrar_mensaje("ID: ");
        long i = con.capturar_enterolargo();
        
        EstudianteDTO est = new EstudianteDTO(i, " ", " ", " ");
        return est;
    }
    public EstudianteDTO EliminarEstudianteDTO(){
    	long i;
        Consola con = new Consola();
        con.mostrar_mensaje_line("Solicitud Datos del Estudiante a Eliminar");
        con.mostrar_mensaje("ID: ");
        i = con.capturar_enterolargo();
        
        EstudianteDTO est = new EstudianteDTO(i, " ", " ", " ");
        return est;
    }
    public EstudianteDTO ActualizarEstudianteDTO(){
        long i;
        String prog = new String();
    	Consola con = new Consola();
        con.mostrar_mensaje_line("Solicitud Datos del Estudiante a Actualizar");
        con.mostrar_mensaje("ID: ");
        i = con.capturar_enterolargo();
        con.mostrar_mensaje("Programa nuevo: ");
        prog = con.capturar_cadena();
        EstudianteDTO est = new EstudianteDTO(i, " ", " ", prog);
        return est;
    }


}


