import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class D {
	
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static String line;
	static BigInteger[] mem=new BigInteger[1001];

	public static void main(String[] args) throws IOException{
		line=br.readLine();
		Arrays.fill(mem, new BigInteger("-1"));
		while(line!=null&&!line.isEmpty()) {
			int n=Integer.parseInt(line);
			System.out.println(fibonacci(n));
			line=br.readLine();
		}
	}
	
	static BigInteger fibonacci(int n) {
		if(mem[n].equals(new BigInteger("-1"))) {
			if(n==0)mem[0]=new BigInteger("1");
			else if(n==1)mem[1]=new BigInteger("2");
			else {
				
				mem[n]=fibonacci(n-1).add(fibonacci(n-2));
			}
		}
		return mem[n];
	}

}
