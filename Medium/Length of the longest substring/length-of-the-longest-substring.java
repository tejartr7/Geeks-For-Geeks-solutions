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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
        int i=0,j=0,n=s.length();
        int maxi=0;
        Set<Character> set=new HashSet<>();
        while(j<n)
        {
            while(i<n && set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxi=Math.max(maxi,set.size());
            j++;
        }
        return maxi;
    }
}