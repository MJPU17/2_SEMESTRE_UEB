import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class F {
	
	static class Node {

		int first;
		char second;

		public Node(int a, char b) {
			first=a;
			second=b;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer buf = new StringBuffer();
	static String line[];
	static ArrayList<Node>adj[];
	static int N,V;

	public static void main(String[] args) throws IOException{
		line=br.readLine().split(" ");
		N=Integer.parseInt(line[0]);
		adj=new ArrayList[N];
		for (int i = 0; i < N; i++) adj[i]=new ArrayList<>();
		V=Integer.parseInt(line[1]);
		for (int i = 0; i < V; i++) {
			line=br.readLine().split("\\s+");
			int a= Integer.parseInt(line[0])-1,b=Integer.parseInt(line[1])-1;
			char w=line[2].charAt(0);
			adj[a].add(new Node(b, w));
		}	
		solve();
		System.out.print(buf);
	}
	
	static void bfs(int s,int d[],int[] pred,String[] ways) {
		Arrays.fill(d, -1);
		Arrays.fill(pred, -1);
		d[s]=0;
		ways[s]="";
		Queue<Node>Q=new LinkedList<>();
		Q.add(new Node(s,' '));
		while(!Q.isEmpty()) {
			int u=Q.poll().first;
			for(Node v: adj[u]) {
				int p=v.first;
				char e=v.second;
				if(d[p]==-1) {
					d[p]=d[u]+1;
					pred[p]=u;
					ways[p]=(ways[u]+e);
					Q.add(v);
				}
				else if(d[p]!=-1) {
					String a=ways[p];
					String b=ways[u]+e;
					ways[p]=minway(a, b);
					if(ways[p].equals(b)) {
						pred[p]=u;
						d[p]=d[u]+1;
					}
				}
			}
		}
	}
	
	static String minway(String a, String b) {
		if(a.length()<b.length())return a;
		if(b.length()<a.length()) return b;
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i)<b.charAt(i)) return a;
			if(b.charAt(i)<a.charAt(i)) return b;
			
		}
		return a;
	}
	
	static void solve() {
		int[] d=new int[N],pred=new int[N];
		String[] ways=new String[N];
		bfs(0, d, pred,ways);
		buf.append(d[N-1]+"\n");
		String way="";
		int m=N-1;
		while(m!=-1) {
			if(m==N-1) way+=(m+1);
			else way=(m+1)+" "+way;
			m=pred[m];
		}
		buf.append(way+"\n"+ways[N-1]+"\n");
	}

}
