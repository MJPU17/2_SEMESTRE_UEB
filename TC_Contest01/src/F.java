import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long n=Long.parseLong(br.readLine());
		while(n>=0) {
			System.out.println((n*(n+1)/2)+1);
			n=Long.parseLong(br.readLine());
		}
	}

}
