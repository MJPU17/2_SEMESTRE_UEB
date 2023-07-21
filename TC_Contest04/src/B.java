import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static Queue<Integer> cola=new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		String[]line=br.readLine().split(" ");
		int n=Integer.parseInt(line[0]),k=Integer.parseInt(line[1]),cont=0;
		line=br.readLine().split(" ");
		int[] a=new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i]=Integer.parseInt(line[i]);
		}
		line=br.readLine().split(" ");
		for (int i = 0; i < k; i++) {
			cola.add(Integer.parseInt(line[i]));
		}
		for (int i = 0; i < a.length; i++) {
			if(cola.isEmpty()) {
				break;
			}
			int bille=cola.element();
			if(bille>=a[i]) {
				cola.poll();
				cont++;
			}
		}
		System.out.println(cont);
	}

}
