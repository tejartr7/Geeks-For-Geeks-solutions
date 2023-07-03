//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        int l[]=new int[n];
        int r[]=new int[n];
        l[0]=arr[0];
        r[n-1]=arr[n-1];
        int res=0;
        int i,j;
        for(i=1;i<n;i++)
        {
            l[i]=Math.min(l[i-1],arr[i]);
        }
        for(i=n-2;i>=0;i--)
        {
            r[i]=Math.max(r[i+1],arr[i]);
        }
        i=0;
        j=0;
        while(i<n && j<n)
        {
            if(r[j]>=l[i])
            {
                res=Math.max(res,j-i);
                j++;
            }
            else i++;
        }
        return res;
    }
}