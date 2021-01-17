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


//Using Hint: In 3-Sum, fix one element and then the problem becomes 2-Sum, which can be solved using HashMap
//Below solution accepted, but run time is high: 1252 ms

class Solution {
    
    Set<List<Integer>> hs = new HashSet<>();
    
    Map<Integer, Integer> hm = new HashMap<>();
    
    public void checkTwoSum(int[] nums, int fixed, int start, int end){
        for(int j=start; j<end; j++){
            int v = nums[j];
            int diff = -1 * (fixed + v);
            
            if(hm.containsKey(diff)){
                int foundIndex = hm.get(diff);
                
                if(foundIndex != j && foundIndex >= start){
                    List<Integer> temp = new ArrayList<Integer>(Arrays.asList(fixed, v, diff));
                    Collections.sort(temp);
                    hs.add(temp);
                    hm.put(v, j);
                }
            }
            hm.put(v, j);
            
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        for(int i=0; i< len-2; i++){
            int fixed = nums[i];
            checkTwoSum(nums, fixed, i+1, len);
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>(hs);
        return res;
    }
}
