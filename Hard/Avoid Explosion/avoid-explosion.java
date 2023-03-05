//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int mix[][] = new int[n][2];
            int danger[][] = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExlosion(mix, n, danger, m);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {
         int[] ds = new int[n];
        for (int i = 0; i < n; i++) ds[i] = i;
        
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = mix[i][0] - 1, y = mix[i][1] - 1;
            int fx = find(x, ds), fy = find(y, ds);
            boolean is_safe = true;
            for (int j = 0; j < m; j++) {
                int p = danger[j][0] - 1, q = danger[j][1] - 1;
                int fp = find(p, ds), fq = find(q, ds);
                if ((fx == fp && fy == fq) || (fx == fq && fy == fp)) {
                    is_safe = false;
                    break;
                }
            }
            res.add(is_safe ? "Yes" : "No");
            if (is_safe) ds[fx] = fy;
        }
        
        return res;
    }
    
    private int find(int x, int[] ds) {
        if (ds[x] != x) 
            ds[x] = find(ds[x], ds);
        return ds[x];
    
    }
}
