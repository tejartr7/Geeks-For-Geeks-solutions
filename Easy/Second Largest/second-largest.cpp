//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	// Function returns the second
	// largest elements
	int print2largest(int arr[], int n) {
	    // code here
	    int a=-1,b=-1;
	    for(int i=0;i<n;i++)
	    {
	        int x=arr[i];
	        if(x>a)
	        {
	            b=a;
	            a=x;
	        }
	        if(x>b && x<a)
	        {
	            b=x;
	        }
	    }
	    return b==a?-1:b;
	}
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.print2largest(arr, n);
        cout << ans << "\n";
    }
    return 0;
}

// } Driver Code Ends