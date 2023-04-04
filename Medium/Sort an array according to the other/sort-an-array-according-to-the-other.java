//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


// } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int a1[], int n, int a2[], int m)
    {
        //Your code here
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int x:a1)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int i=0;
        int k=0;
        while(i<m)
        {
            if(map.containsKey(a2[i])){
            int x=map.get(a2[i]);
            while(x>0)
            {
                a1[k++]=a2[i];
                x--;
            }
            map.remove(a2[i]);
            }
            i++;
        }
        while(map.size()>0)
        {
            int x=map.firstKey();
            int y=map.get(x);
            while(y>0)
            {
                a1[k++]=x;
                y--;
            }
            map.remove(x);
        }
        return a1;
    }
}



//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}



// } Driver Code Ends