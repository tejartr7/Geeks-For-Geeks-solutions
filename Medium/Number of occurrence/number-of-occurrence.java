//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int lower(int l,int h,int x,int[] arr)
    {
        while(l<=h){
        int mid=(l+h)/2;
        if(arr[mid]>=x)
        {
            h=mid-1;
        }
        else 
        l=mid+1;
        }
        return l;
    }
    int higher(int l,int h,int x,int[] arr)
    {
        while(l<=h){
        int mid=(l+h)/2;
        if(arr[mid]<=x)
        {
            l=mid+1;
        }
        else 
        h=mid-1;
        }
        return h;
    }
    int count(int[] arr, int n, int x) {
        // code here
        int l=lower(0,n-1,x,arr);
        int h=higher(0,n-1,x,arr);
       // System.out.println(l+" "+h);
        return h-l+1;
    }
}