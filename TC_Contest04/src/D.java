import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class D {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer buf = new StringBuffer();
	static String line[];
	static HashSet<Integer> adj[];
	static int N;
	
	public static void main(String[] args) throws IOException{
		int t=Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			N=Integer.parseInt(br.readLine());
			adj=new HashSet[N];
			for (int j = 0; j < N; j++)adj[j]=new HashSet<>();
			for (int j = 0; j < N-1; j++) {
				line=br.readLine().split(" ");
				int a=Integer.parseInt(line[0]);
				for (int k = 1; k <= a; k++) {
					int b=Integer.parseInt(line[k])-1;
					adj[j].add(b);
				}
			}
			solve();
			if(i!=t-1)buf.append("\n");
		}
		System.out.print(buf);
	}
	
	static void bfs(int s,int d[],int pred[]) {
		d[s]=0;
		Queue<Integer>cola=new LinkedList<>();
		cola.add(s);
		while(!cola.isEmpty()) {
			int u=cola.poll();
			for(int v : adj[u]) {
				if(d[v]==-1) {
					d[v]=d[u]+1;
					pred[v]=u;
					cola.add(v);
				}
			}
		}
	}
	
	static void solve() {
		int[] d=new int[N],pred=new int[N];
		Arrays.fill(d, -1);
		Arrays.fill(pred, -1);
		bfs(0,d,pred);
		if(d[N-1]==-1) {
			buf.append("-1\n");
		}
		else {
			buf.append(d[N-1]+"\n");
			String way="";
			int u=pred[N-1];
			while (u != -1) {
	            if(u==pred[N-1]){
	                way+=(u+1);
	            }
	            else{
	                way=(u+1)+" "+way;
	            }
				u=pred[u];
			}
			buf.append(way+"\n");
		}
	}

}
