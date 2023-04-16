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
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.solve(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long solve(int N, int[] A, int[] B) {
        // code here
        long operations=0;
        Arrays.sort(A);
        Arrays.sort(B);
         int sumA=0;
        int sumB=0;
        for(int i=0;i<N;i++)
        {
           sumA += A[i];
           sumB += B[i];
        }
        if(sumA != sumB)
            return -1;
       
        ArrayList<Integer> Aodd = new ArrayList<Integer>();
        ArrayList<Integer> Bodd = new ArrayList<Integer>();
        ArrayList<Integer> Aeven = new ArrayList<Integer>();
        ArrayList<Integer> Beven = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            if(A[i]%2==0)
            Aeven.add(A[i]);
            else
            Aodd.add(A[i]);
            if(B[i]%2==0)
            Beven.add(B[i]);
            else
            Bodd.add(B[i]);
            
        }
        if(Aodd.size() != Bodd.size() || Aeven.size() != Beven.size())
            return -1;
        for(int i=0;i<Aodd.size();i++)
        {
            operations=operations+Math.abs(Aodd.get(i)-Bodd.get(i));
        }
        for(int i=0;i<Aeven.size();i++)
        {
            operations=operations+Math.abs(Aeven.get(i)-Beven.get(i));
        }
        return operations/4;
    }
}