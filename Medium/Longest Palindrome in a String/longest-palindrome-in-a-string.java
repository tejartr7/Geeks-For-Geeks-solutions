//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
        // code here
        int maxi=0;
        String ans="";
        int i,n=s.length();
        for(i=0;i<n;i++)
        {
            int j=i,k=i;
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k))
            {
                j--;
                k++;
            }
            if(k-j-1>maxi)
            {
                maxi=k-j-1;
                ans=s.substring(j+1,k);
            }
            j=i;
            k=i+1;
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k))
            {
                j--;
                k++;
            }
            if(k-j-1>maxi)
            {
                maxi=k-j-1;
                ans=s.substring(j+1,k);
            }
        }
        return ans;
    }
}