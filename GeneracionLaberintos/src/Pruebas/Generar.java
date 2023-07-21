package Pruebas;

public class Generar {
	
	private Laberintos prueba;
	private char [][] camino;
	private String imprimir;
	String solucion;
	
	public Generar() {
		prueba= new Laberintos(20,20);
		imprimir="";
		prueba.asegurarCamino();
		camino=prueba.getRepreslab();
		for(int i=0;i<prueba.getFil();i++) {
			for(int u=0;u<prueba.getCol();u++) {
			imprimir=imprimir+camino[i][u];
			
			}
			imprimir=imprimir+"\n";
		}
		System.out.println(imprimir);
		System.out.println("Los intentos fueron:"+prueba.getIntentos());
		}

}
