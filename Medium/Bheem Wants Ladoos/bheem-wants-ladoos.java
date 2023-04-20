//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int home = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            Solution x = new Solution();
            System.out.println( x.ladoos(root, home, k) );
            t--;
        }
    }
}


// } Driver Code Ends




class Solution{
    static int ladoos(Node root, int home, int k){
        // Your code goes here
        Node h=null;
        int ans=0;
        Map<Integer,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int i,n=q.size();
            for(i=0;i<n;i++)
            {
                Node top=q.poll();
                if(top.data==home)
                {
                    h=top;
                }
                if(top.left!=null)
                {
                    map.put(top.left.data,top);
                    q.offer(top.left);
                }
                if(top.right!=null)
                {
                    map.put(top.right.data,top);
                    q.offer(top.right);
                }
            }
        }
        if(h==null)
        return -1;
        Set<Integer> visited=new HashSet<>();
        q.offer(h);
        while(!q.isEmpty() && k>=0)
        {
            int i,n=q.size();
            for(i=0;i<n;i++)
            {
                Node top=q.poll();
                ans+=top.data;
                visited.add(top.data);
                if(map.containsKey(top.data))
                {
                    if(!visited.contains(map.get(top.data).data))
                    q.offer(map.get(top.data));
                }
                if(top.left!=null && !visited.contains(top.left.data))
                {
                    q.offer(top.left);
                }
                if(top.right!=null && !visited.contains(top.right.data))
                q.offer(top.right);
            }
            k--;
        }
        return ans;
    }
}

