//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution {
	public:
		string FirstNonRepeating(string s){
		    // Code here
		    queue<int> q;
		    int i=0;
		    int n=s.size();
		    vector<int> a(26,0);
		    string ans="";
		    for(i=0;i<n;i++)
		    {
		        q.push(s[i]);
		        a[s[i]-'a']++;
		        while(q.size()>0 && a[q.front()-'a']!=1)
		        q.pop();
		        if(q.empty())
		        ans+='#';
		        else ans+=q.front();
		    }
		    return ans;
		}

};


//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string A;
		cin >> A;
		Solution obj;
		string ans = obj.FirstNonRepeating(A);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends