//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;
struct Node* modifyTheList(struct Node *head);
struct Node
{
    int data;
    struct Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
    
};

void print(Node *head)
{
    Node *temp=head;
	while (temp)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout<<endl;
}


// } Driver Code Ends
/*Complete the function below
Node is as follows:
struct Node
{
    int data;
    struct Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
    
};
*/
class Solution{
public:
    Node *getMid(Node *root) {
        Node *slow = root, *fast = root->next;
        
        while(fast->next and fast->next->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        Node *temp = slow->next;
        slow->next = NULL;
        return temp;
    }
    
    Node *reverse(Node *root) {
        Node *p = root, *prev = NULL, *next;
        
        while(p) {
            next = p->next;
            p->next = prev;
            
            prev = p;
            p = next;
        }
        
        return prev;
    }
    
    struct Node* modifyTheList(struct Node *head)
    {
        int len = 0;
        Node *p = head;
        while(p) {
            len++;
            p = p->next;
        }
        
        Node *mid = getMid(head);
        Node *firstHalf = head;
        p = mid;
        Node *q = firstHalf;
        
        vector<int> v1, v2;
        while(q) {
            v1.push_back(q->data);
            q = q->next;
        }
        
        while(p) {
            v2.push_back(p->data);
            p = p->next;
        }
        
        if(len % 2 != 0) {
            int i = v2.size() - 1;
            Node *prev = NULL;
            while(firstHalf and i >= 1) {
                prev = firstHalf;
                firstHalf->data = v2[i--] - firstHalf->data;
                firstHalf = firstHalf->next;
            }
            
            p = mid->next;
            i = v1.size() - 1;
            while(p and i >= 0) {
                p->data = v1[i--];
                p = p->next;
            }
            
            prev->next = mid;
        }
        
        else {
            int i = v2.size() - 1;
            Node *prev = NULL;
            while(firstHalf and i >= 0) {
                prev = firstHalf;
                firstHalf->data = v2[i--] - firstHalf->data;
                firstHalf = firstHalf->next;
            }
            
            p = mid;
            i = v1.size() - 1;
            while(p and i >= 0) {
                p->data = v1[i--];
                p = p->next;
            }
            
            prev->next = mid;
        }
        
        return head;
    }
};

//{ Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		struct Node *head = NULL,*temp=NULL;
		while(n--){
		    int a;
            cin>>a;
			Node *newNode = new Node(a);
			if(head==NULL)
                head=newNode;
            else
                temp->next=newNode;
            temp=newNode;
		}
		Solution obj;
		head = obj.modifyTheList(head);
		print(head);
		
	}
    return 0;
}
// } Driver Code Ends