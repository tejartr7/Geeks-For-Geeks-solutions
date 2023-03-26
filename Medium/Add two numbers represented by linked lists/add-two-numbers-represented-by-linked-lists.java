//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverseList(Node head)
    {
        // code here
        Node temp=null;
        Node curr=head;
        Node prev=null;
        while(curr!=null)
        { temp=curr.next;
          curr.next=prev;
          prev=curr;
          curr=temp;
        }
        return prev;
    }
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        int carry=0;
        first=reverseList(first);
        second=reverseList(second);
        Node dummy=new Node(-1);
        Node curr=dummy;
        while(first!=null || second!=null || carry>0)
        {
            int x=0;
            if(first!=null)
            x+=first.data;
            if(second!=null)
            x+=second.data;
            x+=carry;
            carry=x/10;
            x%=10;
            Node temp=new Node(x);
            curr.next=temp;
            curr=curr.next;
            if(first!=null)
            first=first.next;
            if(second!=null)
            second=second.next;
        }
        curr=reverseList(dummy.next);
        return curr;
    }
}