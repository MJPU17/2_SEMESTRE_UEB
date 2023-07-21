package co.edu.unbosque.model;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;//indica que abrira un archivo con canal de llegada al archivo
import java.io.ObjectOutputStream;//convierte la info de un objeto a una serie de bytes
import java.io.FileInputStream; //indica canal de info desde archivo
import java.io.ObjectInputStream; //convierte una serie de bytes en un objeto especificado
public class BinarioDAO {


    public BinarioDAO(){
    }
    public void Almacenar_BinarioDAO(ArrayList <EstudianteDTO>ListaEstudiantes, String path){
        
        ObjectOutputStream objeto_out_stream=null;
        try{
            objeto_out_stream = new ObjectOutputStream(new FileOutputStream(path));
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(IOException e2) {
            System.out.println(e2.getMessage());
        
        }finally{
        
            //int i= 0;
            for(EstudianteDTO elem: ListaEstudiantes){
                try{
                    objeto_out_stream.writeObject(elem);
                }catch(IOException e1) {
                    System.out.println(e1.getMessage());
                }
            }
            try{
                objeto_out_stream.close();  // Se cierra al terminar.
            }catch(IOException e2) {
                System.out.println(e2.getMessage());
        
            }
        }

    }
    public ArrayList <EstudianteDTO> Importar_BinarioDAO(String path){
        ArrayList <EstudianteDTO>Lista = new ArrayList <EstudianteDTO>();
        ObjectInputStream objeto_input_stream = null;
        EstudianteDTO aux = new EstudianteDTO();
        try{
            objeto_input_stream= new ObjectInputStream(new FileInputStream("d:/prueba/datos_estudiantes.dat"));    //Se lee el primer objeto que debe tener la cabecera de los datos, si no se amacenó
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }catch(IOException e1) {
            System.out.println(e1.getMessage());
        }
    
        
        while (true)
        {
            try{
                aux = (EstudianteDTO)objeto_input_stream.readObject();
                if (aux != null)
                    Lista.add(aux);
            }catch(IOException e2) {
                //System.out.println("Termino de leer las Lineas del archivo "+e2.getMessage());
                break;
            }catch( ClassNotFoundException e4){
                System.out.println(e4.getMessage());
            }
        }
        
        try{
            objeto_input_stream.close();
        }catch(IOException e1) {
                System.out.println(e1.getMessage());
        }
        return Lista;
    }    
}
