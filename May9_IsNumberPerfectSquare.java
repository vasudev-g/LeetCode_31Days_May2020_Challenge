/* Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false */

class Solution {
    public boolean isPerfectSquare(int num) {
        int i;
		int u=num%10;
		if(u==2||u==3||u==7||u==8)
		{
			return(false);
		}
		else
		{
			for(i=1;i*i<=num;i++)
			{
				if(i*i==num)
				{
					return(true);
				}
			}
				return(false);
		}

    }
}



