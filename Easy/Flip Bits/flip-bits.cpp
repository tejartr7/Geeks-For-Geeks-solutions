//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution{
    public:
    int maxOnes(int a[], int n)
    {
        // Your code goes here
        int maxo = 0;
        int one = 0;
        int temp=0;
        for(int i=0;i<n;i++){
            if(temp<0)temp=0;
            if(a[i]==1){
                temp--;
                one++;
            }
            else{
                temp++;
            }
            maxo = max(temp,maxo);
    }
    return maxo+one;
    }
};


//{ Driver Code Starts.
int main()
{
    int t; cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        int a[n+5];
        for(int i=0;i<n;i++)
            cin>>a[i];
        Solution ob;
        cout<< ob.maxOnes(a, n) <<endl;
    }
    return 0;
}

// } Driver Code Ends