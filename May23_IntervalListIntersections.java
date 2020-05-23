/* Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].) */

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
         int ans[][] = new int[1000][1000];
		 int k=0;
		 int i=0,j=0;
		 while(i<A.length && j<B.length)
		 {
			 if(A[i][0]>B[j][1])
					 {
				 j++;
				 continue;
					 }
              if(A[i][1]<B[j][0])
					 {
				 i++;
				 continue;
					 }
			 if(A[i][0]<=B[j][0] && A[i][1]<=B[j][1])
			 {
				 ans[k][0]=B[j][0];
				 ans[k][1]=A[i][1];
				 i++;
				 k++;
				 continue;
			 }
			 if(A[i][0]<=B[j][0] && A[i][1]>=B[j][1])
			 {
				 ans[k][0]=B[j][0];
				 ans[k][1]=B[j][1];
				 j++;
				 k++;
				 continue;
			 }
			 if(A[i][0]>=B[j][0] && A[i][1]<=B[j][1])
			 {
				 ans[k][0]=A[i][0];
				 ans[k][1]=A[i][1];
				 i++;
				 k++;
				 continue;
			 }
			 if(A[i][0]>=B[j][0] && A[i][1]>=B[j][1])
			 {
				 ans[k][0]=A[i][0];
				 ans[k][1]=B[j][1];
				 j++;
				 k++;
				 continue;
			 }
			 
			 
		 }
		 int f[][]=new int[k][2];
		 for(i=0;i<k;i++)
		 {
			 f[i][0]=ans[i][0];
			 f[i][1]=ans[i][1];
		 }
		 return f;
    }
}