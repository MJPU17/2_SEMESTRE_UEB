import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String line[];
	static long flor[],aux[]=new long[2],mayor=0,sol=0;;

	public static void main(String[] args) throws IOException{
		int n=Integer.parseInt(br.readLine()),pos[]=new int[n];
		long may=0,men=2000000000;
		flor=new long[n];
		line=br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			flor[i]=Integer.parseInt(line[i]);
			pos[i]=i;
			if(flor[i]>may) may=flor[i];
			if(flor[i]<men) men=flor[i];
		}
		mayor=may-men;
		System.out.println(mayor+" "+sol);
	}
	

}
