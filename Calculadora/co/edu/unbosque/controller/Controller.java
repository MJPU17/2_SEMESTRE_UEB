package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import co.edu.unbosque.model.Operaciones;
import co.edu.unbosque.view.MensajesEmergentes;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener{
	
	private VentanaPrincipal vista;
	
	public Controller() {
		vista=new VentanaPrincipal();
		asignarOyentes();
	}

	private void asignarOyentes() {
		
		for(int y=0;y<5;y++) {
			for(int x=0;x<4;x++) {
				vista.getPdatos().getBcalculadora()[y][x].addActionListener(this);
			}
		}
		
		vista.getPdatos().getBborrar().addActionListener(this);
		vista.getPdatos().getBquitar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando=e.getActionCommand();
		String text=vista.getPresultado().getTresultado().getText();
		String aux="";
		boolean continuar=true;
		boolean parentesis=false;
		double res=0;
		double opuesto=0;
		int ipparentesis=0;
		int fpparentesis=0;
		
		String[][]ctext= {
				{"%","/"},
				{"7","8","9","X"},
				{"4","5","6","-"},
				{"1","2","3","+"},
				{"0","."},
		};
		
		String[][] accion= {
				{"PORCENTAJE","DIVISION"},
				{"SIETE","OCHO","NUEVE","MULTIPLICACION"},
				{"CUATRO","CINCO","SEIS","MENOS"},
				{"UNO","DOS","TRES","MAS"},
				{"CERO","PUNTO"},
		};
		
		for(int y=0;y<accion.length;y++) {
			for(int x=0;x<accion[y].length;x++) {
				
				if(comando.equals(accion[y][x])) {
					
					if((ctext[y][x].equals("+")||ctext[y][x].equals("-")||ctext[y][x].equals("X")||ctext[y][x].equals("/")||ctext[y][x].equals("%")||ctext[y][x].equals("."))&&text.equals("")) {
						MensajesEmergentes.MensajeInformacion(vista, "El formato que quiere introducir no es valido.");
					}
					else if((ctext[y][x].equals("%")&&text.charAt(text.length()-1)=='%')||(ctext[y][x].equals(".")&&text.charAt(text.length()-1)=='.')||(ctext[y][x].equals(".")&&text.charAt(text.length()-1)=='%')) {
						MensajesEmergentes.MensajeInformacion(vista, "El formato que quiere introducir no es valido.");
					}
					else if((ctext[y][x].equals("+")||ctext[y][x].equals("-")||ctext[y][x].equals("X")||ctext[y][x].equals("/")||ctext[y][x].equals("%")||ctext[y][x].equals("."))&&(text.charAt(text.length()-1)=='+'||text.charAt(text.length()-1)=='-'||text.charAt(text.length()-1)=='X'||text.charAt(text.length()-1)=='/'||text.charAt(text.length()-1)=='(')){
						MensajesEmergentes.MensajeInformacion(vista, "El formato que quiere introducir no es valido.");
					}
					else {
						if(!text.equals("")) {
							if(text.charAt(text.length()-1)=='%'&&!ctext[y][x].equals("+")&&!ctext[y][x].equals("-")&&!ctext[y][x].equals("X")&&!ctext[y][x].equals("/")) {
								vista.getPresultado().getTresultado().append("X"+ctext[y][x]);
							}else if(text.charAt(text.length()-1)==')'&&!ctext[y][x].equals("+")&&!ctext[y][x].equals("-")&&!ctext[y][x].equals("X")&&!ctext[y][x].equals("/")) {
								vista.getPresultado().getTresultado().append("X"+ctext[y][x]);
							}
							else {
								vista.getPresultado().getTresultado().append(ctext[y][x]);
							}
						}else {
							vista.getPresultado().getTresultado().append(ctext[y][x]);
						}
					}
					 
					y=accion.length;
					break;
				}
			}
		}
		
		if(comando.equals("BORRAR")) {
			vista.getPresultado().getTresultado().setText("");
		}
		else if(comando.equals("QUITAR")) {
			
			if(text.length()!=0) {
				vista.getPresultado().getTresultado().setText(text.substring(0, text.length()-1));
			}
			
		}
		else if(comando.equals("IPARENTESIS")) {
			
			if(text.length()!=0) {
				if(text.charAt(text.length()-1)!='+'&&text.charAt(text.length()-1)!='-'&&text.charAt(text.length()-1)!='X'&&text.charAt(text.length()-1)!='/'&&text.charAt(text.length()-1)!='(') {
					vista.getPresultado().getTresultado().append("X(");
				}else {
					vista.getPresultado().getTresultado().append("(");
				}
			}else {
				vista.getPresultado().getTresultado().append("(");
			}

		}
		else if(comando.equals("FPARENTESIS")) {
			vista.getPresultado().getTresultado().append(")");
		}
		
		else if(comando.equals("OPUESTO")) {
			if(!text.equals("")&&text.charAt(text.length()-1)!='+'&&text.charAt(text.length()-1)!='-'&&text.charAt(text.length()-1)!='X'&&text.charAt(text.length()-1)!='/'&&text.charAt(text.length()-1)!='E'&&text.charAt(text.length()-1)!='('&&text.charAt(text.length()-1)!='%') {
				for(int i=text.length()-1;i>=0;i--) {
					if(i==0) {
						aux=text.charAt(i)+aux;
						opuesto=Operaciones.opuesto(Double.parseDouble(aux));
						if((int)opuesto-opuesto==0) {
							vista.getPresultado().getTresultado().setText(""+((int)opuesto));
						}else {
							vista.getPresultado().getTresultado().setText(""+opuesto);
						}
						break;
					}
					else if(text.charAt(i)=='(') {
						opuesto=Operaciones.opuesto(Double.parseDouble(aux));
						if((int)opuesto-opuesto==0) {
							vista.getPresultado().getTresultado().setText(text.substring(0, i+1)+((int)opuesto));
						}else {
							vista.getPresultado().getTresultado().setText(text.substring(0, i+1)+opuesto);
						}
						break;
					}
					else if((text.charAt(i)=='+'||text.charAt(i)=='-'||text.charAt(i)=='X'||text.charAt(i)=='/'||text.charAt(i)=='E')&&(text.charAt(i-1)!='+'&&text.charAt(i-1)!='-'&&text.charAt(i-1)!='X'&&text.charAt(i-1)!='/'&&text.charAt(i-1)!='E'&&text.charAt(i-1)!='(')) {
						opuesto=Operaciones.opuesto(Double.parseDouble(aux));
						if((int)opuesto-opuesto==0) {
							vista.getPresultado().getTresultado().setText(text.substring(0, i+1)+((int)opuesto));
						}else {
							vista.getPresultado().getTresultado().setText(text.substring(0, i+1)+opuesto);
						}
						break;
					}
					else {
						aux=text.charAt(i)+aux;
					}
				}
			}
			else if(!text.equals("")&&text.charAt(text.length()-1)=='%') {
				vista.getPresultado().getTresultado().append("X-");
			}
			else if(!text.equals("")&&text.charAt(text.length()-1)=='-') {
				vista.getPresultado().getTresultado().setText(text.substring(0,text.length()-1));
			}
			else {
				vista.getPresultado().getTresultado().append("-");
			}
		}
		else if(comando.equals("IGUAL")) {
			
			if(!text.equals("")) {
				
				for(int i=0;i<text.length();i++) {
					if(text.charAt(i)=='(') {
						parentesis=true;
						break;
					}
				}
				while(parentesis==true) {
					ipparentesis=text.lastIndexOf('(');
					for(int i=ipparentesis;i<text.length();i++) {
						if(text.charAt(i)==')') {
							fpparentesis=i;
							break;
						}
					}
					
					
					try {
						res=operacionesCalculadora(text.substring(ipparentesis+1, fpparentesis));
						text=text.substring(0, ipparentesis)+res+text.substring(fpparentesis+1);
					} catch (StringIndexOutOfBoundsException e2) {
						MensajesEmergentes.MensajeError(vista, "El formato introducido no es valido.");
						continuar=false;
						parentesis=false;
						vista.getPresultado().getTresultado().setText("");
					} catch (IndexOutOfBoundsException e2) {
						MensajesEmergentes.MensajeError(vista, "El formato introducido no es valido.");
						continuar=false;
						parentesis=false;
						vista.getPresultado().getTresultado().setText("");
					}catch (ArithmeticException e2) {
						continuar=false;
						parentesis=false;
						vista.getPresultado().getTresultado().setText("Math Error");
					}
					
					if(continuar==true) {
						for(int i=0;i<text.length();i++) {
							if(text.charAt(i)=='(') {
								parentesis=true;
								break;
							}else {
								parentesis=false;
							}
						}
					}
					
				}
				
				if(continuar==true) {
					
					try {
						res=operacionesCalculadora(text);
					} catch (NumberFormatException e2) {
						MensajesEmergentes.MensajeError(vista, "El formato introducido no es valido.");
						continuar=false;
						vista.getPresultado().getTresultado().setText("");
					} catch (IndexOutOfBoundsException e2) {
						MensajesEmergentes.MensajeError(vista, "El formato introducido no es valido.");
						continuar=false;
						vista.getPresultado().getTresultado().setText("");
					}catch (ArithmeticException e2) {
						continuar=false;
						vista.getPresultado().getTresultado().setText("Math Error");
					}
					
					if((int)res-res==0&&continuar==true) {
						vista.getPresultado().getTresultado().setText(""+((int)res));
					}
					else if(continuar==true){
						vista.getPresultado().getTresultado().setText(""+res);
					}
					
				}
			}
			
		}
	}
	
	public double operacionesCalculadora(String text) {
		LinkedList<String> numeros=new LinkedList<String>();
		LinkedList<String> operadores=new LinkedList<String>();
		String num="";
		String operador="";
		double res=0;
		for(int i=0;i<text.length();i++) {
			
			if(i==0) {
				num+=text.charAt(i);
			}
			else if ((text.charAt(i)=='+'||text.charAt(i)=='-'||text.charAt(i)=='X'||text.charAt(i)=='/'||text.charAt(i)=='%'||text.charAt(i)=='E')&&(text.charAt(i-1)!='+'&&text.charAt(i-1)!='-'&&text.charAt(i-1)!='X'&&text.charAt(i-1)!='/'&&text.charAt(i-1)!='E')) {
				operador=""+text.charAt(i);
				operadores.add(operador);
				if(!num.equals("")) {
					numeros.add(num);
				}
				num="";
			}
			else {
				num+=text.charAt(i);
			}
			
			if(i==text.length()-1&&!num.equals("")) {
				numeros.add(num);
			}
		}
		
		
		for(int i=0;i<operadores.size();i++) {
			
			if(operadores.get(i).equals("X")) {
				num=""+Operaciones.multiplicacion(Double.parseDouble(numeros.get(i)), Double.parseDouble(numeros.get(i+1)));
				operadores.remove(i);
				numeros.remove(i+1);
				numeros.remove(i);
				numeros.add(i,num);
				i--;
			}else if (operadores.get(i).equals("/")&&i+1!=operadores.size()) {
				if(operadores.get(i+1).equals("%")) {
					num=""+Operaciones.porcentaje(1, Double.parseDouble(numeros.get(i+1)));
					operadores.remove(i+1);
					numeros.remove(i+1);
					numeros.add(i+1,num);
					
				}
				num=""+Operaciones.division(Double.parseDouble(numeros.get(i)), Double.parseDouble(numeros.get(i+1)));
				operadores.remove(i);
				numeros.remove(i+1);
				numeros.remove(i);
				numeros.add(i,num);
				i--;
			}
			else if(operadores.get(i).equals("/")) {
				num=""+Operaciones.division(Double.parseDouble(numeros.get(i)), Double.parseDouble(numeros.get(i+1)));
				operadores.remove(i);
				numeros.remove(i+1);
				numeros.remove(i);
				numeros.add(i,num);
				i--;
				
			}
			else if(operadores.get(i).equals("E")) {
				num=""+Operaciones.notacionE(Double.parseDouble(numeros.get(i)), Double.parseDouble(numeros.get(i+1)));
				operadores.remove(i);
				numeros.remove(i+1);
				numeros.remove(i);
				numeros.add(i,num);
				i--;
			}
			else if(i+1!=operadores.size()&&operadores.get(i).equals("%")) {
			if(operadores.get(i+1).equals("X")||operadores.get(i+1).equals("/")) {
					num=""+Operaciones.porcentaje(1, Double.parseDouble(numeros.get(i)));
					operadores.remove(i);
					numeros.remove(i);
					numeros.add(i,num);
					i--;
				}
			}
		}
		
		res=Double.parseDouble(numeros.get(0));
		
		for(int i=0;i<operadores.size();i++) {
			
			if(i+1!=operadores.size()) {
				if(operadores.get(i+1).equals("%")) {
					num=""+Operaciones.porcentaje(res,Double.parseDouble(numeros.get(i+1)));
					operadores.remove(i+1);
					numeros.add(i+1,num);
				}
				
			}

			if(operadores.get(i).equals("+")) {
				res=Operaciones.suma(res, Double.parseDouble(numeros.get(i+1)));
			}
			else if(operadores.get(i).equals("-")) {
				res=Operaciones.resta(res, Double.parseDouble(numeros.get(i+1)));
			}else if(operadores.get(i).equals("%")) {
				res=Operaciones.porcentaje(1, res);
				operadores.remove(i);
				i--;
			}
			
		}
		return res;
	}

}
