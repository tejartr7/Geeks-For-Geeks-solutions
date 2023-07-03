//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static int maxAND (int arr[], int n) {
        int res = 0, count = 0;
        for(int bit = 31; bit>=0; bit--){
            count = checkBits((res | 1<<bit), arr, n);
            
            if(count>=2) {//System.out.println(bit);
            res |= (1<<bit);}
        }
        return res;
    }
    
    static int checkBits(int pattern, int[] arr, int n){
        int count = 0;
        for(int i = 0; i<n; i++){
            if((pattern&arr[i])==pattern) count++;
        }
        return count;
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