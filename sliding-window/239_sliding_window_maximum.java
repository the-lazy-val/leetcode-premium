class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
//         ArrayList<Integer> output = new ArrayList();
        
//         PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
//         for(int i=0; i<nums.length; i++){
            
//             pq.add(nums[i]);
            
//             if(pq.size() == k){
//                 output.add(pq.peek());
//                 pq.remove(nums[i-k+1]);
//             }
//         }
        
//         return output.stream().mapToInt(i -> i).toArray();
        
        /**
        Another way of explaining the deque method (approach 2):
        You want to ensure the deque window only has decreasing elements. That way, the leftmost element is always the largest.
        
        Hence the name "Monotonic Deque": a deque with increasing (or decreasing) ordered elements.
        */
        
        Deque<Integer> dq = new ArrayDeque();
        
        ArrayList<Integer> output = new ArrayList();
        
        int i=0;
        int j=0;
        
        while(j < nums.length){
            
            int curr = nums[j];
            
            //keep removing from end of deque if bigger element comes
            while(!dq.isEmpty() && dq.peekLast() < curr){
                dq.removeLast();
            }
            
            //add the new element
            dq.addLast(curr);
            
            //window size hit
            if(j >= k-1){
                //the first element of deque is the max of that window
                output.add(dq.peekFirst());
                
                //if nums[i] was at head of deque then remove it, because now its out of the window
                int rem = nums[i];
                
                if(dq.peekFirst() == rem){
                    dq.removeFirst();
                }
                i++; //contract from left
            }
            j++;//expand from right
        }
        
        
        return output.stream().mapToInt(x->x).toArray();
    }
}
