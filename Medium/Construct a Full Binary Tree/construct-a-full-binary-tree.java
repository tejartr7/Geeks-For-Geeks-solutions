//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public Node helper(int pre[],int l,int h)
    {
        int mid=(l+h)/2;
        Node root=new Node(pre[l]);
        if(l<h)
        {
            root.left=helper(pre,l+1,mid);
            root.right=helper(pre,mid+1,h);
        }
        return root;
    }
    public Node constructBTree(int pre[], int preM[], int size)
    {
        // your code here
        return helper(pre,0,size-1);
    }
    
}