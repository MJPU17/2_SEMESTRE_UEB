import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer buf = new StringBuffer();
	static String nums;
	static BigInteger galletas;
	
	public static void main(String[] args) throws IOException{
		int t=Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			galletas=new BigInteger(br.readLine());
			nums="";
			for (int j = 2; j <= 6; j++) {
				if(galletas.mod(new BigInteger(Integer.toString(j))).equals(BigInteger.ZERO)) {
					nums+=(Integer.toString(j)+" ");
				}
			}
			if(!nums.isEmpty()) {
				buf.append(nums.trim()+"\n");
			}
			else {
				buf.append("-1\n");
			}
		}
		System.out.print(buf);

	}

}
