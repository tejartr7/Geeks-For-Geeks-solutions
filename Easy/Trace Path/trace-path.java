//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution{
    static boolean isValid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    static boolean check(int i,int j,int n,int m,String s)
    {
        int x=0;
        int l=s.length();
        while(x<l)
        {
            if(!isValid(i,j,n,m)) return false;
            if(s.charAt(x)=='L')
            {
                if(!isValid(i,j-1,n,m)) return false;
                j--;                
            }
            else if(s.charAt(x)=='R')
            {
                if(!isValid(i,j+1,n,m)) return false;
                j++;                
            }
            else if(s.charAt(x)=='D')
            {
                if(!isValid(i-1,j,n,m)) return false;
                i--;                
            }
            else if(s.charAt(x)=='U')
            {
                if(!isValid(i+1,j,n,m)) return false;
                i++;                
            }
            x++;
        }
        
        return x==l;
    }
    static int isPossible(int n, int m, String s){
        // code here 
        int currCol=0 , currRow=0 , minRow=0 , maxRow=0 , minCol=0 , maxCol =0;
        for(int i=0 ; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == 'L') {
                currCol--;
            }
            else if(ch == 'R') {
                currCol++;
            }
            else if(ch == 'D') {
                currRow--;    
            }
            else if(ch == 'U') {
                currRow++;
            }
            else{
                continue;
            }
        
            minRow =Math.min(minRow , currRow);
            maxRow =Math.max(maxRow , currRow);
            minCol =Math.min(minCol , currCol);
            maxCol =Math.max(maxCol , currCol);
        }
        
        return ((maxRow-minRow)<n) && ((maxCol-minCol)<m) ? 1:0;
    }
}