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




// User function Template for Java
class  pair
{
    int wt;
    int node;
    pair(int wt,int node)
    {
        this.wt=wt;
        this.node=node;
    }
}
class Solution{
	static int spanningTree(int v, int e, int edges[][]){
            // Code Here.
            Map<Integer,List<pair>> map=new HashMap<>();
            int i,j;
            for(i=0;i<edges.length;i++)
            {
                int x=edges[i][0];
                int y=edges[i][1];
                int z=edges[i][2];
                if(!map.containsKey(x))
                    map.put(x,new ArrayList<>());
                if(!map.containsKey(y))
                    map.put(y,new ArrayList<>());
                map.get(x).add(new pair(y,z));
                map.get(y).add(new pair(x,z));
            }
            //System.out.println(map);
            PriorityQueue<pair> pq=new PriorityQueue<pair>((a,b)->a.wt-b.wt);
            pq.offer(new pair(0,0));
            int sum=0;
            boolean visited[]=new boolean[v];
            //visited[0]=true;
            while(!pq.isEmpty())
            {
                pair top=pq.poll();
                if(visited[top.node])
                continue;
                visited[top.node]=true;
                sum+=top.wt;
                for(pair x:map.get(top.node))
                {
                    if(!visited[x.wt])
                        pq.offer(new pair(x.node,x.wt));
                }
            }
            return sum;
        }
}