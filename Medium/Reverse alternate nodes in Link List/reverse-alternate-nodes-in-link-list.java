//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        // add your code here
        Node pre=odd, curr=odd.next;
        Node alt=new Node(-1);
        while(pre!=null&&curr!=null){
            pre.next=curr.next;
            insertHead(alt, curr);
            //cut the link
            if(pre.next==null) break;
            pre=pre.next;
            if(pre!=null)
              curr=pre.next;
        }
        pre.next=alt.next;
        
    }
   static void insertHead(Node head, Node node){
        if(head.next==null){
            head.next=node;
            node.next=null;
            return;
        }
        node.next=head.next;
        head.next=node;
    }
}
