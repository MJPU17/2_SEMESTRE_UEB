package co.edu.unbosque.controller;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;
import java.util.ArrayList;
public class Controller {
	public Controller() {
	}
	
	public void run() {
	int opcion;
	EstudianteDTO est = new EstudianteDTO(0," ", " ", " ");
	ArrayList <EstudianteDTO> ListaEstudiantes = new ArrayList<EstudianteDTO>();
	Consola con = new Consola();
	EstudianteDTO estDTO = new EstudianteDTO();
	EstudianteDAO estDAO = new EstudianteDAO();
	BinarioDAO DAOB = new BinarioDAO();
	ListaEstudiantes = DAOB.Importar_BinarioDAO("d:/prueba/datos_estudiantes.dat");
    do{
        opcion = con.menu();
        switch(opcion){
        case 1:	estDTO = estDTO.CrearEstudianteDTO();
        ListaEstudiantes = estDAO.CrearEstudianteDAO(estDTO, ListaEstudiantes);
        if (ListaEstudiantes == null)
        	con.mostrar_mensaje_line("ERROR AL CREAR LISTA VACIA!!");
        break;
        	
        case 2: estDTO = estDTO.LeerEstudianteDTO();
        		estDTO = estDAO.ConsultarEstudianteDAO(estDTO, ListaEstudiantes);
        		if (estDTO != null)
        				con.mostrar_mensaje_line(estDTO.toString());
        		break;
        case 3: estDTO = estDTO.ActualizarEstudianteDTO();
        		if(estDAO.ActualizarEstudianteDAO(estDTO, ListaEstudiantes)==true){
        			con.mostrar_mensaje_line("Actualización EXITOSA!!");
        		}else{
        			con.mostrar_mensaje_line("No se realizó la Actualización!!");
        		}
        		break;
        case 4: estDTO = estDTO.EliminarEstudianteDTO();
        		if (estDAO.EliminarEstudianteDAO(estDTO, ListaEstudiantes)==true){
        			con.mostrar_mensaje_line("Eliminación EXITOSA!!");
        		}else{
        			con.mostrar_mensaje_line("No se realizó la Eliminación!!");
        		}
        		break;
        case 5: int i=0;
        		System.out.println("tamaño Lista="+ListaEstudiantes.size());
        		while (true){
        			estDTO = estDAO.ConsultarposEstudianteDAO(i++,ListaEstudiantes);
        			if (estDTO == null)
        				break;
        			else
        				con.mostrar_mensaje_line(estDTO.toString());
        		}       
        		break;
        }

    }while(opcion!=6);
    con.mostrar_mensaje("Hasta Pronto.");
}

}
