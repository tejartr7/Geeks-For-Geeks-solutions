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
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.findMaxSubsetSum(N, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {

    public static long findMaxSubsetSum(int N, int[] A) {
        // code here
        int take=A[0];
        int ntake=0;
        for(int i=1;i<N;i++)
        {
            int newtake=Math.max(ntake+A[i],take+A[i]);
            int newntake=take;
            
            take=newtake;
            ntake=newntake;
        }
        return Math.max(take,ntake);
    }
}
        
