//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int maxSweetness(int [] sweetness, int n, int k) {
	    // Write your code heren
	    int l=1,h=0;
	    for(int x:sweetness)
	    h+=x;
	    while(l<h)
	    {
	        int mid=(l+h+1)/2;
	        int count=0;
	        int sum=0;
	        for(int i=0;i<n;i++)
	        {
	            sum+=sweetness[i];
	            if(sum>=mid)
	            {
	                sum=0;
	                count++;
	            }
	        }
	        if(count<=k)
	        {
	           h=mid-1;
	        }
	        else
	           l=mid;
	    }
	    return h;
	}
}