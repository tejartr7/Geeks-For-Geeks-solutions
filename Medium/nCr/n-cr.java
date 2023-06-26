//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long modInverse(long b, long m) {
        long g = gcd(b, m);
        if (g != 1) {
            return -1;
        } else {
            // If b and m are relatively prime,
            // then modulo inverse is b^(m-2) mod m
            long result = 1;
            for (int i = 0; i < m - 2; i++) {
                result = (result * b) % m;
            }
            return result;
        }
    }

    static int nCr(int n, int r) {
        int dp[][]=new int[n+1][n+1];
        int m=1000_000_007;
        int i,j;
        if(r>n) return 0;
        for(i=0;i<=n;i++)
            for(j=0;j<=n;j++)
                if(i==j || j==0)
                    dp[i][j]=1;
        for(i=1;i<=n;i++)
        {
            for(j=1;j<i;j++)
            {
                dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%m;
            }
        }
        return dp[n][r]%m;
    }
}
