/**
O(N) solution

instead of traversing over elements, we store all elements in HashSet

And then, we take one element, and check if elem+1 is in HashSet & update count & max

Before preocessing an element, we check if (elem-1) is in HashSet, because if it is, this means this element is already processed when calculating for some previous element
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        
        int max= 0;
        
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums){
            hs.add(n);
        }
        
        for(int i : nums){
            if(hs.contains(i-1)){ //because if i-1 was in the original list, then it should have been already processed for longest sequence calculation
                continue;
            }else{
                int currCount = 1;
                int curr=i;
                while(hs.contains(curr+1)){
                    currCount++;
                    curr++;
                }
                max = Math.max(max, currCount);
            }
        }
        
        return max;
    }
}

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
