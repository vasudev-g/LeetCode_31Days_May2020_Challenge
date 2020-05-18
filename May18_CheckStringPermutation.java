/* Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string. 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False */

class Solution {
    public boolean checkInclusion(String p, String s) {
        int pSum=0;
	int cubeS[]=new int[s.length()];
	int i;
	for(i=0;i<p.length();i++)
	{
		int t=p.charAt(i);
		t=t-96;
		//System.out.println(t);
		pSum=pSum+t*t*t*t;
		
	}
	
	for(i=0;i<s.length();i++)
	{
		int t=s.charAt(i);
		t=t-96;
		cubeS[i]=t*t*t*t;
	}
	//System.out.println(Arrays.toString(cubeS));
	int c=0;
	
	for(i=0;i<cubeS.length-p.length()+1;i++)
	{
		int sum=0;
		for(int j=i;j<i+p.length();j++)
		{
			sum=sum+cubeS[j];
		}
		if(sum==pSum)
		return true;
	}
	return false;
    }
}