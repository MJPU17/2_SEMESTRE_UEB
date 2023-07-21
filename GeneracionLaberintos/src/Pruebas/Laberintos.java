package Pruebas;

import java.util.ArrayList;

public class Laberintos {
	
	private int matriz[][];
	private char[][] represlab;
	private int iposx;
	private int iposy;
	private int fposx;
	private int fposy;
	private int fil;
	private int col;
	private int intentos;
	private boolean solucion;
	private int[] letposx;
	private int[] letposy;
	private int[] torposx;
	private int[] torposy;
	
	public Laberintos(int filas,int columnas) {
		col=columnas+2;
		fil=filas+2;
		iposx=1;
		iposy=1;
		fposx=col-2;
		fposy=fil-2;
		intentos=0;
		solucion=false;
	}
	
	public void generarLaberinto() {
		matriz=new int[fil][col];
		int posy=1;
		int posx=1;
		int posb=0;
		boolean seg=false;
		int stop=(col-2)*(fil-2)*45/100;
		int derecha,izquierda,arriba,abajo;
		for(int f=0;f<fil;f++) {
			for(int c=0;c<col;c++) {
				if(c==0||f==0||c==col-1||f==fil-1) {
					matriz[f][c]=1;
				}else {
					matriz[f][c]=0;
				}
			}
		}
		for(int cont=0;cont<stop+2;cont++) {
			do {
				posy=(int)(Math.random()*(fil-2)+1);
				posx=(int)(Math.random()*(col-2)+1);
				
			}while(matriz[posy][posx]!=0&&matriz[posy][posx+1]!=0&&matriz[posy][posx-1]!=0&&matriz[posy-1][posx]!=0&&matriz[posy+1][posx]!=0);
			matriz[posy][posx]=1;
		}
		matriz[iposy][iposx]=0;
		matriz[fposy][fposx]=0;
		
		
	}
	
	public void asignarAsesinosletales(int lim) {
		letposy=new int [lim];
		letposx=new int [lim];
		int posy=0;
		int posx=0;
		for(int i=0;i<lim;i++) {
			do {
				posy=(int)(Math.random()*(fil-2)+1);
				posx=(int)(Math.random()*(col-2)+1);
			} while (matriz[posy][posx]!=0&&matriz[posy][posx]==3&&posy+1==iposy&&posx==iposx&&posy-1==iposy&&posx==iposx&&posy==iposy&&posx+1==iposx&&posy==iposy&&posx-1==iposx&&posy==iposy&&posx==iposx);
			matriz[posy][posx]=3;
			letposy[i]=posy;
			letposx[i]=posx;
		}
	}
	
	public void asignarTormentosos(int lim) {
		torposy=new int[lim];
		torposx=new int[lim];
		int posy=0;
		int posx=0;
		for(int i=0;i<lim;i++) {
			do {
				posy=(int)(Math.random()*(fil-2)+1);
				posx=(int)(Math.random()*(col-2)+1);
			} while (matriz[posy][posx]!=0&&matriz[posy][posx]==3&&matriz[posy][posx]==2&&posy+1==iposy&&posx==iposx&&posy-1==iposy&&posx==iposx&&posy==iposy&&posx+1==iposx&&posy==iposy&&posx-1==iposx&&posy==iposy&&posx==iposx);
			matriz[posy][posx]=2;
			torposy[i]=posy;
			torposx[i]=posx;
		}
	}
	
	public void representacionLaberinto() {
		represlab=new char[fil][col];
		for(int y=0;y<fil;y++) {
			for(int x=0;x<col;x++) {
				if(matriz[y][x]==1) {
					represlab[y][x]='#';
				}else {
					represlab[y][x]=' ';
				}
			}
		}
		represlab[fposy][fposx]='F';	
	}
	
	public void solucionLaberinto( int y,int x) {
		boolean repetir=false;
		int ingresador=0;
		int volver=0;
		int stop=fil*col*10;
		ArrayList<Integer> posicionx= new ArrayList<Integer>();
		ArrayList<Integer> posiciony= new ArrayList<Integer>();
		for(int i=0;i<stop;i++) {
			if (repetir==false&&represlab[y][x]!='#'&&represlab[y][x]!='c') {
				represlab[y][x]='c';
				posiciony.add(y);
				posicionx.add(x);
				ingresador++;
				volver=ingresador;
			} 
			if(represlab[y][x+1]!='#'&&represlab[y][x+1]!='c') {
				x++;
				repetir=false;
			}else if(represlab[y+1][x]!='#'&&represlab[y+1][x]!='c') {
				y++;
				repetir=false;
			}else if(represlab[y][x-1]!='#'&&represlab[y][x-1]!='c') {
				x--;
				repetir=false;
			}else if(represlab[y-1][x]!='#'&&represlab[y-1][x]!='c') {
				y--;
				repetir=false;
			}else {
				if(volver>0) {
					volver--;
					x=posicionx.get(volver);
					y=posiciony.get(volver);
				}
				repetir=true;
			}
			if(x==fposx&&y==fposy) {
				solucion=true;
			}
			
		}
	}
	
	public void asegurarCamino() {
		
		do {
			generarLaberinto();
			representacionLaberinto();
			solucionLaberinto(iposy, iposx);
			intentos++;
		} while (solucion!=true);
		
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public int getIposx() {
		return iposx;
	}

	public void setIposx(int iposx) {
		this.iposx = iposx;
	}

	public int getIposy() {
		return iposy;
	}

	public void setIposy(int iposy) {
		this.iposy = iposy;
	}

	public int getFposx() {
		return fposx;
	}

	public void setFposx(int fposx) {
		this.fposx = fposx;
	}

	public int getFposy() {
		return fposy;
	}

	public void setFposy(int fposy) {
		this.fposy = fposy;
	}

	public int getFil() {
		return fil;
	}

	public void setFil(int fil) {
		this.fil = fil;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int[] getLetposx() {
		return letposx;
	}

	public void setLetposx(int[] letposx) {
		this.letposx = letposx;
	}

	public int[] getLetposy() {
		return letposy;
	}

	public void setLetposy(int[] letposy) {
		this.letposy = letposy;
	}

	public int[] getTorposx() {
		return torposx;
	}

	public void setTorposx(int[] torposx) {
		this.torposx = torposx;
	}

	public int[] getTorposy() {
		return torposy;
	}

	public void setTorposy(int[] torposy) {
		this.torposy = torposy;
	}

	public char[][] getRepreslab() {
		return represlab;
	}

	public void setRepreslab(char[][] represlab) {
		this.represlab = represlab;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public boolean isSolucion() {
		return solucion;
	}

	public void setSolucion(boolean solucion) {
		this.solucion = solucion;
	}

}
