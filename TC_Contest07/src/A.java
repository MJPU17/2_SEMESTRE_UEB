import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class A {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String line[];
	static StringBuffer buf=new StringBuffer();
	static HashMap<Integer, Integer>nums;
	static BigInteger mem[]=new BigInteger[1000000];

	public static void main(String[] args) throws IOException{
		int t=Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n=Integer.parseInt(br.readLine());
			nums=new HashMap<>();
			line=br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int aux=Integer.parseInt(line[j]);
				if(nums.containsKey(aux)) nums.put(aux, nums.get(aux)+1);
				else nums.put(aux, 1);
			}
			BigInteger sol=new BigInteger("0"),num,dem;
			for(int k : nums.values()) {
				if(k>=2) {
					num=factorial(k);
					dem=factorial(2).multiply(factorial(k-2));
					num=num.divide(dem);
					sol=sol.add(num);
				}
			}
			sol=sol.multiply(new BigInteger("2"));
			buf.append(sol.toString()+"\n");
		}
		System.out.print(buf);
				
	}
	
	static BigInteger factorial(int n) {
		return null;
	}

}
