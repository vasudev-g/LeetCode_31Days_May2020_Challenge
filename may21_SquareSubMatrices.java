// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

class Solution {
    public int countSquares(int[][] m) {
        
		int i,j;
		int ans=0;
		int max=Math.max(m[0].length,m.length );
		
		for(int t=0;t<max;t++)
		for(i=0;i<m.length;i++)
		{
			for(j=0;j<m[0].length;j++)
			{
				
				if(count(m,i,j,t))
				{
					
					ans++;
				}
			}
			
		}
		return ans;
	}
   private static boolean count(int m[][],int i, int j,int p) {
		
		if(i+p<m.length && j+p<m[0].length)
		{
			
			for(int k=i;k<=i+p;k++)
			{
				for(int l=j;l<=j+p;l++)
				{
					
					if(m[k][l]==1)
					{
						continue;
					}
						
					else
						return false;
				}
				
			}
			return true;
		}
		else
return false;
		
	}
    }
