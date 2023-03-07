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

class pair
{
    int node;
    int weight;
    pair(int x,int y)
    {
        node=x;
        weight=y;
    }
}
//User function Template for Java
class Solution {
    public void helper(pair x,int dist,int ans[])
    {
        dist=dist+x.weight;
        ans[x.node]=Math.min(ans[x.node],dist);
    }
    public void dfs(int start,Stack<Integer> stack,Map<Integer,List<pair>> map,
    boolean visited[])
    {
        visited[start]=true;
        for(pair x:map.get(start))
        {
            if(!visited[x.node])
            {
                dfs(x.node,stack,map,visited);
            }
        }
        stack.push(start);
    }
	public int[] shortestPath(int n,int m, int[][] edges) {
		//Code 
		int ans[]=new int[n];
		Arrays.fill(ans,Integer.MAX_VALUE);
		Map<Integer,List<pair>> map=new HashMap<>();
		int i;
		for(i=0;i<n;i++)
		{
		    map.put(i,new ArrayList<>());
		}
		for(i=0;i<m;i++)
		{
		    map.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
		}
		//System.out.println(map);
		boolean visited[]=new boolean[n];
		Stack<Integer> stack=new Stack<>();
		for(i=0;i<n;i++)
		{
		    if(!visited[i])
		    {
		        dfs(i,stack,map,visited);
		    }
		}
		//System.out.println(stack);
		ans[0]=0;
		while(stack.peek()!=0)
		{
		    ans[stack.pop()]=-1;
		}
		while(!stack.isEmpty())
		{
		    int peek=stack.pop();
		    for(pair x:map.get(peek))
		    {
		        helper(x,ans[peek],ans);
		    }
		}
		for(i=0;i<n;i++)
		if(ans[i]==Integer.MAX_VALUE)
		ans[i]=-1;
		return ans;
	}
}