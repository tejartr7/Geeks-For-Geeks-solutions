//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][]=new int[x+1][y+1];
        int i,j;
        for(i=0;i<=x;i++)
        {
            dp[i][0]=0;
        }
        for(i=0;i<=y;i++)
        {
            dp[0][i]=0;
        }
        for(i=1;i<=x;i++)
        {
            for(j=1;j<=y;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }
    public int longestPalinSubseq(String s)
    {
        //code here
        StringBuilder sb=new StringBuilder(s);
        return lcs(s.length(),s.length(),s,sb.reverse().toString());
    }
}