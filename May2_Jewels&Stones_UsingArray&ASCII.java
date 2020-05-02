/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        char str[]=J.toCharArray();
		char str1[]=S.toCharArray();
		int val[]=new int[52];
		int i;
		for(i=0;i<52;i++)
		{
			val[i]=-1;
		}
		for(i=0;i<J.length();i++) {
			int c=str[i];
			
			if(c>=65 && c<97)		
			{
			  val[str[i]-65]++;	
			}
			else 
			{
				val[str[i]-97+26]++;
			}
		}
		
		int ans =0;
		for(i=0;i<S.length();i++)
		{
			int c=str1[i];
			
			if(c>=65 && c<97)
			{
				
				if(val[str1[i]-65]>=0)
					ans++;
					
			}
			else if(val[str1[i]-97+26]>=0)
			{
				ans++;
			}
			
		}
		return ans;
    }
}