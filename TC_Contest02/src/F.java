import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class F {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb;
	static long total=0;
	static double nes=0.0;
	static int ej[];
	static TreeMap<Long,String>respuestas=new TreeMap<>();

	public static void main(String[] args) throws IOException{
		String line[]=br.readLine().split(" ");
		int n=Integer.parseInt(line[0]),k=0;
		nes=Double.parseDouble(line[1]);
		int pos[]=new int [n],cop[]=new int[n];
		ej=new int[n];
		line=br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			ej[i]=Integer.parseInt(line[i]);
			cop[i]=ej[i];
			total+=ej[i];
			pos[i]=i;
		}
		Arrays.sort(cop);
		long sum=0;
		for(int i=cop.length-1;i>=0;i--) {
			if((double)sum/total*100>=nes) {
				break;
			}
			sum+=cop[i];
			k++;
		}
		combination(pos, n, k);
		sb=new StringBuffer();
		sb.append(k+" "+respuestas.size()+"\n");
		for(String res : respuestas.values()) {
			sb.append(res+"\n");
		}
		System.out.print(sb);
		
	}
	
	static void combinationUtil(int arr[], int data[], int start,int end, int index, int r) {
        if (index == r) {
        	long tot=0,two=0;;
        	int aux[]=new int[r];
            for (int j = 0; j < r; j++) {
                aux[j]=data[j]+1;
                two+=Math.pow(2, data[j]);
                tot+=ej[data[j]];
            }
            if((double)tot/total*100>=nes) {
            	tot=tot*100/total;
            	sb=new StringBuffer();
            	sb.append(tot+" ");
    			for (int i = 0; i < aux.length; i++) {
    				sb.append(aux[i]).append(i!=aux.length-1?" ":"");
    			}
    			respuestas.put(two, sb.toString());
            }
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

    static void  combination(int arr[], int n, int r) {
        int data[] = new int[r];
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }
	

}
