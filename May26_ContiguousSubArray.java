// Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

class Solution {
    public int findMaxLength(int[] nums) {
        
       Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int maxLength = 0, count = 0; 
        for(int i=0; i<nums.length; i++) {
            
            if(nums[i] == 0)
                count= count-1;
            else
                count= count + 1;
                
            if(map.containsKey(count))
                maxLength = Math.max(maxLength, i-map.get(count));
            else
                map.put(count, i);    
        }
        return maxLength;
        
    }
}