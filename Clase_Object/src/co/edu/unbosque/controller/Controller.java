package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Objects;

import co.edu.unbosque.model.Person;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PopUpMessages;

public class Controller implements ActionListener{
	
	private MainWindow view;
	private LinkedList<Person> people;
	
	public Controller() {
		people=new LinkedList<>();
		view=new MainWindow();
		assignListeners();
		
	}

	private void assignListeners() {
		view.getPmenu().getBregister().addActionListener(this);
		view.getPmenu().getBconsult().addActionListener(this);
		view.getPdata().getBregister().addActionListener(this);
		view.getPdata().getBback().addActionListener(this);
		view.getPconsult().getBconsult().addActionListener(this);
		view.getPconsult().getBback().addActionListener(this);
		view.getPresult().getBback().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando=e.getActionCommand(),name="",gender="",aux="";
		Person aux2;
		int age,aux3;
		double heigth,weigth;
		
		if(comando.equals("REGISTER")) {
			view.getPmenu().setVisible(false);
			view.getPdata().getFname().setText("");
			view.getPdata().getFage().setText("");
			view.getPdata().getFheight().setText("");
			view.getPdata().getFweigth().setText("");
			view.getPdata().setVisible(true);
		}
		else if(comando.equals("CONSULT")) {
			view.getPmenu().setVisible(false);
			view.getPconsult().getFconsult().setText("");;
			view.getPconsult().setVisible(true);
		}
		else if(comando.equals("REGISTER PERSON")) {
			try {
				name=view.getPdata().getFname().getText();
				age=Integer.parseInt(view.getPdata().getFage().getText());
				heigth=Double.parseDouble(view.getPdata().getFheight().getText());
				weigth=Double.parseDouble(view.getPdata().getFweigth().getText());
				if(view.getPdata().getRmale().isSelected()) {
					gender="Male";
				}
				else if(view.getPdata().getRfemale().isSelected()) {
					gender="Female";
				}
				if((view.getPdata().getRmale().isSelected()||view.getPdata().getRfemale().isSelected())&&validFormat(name, age, weigth, heigth)) {
					aux2=new Person(name, age, gender, weigth, heigth, people);
					people.add(aux2);
					PopUpMessages.informationMessage(view, "Your DNI is: "+aux2.getDni());
					view.getPdata().setVisible(false);
					view.getPmenu().setVisible(true);
				}
				else if(heigth<0||weigth<0){
					PopUpMessages.errorMessage(view, "Negative data is not valid.");
				}else {
					PopUpMessages.errorMessage(view, "Please enter all data.");
				}
			} catch (NumberFormatException e2) {
				PopUpMessages.errorMessage(view, "The input format is invalid.");
			}
		}
		else if(comando.equals("CONSULT PERSON")) {
			aux=view.getPconsult().getFconsult().getText();
			if(validFormat(aux)) {
				aux3=Objects.hash(aux);
				aux2=Person.findPerson(people, aux3);
				if(aux2!=null) {
					view.getPconsult().setVisible(false);
					view.getPresult().getAresult().setText(aux2.toString());
					view.getPresult().setVisible(true);
				}
				else {
					PopUpMessages.errorMessage(view, "The DNI not exist.");
				}
			}else {
				PopUpMessages.errorMessage(view, "The input format is invalid.");
				view.getPconsult().getFconsult().setText("");
			}
		}
		else if(comando.equals("BACK")) {
			view.visiblePanel().setVisible(false);
			view.getPmenu().setVisible(true);
		}
		
		
		
	}
	
	public boolean validFormat(String name,int age,double weigth,double heigth) {
		int cont=0;
		if(age<0||name.equals("")||weigth<0||heigth<0) {
			return false;
		}else {
			for(int i=0;i<name.length();i++) {
				if(name.charAt(i)!=' ') {
					cont++;
					break;
				}
			}
			if(cont==0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validFormat(String dni) {
		int cont=0;
		if(dni.equals("")) {
			return false;
		}else {
			for(int i=0;i<dni.length();i++) {
				if(dni.charAt(i)!=' ') {
					cont++;
					break;
				}
			}
			if(cont==0) {
				return false;
			}
			
		}
		return true;
	}
	
	

}
