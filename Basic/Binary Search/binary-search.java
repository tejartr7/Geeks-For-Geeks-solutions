//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int key = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.binarysearch(arr, n, key));
            T--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    int binarysearch(int nums[], int n, int target) {
        int i,k;
        int l=nums.length;
        int index=-1;
        int mid;
        int first=0;
        int last=l-1;
        while(first<=last){
            mid=first+(last-first)/2;
              if(nums[mid]==target)
            {
                index=mid;
                break;
            }
           else if(nums[mid]>target)
            {
                last=mid-1;
                
            }
            else if(nums[mid]<target)
            {
                first=mid+1;
            }
          
            
        }
        return index;
    }
}