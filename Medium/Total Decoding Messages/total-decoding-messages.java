//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int m=1000_000_007;
    public int helper(String str,int index,int dp[])
    {
        if(index>=str.length())
        return 1;
        if(dp[index]!=-1)
        return dp[index];
        int op1=str.charAt(index)-'0';
        int op2=0,ans=0;
        if(index+1<str.length())
        {
            op2=op1*10+str.charAt(index+1)-'0';
        }
        if(op1>0)
        ans=(ans+helper(str,index+1,dp))%m;
        if(op1>0 && op2>0 && op2<=26)
        ans=(ans+helper(str,index+2,dp))%m;
        dp[index]=(ans%m);
        return ans;
    }
    public int CountWays(String str)
    {
        // code here
        int n=str.length();
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[n]=1;
        return helper(str,0,dp)%m;
    }
}