import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Probar {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String line[];
	static int memo[],rocas[];

	public static void main(String[] args) throws IOException{
		int n=Integer.parseInt(br.readLine());
		memo=new int[n];
		rocas=new int[n];
		Arrays.fill(memo, -1);
		line=br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			rocas[i]=Integer.parseInt(line[i]);
		}
		System.out.println(solRecMem(n-1)+"="+solIterative(n));
	}
	
	/*
	 * Programación dinamica recursion+memoria. De indice mas grande a mas pequeño.
	 */
	static int solRecMem(int n) {
		if(memo[n]==-1) {
			if(n==0)memo[n]=0;
			else if(n==1)memo[n]=Math.abs(rocas[1]-rocas[0]);
			else {
				memo[n]=Math.min(Math.abs(rocas[n]-rocas[n-1])+solRecMem(n-1),Math.abs(rocas[n]-rocas[n-2])+solRecMem(n-2));
			}
		}
		return memo[n];
	}
	
	/*
	 * Programacion dinamica Bottom-Up. De indice mas pequeño a mas grande.
	 */
	static int solIterative(int n) {
		memo[0]=0;
		memo[1]=Math.abs(rocas[0]-rocas[1]);
		for (int i = 2; i < n; i++) {
			memo[i]=Math.min(Math.abs(rocas[i]-rocas[i-1])+memo[i-1],Math.abs(rocas[i]-rocas[i-2])+memo[i-2]);
		}
		return memo[n-1];
	}

}
