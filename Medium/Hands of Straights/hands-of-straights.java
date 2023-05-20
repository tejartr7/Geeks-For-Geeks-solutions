//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int n, int groupSize, int hand[]) {
        // code here
        if(n%groupSize !=0 ) return false;
        Map<Integer,Integer> map=new HashMap<>();
        int i,j;
        Arrays.sort(hand);
        for(i=0;i<n;i++)
        {
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        for(i=0;i<n;i++)
        {
            if(map.containsKey(hand[i]))
            {
                for(j=hand[i];j<hand[i]+groupSize;j++)
                {
                    if(!map.containsKey(j)) return false;
                    map.put(j,map.get(j)-1);
                    if(map.get(j)==0) map.remove(j);
                }
            }
        }
        return true;
    }
}
