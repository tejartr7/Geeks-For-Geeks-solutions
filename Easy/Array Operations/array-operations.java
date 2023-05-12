//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.arrayOperations(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int arrayOperations(int n, int[] arr) {
        boolean isZero = false;
        for(int i=0;i<n;i++){
            if(arr[i]==0)   {
                isZero =true;
                break;
            }
        }
        if(isZero==false)   return -1;
        
        int arrayOps = 0;
       int low = 0,high = 0;
       while(high<n){
           if(arr[high]==0){
               if(high-low>0){
                   arrayOps++;
               }
               low = high+1;
           }
           high++;
       }
       if(high-low>0)   arrayOps++;
       
       return arrayOps;
        // code here
    }
}   
