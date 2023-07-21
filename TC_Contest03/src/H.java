import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cords=Integer.parseInt(br.readLine());
		System.out.println(cords%5==0?cords/5:cords/5+1);
	}

}
