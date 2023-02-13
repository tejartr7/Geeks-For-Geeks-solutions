//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class pair
{
    int row;
    int col;
    pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public boolean isValid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public void bfs(int r,int c,char grid[][],boolean visited[][])
    {
        visited[r][c]=true;
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(r,c));
        while(!q.isEmpty())
        {
            pair top=q.poll();
            int row=top.row;
            int col=top.col;
            for(int i=-1;i<=1;i++)
            {
                for(int j=-1;j<=1;j++)
                {
                    int x=row+i;
                    int y=col+j;
                    if(isValid(x,y,grid.length,grid[0].length))
                    {
                        if(grid[x][y]=='1' && !visited[x][y])
                        {
                            visited[x][y]=true;
                            q.offer(new pair(x,y));
                        }
                    }
                }
            }
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int m=grid.length,n=grid[0].length;
        int i,j;
        boolean visited[][]=new boolean[m][n];
        for(i=0;i<m;i++)
        Arrays.fill(visited[i],false);
        int count=0;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j]){
                count++;
                bfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
}