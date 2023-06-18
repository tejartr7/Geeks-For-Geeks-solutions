//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int n,int k)
    {
        int s=1;
        int e=n;
        int x=0;
        while(s<e)
        {
            int l=k;
            if(x==0){
            while(l>0 && s<e)
            {
                s++;
                l--;
            }
            if(s>=e)
            return s;
            }
            else
            {
                while(l>0 && s<e)
                {
                e--;
                l--;
                }
            if(s>=e)
            return e;     
            }
            x=1-x;
        }
        return x==0?s:e;
    }
}