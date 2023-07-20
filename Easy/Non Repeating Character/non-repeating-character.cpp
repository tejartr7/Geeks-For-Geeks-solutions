//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function to find the first non-repeating character in a string.
    char nonrepeatingCharacter(string s)
    {
       //Your code here
       vector<int> a(26);
       int i,n=s.size();
       for(i=0;i<n;i++)
       a[s[i]-'a']++;
       char ans=' ';
       for(i=0;i<n;i++)
       {
           if(a[s[i]-'a']==1)
          { ans=s[i];
            break;
          }
       }
       return ans==' '?'$':ans;
    }

};

//{ Driver Code Starts.

int main() {
	
	int T;
	cin >> T;
	
	while(T--)
	{
	
	    string S;
	    cin >> S;
	    Solution obj;
        char ans = obj.nonrepeatingCharacter(S);
        
        if(ans != '$')
	    cout << ans;
        else cout << "-1";
            
        cout << endl;
	    
	}
	
	return 0;
}

// } Driver Code Ends