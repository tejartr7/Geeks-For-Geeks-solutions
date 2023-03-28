//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class tuple
{
    int dist;
    int row;
    int col;
    tuple(int dist,int row,int col)
    {
        this.dist=dist;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    
    boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    int MinimumEffort(int heights[][]) {
        PriorityQueue<tuple> q=new PriorityQueue<>((a,b)->a.dist-b.dist);
        q.offer(new tuple(0,0,0));
        int i,j,m=heights.length,n=heights[0].length;
        int dp[][]=new int[m][n];
        for(i=0;i<m;i++)
        Arrays.fill(dp[i],(int)1e9);
        dp[0][0]=0;
        while(!q.isEmpty())
        {
            tuple top=q.poll();
            int dist=top.dist;
            int x=top.row;
            int y=top.col;
            if(x==m-1 && y==n-1) return dist;
            
            if(valid(x+1,y,m,n))
            {
                int effort=Math.max(dist,Math.abs(heights[x][y]-heights[x+1][y]));
                if(effort<dp[x+1][y]){
                dp[x+1][y]=effort;
                q.offer(new tuple(effort,x+1,y));
                }
            }
            
            if(valid(x-1,y,m,n))
            {
                int effort=Math.max(dist,Math.abs(heights[x][y]-heights[x-1][y]));
                if(effort<dp[x-1][y]){
                dp[x-1][y]=effort;
                q.offer(new tuple(effort,x-1,y));
                }
            }
            
            if(valid(x,y+1,m,n))
            {
                int effort=Math.max(dist,Math.abs(heights[x][y]-heights[x][y+1]));
                if(effort<dp[x][y+1]){
                dp[x][y+1]=effort;
                q.offer(new tuple(effort,x,y+1));
                }
            }
            
            if(valid(x,y-1,m,n))
            {
                int effort=Math.max(dist,Math.abs(heights[x][y]-heights[x][y-1]));
                if(effort<dp[x][y-1]){
                dp[x][y-1]=effort;
                q.offer(new tuple(effort,x,y-1));
                }
            }
        }
        return 0;
    }
}