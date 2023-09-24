//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//{ Driver Code Starts

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
      //  Map<Integer,Integer> ans=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();
        int a[]=new int[n];
        int i;
        int count=0;
        for(i=0;i<n;i++)
        {
           a[arr[i]]+=1;
        }
        for(i=0;i<n;i++)
        {
            if(a[i]>1)
            {result.add(i);
                
            }
        }
        if(result.size()==0)
        {
            result.add(-1);
            return result;
        }
        //Collections.sort(result);
        return result;
        
    }
}
