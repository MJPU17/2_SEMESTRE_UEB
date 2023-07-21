import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer buf=new StringBuffer();
	static int chosen[],arr[],N,aux[];

	public static void main(String[] args) throws IOException{
		N=Integer.parseInt(br.readLine());
		arr=new int[N/2];
		Arrays.fill(arr, 2);
		if(N%2!=0) {
			arr[arr.length-1]=3;
		}
		buf.append(arr.length+"\n");
		for (int i = 0; i < arr.length; i++) {
			buf.append(arr[i]);
			buf.append(i!=arr.length-1?" ":"\n");
		}
		System.out.print(buf);
		

	}
	
	

}
