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
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    static int lcs(int x, int y, String s1, String s2)
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
    public int editDistance(String s, String t) {
        // Code here
        int m=s.length(),n=t.length();
        int i,j,k;
        int dp[][]=new int[m+1][n+1];
        dp[0][0]=0;
        for(i=1;i<=m;i++)
        dp[i][0]=i;
        for(j=1;j<=n;j++)
        dp[0][j]=j;
        for(i=1;i<=m;i++)
        {
            for(j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                dp[i][j]=dp[i-1][j-1];
                else
                {
                    int a=dp[i-1][j];
                    int b=dp[i][j-1];
                    int c=dp[i-1][j-1];
                    dp[i][j]=1+Math.min(a,Math.min(b,c));
                }
            }
        }
        return dp[m][n];
    }
}