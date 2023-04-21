<h2><a href="https://practice.geeksforgeeks.org/problems/rank-the-permutations2229/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article">Rank The Permutations</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a string, find the rank of the string amongst its permutations sorted lexicographically.&nbsp;</span><br>
<br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
S = "abc"</span>
<span style="font-size:18px"><strong>Output:</strong>
1</span>
<strong><span style="font-size:18px">Explanation:</span></strong>
<span style="font-size:18px">The order permutations with letters 
'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
S = "acb"</span>
<span style="font-size:18px"><strong>Output:</strong>
2</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your&nbsp;task is to complete the function&nbsp;<strong>findRank()</strong>&nbsp;which takes the string&nbsp;<strong>S</strong>&nbsp;as input parameter&nbsp;and returns the rank of the string amongst its permutations.</span><br>
<span style="font-size:18px">It is guaranteed no characters are repeated in the string.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(|S|*26)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(|S|)</span><br>
<span style="font-size:18px"><strong>Note:</strong>&nbsp;|S| represents the length of string S.</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 ≤ |S| ≤ 18</span></p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>FactSet</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>number-theory</code>&nbsp;<code>Strings</code>&nbsp;<code>Data Structures</code>&nbsp;