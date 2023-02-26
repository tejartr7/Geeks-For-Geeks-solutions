//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(int i,boolean vis[],boolean path[],
    ArrayList<ArrayList<Integer>> adj)
    {
        vis[i]=path[i]=true;
        for(int x:adj.get(i))
        {
            if(!vis[x])
            {
                if(dfs(x,vis,path,adj))
                return true;
            }
            else if(path[x])
            return true;
        }
        path[i]=false;
        return false;
    }
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[]=new boolean[v+1];
        boolean path[]=new boolean[v+1];
        Arrays.fill(vis,false);
        Arrays.fill(path,false);
        int i;
        for(i=0;i<v;i++)
        {
            if(!vis[i])
            {
                if(dfs(i,vis,path,adj))
                return true;
            }
        }
        return false;
    }
}