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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int n, int amount) 
	{ 
	    // Your code goes here
	    int dp[]=new int[amount+1];
	    int i,j;
	    Arrays.fill(dp,Integer.MAX_VALUE);
	    dp[0]=0;
	    for(i=0;i<n;i++)
	    {
	        for(j=coins[i];j<=amount;j++)
	        {
	            if(dp[j-coins[i]]!=Integer.MAX_VALUE)
	            {
	                dp[j]=Math.min(dp[j],1+dp[j-coins[i]]);
	            }
	        }
	    }
	    return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
	} 
}