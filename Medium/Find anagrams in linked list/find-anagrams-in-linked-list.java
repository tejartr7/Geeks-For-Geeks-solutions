//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static boolean valid(String a,String b)
    {
        char x[]=a.toCharArray();
        char y[]=b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        a=new String(x);
        b=new String(y);
        return a.equals(b);
    }
    public static void creater(String s,ArrayList<Node> list)
    {
        Node n=new Node('0');
        Node temp=n;
        int i=0;
        for(i=0;i<s.length();i++)
        {
            Node dummy=new Node(s.charAt(i));
            temp.next=dummy;
            temp=temp.next;
        }
        list.add(n.next);
    }
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        String temp="";
        ArrayList<Node> list=new ArrayList<>();
        Node curr=head;
        while(curr!=null)
        {
            temp+=curr.data;
            if(temp.length()==s.length())
            {
                if(valid(temp,s))
                {
                    creater(temp,list);
                    temp="";
                }
                else
                temp=temp.substring(1);
            }
            curr=curr.next;
        }
        return list;
    }
}