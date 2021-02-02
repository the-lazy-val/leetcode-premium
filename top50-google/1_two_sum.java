/**
My solution: 0ms
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums.length;i++){
            int elem = nums[i];
            int diff = target - elem;
            if(hm.containsKey(diff)){
                return new int[]{i, hm.get(diff)};
            }else{
                hm.put(elem, i);
            }
        }
        return new int[0];
    }
}
