//{ Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Is_LinkedList_Palindrom
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Solution g = new Solution();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}




// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    Node reverseList(Node head)
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
    //Function to check whether the list is palindrome.
    
    boolean isPalindrome(Node head) 
    {
        //Your code here
        Node dummy=head;
        Node slow=head;
        Node fast=head;
        if(head==null || head.next==null)
        return true;
        while(fast!=null && fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node next=slow.next;
        slow.next=null;
        Node temp=reverseList(next);
        Node curr=temp;
        //System.out.println(temp);
        while(head!=null && temp!=null)
        {
            if(head.data!=temp.data)
            return false;
            head=head.next;
            temp=temp.next;
        }
        if(curr==null && dummy.next!=null) return false;
        return true;
    }    
}

