package co.edu.unbosque.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView {
	
	private BufferedReader br;
	
	public ConsoleView() {
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void showInformation(String information) {
		System.out.println(information);
	}
	
	public int reedInteger(String message) throws IOException{
		int aux=0;
		System.out.println(message);
		aux=Integer.parseInt(br.readLine());
		return aux;
	}
	
	public String reedInformation(String message) throws IOException{
		String aux="";
		System.out.println(message);
		aux=br.readLine();
		return aux;
	}

}
