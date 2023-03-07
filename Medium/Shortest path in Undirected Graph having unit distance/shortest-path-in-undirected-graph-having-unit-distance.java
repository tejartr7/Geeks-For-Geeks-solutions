//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

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
    /*public void helper(int x,int dist,int ans[])
    {
        dist=dist;
        ans[x.node]=Math.min(ans[x.node],dist);
    }*/
    public void dfs(int start,Stack<Integer> stack,Map<Integer,List<Integer>> map,
    boolean visited[])
    {
        visited[start]=true;
        for(int x:map.get(start))
        {
            if(!visited[x])
            {
                dfs(x,stack,map,visited);
            }
        }
        stack.push(start);
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int ans[]=new int[n];
		//Arrays.fill(ans,Integer.MAX_VALUE);
		Arrays.fill(ans,Integer.MAX_VALUE);
		Map<Integer,List<Integer>> map=new HashMap<>();
		int i;
		for(i=0;i<n;i++)
		{
		    map.put(i,new ArrayList<>());
		}
		for(i=0;i<m;i++)
		{
		    map.get(edges[i][0]).add(edges[i][1]);
		    map.get(edges[i][1]).add(edges[i][0]);
		}
		ans[src]=0;
		Queue<pair> q=new LinkedList<>();
		q.add(new pair(src,0));
		boolean visited[]=new boolean[n];
		while(!q.isEmpty())
		{
		    pair temp=q.poll();
		    for(int x:map.get(temp.node))
		    {
		        if(temp.dist+1<ans[x])
		        {
		            ans[x]=temp.dist+1;
		            q.add(new pair(x,temp.dist+1));
		        }
		    }
		}
		for(i=0;i<n;i++)
		    if(ans[i]==Integer.MAX_VALUE)
		        ans[i]=-1;
		return ans;
    }
}