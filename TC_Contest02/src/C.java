import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class C {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer buf =new StringBuffer();
	static String[]line;
	static HashMap<Integer, HashSet<Integer>>adj;
	static int N,V,sol;
	static boolean bipartito;

	public static void main(String[] args) throws IOException{
		int t=Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			br.readLine();
			N=Integer.parseInt(br.readLine());
			V=N;
			adj=new HashMap<>();
			sol=0;
			int mayor=0;
			for (int j = 0; j < N; j++) {
				line=br.readLine().split(" ");
				int e=Integer.parseInt(line[0]);
				for (int k = 1; k <= e; k++) {
					int b=Integer.parseInt(line[k])-1;
					if(!adj.containsKey(j)) {
						adj.put(j, new HashSet<>());
					}
					adj.get(j).add(b);
					if(!adj.containsKey(b)) {
						adj.put(b, new HashSet<>());
					}
					adj.get(b).add(j);
					if(b+1>mayor) {
						mayor=b+1;
					}
				}
			}
			if(mayor>N) {
				N=mayor;
			}
			for (int j = 0; j < N; j++) {
				if(!adj.containsKey(j)) {
					adj.put(j, new HashSet<>());
				}
			}
			solve();
		}
		System.out.print(buf);
	}
	
	static int[] bfs(int s, int[]d, int[] pred) {
		int[] aux=new int[2];
		d[s]=0;
		if(s<V) {
			aux[0]++;
		}
		Queue<Integer> cola=new LinkedList<>();
		cola.add(s);
		while(!cola.isEmpty()) {
			int u=cola.poll();
			for(int v : adj.get(u)) {
				if(d[v]!=-1 && v!=pred[u] && d[u]%2==d[v]%2) {
					bipartito=false;
				}
				else if(d[v]==-1) {
					d[v]=d[u]+1;
					pred[v]=u;
					cola.add(v);
					if(d[v]%2==0&&v<V) {
						aux[0]++;
					}
					else if(v<V){
						aux[1]++;
					}
				}
			}
		}
		if(!bipartito) {
			aux[0]=0;
			aux[1]=0;
		}
		return aux;
	}
	
	static void solve() {
		int[]d=new int[N],pred=new int[N];
		Arrays.fill(d, -1);
		Arrays.fill(pred,-1);
		for (int i = 0; i < N; i++) {
			bipartito=true;
			if(d[i]==-1) {
				int[] pari=bfs(i, d, pred);
				sol+=Math.max(pari[0],pari[1]);
			}
		}	
		buf.append(sol+"\n");
	}

}
