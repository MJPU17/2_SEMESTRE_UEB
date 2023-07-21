package co.edu.unbosque.model;

public class CharactersMatrix {
	
	private String[] characters;
	private char[][] matrix;
	
	public CharactersMatrix() {
		characters=new String[8];
		matrix=new char[8][8];
	}
	
	public CharactersMatrix(String[]characters) {
		this.characters=characters;
		matrix=new char[8][8];
		for(int y=0;y<characters.length;y++) {
			characters[y]=characters[y].toUpperCase();
			for(int x=0;x<characters[y].length();x++) {
				matrix[y][x]=characters[y].charAt(x);
			}
		}
	}
	
	@Override
	public String toString() {
		String cm="";
		for(int y=0;y<matrix.length;y++) {
			for(int x=0;x<matrix[y].length;x++) {
				cm+="["+matrix[y][x]+"]";
			}
			cm+="\n";
		}
		return cm;
	}
	
	public String showLocationCharacter(char character) {
		String locations="";
		for(int y=0;y<matrix.length;y++) {
			for(int x=0;x<matrix[y].length;x++) {
				if(matrix[y][x]==character) {
					locations+="["+y+"]"+"["+x+"]\n";
				}
			}
		}
		return locations;
	}
	
	public String showWordLocation(String word) {
		String locations="";
		int count;
		word=word.toUpperCase();
		for(int y=0;y<matrix.length;y++) {
			count=0;
			for(int x=0;x<matrix[y].length;x++) {
				if(matrix[y][x]==word.charAt(count)) {
					count++;
					if(count==word.length()) {
						break;
					}
				}else {
					count=0;
				}
			}
			if(count==word.length()) {
				locations+=y+",";
			}
		}
		if(locations.length()!=0) {
			locations=locations.substring(0,locations.length()-1);
		}
		return locations;
	}
	
	public String showWord(int[][] locations) {
		String word="";
		for(int i=0;i<locations.length;i++) {
			word+=matrix[locations[i][0]][locations[i][1]];
		}
		return word;
	}
	
	public void createMatirx() {
		for(int y=0;y<characters.length;y++) {
			characters[y]=characters[y].toUpperCase();
			for(int x=0;x<characters[y].length();x++) {
				matrix[y][x]=characters[y].charAt(x);
			}
		}
	}
	
	public int[][] charactersLocation(String[] cords){
		int[][] coordslet=new int[cords.length][2];
		String[] aux;
		for(int i=0;i<cords.length;i++) {
			aux=cords[i].split("-");
			if(aux.length!=2) {
				coordslet[0][0]=-1;
				break;
			}else {
				coordslet[i][0]=Integer.parseInt(aux[0]);
				coordslet[i][1]=Integer.parseInt(aux[1]);
			}
			
		}
		return coordslet;
	}

	public String[] getCharacters() {
		return characters;
	}

	public void setCharacters(String[] characters) {
		this.characters = characters;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(char[][] matrix) {
		this.matrix = matrix;
	}

}
