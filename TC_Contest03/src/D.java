import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class D {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<HashSet<Integer>>nums=new ArrayList<>();

	public static void main(String[] args) throws IOException{
		int n=Integer.parseInt(br.readLine());
		String[] line=br.readLine().split(" ");
		int aux,cont=0;
		for (int i = 0; i < n; i++) {
			aux=Integer.parseInt(line[i]);
			agregarNum(aux);
		}
		for (int i = 0; i < nums.size(); i++) {
			cont+=(nums.get(i).size()-1);
		}
		System.out.println(cont);

	}
	
	static void agregarNum(int a) {
		boolean agr=false;
		for (int i = 0; i <nums.size(); i++) {
			if(!nums.get(i).contains(a)) {
				nums.get(i).add(a);
				agr=true;
				break;
			}
		}
		if(!agr) {
			HashSet<Integer> con=new HashSet<>();
			con.add(a);
			nums.add(con);
		}
	}

}
