//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            

            Solution ob = new Solution();
            
            System.out.println(ob.maxSubarrayXOR(N,arr));
            
            
        }
    }
}

// } Driver Code Ends


class Node {
    Node links[] = new Node[2];
    int val = 0;

    public Node() {
        val = 0;
    }

    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    Node get(int ind) {
        return links[ind];
    }

    void put(int ind, Node node) {
        links[ind] = node;
    }
}

class Solution {

    static Node root;

    static void insert(int temp) {
        int i, j;
        Node curr = root;
        for (j = 31; j >= 0; j--) {
            int x = (temp >> j) & 1;
            if (!curr.containsKey(x)) {
                curr.put(x, new Node());
            }
            curr = curr.get(x);
        }
        curr.val = temp;
    }

    static int finder(int temp) {
        int ans = temp;
        int i, j;
        Node curr = root;
        for (j = 31; j >= 0; j--) {
            int x = 1-(temp >> j) & 1;
            if (curr.containsKey(x)) {
                curr = curr.get(x);
            } else {
                curr = curr.get(1- x);
            }
        }
        return curr.val ^ temp;
    }

    static int maxSubarrayXOR(int n, int arr[]) {
        root = new Node();
        int xor = 0, maxi = 0;
        insert(0);
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            insert(xor);
            maxi = Math.max(maxi, finder(xor));
        }
        return maxi;
    }
}
