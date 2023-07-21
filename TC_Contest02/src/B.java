import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] line=br.readLine().split(" ");
			int lon=Integer.parseInt(line[1]);
			if(line[0].matches(".*[0-9].*")) {
				String[] nums=line[0].replaceAll("[^0-9]", " ").trim().split("\\s+");
				long sum=0;
				long arr[]=new long[nums.length];
				for (int j = 0; j < arr.length; j++) {
					arr[j]=Long.parseLong(nums[j]);
					sum+=(arr[j]-1);
				}
				if(sum+line[0].replaceAll("[0-9]","").length()<=lon) {
					for (int j = 0; j < arr.length; j++) {
						char letra=line[0].charAt(line[0].indexOf(nums[j])+1);
						String rem="";
						for (long k = 0; k < arr[j]-1; k++) {
							rem+=letra;
						}
						line[0]=line[0].replaceFirst(nums[j], rem);
					}
					System.out.println(line[0]);
				}
				else {
					System.out.println("unfeasible");
				}
			}
			else {
				System.out.println(line[0].length()<=lon?line[0]:"unfeasible");
			}
		}

	}

}