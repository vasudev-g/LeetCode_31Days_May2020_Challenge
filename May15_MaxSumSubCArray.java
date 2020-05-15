?* Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

 */
class Solution {
public int maxCircularSum (int A[]) 
    { 
        int n = a.length; 
  
        
        int hg = rtn(a); 
  
        
        int w  =  0; 
        for (int i = 0; i < n; i++) 
        { 
            w += a[i]; 
            a[i] = -a[i];   
        } 
  
       
        w = w + rtn(a); 
  
        
        return (w > hg)? w: hg; 
    } 
  
     int rtn (int a[]) 
    { 
        int n = a.length; 
        int mx = 0, eh = 0; 
        for (int i = 0; i < n; i++) 
        { 
            eh = eh + a[i]; 
            if (eh < 0) 
                eh = 0; 
            if (mx < eh) 
                mx = eh; 
        } 
        return mx; 
    } 
	}