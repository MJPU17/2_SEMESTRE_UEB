import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class H {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{	
		int n=Integer.parseInt(br.readLine());
		ArrayList<String> words=new ArrayList<>(n);
		String[] line=br.readLine().split(" ");
		words.add(line[0]);
		for (int i = 1; i < line.length; i++) {
			boolean comp=false;
			for (int j = 0; j < words.size(); j++) {
				if(esta(line[i], words.get(j))) {
					comp=true;
					break;
				}
			}
			if(!comp) {
				words.add(line[i]);
			}
		}
		System.out.println(words.size());
	}
	
	static boolean esta(String a,String b) {
		return a.length()==b.length()&&(a+a).contains(b);
	}

}
