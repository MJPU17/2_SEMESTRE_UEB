package co.edu.unbosque.model;
import java.util.ArrayList;
public class EstudianteDAO {
	String nom_arch = new String("d:/prueba/datos_estudiantes.dat");
	 static BinarioDAO DAOB = new BinarioDAO();
	    public ArrayList<EstudianteDTO> CrearEstudianteDAO(EstudianteDTO est, ArrayList <EstudianteDTO>ListaEstudiantes){
	    	if (ListaEstudiantes == null)
	    		ListaEstudiantes = new ArrayList <EstudianteDTO>();
	    	if(ListaEstudiantes.add(est)==true){
	           DAOB.Almacenar_BinarioDAO(ListaEstudiantes, nom_arch); 
	           return ListaEstudiantes;
	        }else
	            return null;

	    }
	    public EstudianteDTO ConsultarEstudianteDAO(EstudianteDTO est, ArrayList <EstudianteDTO>ListaEstudiantes){
	        
	        for(EstudianteDTO elem: ListaEstudiantes){
	            if(elem.getID()== est.getID())//Lo encontre
	                return elem;
	        }
	        return null;
	    }
	    public boolean EliminarEstudianteDAO(EstudianteDTO est, ArrayList <EstudianteDTO>ListaEstudiantes){
	         
	        for(EstudianteDTO elem: ListaEstudiantes){
	            if(elem.getID()== est.getID()){//Lo encontre
	                ListaEstudiantes.remove(elem);
	                DAOB.Almacenar_BinarioDAO(ListaEstudiantes, nom_arch); 
	                return true;
	            }
	        }
	        return false;
	    }
	    public boolean ActualizarEstudianteDAO(EstudianteDTO est, ArrayList <EstudianteDTO>ListaEstudiantes){
	        int pos=0; 
	        for(EstudianteDTO elem: ListaEstudiantes){
	            if(elem.getID()== est.getID()){//Lo encontre
	                elem.setprograma(est.getprograma());
	                ListaEstudiantes.set(pos, elem);
	                DAOB.Almacenar_BinarioDAO(ListaEstudiantes, nom_arch); 
	                return true;
	            }
	            pos++;
	        }
	        return false;
	    }
	    public EstudianteDTO ConsultarposEstudianteDAO(int pos, ArrayList <EstudianteDTO>ListaEstudiantes){
	        int i= 0;
	        if (pos >=0 && pos < ListaEstudiantes.size()){
	            for(EstudianteDTO elem: ListaEstudiantes){
	                if(i== pos)//Lo encontre
	                    return elem;
	                else
	                    i++;
	            }
	        }

	        return null;
	    }
	}

