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
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.bestNode(N, A, P);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long bestNode(int N, int[] A, int[] P) {
           List<Integer>[] adj = new List[N + 1];
    for(int i = 1; i <= N; i++) {
        adj[i] = new ArrayList<>();
    }
    for(int i = 1; i < N; i++) {
        adj[P[i]].add(i + 1);
    }
    long ans = Long.MIN_VALUE;
    for(int i = 1; i <= N; i++) {
        ans = Math.max(ans, dfs(i, adj, A, false));
    }
    return ans;
}

public static long dfs(int node, List<Integer>[] adj, int[] A, boolean f) {
    long ans = Long.MIN_VALUE;
    for(int child : adj[node]) {
        ans = Math.max(ans, dfs(child, adj, A, !f));
    }
    long nodeVal = A[node - 1];
    if(f) {
        nodeVal = -nodeVal;
    }
    if(ans == Long.MIN_VALUE) {
        return nodeVal;
    }
    return ans + nodeVal;

    }
}
        
