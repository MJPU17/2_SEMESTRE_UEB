import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer buf = new StringBuffer();
	static String line[];
	static ArrayList<Integer> adj[];
	static int N,M,time,d[],low[];
	static boolean[] ap;
	
	
	public static void main(String[] args) throws IOException{
		
		while(true) {
			line=br.readLine().split(" ");
			N=Integer.parseInt(line[0]);M=Integer.parseInt(line[1]);
			if(N==0) {
				break;
			}
			adj=new ArrayList[N];
			for (int i = 0; i < N; i++)adj[i]=new ArrayList<>();
			for (int i = 0; i < M; i++) {
				line=br.readLine().split(" ");
				int a=Integer.parseInt(line[0])-1;
				int b=Integer.parseInt(line[1])-1;
				adj[a].add(b);
				adj[b].add(a);
			}
			buf.append(solve()+"\n");
		}
		System.out.print(buf);
	}
	
	static void dfs(int u,int par) {
		d[u]=time++;
		low[u]=d[u];
		int children=0;
		for(int v : adj[u]) {
			if(v==par)continue;
			else if(d[v]>0) {
				low[u]=Math.min(low[u], d[v]);
			}
			else {
				children++;
				dfs(v,u);
				low[u]=Math.min(low[u], low[v]);
				if(par!=-1&&low[v]>=d[u])ap[u]=true;
			}
		}
		if(par==-1&&children>1)ap[u]=true;
	}
	
	static int solve() {
		d=new int[N];
		low=new int[N];
		time=1;
		ap=new boolean[N];
		dfs(0,-1);
		int cont=0;
		for (int i = 0; i < N; i++) {
			if(ap[i]) {
				cont++;
			}
		}
		return cont;
	}

}
