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
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.totalCuts(N, K, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int totalCuts(int n, int k, int[] a) {
        // code here
        int count=0;
        int i;
        int maxi=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(a[n-1]);
        int mini=a[n-1];
        for(i=n-2;i>0;i--)
        {
            mini=Math.min(mini,a[i]);
            stack.push(mini);
        }
        for(i=0;i<n-1;i++)
        {
            maxi=Math.max(a[i],maxi);
            if(maxi+stack.peek()>=k)
            count++;
            stack.pop();
        }
        return count;
    }
}
        
