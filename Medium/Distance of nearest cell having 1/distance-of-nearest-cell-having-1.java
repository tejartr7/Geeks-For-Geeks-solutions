//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
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
class Solution
{
    public boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int i,j,m=grid.length,n=grid[0].length;
        int arr[][]=new int[m][n];
        for(i=0;i<m;i++)
        Arrays.fill(arr[i],-1);
        Queue<pair> q=new LinkedList<>();
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    q.offer(new pair(i,j));
                    arr[i][j]=0;
                }
            }
        }
        int count=0;
        while(!q.isEmpty())
        {
            int l=q.size();
            count++;
            for(int k=0;k<l;k++)
            {
                pair top=q.poll();
                int r=top.row;
                int c=top.col;
                if(valid(r+1,c,m,n) && arr[r+1][c]==-1)
                {
                    q.offer(new pair(r+1,c));
                    arr[r+1][c]=count;
                }
                if(valid(r-1,c,m,n) && arr[r-1][c]==-1)
                {
                    q.offer(new pair(r-1,c));
                    arr[r-1][c]=count;
                }
                if(valid(r,c+1,m,n) && arr[r][c+1]==-1)
                {
                    q.offer(new pair(r,c+1));
                    arr[r][c+1]=count;
                }
                if(valid(r,c-1,m,n) && arr[r][c-1]==-1)
                {
                    q.offer(new pair(r,c-1));
                    arr[r][c-1]=count;
                }
            }
        }
        return arr;
    }
}