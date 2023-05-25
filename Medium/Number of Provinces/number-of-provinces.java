//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int x=0;
    static void dfs(int i,boolean visited[],Map<Integer,List<Integer>> map)
    {
        if(visited[i]) return ;
        visited[i]=true;
        for(int x:map.get(i))
        {
            if(!visited[x])
            dfs(x,visited,map);
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        // code here
        Map<Integer,List<Integer>> map=new HashMap<>();
        int i,j;
        for(i=0;i<v;i++)
        map.put(i,new ArrayList<>());
        for(i=0;i<v;i++)
        {
            for(j=0;j<v;j++)
            {
                if(i!=j && adj.get(i).get(j)==1)
                {
                    map.get(i).add(j);
                }
            }
        }
       // System.out.println(map);
        boolean visited[]=new boolean[v];
        int count=0;
        for(i=0;i<v;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i,visited,map);
            }
        }
        return count;
    }
};