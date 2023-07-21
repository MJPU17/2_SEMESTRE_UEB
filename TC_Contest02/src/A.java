import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb=new StringBuffer();

	public static void main(String[] args) throws IOException{
		int t=Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] arr=br.readLine().split(" ");
			long k=Long.parseLong(arr[0]),n=Long.parseLong(arr[1]);
			System.out.println(triangulos(n, k));
			
		}

	}
	
	static long triangulos(long k,long n) {
		long a=((n+2)*(n+1)/2)%1000000007;
		long b=(k+1)%1000000007;
		return (a*b)%1000000007;
	}

}
