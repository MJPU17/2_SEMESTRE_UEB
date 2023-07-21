import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		int t=Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int cont=0;
			String[] line=br.readLine().split(" ");
			HashMap<Character, Integer> prefix=new HashMap<>();
			for (int j = 0; j < line[1].length(); j++) {
				if(prefix.containsKey(line[1].charAt(j))) {
					prefix.put(line[1].charAt(j), prefix.get(line[1].charAt(j))+1);
				}
				else {
					prefix.put(line[1].charAt(j), 1);
				}
			}
			for (int j = 0; j < line[0].length(); j++) {
				if(prefix.containsKey(line[0].charAt(j))&&prefix.get(line[0].charAt(j))>0) {
					prefix.put(line[0].charAt(j), prefix.get(line[0].charAt(j))-1);
					cont++;
				}
				else break;
			}
			System.out.println(cont);
		}
	}

}
