import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		while(line!=null&&!line.equals("")) {
			String[] aux=line.split(" ");
			long n=Long.parseLong(aux[0]),k=Long.parseLong(aux[1]);
			System.out.println(n*k*2);
			line=br.readLine();
		}

	}

}
