//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
	public static int countPaths(int n){
		//code here
	    long dp[]=new long[n+1];
	    long m=1000_000_007;
	    if(n<=1) return 0;
	    dp[1]=0l;
	    dp[2]=3l;
	    int i;
	    for(i=3;i<=n;i++)
	    {
	        long x=(dp[i-1]%m*3)%m;
	        dp[i]=(i%2==1?x-3:x+3)%m;
	    }
	    return (int)(dp[n]%m);
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends