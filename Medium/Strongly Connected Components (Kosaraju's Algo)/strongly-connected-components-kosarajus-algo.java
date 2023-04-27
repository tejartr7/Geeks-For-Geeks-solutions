//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void dfs(int i,boolean visited[],ArrayList<ArrayList<Integer>> adj,
    Stack<Integer> stack)
    {
        if(!visited[i])
        {
            visited[i]=true;
            for(int x:adj.get(i))
            {
                if(!visited[x])
                dfs(x,visited,adj,stack);
            }
            stack.push(i);
        }
    }
    public void dfsK(int i,boolean visited[],ArrayList<ArrayList<Integer>> adj)
    {
        if(!visited[i])
        {
            visited[i]=true;
            for(int x:adj.get(i))
            {
                if(!visited[x])
                    dfsK(x,visited,adj);
            }
        }
    }
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> stack=new Stack<>();
        boolean visited[]=new boolean[v];
        int i,n;
        for(i=0;i<v;i++)
        {
            if(!visited[i])
                dfs(i,visited,adj,stack);
        }
        //System.out.println(stack);
        ArrayList<ArrayList<Integer>> rev=new ArrayList<>();
        for(i=0;i<v;i++)
            rev.add(new ArrayList<>());
        for(i=0;i<v;i++)
        {
            for(int x:adj.get(i))
            {
                rev.get(x).add(i);
            }
        }
        Arrays.fill(visited,false);
        int sc=0;
        while(!stack.isEmpty())
        {
            int x=stack.pop();
            if(!visited[x])
            {
                sc++;
                dfsK(x,visited,rev);
            }
        }
        return sc;
        
    }
}
