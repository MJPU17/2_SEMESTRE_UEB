import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String line[]=br.readLine().split(" ");
			Long t=Long.parseLong(line[0]),k=Long.parseLong(line[1]);
			System.out.println(k+(t-1));
		}

	}

}