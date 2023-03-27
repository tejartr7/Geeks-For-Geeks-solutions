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
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class tuple
{
    int dis;
    int row;
    int col;
    tuple(int x,int y,int z)
    {
        dis=x;
        row=y;
        col=z;
    }
}
class Solution {
    boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0] == destination[0] &&
                source[1] == destination[1]) return 0;
        int mini=Integer.MAX_VALUE;
        int i,j,m=grid.length,n=grid[0].length;
        Queue<tuple> q=new LinkedList<>();
        q.offer(new tuple(0,source[0],source[1]));

        int dist[][]=new int[m][n];
        for(i=0;i<m;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[source[0]][source[1]]=0;
        while(!q.isEmpty())
        {
            tuple top=q.poll();
            int dis=top.dis;
            int x=top.row,y=top.col;
            if(x==destination[0] && y==destination[1])
            {
                return dis;
            }
            
            if(valid(x+1,y,m,n) && grid[x+1][y]==1 && dis+1<dist[x+1][y])
            {   q.offer(new tuple(dis+1,x+1,y));
                dist[x+1][y]=dis+1;
            }
            
            if(valid(x-1,y,m,n) && grid[x-1][y]==1 && dis+1<dist[x-1][y])
            {   q.offer(new tuple(dis+1,x-1,y));
                dist[x-1][y]=dis+1;
            }
            
            if(valid(x,y+1,m,n) && grid[x][y+1]==1 && dis+1<dist[x][y+1])
            { q.offer(new tuple(dis+1,x,y+1));
                dist[x][y+1]=dis+1;
            }
            
            if(valid(x,y-1,m,n) && grid[x][y-1]==1 && dis+1<dist[x][y-1])
            {    q.offer(new tuple(dis+1,x,y-1));
                dist[x][y-1]=dis+1;
            }
        }
        return -1;
    }
}
