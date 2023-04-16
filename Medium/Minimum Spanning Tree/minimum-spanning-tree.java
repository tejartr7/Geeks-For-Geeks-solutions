//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


class DisjointSet {
    //List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
       int a=findUPar(u);
       int b=findUPar(v);
       if(a==b)
       return ;
       if(size.get(a)<size.get(b))
       {
           parent.set(a,b);
           size.set(b,size.get(a)+size.get(b));
       }
       else
       {
           parent.set(b,a);
           size.set(a,size.get(a)+size.get(b));
       }
    }
}
class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};
class Solution{
	static int spanningTree(int V, int E, int adj[][]){
            // Code Here.
            List<Edge> edges = new ArrayList<Edge>();
        // O(N + E)
        for(int[] i :adj)
        {
            int u=i[0];
            int v=i[1];
            int cost=i[2];
            //Edge temp= new Edge(u,v,cost);
            edges.add(new Edge(u,v,cost));
        }
        DisjointSet ds = new DisjointSet(V);
        // M log M
        Collections.sort(edges);
        int ans=0;
        for(Edge x:edges)
        {
            int a=x.src;
            int b=x.dest;
            int wt=x.weight;
            if(ds.findUPar(a)!=ds.findUPar(b))
            {
                ans+=wt;
                ds.unionBySize(a,b);
            }
        }
        return ans;
        }
}