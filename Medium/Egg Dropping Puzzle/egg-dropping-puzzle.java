//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int dp[][];
    static int helper(int n,int k){
        if(k<2) return k;
        if(n<2) return k;
        int min=(int)(1e9);
        if (dp[n][k] != -1)
            return dp[n][k];
        for(int f=1;f<=k;f++)
        {
            int temp=1+Math.max(helper(n-1,f-1),helper(n,k-f));
            min=Math.min(min,temp);
        }
        return dp[n][k]=min;
    }
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    dp=new int[n+1][k+1];
	    for(int x[]:dp)
	    Arrays.fill(x,-1);
	    return helper(n,k);
	}
}