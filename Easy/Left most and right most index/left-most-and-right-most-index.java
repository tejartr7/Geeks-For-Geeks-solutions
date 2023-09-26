//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    public int first(long arr[],long x)
    {
        int s=0,e=arr.length-1;
        int idx=-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]==x)
            {
                if(mid==0)
                return mid;
                else if(arr[mid]>arr[mid-1])
                {
                    return mid;
                }
                else
                {
                    e=mid-1;
                }
            }
            else if(arr[mid]<x)
            s=mid+1;
            else e=mid-1;
        }
        return -1;
    }
     public int last(long arr[],long x)
    {
        int s=0,e=arr.length-1;
        int idx=-1;
        int n=arr.length;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]==x)
            {
                if(mid==n-1)
                return mid;
                else if(arr[mid]<arr[mid+1])
                {
                    return mid;
                }
                else
                {
                    s=mid+1;
                }
            }
            else if(arr[mid]>x)
            e=mid-1;
            else s=mid+1;
        }
        return -1;
    }
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        int a=first(v,x);
        int b=last(v,x);
        return new pair((long)a,(long)b);
    }
}