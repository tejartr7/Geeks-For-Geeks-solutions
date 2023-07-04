//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int m[][], int n)
    {
    	// code here 
    	int i,j;
    	int k[]=new int[n];
    	int x[]=new int[n];
    	for(i=0;i<n;i++)
    	{
    	    int sum=0;
    	    for(j=0;j<n;j++)
    	    {
    	        sum+=m[i][j];
    	        if(m[i][j]==1)
    	        {
    	            k[j]+=1;
    	        }
    	    }
    	    x[i]+=sum;
    	}
    	
    	boolean valid=false;
    	int cnt=0;
    	for(i=0;i<n;i++)
    	{
    	    if(k[i]==n-1 && x[i]==0)
    	    {
    	        return i;
    	    }
    	}
    	return -1;
    }
}