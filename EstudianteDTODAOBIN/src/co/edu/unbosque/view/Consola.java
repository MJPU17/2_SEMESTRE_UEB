package co.edu.unbosque.view;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Consola {
	 int msg_default;
	    public Consola(){
	    }
	    
	    public void mostrar_mensaje(String mensaje){
	        System.out.print(mensaje);
	    }
	    
	    public void mostrar_mensaje_line(String mensaje){
	        System.out.println(mensaje);
	    }

	     public int capturar_entero()throws InputMismatchException{
	        int num;
	        Scanner leer = new Scanner(System.in);
	        try{
	            num = leer.nextInt();
	        }catch(InputMismatchException e){
	          //En caso de error en digitación se retorna numero 0 del cual no hay opcion de menu
	        	num = 0;
	        }
	        return num;
	    }
	    public void mostrar_entero(int N){
	        System.out.print(N);
	    }
	    public long capturar_enterolargo() throws InputMismatchException{
	        long num;
	        Scanner leer = new Scanner(System.in);
	        try{
	            num = leer.nextLong();
	        }catch(InputMismatchException e){
	            num = 0;
	        }
	        return num;
	    }
	    public void mostrar_enterolargo(long N){
	        System.out.print(N);
	    }
	    public char capturar_caracter(){
	        Scanner leer = new Scanner(System.in);
	        return (leer.next().charAt(0));
	    }
	    public void mostrar_caracter(char N){
	        System.out.print(N);
	    }
	    public String capturar_cadena(){
	    	Scanner leer = new Scanner(System.in);
	        
	    	return (leer.next());
	    }
	    public String capturar_cadena_larga(){
	    	Scanner leer = new Scanner(System.in);
	        
	    	return (leer.nextLine());
	    }
	    public int menu(){
	        int opcion;
	        mostrar_mensaje("MENU\n"+
	        "1. Crear Estudiante\n"+
	        "2. Consultar Estudiante\n"+ 
	        "3. Actualizar Estudiante\n"+
	        "4. Eliminar Estudiante\n"+
	        "5. Listar Estudiantes\n"+
	        "6. Salir\n"+
	        "Digite la Opción: ");
	        opcion = capturar_entero();
	        return opcion;
	    }
	    
	    

	}
