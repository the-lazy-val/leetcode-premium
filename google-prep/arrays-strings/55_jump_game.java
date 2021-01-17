/**
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:

    1 <= nums.length <= 3 * 104
    0 <= nums[i] <= 105
*/

/**
My solution: 74/75 test cases passed
failing test case: [4,2,0,0,1,1,4,4,4,0,4,0]
output: false
expected: true
*/

class Solution {
    
    public int getMaxIndex(int[] nums, int j, int limit){
        int max = 0;
        int maxIndex = -1;
        
        for(int k = j; k<=limit;k++){
            int value = nums[k];
            if(value >= max){
                max = value;
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public boolean canJump(int[] nums) {
        int i =0;
        int range = 0;
        int limit = 0;
        int j = 0;
        
        int lastIndex = nums.length - 1;
        
        if(i == lastIndex){
            return true;
        }else{
            boolean flag = true;
        
            while(flag){
                range = nums[i];
                if(range == 0){
                    flag = false;
                    break;
                }else{
                    limit = i+range;
                    if(limit >= lastIndex){
                    break;
                }else{
                    j = i+1;
                    i = getMaxIndex(nums, j, limit);
                    }
                }
            }
            return flag;
        }
    }
}
