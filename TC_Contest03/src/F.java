import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),c=1;
		while (n!=0) {
			Graph g=new Graph();
			int a,b;
			for(int i=0;i<n;i++) {
				a=sc.nextInt();
				b=sc.nextInt();
				g.addEdge(a, b);
			}
			a=sc.nextInt();
			b=sc.nextInt();
			while(a!=0||b!=0) {
				int nodes=0;
				if(g.adj.containsKey(a)) {
					g.BFS(a, b);
					nodes=g.adj.size()-g.all-1;
				}
				else {
					nodes=g.adj.size();
				}
				System.out.println("Case "+c+": "+nodes+" nodes not reachable from node "+a+" with TTL = "+b+".");
				c++;
				a=sc.nextInt();
				b=sc.nextInt();
			}
			n=sc.nextInt();
		}
		
	}
	
	static class Graph{
		HashMap<Integer, LinkedList<Integer>> adj;
		int all,ttl,init;
		
		public Graph() {
			adj=new HashMap<>();
		}
		
		void addEdge(int org,int des) {
			if(!adj.containsKey(org)) adj.put(org, new LinkedList<>());
			adj.get(org).add(des);
			if(!adj.containsKey(des)) adj.put(des, new LinkedList<>());
			adj.get(des).add(org);
		}
		 
		void BFS(int org,int ttl) {
			all=0;
	        HashMap<Integer,Integer>visit=new HashMap<>();
	        LinkedList<Integer> cola= new LinkedList<>();
	        visit.put(org,ttl);
	        cola.add(org);
	        while (!cola.isEmpty()) {
	        	org=cola.poll();
	            ttl=visit.get(org);
	            Iterator<Integer> it = adj.get(org).listIterator();
	            while(it.hasNext()&&ttl>0) {
	            	int n = it.next();
	            	if(!visit.containsKey(n)) {
	            		if(ttl>0)all++;
	                    visit.put(n,ttl-1);
	                    cola.add(n);
	            	}
	            }
	            ttl--;
	        }
	    } 
	}

}