import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;

public class A {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashSet<Integer> colonia=new HashSet<>();
	static BigInteger aux;

	public static void main(String[] args) throws IOException{
		int n=Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			aux=new BigInteger(br.readLine());
			if(aux.compareTo(BigInteger.ZERO)!=-1&&aux.compareTo(new BigInteger("1000000"))!=1) {
				int horm=Integer.parseInt(aux.toString());
				colonia.add(horm);
			}
		}
		int max=0;
		if(colonia.size()>0) {
			max=Collections.max(colonia)+1;
		}
		for (int i = 0; i <= max; i++) {
			if(!colonia.contains(i)) {
				System.out.println(i);
				break;
			}
		}
	}

}
