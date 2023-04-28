//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class tuple
{
    int r;
    int c;
    int s;
    tuple(int x,int y,int z)
    {
        r=x;
        c=y;
        s=z;
    }
}
class Solution
{
    public boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int[][] chefAndWells(int m,int n,char c[][])
    {
        int dp[][]=new int[m][n];
        int i,j;
        for(i=0;i<m;i++)
        Arrays.fill(dp[i],Integer.MAX_VALUE);
        Queue<tuple> q=new LinkedList<>();
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(c[i][j]=='W')
                {
                    q.offer(new tuple(i,j,1));
                    dp[i][j]=0;
                }
                if(c[i][j]=='N')
                dp[i][j]=0;
            }
        }
        while(!q.isEmpty())
        {
            tuple top=q.poll();
            int a[]={0,0,1,-1};
            int b[]={1,-1,0,0};
            for(j=0;j<4;j++)
            {
                int row=top.r+a[j];
                int col=top.c+b[j];
                int steps=top.s;
                if(valid(row,col,m,n) &&  c[row][col]!='N' && dp[row][col]>steps*2)
                {
                    
                    dp[row][col]=steps*2;
                    q.offer(new tuple(row,col,steps+1));
                }
            }
        }
         for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(dp[i][j]==Integer.MAX_VALUE)
                {
                    if(c[i][j]=='H')
                    dp[i][j]=-1;
                    else
                    dp[i][j]=0;
                }
                if(c[i][j]=='.')
                dp[i][j]=0;
            }
        }
        return dp;
    }
}