//{ Driver Code Starts
//Initial Template for Java

import java.math.*;
import java.util.*;
import java.io.*;

class Driverclass
{
    // Driver Code
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    out.println(new Solution().findLongestConseqSubseq(a, n));
		    t--;
		}
		out.flush();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int n)
	{
	   // add your code here
	   //Arrays.sort(arr);
	   int i;
	   TreeSet<Integer> set=new TreeSet<>();
	   for(i=0;i<n;i++)
	   {
	       if(!set.contains(arr[i]))
	       {
	           set.add(arr[i]);
	       }
	   }
	   int maxi=1,count=1;
	   int prev=-1;
	   for(int x:set)
	   {
	       if(prev==-1)
	       {
	           prev=x;
	       }
	       else 
	       {
	           if(prev+1==x)
	           {
	               count++;
	           }
	           else
	           {
	               maxi=Math.max(maxi,count);
	               count=1;
	           }
	           prev=x;
	       }
	   }
	   maxi=Math.max(maxi,count);
	   return maxi;
	}
}