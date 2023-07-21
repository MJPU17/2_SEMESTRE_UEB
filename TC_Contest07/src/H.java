import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String line[];

	public static void main(String[] args) throws IOException{
		int n=Integer.parseInt(br.readLine());
		double sol=0.0;
		line=br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			sol+=Integer.parseInt(line[i]);
		}
		sol/=n;
		System.out.println(sol);

	}

}
