import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Probar {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer buf = new StringBuffer();
	static String line[];
	static TreeSet<Node> adj[];
	static int N,V;

	public static void main(String[] args) throws IOException{
		line=br.readLine().split(" ");
		N=Integer.parseInt(line[0]);
		adj=new TreeSet[N];
		for (int i = 0; i < N; i++) adj[i]=new TreeSet<>();;
		V=Integer.parseInt(line[1]);
		for (int i = 0; i < V; i++) {
			line=br.readLine().split(" ");
			int a=Integer.parseInt(line[0])-1,b=Integer.parseInt(line[1])-1;
			char w=line[2].charAt(0);
			adj[a].add(new Node(b, w));
		}
		solve();
		System.out.print(buf);
	}
	
	static void bfs(int s,int d[],int[] pred,char[] let) {
		Arrays.fill(d, -1);
		Arrays.fill(pred, -1);
		Arrays.fill(let,'0');
		d[s]=0;
		Queue<Integer> cola = new LinkedList<>();
		cola.add(s);
		while(!cola.isEmpty()) {
			int u=cola.poll();
			for(Node v : adj[u]) {
				
				if(d[v.first]==-1) {
					d[v.first]=d[u]+1;
					pred[v.first]=u;
					let[v.first]=v.second;
					cola.add(v.first);
				}
			}
		}
	}
	
	static void solve() {
		int[] d=new int[N],pred=new int[N];
		char[]let=new char[N];
		bfs(0, d, pred, let);
		buf.append(d[N-1]+"\n");
		if(d[N-1]!=-1) {
			String way="";
			int m=N-1;
			while(m!=-1) {
				if(m==N-1) way+=(m+1);
				else way=(m+1)+" "+way;
				m=pred[m];
			}
			buf.append(way+"\n");
			way="";
			char l=let[N-1];
			m=N-1;
			while(l!='0') {
				way=l+way;
				m=pred[m];
				l=let[m];
			}
			buf.append(way+"\n");
		}
	}
	
	static class Node implements Comparable<Node>{
		
		int first;
		char second;
		
		public Node(int a, char b) {
			first=a;
			second=b;
		}

		@Override
		public int compareTo(Node other) {
			if(second > other.second) {
				return 1;
			}
			else if(second == other.second) {
				return 0;
			}
			return -1;
		}
	}

}