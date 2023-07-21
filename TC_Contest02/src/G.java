import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		String[] arr=br.readLine().split(" ");
		long a=Long.parseLong(arr[0]),b=Long.parseLong(arr[1]),c=Long.parseLong(arr[2]);
		long w=valor(a)+valor(b)+valor(c);
		long e=valor(a+b)+valor(c);
		long r=valor(a+c)+valor(b);
		long t=valor(b+c)+valor(a);
		long y=valor(a+b+c);
		System.out.println(Math.min(w, Math.min(e, Math.min(r, Math.min(t, y)))));
		
	}
	
	static long valor(long x) {
		if(x>=500)return x-=100;
		return x;
	}

}
