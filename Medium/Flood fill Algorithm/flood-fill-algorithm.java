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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public boolean isValid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public void dfs(int row,int col,int prev,int newColor,int image[][],int ans[][])
    {
        ans[row][col]=newColor;
        int m=ans.length,n=ans[0].length;
        int i,j;
        if(isValid(row+1,col,m,n))
        {
            if(image[row+1][col]==prev && ans[row+1][col]!=newColor){
                dfs(row+1,col,prev,newColor,image,ans);
            }
        }
        if(isValid(row-1,col,m,n))
        {
            if(image[row-1][col]==prev && ans[row-1][col]!=newColor){
                dfs(row-1,col,prev,newColor,image,ans);
            }
        }
        if(isValid(row,col+1,m,n))
        {
            if(image[row][col+1]==prev && ans[row][col+1]!=newColor){
                dfs(row,col+1,prev,newColor,image,ans);
            }
        }
        if(isValid(row,col-1,m,n))
        {
            if(image[row][col-1]==prev && ans[row][col-1]!=newColor){
                dfs(row,col-1,prev,newColor,image,ans);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int prev=image[sr][sc];
        int m=image.length,n=image[0].length;
        int ans[][]=new int[m][n];
        ans=image;
        dfs(sr,sc,prev,newColor,image,ans);
        return ans;
    }
}