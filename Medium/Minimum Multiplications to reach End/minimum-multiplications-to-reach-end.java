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
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair
{
    int start;
    int steps;
    pair(int start,int steps)
    {
        this.start=start;
        this.steps=steps;
    }
}
class Solution {
    
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code 
        int mod=100000;
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(start,0));
        int dist[]=new int[100000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start%100000]=0;
        while(!q.isEmpty())
        {
            pair top=q.poll();
            int x=top.start;
            int steps=top.steps;
            for(int k:arr)
            {
                int val=(x*k)%mod;
                if(steps+1<dist[val])
                {
                    dist[val]=steps+1;
                    if(val==end)
                    return dist[val];
                    q.offer(new pair(val,steps+1));
                }
            }
        }
        return dist[end]==Integer.MAX_VALUE?-1:dist[end];
    }
}
