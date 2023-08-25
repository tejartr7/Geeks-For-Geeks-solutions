//{ Driver Code Starts
 
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++



class Solution{
public:	
	
	
	int isPalindrome(string s)
	{
	    // Your code goes here
	    int i=0,j=s.size()-1;
	    while(i<j)
	    {
	        if(s[i++]!=s[j--])
	        return false;
	    }
	    return true;
	}

};




//{ Driver Code Starts.

int main() 
{
   	ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
   
   	int t;
   	cin >> t;
   	while(t--)
   	{
   		string s;
   		cin >> s;

   	    Solution ob;

   		cout << ob.isPalindrome(s) << "\n";
   	}

    return 0;
}
// } Driver Code Ends