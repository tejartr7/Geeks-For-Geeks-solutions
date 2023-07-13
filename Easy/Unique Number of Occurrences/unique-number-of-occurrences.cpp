//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution
{
    public:
    bool isFrequencyUnique(int n, int arr[])
    {
        map<int,int> map;
        int i;
        for(i=0;i<n;i++)
        {
            if(map.find( arr[i])==map.end())
            {
                map[arr[i]]=0;
            }
            map[arr[i]]+=1;
        }
        set<int> set;
        for(auto &x:map)
        {
            set.insert(x.second);
        }
        return set.size()==map.size();
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];
        Solution ob;
        bool ans=ob.isFrequencyUnique(n,arr);
        if(ans)
            cout<<1<<endl;
        else
            cout<<0<<endl;
    }
}
// } Driver Code Ends