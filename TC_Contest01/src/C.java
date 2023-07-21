import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long n=Long.parseLong(br.readLine());
		for (int i = 0; i < n; i++) {
			String l[]=br.readLine().split(" ");
			long arr[]=new long[3];
			int k=0;
			for (int j = 0; j < arr.length; j++) {
				arr[j]=Long.parseLong(l[j]);
			}
			long min=arr[0];
			for (int j = 1; j < arr.length; j++) {
				if(arr[j]<min) {
					min=arr[j];
					k=j;
				}
			}
			if(k==0) {
				System.out.println("First");
			}
			else if(k==1) {
				System.out.println("Second");
			}
			else if(k==2) {
				System.out.println("Third");
			}
		}

	}

}