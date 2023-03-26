//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair
{
    int dist;
    int node;
    pair(int dist,int node)
    {
        this.dist=dist;
        this.node=node;
    }
}
class Solution {
   // static List<Integer> list=new ArrayList<>();
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        int i;
        int maxi=Integer.MAX_VALUE;
        PriorityQueue<pair> pq=new PriorityQueue<>((pair a,pair b)->a.dist!=b.dist?
        a.dist-b.dist:a.node-b.node);
        ArrayList<ArrayList<pair>> adj = new ArrayList<>(); 
        for(i = 0;i<=n;i++) {
            adj.add(new ArrayList<>()); 
        }
        for(i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(new pair(edges[i][1], edges[i][2])); 
            adj.get(edges[i][1]).add(new pair(edges[i][0], edges[i][2])); 
        }
        int parent[]=new int[n+1];
        int ans[]=new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[1]=0;
        parent[1]=1;
        pq.offer(new pair(0,1));
        while(!pq.isEmpty())
        {
            pair top=pq.poll();
            int dist=top.dist;
            int node=top.node;
            for(pair x:adj.get(node))
            {
                int wt=x.node;
                int edge=x.dist;
                if(wt+dist<ans[edge])
                {
                    ans[edge]=wt+dist;
                    parent[edge]=node;
                    pq.offer(new pair(dist+wt,edge));
                }
            }
        }
        List<Integer> list=new LinkedList<>();
        if(ans[n]==Integer.MAX_VALUE)
        {
            list.add(-1);
            return list;
        }
        
        int node = n;
        // o(N)
        while(parent[node] != node) {
            list.add(node); 
            node = parent[node]; 
        }
        list.add(1); 
        Collections.reverse(list);
        return list;
    }
}