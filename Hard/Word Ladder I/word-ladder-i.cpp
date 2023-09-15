//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends



#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>

using namespace std;

class Pair {
public:
    string str;
    int level;
    
    Pair(string s, int x) : str(s), level(x) {}
};

class Solution {
public:
    void helper(string s, int level, unordered_set<string>& wordSet, queue<Pair>& q) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            string temp = s;
            for (char j = 'a'; j <= 'z'; j++) {
                temp[i] = j;
                if (wordSet.find(temp) != wordSet.end()) {
                    q.push(Pair(temp, level + 1));
                    wordSet.erase(temp);
                }
            }
        }
    }

    int wordLadderLength(string beginWord, string endWord, vector<string>& wordList) {
        int mini = INT_MAX;
        queue<Pair> q;
        q.push(Pair(beginWord, 1));
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        wordSet.erase(beginWord);
        
        while (!q.empty()) {
            Pair top = q.front();
            q.pop();
            
            if (top.str == endWord) {
                return top.level;
            }
            
            helper(top.str, top.level, wordSet, q);
        }
        
        return mini == INT_MAX ? 0 : mini;
    }
};


//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<string>wordList(n);
		for(int i = 0; i < n; i++)cin >> wordList[i];
		string startWord, targetWord;
		cin >> startWord >> targetWord;
		Solution obj;
		int ans = obj.wordLadderLength(startWord, targetWord, wordList);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends