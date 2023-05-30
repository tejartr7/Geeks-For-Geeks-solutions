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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    boolean found=false;
    public boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public void dfs(int i,int j,int idx,String word,boolean visited[][],char board[][])
    {
        int m=visited.length;
        int n=visited[0].length;
        if(idx==word.length())
        {
            found=true;
            return;
        }
        if(!valid(i,j,m,n) || visited[i][j]) return ;
        visited[i][j]=true;
        if(board[i][j]==word.charAt(idx))
        {
            if(valid(i+1,j,m,n))
            {
                dfs(i+1,j,idx+1,word,visited,board);
            }
            if(valid(i-1,j,m,n))
            {
                dfs(i-1,j,idx+1,word,visited,board);
            }
            if(valid(i,j+1,m,n))
            {
                dfs(i,j+1,idx+1,word,visited,board);
            }
            if(valid(i,j-1,m,n))
            {
                dfs(i,j-1,idx+1,word,visited,board);
            }
        }
    }
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int i,j,m=board.length,n=board[0].length;
        int l=word.length();
        int x=0;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(found)
                return true;
                if(board[i][j]==word.charAt(0))
                {
                    boolean visited[][]=new boolean[m][n];
                    dfs(i,j,0,word,visited,board);
                }
            }
        }
        return found;
    }
}