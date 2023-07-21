import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cadena=br.readLine();
		if(cadena.contains("a")&&cadena.contains("b")&&cadena.contains("c")&&compPos(cadena)) {
			String a=cadena.substring(cadena.indexOf("a"),cadena.lastIndexOf("a")+1);
			String b=cadena.substring(cadena.indexOf("b"),cadena.lastIndexOf("b")+1);
			String c=cadena.substring(cadena.indexOf("c"),cadena.lastIndexOf("c")+1);
			if(a.length()==c.length()||b.length()==c.length()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		else {
			System.out.println("NO");
		}

	}
	
	static boolean compPos(String cadena) {
		char[] letra= {'a','b','c'};
		int j=0;
		for (int i = 0; i < cadena.length(); i++) {
			if(i==0&&cadena.charAt(i)=='a') {
				
			}
			else if(letra[j]=='a'&&cadena.charAt(i)=='b'){
				j++;
			}
			else if(letra[j]=='a'&&cadena.charAt(i)=='c'){
				return false;
			}
			else if(letra[j]=='b'&&cadena.charAt(i)=='c'){
				j++;
			}
			else if(letra[j]=='b'&&cadena.charAt(i)=='a'){
				return false;
			}
			else if(letra[j]=='c'&&cadena.charAt(i)!='c') {
				return false;
			}
		}
		return true;
	}

}