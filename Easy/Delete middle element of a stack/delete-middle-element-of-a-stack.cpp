//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

//User function template for C++

class Solution
{
    public:
    //Function to delete middle element of a stack.
    void helper(stack<int>&s,int x,int cnt)
    {
        if(s.size()==0)
        return ;
        int k=s.top();
        s.pop();
        helper(s,x,cnt+1);
        if(cnt!=x)
        s.push(k);
    }
    void deleteMid(stack<int>&s, int n)
    {
        // code here.. 
        int x=n-(n+1)/2;
        helper(s,x,0);
        
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin>>t;
    
    while(t--)
    {
        int sizeOfStack;
        cin>>sizeOfStack;
        
        stack<int> myStack;
        
        for(int i=0;i<sizeOfStack;i++)
        {
            int x;
            cin>>x;
            myStack.push(x);    
        }

            Solution ob;
            ob.deleteMid(myStack,myStack.size());
            while(!myStack.empty())
            {
                cout<<myStack.top()<<" ";
                myStack.pop();
            }
        cout<<endl;
    }   
    return 0;
}

// } Driver Code Ends