//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    Solution obj = new Solution();
		    
		    System.out.println(obj.maxAND(arr, n));
		}
	}
}

// } Driver Code Ends



class Solution{
    
    // Function for finding maximum and value pair
    public static int counter(int arr[],int temp)
    {
        int i,n=arr.length;
        int cnt=0;
        for(i=0;i<n;i++)
        {
            if((arr[i]&temp)==temp)
            cnt++;
        }
        return cnt;
    }
    public static int maxAND (int arr[], int n) {
        // Complete the function
        int i,j;
        int ans=0;
        for(i=31;i>=0;i--)
        {
            int temp=(ans|(1<<i));
            int x=counter(arr,temp);
            if(x>=2)
            {
                ans|=temp;
            }
        }
        return ans;
    }
    
}
