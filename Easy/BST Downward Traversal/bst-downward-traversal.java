//{ Driver Code Starts
//Initial Template for Java
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
    	    	int target=Integer.parseInt(br.readLine());
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    long ans=g.verticallyDownBST(root,target);
        	    out.println(ans);
                t--;
            
        }
        out.close();
    }
  
}




// } Driver Code Ends


//User function Template for Java

class Pair{

    Node node;

    int level;

    Pair(Node data,int level){

        this.node=data;

        this.level=level;

    }

}

class Solution

{

    long verticallyDownBST(Node root,int target)

    {

        Node n =function(root,target);

        Map<Integer,ArrayList<Integer>> hm = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        if(n==null)return -1;

        q.add(new Pair(n,0));

        while(!q.isEmpty()){

            Pair temp =q.poll();

            Node x=temp.node;

            int level = temp.level;

            

            if(hm.containsKey(level)){

                hm.get(level).add(x.data);

            }

            else{

                ArrayList<Integer> al = new ArrayList<>();

                al.add(x.data);

                hm.put(level,al);

            }

            

            if(x.left!=null){

                q.add(new Pair(x.left,level-1));

            }

            

            if(x.right!=null){

                q.add(new Pair(x.right,level+1));

            }

            

        }

        for(Map.Entry<Integer,ArrayList<Integer>> e:hm.entrySet()){

            //System.out.println(e.getKey()+" "+e.getValue());

            ArrayList<Integer> al =e.getValue();

            if(al.contains(target)){

                long sum=0;

                int index=al.indexOf(target);

                for(int i=index+1;i<al.size();i++){

                    

                    sum+=al.get(i);

                }

                return sum;

            }

        }

        return -1;

    }

    Node function(Node root,int target){

        if(root==null)return null;

        if(root.data==target)return root;

        if(root.data>target){

            return function(root.left,target);

        }else{

            return function(root.right,target);

        }

    }

 

}