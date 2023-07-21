package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.model.persistence.FileHandler;

public class FiestaDAO {
	
	private ArrayList<FiestaDTO> lfiestas;
	
	public FiestaDAO() {
		try {
			lfiestas=cargarDesdeArchivo();
		}catch (Exception e) {
			lfiestas=new ArrayList<>();
			e.printStackTrace();
		}
	}
	
	public ArrayList<FiestaDTO> cargarDesdeArchivo(){
		ArrayList<FiestaDTO> archivo=new ArrayList<>();
		String[] filas=FileHandler.leerArchivo("fiestas_mes.txt").split("\n");
		int j=1;
		long cedula=0;
		int invitados=0,horas=0;
		for(int i=0;i<filas.length;i++) {
			if(j==1) {
				cedula=Long.parseLong(filas[i]);
				j++;
			}
			else if(j==2) {
				invitados=Integer.parseInt(filas[i]);
				j++;
			}
			else if(j==3) {
				horas=Integer.parseInt(filas[i]);
				j++;
			}
			if(j==4) {
				archivo.add(new FiestaDTO(cedula, invitados, horas));
				j=1;
			}
			
		}
		return archivo;
	}
	
	public String mostrar() {
		StringBuilder sb=new StringBuilder();
		int num=1;
		for (FiestaDTO fiesta : lfiestas) {
			sb.append("\n__________________________\n");
			sb.append("Fiesta "+num+" \n");
			sb.append(fiesta.toString());
			num++;
		}
		return sb.toString();
	}
	
	public long totalInvitados() {
		long total=0;
		for(FiestaDTO fiesta : lfiestas) {
			total+=fiesta.getInvitados();
		}
		return total;
	}
	
	public long totalHoras() {
		long horas=0;
		for(FiestaDTO fiesta : lfiestas) {
			horas+=fiesta.getHoras();
		}
		return horas;
	}
	
	public int[] totalFiestas() {
		int[] fiestas=new int [3];
		for(FiestaDTO fiesta : lfiestas) {
			if(fiesta.getHoras()>=1&&fiesta.getHoras()<=3) {
				fiestas[0]++;
			}
			else if(fiesta.getHoras()>=4&&fiesta.getHoras()<=6) {
				fiestas[1]++;
			}
			else if(fiesta.getHoras()>6) {
				fiestas[2]++;
			}
		}
		return fiestas;
	}
	
	public long mayorValorPagado() {
		long mayor=0;
		for(FiestaDTO fiesta : lfiestas) {
			if(fiesta.calcularPrecio()>mayor) {
				mayor=fiesta.calcularPrecio();
			}
		}
		return mayor;
	}
	
	public long menorValorPagado() {
		long menor=0;
		if(lfiestas.size()>0) {
			menor=lfiestas.get(0).calcularPrecio();
			for(FiestaDTO fiesta : lfiestas) {
				if(fiesta.calcularPrecio()<menor) {
					menor=fiesta.calcularPrecio();
				}
			}
		}
		return menor;
	}
	
}
