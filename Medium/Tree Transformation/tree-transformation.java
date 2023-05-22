//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] p = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.solve(N, p);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static int maxi=0;
    static Map<Integer,List<Integer>>map;
    public static void dfs(int node,boolean visited[],int curr)
    {
        if(!map.containsKey(node) || map.get(node).size()==0) return ;
        if(visited[node])
        return ;
        visited[node]=true;
        maxi=Math.max(maxi,curr);
        for(int x:map.get(node))
        {
            if(!visited[x])
            dfs(x,visited,curr+1);
        }
    }
    public static int solve(int N, int[] p) {
        // code here
        int [] a = new int[N + 1];
        for (int i = 1; i < N; i++) 
        {
            a[p[i]]++;
            a[i]++;
        }
        
        int sum = 0;
        for (int i = 0; i < N; i++) 
        {
            if (a[i] == 1)
                sum++;
        }
        return Math.max(N - sum -1,0);
    }
}
        
