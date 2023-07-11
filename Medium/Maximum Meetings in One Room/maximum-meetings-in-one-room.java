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
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends

class tuple {
    int s;
    int e;
    int idx;

    tuple(int a, int b, int c) {
        s = a;
        e = b;
        idx = c;
    }
}

class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] start, int[] end) {
        // code here
        PriorityQueue<tuple> pq=new PriorityQueue<>((a,b)->a.e!=b.e?a.e-b.e:a.idx-b.idx);
        int i,j;
        for(i=0;i<n;i++)
        {
            pq.offer(new tuple(start[i],end[i],i));
        }
        int cnt=0;
        int prevEnd=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(pq.size()>0)
        {
            tuple top=pq.poll();
            if(top.s>prevEnd)
            {
                cnt++;
                prevEnd=top.e;
                list.add(top.idx+1);
            }
        }
        Collections.sort(list);
        return list;
    }
}
        
