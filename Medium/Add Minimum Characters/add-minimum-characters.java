//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public static boolean fun(String str,int n){
        int i = 0;
        int j = n;
        while(i<j && str.charAt(i)==str.charAt(j)){
            i++;
            j--;
        }
        if(i<j)
            return false;
        return true;
    }
    public static int addMinChar(String str){
        //code here
        int n = str.length()-1;
        while(n>=0 && !fun(str,n))
            n--;
        int ans = str.length()-n-1;
        return ans;
            
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
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends