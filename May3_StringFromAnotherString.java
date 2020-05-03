/* Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true */


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
		char str[]=magazine.toCharArray();
		char str1[]=ransomNote.toCharArray();
		int val[]=new int[52];
		int i;
		for(i=0;i<52;i++)
		{
			val[i]=0;
		}
		for(i=0;i<magazine.length();i++) {
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
		
		int ans=0;
		for(i=0;i<ransomNote.length();i++)
		{
			int c=str1[i];
			
			if(c>=65 && c<97)
			{
				if(val[str1[i]-65]>0)
					val[str1[i]-65]--;
				ans++;
					
					
			}
			else if(val[str1[i]-97+26]>0)
			{
				
				val[str1[i]-97+26]--;
				ans++;
			}
			
		}
		if(ans==ransomNote.length())
			return true;
		else return false;
    }
}