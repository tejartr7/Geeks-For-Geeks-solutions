//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class pair
{
    int node;
    int dist;
    pair(int x,int y)
    {
        node=x;
        dist=y;
    }
}

class Solution {

	public int[] shortestPath(int n,int m, int[][] edges) {
		//Code here
		Map<Integer,List<pair>> map=new HashMap<>();
		int i,j;
		for(i=0;i<n;i++)
		map.put(i,new ArrayList<>());
		for(i=0;i<m;i++)
		{
		    int x=edges[i][0];
		    int y=edges[i][1];
		    int z=edges[i][2];
		    map.get(x).add(new pair(y,z));
		}
		int dis[]=new int[n];
		Arrays.fill(dis,1000_000_000);
		dis[0]=0;
		PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
		pq.offer(new pair(0,0));
		while(!pq.isEmpty())
		{
		    pair top=pq.poll();
		    int node=top.node;
		    int dist=top.dist;
		    for(pair x:map.get(node))
		    {
		        if(x.dist+dist<dis[x.node])
		        {
		            dis[x.node]=x.dist+dist;
		            pq.offer(new pair(x.node,dis[x.node]));
		        }
		    }
		}
		for(i=0;i<n;i++)
		{
		    if(dis[i]==1000_000_000)
		    {
		        dis[i]=-1;
		    }
		}
		return dis;
	}
}