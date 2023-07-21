import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class E {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer buf=new StringBuffer();
	static String[]line;
	static ArrayList<Integer> adj[];
	static int N;
	static boolean bipartite;

	public static void main(String[] args) throws IOException{
		
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0)break;
			adj=new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adj[i]=new ArrayList<>();
			}
			while(true) {
				line=br.readLine().split(" ");
				int a=Integer.parseInt(line[0]);
				int b=Integer.parseInt(line[1]);
				if(a==0)break;
				a--;b--;
				adj[a].add(b);
				adj[b].add(a);
			}
			solve();
		}
		System.out.print(buf);
	}
	
	static void bfs (int s, int d[], int[]pred) {
		d[s]=0;
		Queue<Integer> cola=new LinkedList<>();
		cola.add(s);
		while(!cola.isEmpty()) {
			int u=cola.poll();
			for(int v : adj[u]) {
				if(d[v]!=-1 && v!=pred[u] && d[u]%2==d[v]%2) {
					bipartite=false;
				}
				else if(d[v]==-1) {
					d[v]=d[u]+1;
					pred[v]=u;
					cola.add(v);
				}
			}
		}
	}
	
	static void solve() {
		int d[]=new int[N];
		int pred[]=new int[N];
		Arrays.fill(d, -1);
		Arrays.fill(pred, -1);
		bipartite=true;
		for (int i = 0; i < N; i++) {
			if(d[i]==-1) {
				bfs(i,d,pred);
			}
			if(!bipartite) {
				break;
			}
		}
		buf.append(bipartite?"YES\n":"NO\n");
	}

}
