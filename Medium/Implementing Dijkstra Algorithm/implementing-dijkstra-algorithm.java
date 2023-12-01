//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class pair {
    int x, y;

    pair(int a, int b) {
        x = a;
        y = b;
    }
}

class Solution {
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<pair> pq = new PriorityQueue<>((uu, vv) -> uu.y - vv.y);
        pq.offer(new pair(src, 0));

        while (!pq.isEmpty()) {
            pair top = pq.poll();
            int a = top.x;
            int b = top.y;

            for (ArrayList<Integer> curr : adj.get(a)) {
                int x = curr.get(0);
                int y = curr.get(1);
                if (dist[a] + y < dist[x]) {
                    dist[x] = dist[a] + y;
                    pq.offer(new pair(x, dist[x]));
                }
            }
        }
        return dist;
    }
}
