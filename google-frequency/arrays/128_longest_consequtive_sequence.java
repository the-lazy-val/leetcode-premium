/**
My solution: O(nlogn)
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int n : nums){
            pq.add(n);
        }
        
        int count = 1;
        int max= 1;
        
        int prev = pq.poll();
        
        while(!pq.isEmpty()){
            int curr = pq.poll();
            if(curr-prev==1){
                count++;
                max = Math.max(max, count);
                prev=curr;
            }else if(curr-prev==0){
                
            }else{
                count=1;
                prev=curr;
            }
        }
        
        return max;
    }
}
