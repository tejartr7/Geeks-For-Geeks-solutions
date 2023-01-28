//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java



//User function Template for Java


class Solution{
    public static int pivotPoint(int a[],int low,int high)
    {
        int pivotElement=a[high];
        int pivotIndex=low;
        int i;
        for(i=low;i<=high;i++)
        {
            if(a[i]<pivotElement)
            {
                int temp=a[pivotIndex];
                a[pivotIndex]=a[i];
                a[i]=temp;
                pivotIndex++;
            }
        }
        int temp=a[pivotIndex];
        a[pivotIndex]=a[high];
        a[high]=temp;
        return pivotIndex;
    }
    public static int getSmall(int a[],int low,int high,int pivot)
    {
        int x=pivotPoint(a,low,high);
        if(x==pivot-1)
        return a[x];
        else if(x<pivot-1)
        return getSmall(a,x+1,high,pivot);
        else
        return getSmall(a,low,x-1,pivot);
    }
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
      int i,j;
      int n=r-l+1;
      return getSmall(arr,0,n-1,k);
    } 
}