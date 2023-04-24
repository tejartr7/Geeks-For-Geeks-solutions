//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java




//User function Template for Java




//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		int i,j,n=arr.length;
		Stack<Integer> prev=new Stack<>();
		int a[]=new int[n];
		int b[]=new int[n];
		int ans[]=new int[n];
		Arrays.fill(a,-1);
		Arrays.fill(b,n);
		prev.push(-1);
		for(i=0;i<n;i++)
		{
		    while(prev.peek()!=-1 && arr[prev.peek()]>arr[i])
		    {
		        a[prev.pop()]=i;
		    }
		    prev.push(i);
		    //System.out.println(prev);
		}
		b[n-1]=n;
		prev.clear();
		prev.push(n);
		for(i=n-1;i>=0;i--)
		{
            while(prev.peek()!=n && arr[prev.peek()]>arr[i])
		    {
		        b[prev.pop()]=i;
		    }
		    prev.push(i);
		}
		
		for(i=0;i<n;i++)
		{
		    if(a[i]==-1 && b[i]==n)
		    {
		        ans[i]=-1;
		    }
		    else if(a[i]==-1 && b[i]!=n)
		    {
		        ans[i]=b[i];
		    }
		    else if(a[i]!=-1 && b[i]==n)
		    {
		        ans[i]=a[i];
		    }
		    else
		    {
		        if(Math.abs(i-a[i])>Math.abs(i-b[i]))
		        {
		            ans[i]=b[i];
		        }
		        else if(Math.abs(i-a[i])<Math.abs(i-b[i]))
		        {
		            ans[i]=a[i];
		        }
		        else
		        {
		            if(arr[a[i]]>arr[b[i]])
		            {
		                ans[i]=b[i];
		            }
		            else if(arr[a[i]]==arr[b[i]])
		            {
		                ans[i]=Math.min(a[i],b[i]);
		            }
		            else
		            {
		                ans[i]=a[i];
		            }
		        }
		    }
		}
		return ans;
	}
}