//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
   // Function for finding maximum AND value.
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
        
        // Your code here
        // You can add extra function (if required)
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

//{ Driver Code Starts.

class BitWise {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxAND() method of class AND
		    System.out.println(obj.maxAND(arr, n));
		}
	}
}

// } Driver Code Ends