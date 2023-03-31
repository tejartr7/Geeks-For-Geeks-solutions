//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
	int [] lexicographicallyLargest(int [] a, int n) {
		//Write your code here
		boolean found=false;
		int i;
		while(true){
		for(i=0;i<n-1;i++)
		{
		   if(a[i]<a[i+1] && (a[i]+a[i+1])%2==0)
		   {
		       found=true;
		       swap(a,i,i+1);
		   }
		}
		if(!found)
		break;
		found=false;
		}	
		return a;
	}
}