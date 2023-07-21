import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class H {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb=new StringBuffer();

	public static void main(String[] args) throws IOException{
		long t=Long.parseLong(br.readLine());
		for (long i = 0; i < t; i++) {
			int h=0,sol=0;
			String line=br.readLine();
			HashMap<Integer, Integer> alturas=new HashMap<>();
			for (int j = 0; j < line.length(); j++) {
				if(line.charAt(j)=='\\') {
					alturas.put(h, j);
					h--;
				}
				else if(line.charAt(j)=='/') {
					h++;
					if(alturas.containsKey(h)) {
						sol+=(j-alturas.get(h));
						alturas.remove(h);
					}
				}
			}
			sb.append(sol+"\n");
		}
		System.out.print(sb);
	}

}
