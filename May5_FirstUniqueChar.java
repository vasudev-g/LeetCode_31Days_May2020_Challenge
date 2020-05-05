/* Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters. */

class Solution {
    public int firstUniqChar(String s) {
     
		char str[]=new char[s.length()];
		str=s.toCharArray();
		int val[]=new int[26];
		int i;
		for(i=0;i<26;i++)
		{
			val[i]=0;
		}
		for(i=0;i<s.length();i++)
		{
			val[str[i]-97]++;
		}
		for(i=0;i<s.length();i++)
		{
			int v=str[i];
			if(val[v-97]==1)
			{
				
			return(i);
				
			}
		}
        return -1;
    }
}