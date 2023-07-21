import java.util.HashMap;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int t=sc.nextInt();
		for (int i = 0; i < t; i++) {
			HashMap<Integer, Integer> fre=new HashMap<>();
			int n=sc.nextInt();
			for (int j = 0; j < n; j++) {
				String c=sc.next();
				int f=sc.nextInt();
				if(fre.containsKey(f)) {
					fre.put(f, fre.get(f)+1);
				}
				else {
					fre.put(f, 1);
				}
			}
			int mayor=0;
			int top=0;
			for(Integer a:fre.keySet()) {
				if(fre.get(a)>mayor) {
					mayor=fre.get(a);
					top=a;
				}
				else if(fre.get(a)==mayor) {
					top=Math.min(a, top);
				}
			}
			System.out.println(top);
		}

	}

}