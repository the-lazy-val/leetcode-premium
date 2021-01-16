/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []

Constraints:

    0 <= nums.length <= 3000
    -10^5 <= nums[i] <= 10^5
*/

//My solution: works but "Time Limit Exceeded" on bigger input
class Solution {
    
    Set<List<Integer>> hs = new HashSet<>();
    
    public boolean isSumZero(int[] nums, Set<Integer> li) {
        int sum = 0;
        for(int i : li){
            sum += nums[i];
        }
        
        return sum==0;
    }
    
    public void backtrack(int[] nums, Set<Integer> visited, int l, int r){
        if(visited.size() == 3){
            if(isSumZero(nums, visited)){
                List<Integer> temp = 
                    new ArrayList<Integer>(visited)
                    .stream().map(i -> nums[i]).collect(Collectors.toList());
                
                Collections.sort(temp);
                hs.add(temp);
            }
        }else{
            for(int i = l; i<r; i++){
                visited.add(i);
                backtrack(nums, visited, l+1, r);
                visited.remove(i);
            }
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> v = new HashSet<>();
        
        backtrack(nums, v, 0, nums.length);
        
        List<List<Integer>> res = new ArrayList<>(hs);
        return res;
    }
}
