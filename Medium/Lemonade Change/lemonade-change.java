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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int n, int bills[]) {
        // code here
        int a=0,b=0,c=0;
        //Arrays.sort(bills);
        for(int x:bills)
        {
            if(x==5)
            a++;
            else if(x==10)
            {
                if(a>0)
                {
                    a--;
                    b++;
                }
                else return false;
            }
            else
            {
                if(a>0 && b>0)
                {
                    a--;
                    b--;
                    c++;
                }
                else if(a>=3)
                {
                    a-=3;
                    c++;
                }
                else return false;
            }
        }
        return true;
    }
}
