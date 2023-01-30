//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution{
    int count=0;
    public boolean helper(Map<Integer,ArrayList<Integer>> map,boolean []v,int node)
    {
        v[node]=true;
        boolean selected=false;
        for(int x:map.get(node))
        {
            if(!v[x])
            {
                boolean find=helper(map,v,x);
               // System.out.print(node+" "+x+" ");
                if(!find)
                {
                    selected=true;
                }
            }
        }
      //  System.out.print("\n");
        if(selected)
        {
            count++;
        }
        return selected;
    }
    public int countVertex(int n, int[][] edges){
        // code here
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        int i;
        for(i=1;i<=n;i++)
        {
            map.put(i,new ArrayList<Integer>());
        }
        for(int e[]:edges)
        {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        boolean visited[]=new boolean[n+1];
        Arrays.fill(visited,false);
        helper(map,visited,1);
        return count;
    }
}

//{ Driver Code Starts.

// } Driver Code Ends