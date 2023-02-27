//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean dfs(int node, int vis[], 
   int check[], int pathVis[], List<List<Integer>> adj) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        // traverse for adjacent nodes
        for (int it : adj.get(node)) {
            // when the node is not visited
            if (vis[it] == 0) {
                if (dfs(it, vis, check, pathVis, adj) == true)
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (pathVis[it] == 1) {
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {

        // Your code here
       int vis[] = new int[v];
        int pathVis[] = new int[v];
        int check[] = new int[v];
       int i;
       List<Integer> safe=new LinkedList<>();
       for(i=0;i<v;i++)
       {
           if(vis[i]==0)
           {
               dfs(i,vis,check,pathVis,adj);
           }
       }
       for(i=0;i<v;i++)
       {
           if(check[i]==1)
           safe.add(i);
       }
       return safe;
    }
}
