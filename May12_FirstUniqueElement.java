/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
       for(int i=1;i<nums.length-1;i++)
           {
           if(nums[i-1] != nums[i] && nums[i] !=nums[i+1])
               return nums[i];
       }
        if(nums.length==1)
            return nums[0];
        if(nums[0] != nums[1])
        return nums[0];
        else if(nums[nums.length-2]!=nums[nums.length-1])
            return(nums[nums.length-1]);
        return -1;
    }
    
}