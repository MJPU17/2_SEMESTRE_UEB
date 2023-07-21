import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb=new StringBuffer();
	
	public static void main(String[] args) throws IOException{
		int t=Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			long k=Long.parseLong(br.readLine());
			sb.append(powerOfTwo(k)+"\n");
		}
		System.out.print(sb);
	}
	
	static String powerOfTwo(long k) {
		if(k==1) {
			return "2";
		}
		else if(k%2==1) {
			return "(2*"+powerOfTwo(k-1)+")";
		}
		return "("+powerOfTwo(k/2)+")^2";
	}

}
