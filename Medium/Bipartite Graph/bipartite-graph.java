//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class pair
{
    int node;
    int color;
    pair(int node,int color)
    {
        this.node=node;
        this.color=color;
    }
}
class Solution
{
    public boolean check(int i,int col,ArrayList<ArrayList<Integer>>adj,int visited[])
    {
       visited[i]=col;
       for(int x:adj.get(i))
       {
           if(visited[x]==-1)
           {
                if(!check(x,1-col,adj,visited))
                return false;
           }
           else if (visited[x]==visited[i])
                return false;
       }
       return true;
    }
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int visited[]=new int[v];
        Arrays.fill(visited,-1);
        int i;
        for(i=0;i<v;i++)
        {
            if(visited[i]==-1)
            {
                if(!check(i,0,adj,visited))
                return false;
            }
        }
        return true;
    }
}