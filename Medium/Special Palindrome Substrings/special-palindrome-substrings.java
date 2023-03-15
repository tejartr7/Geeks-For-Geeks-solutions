//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    int ans = obj.specialPalindrome(s1,s2);
		    System.out.println(ans);
		    
		    
		    
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    static int mini=Integer.MAX_VALUE;
    public static int make(int start,char []a,char b[])
    {
        int i,n=a.length;
        int j=0;
        int count=0;
        for(i=start;i<n && j<b.length;i++)
        {
            if(a[i]==b[j])
            {
                j++;
            }
            else
            {
                a[i]=b[j];
                count++;
                j++;
            }
        }
        return count;
    }
    public static boolean inStart(int start,int length,int x)
    {
        return x>=start && x<start+length;
    }
    public static int helper(int start,char x[],char []y)
    {
        int count=0;
        int i=0,j=x.length-1;
        while(i<j)
        {
            if(x[i]!=x[j])
            {
                if(inStart(start,y.length,i) && inStart(start,y.length,j))
                return -1;
                else count++;
            }
            i++;
            j--;
        }
        return count;
    }
    public static int specialPalindrome(String a, String b){
       //Code Here
       char x[]=a.toCharArray();
       char y[]=b.toCharArray();
       int i,n=x.length;
       int l=b.length();
       if(b.length()>a.length()) 
       return -1;
       boolean flag=false;
       for(i=0;i<=n-l;i++)
       {
           int count=make(i,x,y);
           //System.out.println(count);
           //System.out.println(new String(x));
           int temp=helper(i,x,y);
           if(temp>=0)
           {
               //System.out.println("i is "+i);
               count+=temp;
               mini=Math.min(mini,count);
           }
           x=a.toCharArray();
       }
       int ans=mini;
       mini=Integer.MAX_VALUE;
       return ans==mini?-1:ans;
    }
}