/* Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab". */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pSum=0;
	int cubeS[]=new int[s.length()];
	int i;
	for(i=0;i<p.length();i++)
	{
		int t=p.charAt(i);
		t=t-96;
		//System.out.println(t);
		pSum=pSum+t*t*t;
		
	}
	
	for(i=0;i<s.length();i++)
	{
		int t=s.charAt(i);
		t=t-96;
		cubeS[i]=t*t*t;
	}
	//System.out.println(Arrays.toString(cubeS));
	int c=0;
	List<Integer> ls=new ArrayList<Integer>();
	for(i=0;i<cubeS.length-p.length()+1;i++)
	{
		int sum=0;
		for(int j=i;j<i+p.length();j++)
		{
			sum=sum+cubeS[j];
		}
		if(sum==pSum)
			ls.add(i);
		//System.out.println(sum);
	}
	return ls;
    }
}