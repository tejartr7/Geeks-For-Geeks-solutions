//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    bool makePalindrome(int n,vector<string> &arr){
        map<string,int> mp;
        map<string,int> mp2;
        for(int i=0;i<n;i++)
        {
            mp[arr[i]]++;
            mp2[arr[i]]++;
        }
        for(int i=0;i<n;i++)
        {
            string s=arr[i];
            reverse(arr[i].begin(),arr[i].end());
            mp2[arr[i]]++;
        }
        for(int i=0;i<n;i++)
        {
            if(mp[arr[i]]*2!=mp2[arr[i]])
            {
                return 0;
            }
        }
        return 1;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        vector<string> arr(n);
        for(int i=0;i<n;i++){
            cin>>arr[i];
        }
        Solution ob;
        if(ob.makePalindrome(n,arr)) cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
    }
    return 0;
}
// } Driver Code Ends