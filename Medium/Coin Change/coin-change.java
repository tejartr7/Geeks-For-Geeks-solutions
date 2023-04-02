//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
      public long count(int coins[], int n, int sum) {
        // code here.
        long [][]dp=new long [n+1][sum+1];
        Arrays.fill(dp[0],0);
        int i,j;
        for(i=1;i<=n;i++)
        {
            dp[i][0]=1;
        }
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=sum;j++)
            {
                if(j-coins[i-1]>=0)
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}