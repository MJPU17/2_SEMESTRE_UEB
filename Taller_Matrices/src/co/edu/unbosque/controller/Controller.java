package co.edu.unbosque.controller;

import java.io.IOException;

import co.edu.unbosque.model.CharactersMatrix;
import co.edu.unbosque.view.ConsoleView;

public class Controller {
	
	private ConsoleView view;
	private CharactersMatrix a;
	
	public Controller() throws IOException {
		view=new ConsoleView();
		a=new CharactersMatrix();
		work();
	}

	private void work() throws IOException {
		int option=0;
		boolean next=true;
		boolean create=false;
		int[][] coordinates;
		String[] aux;
		String aux2="";
		String menu="  MATRIXES ACTIVITY  \n"
		          +"1)Enter matrix.\n"
		          +"2)Print matrix.\n"
		          +"3)Show character location.\n"
		          +"4)Show in which rows appear the word.\n"
		          +"5)Show word with cordinates.\n"
		          +"6)Exit.\n";
		view.showInformation(menu);
		
		while (option!=6) {
			next=true;
			try {
				option=view.reedInteger("Enter a option:");
			}catch (NumberFormatException e) {
				view.showInformation("The option is invalid.");
				next=false;
			}
			if(next) {
				switch (option) {
				
				case 1:
					
					aux=new String[8];
					for(int i=0;i<8;i++) {
						aux[i]=view.reedInformation("Enter a row of characters:");
						aux[i]=aux[i].replace(" ", "");
						if(aux[i].length()!=8) {
							view.showInformation("The rows must have 8 characters.");
							i--;
						}
					}
					a.setCharacters(aux);
					a.createMatirx();
					create=true;
					
					break;
					
				case 2:
					if(create) {
						view.showInformation(a.toString());
					}else {
						view.showInformation("Unable to print a matrix because none has been entered yet. Please enter a matrix.");
					}
					
					break;
					
				case 3:
					if(create) {
						aux2=view.reedInformation("Enter a character:");
						if(aux2.length()==1) {
							aux2=aux2.toUpperCase();
							aux2=a.showLocationCharacter(aux2.charAt(0));
							if(!aux2.equals("")) {
								view.showInformation(aux2);
							}else {
								view.showInformation("The character is not in the matrix.");
							}
						}else {
							view.showInformation("Please enter only one character.");
						}
					}else {
						view.showInformation("The character cannot be found because a matrix none has been entered yet. Enter a matrix.");
					}
					break;
					
				case 4:
					
					if(create) {
						aux2=view.reedInformation("Enter a word:");
						aux2=a.showWordLocation(aux2);
						if(!aux2.equals("")) {
							view.showInformation(aux2);
						}else {
							view.showInformation("The word is not in the matrix.");
						}
					}else {
						view.showInformation("The word cannot be found because a matrix none has been entered yet. Enter a matrix.");
					}
					break;
					
				case 5:
					if(create) {
						try {
							aux=view.reedInformation("Enter the cordinates:").split(",");
							coordinates=a.charactersLocation(aux);
							if(coordinates[0][0]==-1){
								view.showInformation("The coordinates are invalids.");
							}else {
								view.showInformation(a.showWord(coordinates));
							}
						}catch (NumberFormatException e) {
							view.showInformation("The coordinates are invalids.");
						}catch (ArrayIndexOutOfBoundsException e) {
							view.showInformation("The coordinates are invalids.");
						}
					}else {
						view.showInformation("The word cannot be found because a matrix none has been entered yet. Enter a matrix.");
					}
					break;
					
				case 6:
					
					view.showInformation("Thanks for use the program.");
					break;
					
				default:
					
					view.showInformation("The option is invalid.");
					break;
					
				}
			}
			
			
		}
		
		
	}


}
