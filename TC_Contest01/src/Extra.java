import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Extra {
	
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static String line[];
	static int N,arr[][],mem[][];
	
	public static void main(String[] args) throws IOException{
		N=Integer.parseInt(br.readLine());
		arr=new int[N][3];
		mem=new int[N][3];
		int x=0,y=0,max=0;
		for (int i = 0; i < N; i++) {
			line=br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				arr[i][j]=Integer.parseInt(line[j]);
				if(arr[i][j]>max) {
					max=arr[i][j];
					System.out.println(max);
					y=i;
					x=j;
				}
			}
		}
		System.out.println(points(3, 1));
		
	}
	
	static int points(int y,int x) {
		if(mem[y][x]==0) {
			if(y==0) {
				int[] aux=may(arr[0],x);
				mem[y][x]=aux[0];
			}
			else if(y==N-1) {
				int[] aux=may(arr[0],x);
				mem[y][x]=aux[0];
			}
			else {
				int[] aux=may(arr[y], x);
				mem[y][x]=aux[0]+points(y-1, aux[1])+points(y+1, aux[1]);
			}
		}
		return mem[y][x];
	}
	
	static int[] may(int[]arr,int b) {
		int aux[]=new int[2];
		if(b==0) {
			if(arr[1]>arr[2]) {
				aux[0]=arr[1];
				arr[1]=1;
			}
			else {
				aux[0]=arr[2];
				arr[1]=2;
			}
		}
		else if(b==1) {
			if(arr[0]>arr[2]) {
				aux[0]=arr[0];
				arr[1]=0;
			}
			else {
				aux[0]=arr[2];
				arr[1]=2;
			}
		}
		else {
			if(arr[0]>arr[1]) {
				aux[0]=arr[0];
				arr[1]=0;
			}
			else {
				aux[0]=arr[1];
				arr[1]=1;
			}
		}
		return aux;
	}
	

}
