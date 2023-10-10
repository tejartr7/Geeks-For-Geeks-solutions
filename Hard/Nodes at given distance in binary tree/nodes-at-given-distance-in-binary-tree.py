#User function Template for python3

'''
# Tree Node
class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None
'''

class Solution:
    
    def KDistanceNodes(self,root,target,k):
        # code here
        # return the sorted list all nodes at k distance from target
        ki=[]
        def inorder(root):
            if root is None or root.data==target:
                return root
            l=inorder(root.left)
            #ki.append(root)
            r=inorder(root.right)
            if l:
                return l
            return r
        inorder(root)
        n=inorder(root)

        d={}
        q=deque([root])
        
        while q:
            
            for i in range(len(q)):
                a=q.popleft()
                
                if a.left:
                    d[a.left]=a
                    q.append(a.left)
                if a.right:
                    d[a.right]=a
                    q.append(a.right)
        
        q.append(n)
        c=0
        ans=[]
        v=set()
        while q:
            for i in range(len(q)):
                a=q.popleft()
                v.add(a)
                if c==k:
                    ans.append(a.data)
                if a.left and a.left not in v:
                    q.append(a.left)
                if a.right and a.right not in v:
                    q.append(a.right)
                if a in d and d[a] not in v:
                    q.append(d[a])
            c+=1
            if c>k:
                break
        return sorted(ans)

        # code here
        # return the sorted list all nodes at k distance from target


#{ 
 # Driver Code Starts
#Initial Template for Python 3

from collections import deque

# Tree Node
class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None

# Function to Build Tree
def buildTree(s):
    # Corner Case
    if (len(s) == 0 or s[0] == "N"):
        return None

    # Creating list of strings from input
    # string after spliting by space
    ip = list(map(str, s.split()))

    # Create the root of the tree
    root = Node(int(ip[0]))
    size = 0
    q = deque()

    # Push the root to the queue
    q.append(root)
    size = size + 1

    # Starting from the second element
    i = 1
    while (size > 0 and i < len(ip)):
        # Get and remove the front of the queue
        currNode = q[0]
        q.popleft()
        size = size - 1

        # Get the current node's value from the string
        currVal = ip[i]

        # If the left child is not null
        if (currVal != "N"):
            # Create the left child for the current node
            currNode.left = Node(int(currVal))

            # Push it to the queue
            q.append(currNode.left)
            size = size + 1
        # For the right child
        i = i + 1
        if (i >= len(ip)):
            break
        currVal = ip[i]

        # If the right child is not null
        if (currVal != "N"):
            # Create the right child for the current node
            currNode.right = Node(int(currVal))

            # Push it to the queue
            q.append(currNode.right)
            size = size + 1
        i = i + 1
    return root

if __name__ == "__main__":
    x = Solution()
    t = int(input())
    for _ in range(t):
        line = input()
        target=int(input())
        k=int(input())

        root = buildTree(line)
        res = x.KDistanceNodes(root,target,k)
        
        for i in res:
            print(i, end=' ')
        print()

# } Driver Code Ends