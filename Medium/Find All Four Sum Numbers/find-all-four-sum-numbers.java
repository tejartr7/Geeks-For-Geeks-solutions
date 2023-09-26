//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int t) {
        // code here
        Arrays.sort(arr);
        int p,q,r,s;
        int n=arr.length;
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(p=0;p<n;p++)
        {
            if(p>0 && arr[p-1]==arr[p])
            {
                continue;
            }
            for(q=p+1;q<n;q++)
            {
                if(q>p+1 && arr[q]==arr[q-1])
                continue;
                r=q+1;
                s=n-1;
                while(r<s)
                {
                    int sum=arr[p]+arr[q]+arr[r]+arr[s];
                    if(r>q+1 && arr[r]==arr[r-1])
                    {
                        r++;
                        continue;
                    }
                    if(sum==t)
                    {
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(arr[p]);
                        temp.add(arr[q]);
                        temp.add(arr[r]);
                        temp.add(arr[s]);
                        list.add(new ArrayList<>(temp));
                        r++;
                        s=n-1;
                    }
                    else if(sum<t)
                    {
                        r++;
                    }
                    else s--;
                }
            }
        }
        return list;
    }
}